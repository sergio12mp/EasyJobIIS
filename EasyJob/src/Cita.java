import java.util.LinkedList;

public class Cita {
    private String fecha;
    private Usuario remitente;
    private LinkedList<Usuario> destinatarios;
    private boolean aceptada;

    public Cita(String fecha, Usuario remitente, LinkedList<Usuario> destinatarios){
        this.fecha = fecha;
        this.remitente = remitente;
        this.destinatarios = destinatarios;
        this.aceptada = false;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getFecha() {
        return fecha;
    }
    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }
    public boolean isAceptada(){
        return aceptada;
    }
    public Usuario getRemitente() {
        return remitente;
    }
    public void setRemitente(Usuario remitente){
        this.remitente = remitente;
    }
    public String toString() {
        String res = "Solicitud cita de ";
        res += remitente.getNombre() + ", para el " + fecha + "\n ESTADO: ";
        if (!aceptada) {
            res += "Pendiente de confirmacion";
        } else {
            res += "Aceptada";
        }
        return res;
    }
}
