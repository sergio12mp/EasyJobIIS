import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConexionBaseDatosJDBC extends ConexionBD {

    private static ConexionBaseDatosJDBC instanciaInterfaz = null;
    PreparedStatement ps;
    ResultSet rs;
    private Connection conn;
    private boolean esJefe= false;

    public ConexionBaseDatosJDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e)
        {
            System.err.println("ERROR DE DRIVER");
        }
        try {
            // create connection for database called DBB_SCHEMA in a server installed in
            // DB_URL, with a user USER with password PASS
            conn = DriverManager.getConnection("jdbc:mysql://iis2021.cobadwnzalab.eu-central-1.rds.amazonaws.com/grupoF","usuarioF", "corcellesmurillo");
        } catch (SQLException e) {
            System.err.println("ERROR DE CONEXION");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ConexionBaseDatosJDBC getInstance() {
        if (instanciaInterfaz == null) {
            instanciaInterfaz = new ConexionBaseDatosJDBC();
        }
        return instanciaInterfaz;
    }

    @Override
    public void introducirUsuario(Usuario u) {

        String insertBody = "INSERT INTO Usuario (DNI, Nombre, Apellidos, Correo, Telefono, Contraseña, FotoPerfil, QR, Jefe ) VALUES (?, ?, ?, ?, ?, ?, null,null,0)";
        try {
            ps = conn.prepareStatement(insertBody);
            ps.setString(1, u.getDNI());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellidos());
            ps.setString(4, u.getCorreoElectronico());
            ps.setString(5, u.getTelefono());
            ps.setString(6, u.getContrasena());
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registrado con exito");
            }

            conn.close();
        } catch(SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "DNI ya registrado. Pruebe a iniciar sesión");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario");
            e.printStackTrace();
        }
    }


    public boolean buscarUsuario(String dni, String contraseña) {
        boolean esta = false;
        try {
            ps = conn.prepareStatement("SELECT * FROM Usuario WHERE DNI = ? AND Contraseña = ?");
            ps.setString(1,dni);
            ps.setString(2,contraseña);

            rs = ps.executeQuery();

            if(rs.next()){
                esta = true;
                esJefe = rs.getBoolean("Jefe");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return esta;
    }

    public boolean esOnoJefe(){
        return esJefe;
    }

    @Override
    public List<Usuario> verUsuarios() {
        List<Usuario> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement("SELECT * FROM Usuario");
            rs = ps.executeQuery();

            while(rs.next()){
                Usuario u = new Usuario();

                u.setDNI(rs.getString("DNI"));
                u.setNombre(rs.getString("Nombre"));
                u.setApellidos(rs.getString("Apellidos"));
                u.setCorreoElectronico(rs.getString("Correo"));
                u.setTelefono(rs.getString("Telefono"));
                u.setFotoPerfil(rs.getString("FotoPerfil"));
                u.setQR(rs.getBytes("QR"));
                u.setEsJefe(rs.getBoolean("Jefe"));

                list.add(u);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Mensaje> verMensajes() {
        List<Mensaje> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT * FROM Mensaje Where DNI_Destino = ? ");
            ps.setString(1, PanelIniciarSesion.identificador);
            rs = ps.executeQuery();

            while(rs.next()){
                Mensaje m = new Mensaje();
                m.setAutor(rs.getString("DNI_Origen"));
                m.setContenido(rs.getString("Mensaje"));
                m.setDestino(rs.getString("DNI_Destino"));
                m.setIdentificador(rs.getInt("Identificador"));

                list.add(m);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Mensaje> verMensajesEnviados() {
        List<Mensaje> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT * FROM Mensaje Where DNI_Origen = ? ");
            ps.setString(1, PanelIniciarSesion.identificador);
            rs = ps.executeQuery();

            while(rs.next()){
                Mensaje m = new Mensaje();
                m.setAutor(rs.getString("DNI_Origen"));
                m.setContenido(rs.getString("Mensaje"));
                m.setDestino(rs.getString("DNI_Destino"));
                m.setIdentificador(rs.getInt("Identificador"));

                list.add(m);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void EnviarMensaje(String dni, String mensaje) {
        String insertBody = "INSERT INTO Mensaje (Mensaje,DNI_DESTINO,DNI_ORIGEN) VALUES (?, ?, ?)";
        try {
            ps = conn.prepareStatement(insertBody);
            ps.setString(1,mensaje);
            ps.setString(2,dni);
            ps.setString(3,PanelIniciarSesion.identificador);
            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Mensaje enviado con exito");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void BorrarMensaje(int iden) {
        try {
            ps = conn.prepareStatement("DELETE FROM Mensaje WHERE Identificador = ?");
            ps.setInt(1,iden);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Borrado con éxito");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void cambiarCorreo(String dni, String nuevo) {
        try {
            ps = conn.prepareStatement("UPDATE Usuario  SET Correo =  ?  WHERE DNI = ?");
            ps.setString(1,nuevo);
            ps.setString(2,dni);
            int res = ps.executeUpdate();

            if (res > 0){
                JOptionPane.showMessageDialog(null, "Correo actualizado con exito");
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void eliminarUsuario(String dni){
        try {
            ps = conn.prepareStatement("DELETE FROM Usuario WHERE DNI = ?");
            ps.setString(1,dni);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Borrado con éxito");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void cambiarTelefono(String dni, String nuevo) {
        try {
            ps = conn.prepareStatement("UPDATE Usuario  SET Telefono =  ?  WHERE DNI = ?");
            ps.setString(1,nuevo);
            ps.setString(2,dni);
            int res = ps.executeUpdate();

            if (res > 0){
                JOptionPane.showMessageDialog(null, "Telefono actualizado con exito");
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void cambiarContraseña(String dni,String nuevo) {
        try {
            ps = conn.prepareStatement("UPDATE Usuario  SET Contraseña =  ?  WHERE DNI = ?");
            ps.setString(1,nuevo);
            ps.setString(2,dni);
            int res = ps.executeUpdate();

            if (res > 0){
                JOptionPane.showMessageDialog(null, "Contraseña actualizado con exito");
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public void cambiarFoto(String dni, String nuevo) {
        try {
            ps = conn.prepareStatement("UPDATE Usuario  SET FotoPerfil =  ?  WHERE DNI = ?");
            ps.setString(1,nuevo);
            ps.setString(2,dni);
            int res = ps.executeUpdate();

            if (res > 0){
                JOptionPane.showMessageDialog(null, "FotoPerfil actualizado con exito");
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Horario horarioFavorito (String dni) {
        Horario h = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM Horario where DNI = ?");

            ps.setString(1, dni);
            rs = ps.executeQuery();

            while (rs.next()) {
                int[] semana = new int[7];
                semana[0] = rs.getInt("Lunes");
                semana[1] = rs.getInt("Martes");
                semana[2] = rs.getInt("Miercoles");
                semana[3] = rs.getInt("Jueves");
                semana[4] = rs.getInt("Viernes");
                semana[5] = rs.getInt("Sabado");
                semana[6] = rs.getInt("Domingo");
                h = new Horario(semana);
            }
            } catch(SQLException throwables){
                throwables.printStackTrace();
            }

        return h;
    }

    public void anadirQR (byte[] img, String dni) {
        try {

            ps = conn.prepareStatement("UPDATE Usuario SET QR =  ?  WHERE DNI = ?");
            ps.setBytes(1, img);
            ps.setString(2,dni);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean tieneQR (String dni) {
        boolean res = false;
        try {

            ps = conn.prepareStatement("SELECT QR FROM Usuario WHERE DNI = ?");
            ps.setString(1,dni);
            rs = ps.executeQuery();

            if (rs.next()){
                if (rs.getString("QR") == null) {
                    res = false;
                } else {
                    res = true;
                }
            }





        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return res;
    }

    public byte[] getQR (String dni) {
        byte[] bytes = null;
        try {

            ps = conn.prepareStatement("SELECT QR FROM Usuario WHERE DNI = ?");
            ps.setString(1,dni);
            rs = ps.executeQuery();


            if (rs.next()) {
                bytes = rs.getBytes("QR");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bytes;
    }




}