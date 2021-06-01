import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class Chat {

    private String nombreChat;
    private List<Mensaje> mensajes;


    public Chat (String nombre) {
        nombreChat = nombre;
        mensajes = new LinkedList<>();
    }

    public  void añadirMensaje (Mensaje m) {
        mensajes.add(m);
    }

    public void eliminarMensaje (Mensaje m) {
        mensajes.remove(m);
    }

    public String verMensajes () {
        System.out.println("**********************************");
        StringJoiner sj = new StringJoiner("\n");
        sj.add("Chat " + nombreChat);
        for (Mensaje m : mensajes) {
            sj.add(m.toString());
        }
        sj.add("*********************************************");
        return sj.toString();
    }



}
