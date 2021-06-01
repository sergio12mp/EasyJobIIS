import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConexionBaseDatosJDBC extends ConexionBD {

    private Connection conn;

    private static ConexionBaseDatosJDBC instanciaInterfaz = null;

    public ConexionBaseDatosJDBC() {
        try {
            // create connection for database called DBB_SCHEMA in a server installed in
            // DB_URL, with a user USER with password PASS
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://iis2021.cobadwnzalab.eu-central-1.rds.amazonaws.com/grupoF","usuarioF", "corcellesmurillo");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
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

        String insertBody = "INSERT INTO Usuario (DNI, Nombre, Apellidos, Correo, Telefono, Contraseña, FotoPerfil, QR ) VALUES (?, ?, ?, ?, ?, ?, null,null)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(insertBody,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, u.getDNI());
            preparedStatement.setString(2, u.getNombre());
            preparedStatement.setString(3, u.getApellidos());
            preparedStatement.setString(4, u.getCorreoElectronico());
            preparedStatement.setString(5, u.getTelefono());
            preparedStatement.setString(6, u.getContrasena());
            int res = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}