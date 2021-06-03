import java.awt.*;

import java.awt.event.ActionListener;


import javax.swing.*;
public class PanelHelp  extends JPanel implements VistaEasyJob {
    

    private String fuente = "Arial";

    public JFormattedTextField correo, telefono;

    public JButton HAtras;
    static String bHAtras = "Atras";



    public PanelHelp(){
        
        setLayout(new GridLayout(5, 3, 5, 5));

        correo = new JFormattedTextField("CORREO: easyjob@easyjob.com");
        correo.setFont(new Font(fuente, Font.BOLD, 20));
        correo.setAlignmentX(Component.CENTER_ALIGNMENT);

        telefono = new JFormattedTextField("TELEFONO: +34 987 987 987");
        telefono.setFont(new Font(fuente, Font.BOLD, 20));
        telefono.setAlignmentX(Component.CENTER_ALIGNMENT);
    

        HAtras= new JButton(bHAtras);
        HAtras.setFont(new Font(fuente, Font.BOLD, 20));
        HAtras.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        
        



        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));


        add(Box.createVerticalStrut(3));
        add(correo);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(telefono);
        add(Box.createVerticalStrut(3));


        add(Box.createVerticalStrut(3));
        add(HAtras);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

    }

    @Override
    public void controlador(ActionListener ctrl) {
        HAtras.addActionListener(ctrl);        
    }


}
