<<<<<<< HEAD
import java.util.Arrays;

public class SolicitudHorario{
        private int iden;
        private String dni_empleado;
        private String dni_jefe;
        private int[] semana = new int[7];

        public SolicitudHorario() {
            for (int i = 0; i<semana.length; i++){
                semana[i] = 0;
            }
        }
        public SolicitudHorario(int iden,String dni_e,String dni_j,int[] semana){
            this.iden = iden;
            this.dni_empleado = dni_e;
            this.dni_jefe = dni_j;
            this.semana = semana;
        }

        public int[] getSemana(){
            return semana;
        }
        public String getDni_empleado() { return dni_empleado;}
        public String getDni_jefe() { return dni_jefe;}

        public String toString() {
            return  Arrays.toString(semana);
        }
}
=======
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SolicitudHorario {


    private String autor;
    private String destino;
    private String contenido;
    private int Identificador;
    private String fecha;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setIdentificador(int identificador) {
        Identificador = identificador;
    }

    public void setFecha(String date) {fecha = date;}

    public SolicitudHorario(){
        Identificador = 0;
        autor = null;
        destino = null;
        contenido = null;
        fecha = null;

    }
    public SolicitudHorario(int id, String aut, String asu, String cont, String date) {
        Identificador = id;
        autor = aut;
        destino = asu;
        contenido = cont;
        fecha = date;
    }


    public String toString() {

        String recibido = "RECIBIDO";

        if(autor.compareTo(PanelIniciarSesion.identificador) == 0) {
            recibido = "ENVIADO";
        }

        return ( "(" + Identificador + ") " + "("+ fecha + ") " + recibido + " Mensaje de " + autor + " para " + destino + ": " + contenido);
    }

}

>>>>>>> 513a5e473d48c3714ec7f3fa34980489657edfa0
