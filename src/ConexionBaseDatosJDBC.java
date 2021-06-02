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

        String insertBody = "INSERT INTO Usuario (DNI, Nombre, Apellidos, Correo, Telefono, Contraseña, FotoPerfil, QR ) VALUES (?, ?, ?, ?, ?, ?, null,null,0)";
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

    @Override
    public boolean buscarUsuario(String dni, String contraseña) {
        boolean esta = false;
        try {
            ps = conn.prepareStatement("SELECT * FROM Usuario WHERE DNI = ? AND Contraseña = ?");
            ps.setString(1,dni);
            ps.setString(2,contraseña);

            rs = ps.executeQuery();

            if(rs.next()){
                esta = true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return esta;
    }

    @Override
    public boolean esJefe (String dni, String contraseña){
        int njefe=0;
        boolean esJefe = false;

        try{
            ps = conn.prepareStatement("SELECT * FROM Usuario WHERE DNI = ? AND Contraseña = ? AND WHERE Jefe = ?");
            ps.setString(1,dni);
            ps.setString(2,contraseña);
            ps.setInt(3,njefe);

            if(njefe ==1) {
                esJefe = true;
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return esJefe;
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
}