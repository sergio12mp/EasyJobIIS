public class Mensaje {


    private String autor;
    private String asunto;
    private String contenido;

    public Mensaje (String aut, String asu, String cont){
        autor = aut;
        asunto = asu;
        contenido = cont;
    }

    public String toString () {
        return ("Usuario: " + autor + ", Asunto: " + asunto + ", Contenido: " + contenido);
    }
}



