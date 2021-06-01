java.util.*;

public class Vacaciones {
private Date dinicio;
private Date dfinal;

public Vacaciones(Date ini, Date fin){
    dinicio = ini;
    dfinal  = fin;
}

    public Date getDinicio() {
        return dinicio;
    }

    public void setDinicio(Date dinicio) {
        this.dinicio = dinicio;
    }

    public Date getDfinal() {
        return dfinal;
    }

    public void setDfinal(Date dfinal) {
        this.dfinal = dfinal;
    }
}
