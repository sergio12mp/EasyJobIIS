import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelVistaPrincipal extends JPanel implements VistaEasyJob {

    private JButton Horario, Chat, Fichar, Configuracion, Help, CS;
    private String fuente = "Arial";

     static String bHorario = "HORARIO";
     static String bChat = "CHAT";
     static String bFichar = "FICHAR";
     static String bConfiguracion = "CONFIGURACION";
     static String bHelp = "HELP";
     static String bCS = "CERRAR SESION";


    public PanelVistaPrincipal() {


        // setLayout(null);
        setLayout(new GridLayout(8, 3, 5, 5));

        //Inicializamos las variables

        Horario = new JButton(bHorario);
        Horario.setFont(new Font(fuente, Font.BOLD, 20));
        Horario.setAlignmentX(Component.CENTER_ALIGNMENT);


        Chat = new JButton(bChat);
        Chat.setAlignmentX(Component.CENTER_ALIGNMENT);
        Chat.setFont(new Font(fuente, Font.BOLD, 20));


        Fichar = new JButton(bFichar);
        Fichar.setAlignmentX(Component.CENTER_ALIGNMENT);
        Fichar.setFont(new Font(fuente, Font.BOLD, 20));


        Configuracion = new JButton(bConfiguracion);
        Configuracion.setAlignmentX(Component.CENTER_ALIGNMENT);
        Configuracion.setFont(new Font(fuente, Font.BOLD, 20));


        Help = new JButton(bHelp);
        Help.setAlignmentX(Component.CENTER_ALIGNMENT);
        Help.setFont(new Font(fuente, Font.BOLD, 20));


        CS = new JButton(bCS);
        CS.setAlignmentX(Component.CENTER_ALIGNMENT);
        CS.setFont(new Font(fuente, Font.BOLD, 20));


        //AÑADIMOS AL PANEL
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));

        add(Horario, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Chat);
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Fichar);
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Configuracion);
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Help);
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(CS);
        add(Box.createVerticalStrut(3));
    }

    public void controlador(ActionListener ctrl) {
        Horario.addActionListener(ctrl);
        Fichar.addActionListener(ctrl);
        Chat.addActionListener(ctrl);
        Configuracion.addActionListener(ctrl);
        Help.addActionListener(ctrl);
        CS.addActionListener(ctrl);

    }

}
