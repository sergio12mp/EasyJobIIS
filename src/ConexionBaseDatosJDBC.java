import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                m.setFecha(rs.getString("Hora"));

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
                m.setFecha(rs.getString("Hora"));

                list.add(m);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<SolicitudHorario> verSolicitudes() {
        List<SolicitudHorario> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT * FROM SolicitudHorario Where DNI_Jefe = ? ");
            ps.setString(1, PanelIniciarSesion.identificador);
            rs = ps.executeQuery();

            while(rs.next()){

                int[] semana = new int[7];
                int iden = rs.getInt("Identificador");
                String dni_e = rs.getString("DNI_Empleado");
                String dni_j = rs.getString("DNI_Jefe");
                semana[0] = rs.getInt("Lunes");
                semana[1] = rs.getInt("Martes");
                semana[2] = rs.getInt("Miercoles");
                semana[3] = rs.getInt("Jueves");
                semana[4] = rs.getInt("Viernes");
                semana[5] = rs.getInt("Sabado");
                semana[6] = rs.getInt("Domingo");
                SolicitudHorario sh = new SolicitudHorario(iden,dni_e,dni_j,semana);
                list.add(sh);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public void eliminarSolicitud(int Identificador) {
        try {
            ps = conn.prepareStatement("DELETE FROM SolicitudHorario WHERE Identificador = ?");
            ps.setInt(1,Identificador);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Borrado con éxito");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void añadirSolicitud(String dni, int[] semana) {
        try{
            ps = conn.prepareStatement("INSERT INTO SolicitudHorario" +
                    "(DNI_Empleado,DNI_Jefe,Lunes,Martes,Miercoles,Jueves,Viernes,Sabado,Domingo) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)");

            ps.setString(1,PanelIniciarSesion.identificador);
            ps.setString(2,dni);
            ps.setInt(3,semana[0]);
            ps.setInt(4,semana[1]);
            ps.setInt(5,semana[2]);
            ps.setInt(6,semana[3]);
            ps.setInt(7,semana[4]);
            ps.setInt(8,semana[5]);
            ps.setInt(9,semana[6]);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Solicitud enviada con éxito");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void cambiarHorario(String dni,int[] semana) {
        try {
            ps = conn.prepareStatement("UPDATE Horario SET " +
                    "Lunes=? && Martes=? && Miercoles=? && Jueves=? && Viernes=?" +
                    "Sabado=? && Domingo=?   WHERE DNI = ?");
            ps.setString(8,dni);
            ps.setInt(1,semana[0]);
            ps.setInt(2,semana[1]);
            ps.setInt(3,semana[2]);
            ps.setInt(4,semana[3]);
            ps.setInt(5,semana[4]);
            ps.setInt(6,semana[5]);
            ps.setInt(7,semana[6]);

            int res = ps.executeUpdate();

            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Horario del empleado cambiado con éxito");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void EnviarMensaje(String dni, String mensaje ,String date) {
        String insertBody = "INSERT INTO Mensaje (Mensaje,DNI_DESTINO,DNI_ORIGEN, Hora) VALUES (?, ?, ?,?)";

        try {
            ps = conn.prepareStatement(insertBody);
            ps.setString(1,mensaje);
            ps.setString(2,dni);
            ps.setString(3,PanelIniciarSesion.identificador);
            ps.setString(4,date);
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

    public boolean esOnoJefe(String dni){
        boolean loes = false;
        try {
            ps = conn.prepareStatement("SELECT Jefe FROM Usuario WHERE DNI = ?");
            ps.setString(1,dni);
            rs = ps.executeQuery();

            if (rs.next()){
                loes = rs.getBoolean("Jefe");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return loes;
    }

    @Override
    public void Ascender(String dni, boolean esunJefe) {
        try {
            ps = conn.prepareStatement("UPDATE Usuario SET Jefe =  ?  WHERE DNI = ?");
            ps.setBoolean(1,!esunJefe);
            ps.setString(2,dni);
            int res = ps.executeUpdate();

            if (res > 0){
                JOptionPane.showMessageDialog(null, "Ascendido con éxito");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminarUsuario(String dni){
        try {
            ConexionBD conex = new ConexionBaseDatosJDBC();
            conex.borrarHorario(dni);
            conex.borrarMensajes(dni);
            conex.borrarSolicitudHorario(dni);
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

    public void borrarHorario(String dni){
        try {
            ps = conn.prepareStatement("DELETE FROM Horario WHERE DNI = ?");
            ps.setString(1,dni);

            int res = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void borrarMensajes(String dni){
        try {
            ps = conn.prepareStatement("DELETE FROM Mensaje WHERE DNI_Origen = ? or DNI_Destino = ?");
            ps.setString(1,dni);
            ps.setString(2,dni);
            int res = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void borrarSolicitudHorario(String dni){
        try {
            ps = conn.prepareStatement("DELETE FROM SolicitudHorario WHERE DNI_Empleado = ? or DNI_Jefe = ?");
            ps.setString(1,dni);
            ps.setString(2,dni);
            int res = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean ContrAntiguaCorrecta(String dni,String actual){
        boolean esCorrecta = false;
        try {
            ps = conn.prepareStatement("SELECT Contraseña FROM Usuario WHERE DNI = ?");
            ps.setString(1,dni);
            rs = ps.executeQuery();

            String contra = null;
            if(rs.next()){
                contra = rs.getString("Contraseña");
            }
            if(contra.equals(actual))
                esCorrecta = true;

            } catch (SQLException e) {
            e.printStackTrace();
        }
        return esCorrecta;
    }

    @Override
    public boolean CorreoAntiguoCorrecto(String dni, String actual) {
        boolean esCorrecta = false;
        try {
            ps = conn.prepareStatement("SELECT Correo FROM Usuario WHERE DNI = ?");
            ps.setString(1,dni);
            rs = ps.executeQuery();

            String correo = null;
            if(rs.next()){
                correo = rs.getString("Correo");
            }
            if(correo.equals(actual))
                esCorrecta = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return esCorrecta;
    }

    @Override
    public boolean TelefAntiguoCorrecto(String dni, String actual) {
        boolean esCorrecta = false;
        try {
            ps = conn.prepareStatement("SELECT Telefono FROM Usuario WHERE DNI = ?");
            ps.setString(1,dni);
            rs = ps.executeQuery();

            String telef = null;
            if(rs.next()){
                telef = rs.getString("Telefono");
            }
            if(telef.equals(actual))
                esCorrecta = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return esCorrecta;
    }

    @Override
    public void cambiarCorreo(String dni, String actual, String nuevo) {
        try {
            ConexionBD conex = new ConexionBaseDatosJDBC();
            if(conex.CorreoAntiguoCorrecto(dni, actual)){
                ps = conn.prepareStatement("UPDATE Usuario  SET Correo=  ?  WHERE DNI = ?");
                ps.setString(1,nuevo);
                ps.setString(2,dni);
                int res = ps.executeUpdate();

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Correo actualizado con éxito");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Correo actual incorrecto");
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void cambiarContraseña(String dni,String actual,String nuevo) {
        try {
            ConexionBD conex = new ConexionBaseDatosJDBC();
            if(conex.ContrAntiguaCorrecta(dni, actual)){
                ps = conn.prepareStatement("UPDATE Usuario  SET Contraseña =  ?  WHERE DNI = ?");
                ps.setString(1,nuevo);
                ps.setString(2,dni);
                int res = ps.executeUpdate();

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Contraseña actualizada con éxito");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Contraseña actual incorrecta");
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void cambiarTelefono(String dni, String actual,String nuevo) {
        try {
            ConexionBD conex = new ConexionBaseDatosJDBC();
            if(conex.TelefAntiguoCorrecto(dni,actual)){
                ps = conn.prepareStatement("UPDATE Usuario  SET Telefono =  ?  WHERE DNI = ?");
                ps.setString(1,nuevo);
                ps.setString(2,dni);
                int res = ps.executeUpdate();

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Telefono actualizado con éxito");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Telefono actual incorrecto");
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
                h = new Horario(dni,semana);
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