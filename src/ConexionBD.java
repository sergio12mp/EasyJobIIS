import java.util.List;

public abstract class ConexionBD {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://database-iis2021.cobadwnzalab.eu-central-1.rds.amazonaws.com";
    static final String DB_SCHEMA = "grupoF";

    //  Database credentials
    static final String USER = "usuarioF";
    static final String PASS = "corcellesmurillo";

    public abstract void introducirUsuario(Usuario u);
    public abstract boolean buscarUsuario(String dni,String contraseña);
    public abstract void eliminarUsuario(String dni);
    public abstract boolean esOnoJefe();
    public abstract  void cambiarCorreo(String dni, String actual, String nuevo);
    public abstract  void cambiarTelefono(String dni, String actual, String nuevo);
    public abstract  void cambiarContraseña(String dni, String actual, String nuevo);
    public abstract  void cambiarFoto(String dni, String actual, String nuevo);

    public abstract List<Usuario> verUsuarios();
}
