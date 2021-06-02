import javax.swing.undo.UndoableEditSupport;

public class Usuario {

    private String Nombre;
    private String Apellidos;
    private String CorreoElectronico;
    private String FotoPerfil;
    private String DNI;
    private String Telefono;
    private String Contrasena;
    private String QR;
    private boolean esJefe;

    public Usuario(){
        Nombre = null;
        Apellidos = null;
        CorreoElectronico = null;
        this.DNI = null;
        Telefono = null;
        Contrasena = null;
        QR = null;
        esJefe = false;
        FotoPerfil = null;
    }
    public Usuario(String nombre, String apellidos, String correoElectronico,  String DNI, String telefono,  String contrasena) {
        Nombre = nombre;
        Apellidos = apellidos;
        CorreoElectronico = correoElectronico;
        this.DNI = DNI;
        Telefono = telefono;
        Contrasena = contrasena;
        QR = null;
        esJefe = false;
        FotoPerfil = null;
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

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String correElectronico) {
        CorreoElectronico = correElectronico;
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

    public void setEsJefe(boolean esJefe){this.esJefe = esJefe;}
    public boolean getesJefe() { return esJefe; }
}
