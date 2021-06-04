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
    public abstract void borrarHorario(String dni);
    public abstract void borrarMensajes(String dni);
    public abstract void borrarSolicitudHorario(String dni);

    public abstract boolean esOnoJefe();
<<<<<<< HEAD
    public abstract  void cambiarCorreo(String dni, String nuevo);
    public abstract  void cambiarTelefono(String dni, String nuevo);
    public abstract  void cambiarContraseña(String dni, String nuevo);
=======
    public abstract boolean esOnoJefe(String dni);

    public abstract  void cambiarCorreo(String dni,String actual, String nuevo);
    public abstract  void cambiarTelefono(String dni,String actual, String nuevo);
    public abstract  void cambiarContraseña(String dni, String actual,String nuevo);

    public abstract boolean ContrAntiguaCorrecta(String dni,String actual);
    public abstract boolean CorreoAntiguoCorrecto(String dni,String actual);
    public abstract boolean TelefAntiguoCorrecto(String dni,String actual);

    public abstract  void cambiarFoto(String dni, String nuevo);

>>>>>>> 2a7d08d34a2cefeab89508141518c46983bb321b
    public abstract Horario horarioFavorito(String dni);
    public abstract List<SolicitudHorario> verSolicitudes();
    public abstract void eliminarSolicitud(int Identificador);
    public abstract void añadirSolicitud(String dni,int[] semana);
    public abstract void cambiarHorario(String dni,int[] semana);


    public abstract List<Usuario> verUsuarios();
    public abstract void anadirQR(byte[] img, String dni);
    public abstract boolean tieneQR (String dni);
    public abstract byte[] getQR (String dni);

    public abstract boolean tieneFoto (String dni);
    public abstract byte[] getFoto (String dni);

    public abstract List<Mensaje> verMensajes();

    public abstract List<Mensaje> verMensajesEnviados();

    public abstract void EnviarMensaje(String dni, String mensaje, String date);
    public abstract void BorrarMensaje(int iden);

<<<<<<< HEAD
    public abstract void anadirFoto(byte[] bytes, String dni);
=======
    public abstract void Ascender(String dni, boolean esunJefe);

>>>>>>> 2a7d08d34a2cefeab89508141518c46983bb321b
}
