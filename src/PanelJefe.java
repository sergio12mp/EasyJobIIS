import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelJefe extends JPanel implements VistaEasyJob {

    private String fuente = "Arial";

    public JButton VerEmpleados, Solicitudes, CerrarS, Conf, ChatJ,HelpJ;

    static String bVerEmpleados = "VER EMPLEADOS";
    static String bSolicitudes = "SOLICITUDES DE HORARIO";
    static String bCerrarS = "CERRAR SESION \n";
    static String bConf = "CONFIGURACION \n";
    static String bChatJ = "CHAT \n";
    static String bHelpJ = "HELP";


    public PanelJefe() {

        setLayout(new GridLayout(9, 3, 5, 5));

        VerEmpleados = new JButton(bVerEmpleados);
        VerEmpleados.setAlignmentX(Component.CENTER_ALIGNMENT);
        VerEmpleados.setFont(new Font(fuente, Font.BOLD, 20));

        Solicitudes = new JButton(bSolicitudes);
        Solicitudes.setFont(new Font(fuente, Font.BOLD, 20));
        Solicitudes.setAlignmentX(Component.CENTER_ALIGNMENT);

        CerrarS = new JButton(bCerrarS);
        CerrarS.setAlignmentX(Component.CENTER_ALIGNMENT);
        CerrarS.setFont(new Font(fuente, Font.BOLD, 20));

        Conf = new JButton(bConf);
        Conf.setAlignmentX(Component.CENTER_ALIGNMENT);
        Conf.setFont(new Font(fuente, Font.BOLD, 20));

        HelpJ = new JButton(bHelpJ);
        HelpJ.setAlignmentX(Component.CENTER_ALIGNMENT);
        HelpJ.setFont(new Font(fuente, Font.BOLD, 20));

        ChatJ = new JButton(bChatJ);
        ChatJ.setAlignmentX(Component.CENTER_ALIGNMENT);
        ChatJ.setFont(new Font(fuente, Font.BOLD, 20));


        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(VerEmpleados);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(Solicitudes);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(ChatJ);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(Conf);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(HelpJ);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(CerrarS);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

    }

    public void controlador(ActionListener ctrl) {
        CerrarS.addActionListener(ctrl);
        Solicitudes.addActionListener(ctrl);
        VerEmpleados.addActionListener(ctrl);
        ChatJ.addActionListener(ctrl);
        Conf.addActionListener(ctrl);
        HelpJ.addActionListener(ctrl);
    }

}
