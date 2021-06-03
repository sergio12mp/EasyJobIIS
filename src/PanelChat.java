import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelChat extends JPanel implements VistaEasyJob{

    JButton enviarMensaje, mensajesPendientes, atras;

    private String fuente = "Arial";

    static String ENVIARMENSAJE = "ENVIAR MENSAJE";
    static String MENSAJESPENDIENTES = "VER MENSAJES";
    static String chatATRAS = "VOLVER AL MENU";

    public PanelChat() {

        setLayout(new GridLayout(5, 3, 5, 5));

        enviarMensaje = new JButton(ENVIARMENSAJE);
        enviarMensaje.setFont(new Font(fuente, Font.BOLD, 18));
        enviarMensaje.setAlignmentX(Component.CENTER_ALIGNMENT);

        mensajesPendientes = new JButton(MENSAJESPENDIENTES);
        mensajesPendientes.setFont(new Font(fuente, Font.BOLD, 18));
        mensajesPendientes.setAlignmentX(Component.CENTER_ALIGNMENT);

        atras = new JButton(chatATRAS);
        atras.setFont(new Font(fuente, Font.BOLD, 18));
        atras.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(enviarMensaje);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(mensajesPendientes);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(atras);
        add(Box.createVerticalStrut(3));

    }

    public void controlador(ActionListener ctrl) {
        enviarMensaje.addActionListener(ctrl);
        mensajesPendientes.addActionListener(ctrl);
        atras.addActionListener(ctrl);
    }
}
