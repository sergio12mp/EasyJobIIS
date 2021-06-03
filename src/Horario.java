import java.util.*;

public class Horario {

    private String Dia;

    private int[] semana = new int[7];

    public Horario() {
        for (int i = 0; i<semana.length; i++){
            semana[i] = 0;
        }
    }

    public Horario (int [] s) {
        semana = s;
    }

    public int[] getSemana(){
        return semana;
    }

    public String toString() {
        return  Arrays.toString(semana);
    }
}