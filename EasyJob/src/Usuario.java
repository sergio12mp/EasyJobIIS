//<<<<<<< Updated upstream
public class Usuario {
  
=======
public abstract class Usuario {

    private String Nombre;
    private String Apellidos;
    private String CorreElectronico;
    private String FotoPerfil;
    private String DNI;
    private String Telefono;
    private String UsuarioDeAcceso;
    private String Contrasena;
    private String QR;

    public Usuario(String nombre, String apellidos, String correElectronico, String fotoPerfil, String DNI, String telefono, String usuarioDeAcceso, String contrasena, String QR) {
        Nombre = nombre;
        Apellidos = apellidos;
        CorreElectronico = correElectronico;
        FotoPerfil = fotoPerfil;
        this.DNI = DNI;
        Telefono = telefono;
        UsuarioDeAcceso = usuarioDeAcceso;
        Contrasena = contrasena;
        this.QR = QR;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getCorreElectronico() {
        return CorreElectronico;
    }

    public void setCorreElectronico(String correElectronico) {
        CorreElectronico = correElectronico;
    }

    public String getFotoPerfil() {
        return FotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        FotoPerfil = fotoPerfil;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getUsuarioDeAcceso() {
        return UsuarioDeAcceso;
    }

    public void setUsuarioDeAcceso(String usuarioDeAcceso) {
        UsuarioDeAcceso = usuarioDeAcceso;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public String getQR() {
        return QR;
    }

    public void setQR(String QR) {
        this.QR = QR;
    }
//>>>>>>> Stashed changes
}
