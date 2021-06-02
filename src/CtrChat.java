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

        if (actComm.compareTo(PanelChat.ENVIARMENSAJE) == 0) {

            JOptionPane.showMessageDialog(null, "No se pueden enviar mensajes. Servidor en mantenimiento");


        } else if (actComm.compareTo(PanelChat.MENSAJESPENDIENTES) == 0) {

            JOptionPane.showMessageDialog(null, "No se pueden revisar los mensajes. Servidor en mantenimiento");

        } else if (actComm.compareTo(PanelChat.chatATRAS) == 0) {

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

        }
    }
}
