public abstract class ConexionBD {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://database-iis2021.cobadwnzalab.eu-central-1.rds.amazonaws.com";
    static final String DB_SCHEMA = "grupoF";

    //  Database credentials
    static final String USER = "usuarioF";
    static final String PASS = "corcellesmurillo";

    public abstract void introducirUsuario(Usuario u);
}
