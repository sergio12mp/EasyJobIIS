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

    public Mensaje(){
        Identificador = 0;
        autor = null;
        destino = null;
        contenido = null;
        fecha = null;

    }
    public Mensaje(int id, String aut, String asu, String cont, String date) {
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

