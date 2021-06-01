import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrEasyJob implements ActionListener {

    VistaEasyJob vistaEasy;     // Vista
    Usuario usuario;            // Modelo

    public CtrEasyJob(VistaEasyJob ve) {
        vistaEasy = ve;
    }

    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if ((actComm.compareTo(PanelIniciarSesion.botonLogin) == 0)
            //&&loginOK(usuario,contraseña)
        ) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("MENU");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            PanelVistaPrincipal panel = new PanelVistaPrincipal();

            panel.controlador(this);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);


        } else if (actComm.compareTo(PanelIniciarSesion.botonRegistrar) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("Registro");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            PanelRegistro panel = new PanelRegistro();

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(600, 400);
            frame.setVisible(true);

        } else if (actComm.compareTo(PanelVistaPrincipal.bCS) == 0) {

            System.exit(0);

        } else if (actComm.compareTo(PanelVistaPrincipal.bHorario) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("Horario");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            PanelHorario panel = new PanelHorario();
            panel.controlador(this);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(600, 400);
            frame.setVisible(true);

        } else if (actComm.compareTo(PanelVistaPrincipal.bChat) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("Chat");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            PanelChat panel = new PanelChat();
            panel.controlador(this);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(800, 400);
            frame.setVisible(true);

        } else if (actComm.compareTo(PanelChat.ENVIARMENSAJE) == 0) {

            JOptionPane.showMessageDialog(null, "No se pueden enviar mensajes. Servidor en mantenimiento");


        } else if (actComm.compareTo(PanelChat.MENSAJESPENDIENTES) == 0) {

            JOptionPane.showMessageDialog(null, "No se pueden revisar los mensajes. Servidor en mantenimiento");

        } else if ((actComm.compareTo(PanelHorario.bHAtras) == 0) || (actComm.compareTo(PanelChat.chatATRAS) == 0)) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("MENU");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            PanelVistaPrincipal panel = new PanelVistaPrincipal();

            panel.controlador(this);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);

        }else if (actComm.compareTo(PanelHorario.bFav) == 0) {


            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("FAVORITOS");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            PanelHFavoritos panel = new PanelHFavoritos();

            panel.controlador(this);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);

        }else if (actComm.compareTo(PanelHFavoritos.bFAtras) == 0) {


            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("FAVORITOS");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            PanelHorario panel = new PanelHorario();

            panel.controlador(this);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);

        }

    }
}
