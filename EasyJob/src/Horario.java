import java.util.*;

public class Horario {
    private Date hInicio;
    private Date hFin;
    private String Dia;
    private int horaExtra;

    public Horario(Date hInicio, Date hFin, String dia) {
        this.hInicio = hInicio;
        this.hFin = hFin;
        Dia = dia;
    }


    public Date gethInicio() {
        return hInicio;
    }

    public void sethInicio(Date hInicio) {
        this.hInicio = hInicio;
    }

    public Date gethFin() {
        return hFin;
    }

    public void sethFin(Date hFin) {
        this.hFin = hFin;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String dia) {
        Dia = dia;
    }
}
