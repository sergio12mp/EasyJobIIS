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

    public Mensaje buscarMensaje (Mensaje m){
        Mensaje res = null;
        if (!mensajes.contains(m)) {
            System.out.print("El mensaje no está en la base de datos");
            return res;
        } else {
            int i = 0;
            while (!mensajes.get(i).equals(m)){
                i++;
            }
            if (i < mensajes.size()){
                res =  mensajes.get(i);
            }
        }
        return res;
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
