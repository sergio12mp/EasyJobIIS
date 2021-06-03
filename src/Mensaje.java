public class Mensaje {


    private String autor;
    private String destino;
    private String contenido;
    private int Identificador;

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

    public Mensaje(){
        Identificador = 0;
        autor = null;
        destino = null;
        contenido = null;
    }
    public Mensaje(int id, String aut, String asu, String cont) {
        Identificador = id;
        autor = aut;
        destino = asu;
        contenido = cont;
    }


    public String toString() {
        return ("Mensaje número: " + Identificador + " de autor: " + contenido);
    }

}

