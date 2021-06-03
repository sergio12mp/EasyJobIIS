import java.awt.*;

import java.awt.event.ActionListener;


import javax.swing.*;
public class PanelHelp  extends JPanel implements VistaEasyJob {
    

    private String fuente = "Arial";

    public JLabel correo, telefono;

    public JButton HAtras, Henviar;
    static String bHAtras = "Atras";
    static String bHEnviar = "Enviar";



    public PanelHelp(){
        
        setLayout(new GridLayout(5, 3, 1, 5));

        correo = new JLabel("CORREO: easyjob@easyjob.com");
        correo.setFont(new Font(fuente, Font.BOLD, 25));
        correo.setAlignmentX(Component.CENTER_ALIGNMENT);

        Henviar = new JButton(bHEnviar);
        Henviar.setFont(new Font(fuente, Font.BOLD, 20));
        Henviar.setAlignmentX(Component.CENTER_ALIGNMENT);

        telefono = new JLabel("TELEFONO: +34 987 987 987");
        telefono.setFont(new Font(fuente, Font.BOLD, 25));
        telefono.setAlignmentX(Component.CENTER_ALIGNMENT);
    

        HAtras= new JButton(bHAtras);
        HAtras.setFont(new Font(fuente, Font.BOLD, 20));
        HAtras.setAlignmentX(Component.CENTER_ALIGNMENT);


        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(correo);
        add(telefono);
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Henviar);        add(HAtras);


        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

    }

    @Override
    public void controlador(ActionListener ctrl) {
        HAtras.addActionListener(ctrl);
        Henviar.addActionListener(ctrl);
    }


}
