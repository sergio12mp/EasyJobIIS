import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrVerMensajes implements ActionListener {

    VistaEasyJob vistaEasy;     // Vista

    public CtrVerMensajes(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if(actComm.compareTo(PanelVerMensajes.bJVE) == 0) {

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

            frame.setSize(1000, 500);
            frame.setVisible(true);

        }
    }
}

