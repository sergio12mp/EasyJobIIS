import java.util.*;

public class Horario {

    private String dni;
    private int[] semana = new int[7];

    public Horario() {
        for (int i = 0; i<semana.length; i++){
            semana[i] = 0;
        }
    }
    public Horario(String dni,int[] semana){
        this.dni = dni;
        this.semana = semana;
    }

    public int[] getSemana(){
        return semana;
    }
    public String getDni() { return dni;}

    public String toString() {
        return  Arrays.toString(semana);
    }
}