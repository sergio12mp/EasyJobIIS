import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelJefe extends JPanel implements VistaEasyJob {

    private String fuente = "Arial";

    public JButton ModH, VerEmpleados, Solicitudes, CerrarS, Conf;

    public JLabel JEFE;

    static String bModH = "MODIFICAR HORARIO";
    static String bVerEmpleados = "VER EMPLEADOS";
    static String bSolicitudes = "SOLICITUDES DE HORARIO";
    static String bCerrarS = "CERRAR SESION \n";
    static String bConf = "CONFIGURACION \n";


    public PanelJefe() {

        setLayout(new GridLayout(8, 3, 5, 5));

        JLabel JEFE = new JLabel("JEFE");

        ModH = new JButton(bModH);
        ModH.setFont(new Font(fuente, Font.BOLD, 20));
        ModH.setAlignmentX(Component.CENTER_ALIGNMENT);

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


        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));


        add(Box.createVerticalStrut(3));
        add(JEFE, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(ModH, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(VerEmpleados, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(Solicitudes, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(CerrarS, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(Conf, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));


        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

    }

    public void controlador(ActionListener ctrl) {

    }

}
