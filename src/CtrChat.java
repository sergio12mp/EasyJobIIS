import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrChat implements ActionListener {

    VistaEasyJob vistaEasy;     // Vista

    public CtrChat(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if (actComm.compareTo(PanelChat.MENSAJESPENDIENTES) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("VER MENSAJES");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelVerMensajes panel = new PanelVerMensajes();
            CtrVerMensajes ctrChat = new CtrVerMensajes(panel);
            panel.controlador(ctrChat);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);

        } else if (actComm.compareTo(PanelChat.ENVIARMENSAJE) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("ENVIAR MENSAJE");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelEnviarMensaje panel = new PanelEnviarMensaje();
            CtrEnviarMensajes ctrChat = new CtrEnviarMensajes(panel);
            panel.controlador(ctrChat);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);

        } else if (!(PanelIniciarSesion.esJefe) && actComm.compareTo(PanelChat.chatATRAS) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("MENU");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            PanelVistaPrincipal panel = new PanelVistaPrincipal();

            CtrEasyJob ctr = new CtrEasyJob(panel);

            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);
        }else if ((PanelIniciarSesion.esJefe) && actComm.compareTo(PanelChat.chatATRAS) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("MENU");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            PanelJefe panel = new PanelJefe();

            CtrJefe ctr = new CtrJefe(panel);

            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);
        }
    }
}
