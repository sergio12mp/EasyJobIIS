import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrEnviarMensajes implements ActionListener {

    VistaEasyJob vistaEasy;     // Vista

    public CtrEnviarMensajes(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if(actComm.compareTo(PanelEnviarMensaje.bAtras) == 0) {

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

        }
    }
}
