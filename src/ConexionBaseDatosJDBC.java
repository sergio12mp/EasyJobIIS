import javax.swing.*;
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
                u.setQR(rs.getString("QR"));
                u.setEsJefe(rs.getBoolean("Jefe"));

                list.add(u);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public void cambiarCorreo(String dni, String actual, String nuevo) {
        try {
            ps =   ps = conn.prepareStatement("UPDATE Usuario  SET Correo =  ?  WHERE DNI = ?");
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
            ps = conn.prepareStatement("DELETE * FROM Usuario WHERE DNI = ?");
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
    public void cambiarTelefono(String dni, String actual, String nuevo) {
        try {
            ps =   ps = conn.prepareStatement("UPDATE Usuario  SET Telefono =  ?  WHERE DNI = ?");
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
    public void cambiarContraseña(String dni, String actual, String nuevo) {
        try {
            ps =   ps = conn.prepareStatement("UPDATE Usuario  SET Contraseña =  ?  WHERE DNI = ?");
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
    public void cambiarFoto(String dni, String actual, String nuevo) {
        try {
            ps =   ps = conn.prepareStatement("UPDATE Usuario  SET FotoPerfil =  ?  WHERE DNI = ?");
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
}