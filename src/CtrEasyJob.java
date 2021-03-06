import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class CtrEasyJob implements ActionListener {

    VistaEasyJob vistaEasy;     // Vista
    Usuario usuario;            // Modelo

    public CtrEasyJob(VistaEasyJob ve) {
        vistaEasy = ve;
    }

    public void actionPerformed(ActionEvent e) {
        String actComm = e.getActionCommand();

        if (actComm.compareTo(PanelIniciarSesion.botonRegistrar) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("Registro");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelRegistro panel = new PanelRegistro();

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(450,200,600,400);
            frame.setVisible(true);

        } else if (actComm.compareTo(PanelVistaPrincipal.bCS) == 0) {

            System.exit(0);

        } else if (actComm.compareTo(PanelVistaPrincipal.bHorario) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("Horario");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelHorario panel = new PanelHorario();
            CtrHorario ctr = new CtrHorario(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(250,180,1000,500);
            frame.setVisible(true);

        } else if (actComm.compareTo(PanelVistaPrincipal.bChat) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("Chat");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelChat panel = new PanelChat();

            CtrChat ctrChat = new CtrChat(panel);

            panel.controlador(ctrChat);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(250,180,1000,500);
            frame.setVisible(true);

        }else if (actComm.compareTo(PanelVistaPrincipal.bFichar) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("FICHAR");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            PanelFichar panel = null;
            try {
                panel = new PanelFichar();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            CtrFichar ctr = new CtrFichar(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(250,140,1000,600);
            frame.setVisible(true);

        }else if (actComm.compareTo(PanelVistaPrincipal.bConfiguracion) == 0) {

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

        }else if (actComm.compareTo(PanelVistaPrincipal.bHelp) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("HELP");
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
