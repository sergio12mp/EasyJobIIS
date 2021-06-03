import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrFichar implements ActionListener {
    VistaEasyJob vistaEasy;     // Vista

    public CtrFichar(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if (actComm.compareTo(PanelFichar.bMFichar) == 0) {

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

            frame.setSize(1000, 600);
            frame.setVisible(true);
        }
    }
}
