import java.util.Date;

public class Vacaciones {
private Date dinicio;
    private Empleado empleado;
private Date dfinal;
private boolean aceptada;

public Vacaciones(Date ini, Date fin){
    dinicio = ini;
    dfinal  = fin;
    aceptada = false;
}
    public Date getDinicio() {
        return dinicio;
    }

    public void setDinicio(Date dinicio) {
        this.dinicio = dinicio;
    }

    public Date getDfinal() {  return dfinal; }

    public void setDfinal(Date dfinal) {
        this.dfinal = dfinal;
    }

    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    }

    public boolean isAceptada(){
        return aceptada;
    }


    public String toString() {
        String res = "Solicitud cita de ";
        res += empleado.getNombre() + ", para el " + dinicio + "hasta el " + dfinal + "\n ESTADO: ";
        if (!aceptada) {
            res += "Pendiente de confirmacion";
        } else {
            res += "Aceptada";
        }
        return res;
    }
}
