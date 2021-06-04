import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrJefe implements ActionListener {


    VistaEasyJob vistaEasy;     // Vista

    public CtrJefe(VistaEasyJob vb) {
        vistaEasy = vb;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String actComm = e.getActionCommand();

        if (actComm.compareTo(PanelJefe.bCerrarS) == 0) {
            System.exit(1);
        }else if (actComm.compareTo(PanelJefe.bConf) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("CONFIGURACION");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelConfiguracion panel = new PanelConfiguracion();
            CtrConfiguracion ctr = new CtrConfiguracion(panel);
           panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(250,180,1000,500);
            frame.setVisible(true);

        }else if (actComm.compareTo(PanelJefe.bModH) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("MODIFICAR HORARIO");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelJModificarHorario panel = new PanelJModificarHorario();
            CtrModificarHorario ctr = new CtrModificarHorario(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(450,200,600,400);            frame.setVisible(true);


        }else if (actComm.compareTo(PanelJefe.bSolicitudes) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("SOLICITUDES");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelJSolicitudesdeHorario panel = new PanelJSolicitudesdeHorario();
            CtrJSolicitud ctr = new CtrJSolicitud(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);


        }else if (actComm.compareTo(PanelJefe.bVerEmpleados) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("VER EMPLEADOS");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelJVerEmpleados panel = new PanelJVerEmpleados();
            CtrJEmpleados ctr = new CtrJEmpleados(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(250,180,1000,500);
            frame.setVisible(true);

        } else if (actComm.compareTo(PanelJefe.bChatJ) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("CHAT");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelChat panel = new PanelChat();
            CtrChat ctr = new CtrChat(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(250,180,1000,500);
            frame.setVisible(true);

        }  else if (actComm.compareTo(PanelJefe.bHelpJ) == 0) {

        JComponent comp = (JComponent) e.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();

        JFrame frame = new JFrame("CHAT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelHelp panel = new PanelHelp();
        CtrHelp ctr = new CtrHelp(panel);
        panel.controlador(ctr);

        frame.getContentPane().add(panel);
        frame.pack();

        frame.setBounds(250,180,1000,500);
        frame.setVisible(true);

        }
    }
}
