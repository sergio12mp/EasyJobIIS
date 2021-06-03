import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEnviarMensajeDeveloper extends JPanel implements VistaEasyJob {

    JButton enviar, atras;
    static final String bEnviar = "ENVIAR";
    static final String bAtras = "VOLVER A CHAT";

    private JLabel destinatario, mensaje;
    private JTextField destinatarioField;
    private JTextArea mensajeField;
    ConexionBD conex = new ConexionBaseDatosJDBC();

    public PanelEnviarMensajeDeveloper(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


       // destinatario = new JLabel("Enviar mensaje a");
        //destinatario.setAlignmentX(Component.CENTER_ALIGNMENT);

        mensaje = new JLabel("Cuerpo del mensaje");
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);


        destinatarioField = new JTextField("", 20);
        destinatarioField.setMaximumSize(new Dimension(300, 20));
        destinatarioField.setAlignmentX(Component.CENTER_ALIGNMENT);

        mensajeField = new JTextArea(10, 200);
        mensajeField.setWrapStyleWord(true);
        mensajeField.setLineWrap(true);
        mensajeField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        mensajeField.setMaximumSize(new Dimension(700, 200));
        mensajeField.setAlignmentX(Component.CENTER_ALIGNMENT);

        enviar = new JButton(bEnviar);
        enviar.setAlignmentX(Component.CENTER_ALIGNMENT);
        enviar.setMinimumSize(new Dimension(100, 100));
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dest = "developer";
                String mensj = mensajeField.getText();

                if(!dest.isEmpty() && !mensj.isEmpty()) {

                    conex.EnviarMensaje(dest, mensj);

                    JComponent comp = (JComponent) e.getSource();
                    Window win = SwingUtilities.getWindowAncestor(comp);
                    win.dispose();

                    JFrame frame = new JFrame("Chat");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    PanelHelp panel = new PanelHelp();

                    CtrHelp ctrChat = new CtrHelp(panel);

                    panel.controlador(ctrChat);

                    frame.getContentPane().add(panel);
                    frame.pack();

                    frame.setSize(1000, 500);
                    frame.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Datos introducidos incorrectamente");
                }
            }
        });

        atras = new JButton(bAtras);
        atras.setAlignmentX(Component.CENTER_ALIGNMENT);

       // add(Box.createVerticalStrut(10));
        //add(destinatario);
        //add(Box.createVerticalStrut(2));
        //add(destinatarioField);
        add(Box.createVerticalStrut(5));
        add(mensaje);
        add(Box.createVerticalStrut(2));
        add(mensajeField);
        add(Box.createVerticalStrut(5));
        add(enviar);
        add(Box.createVerticalStrut(2));
        add(atras);
    }




    public void controlador(ActionListener ctrl) {
        atras.addActionListener(ctrl);
    }

}
