import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrHSolicitud implements ActionListener {
    VistaEasyJob vistaEasy;     // Vista

    public CtrHSolicitud(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if (actComm.compareTo(PanelSolicitudHorario.bSAtras) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("HORARIOS");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            PanelHorario panel = new PanelHorario();
            CtrHorario ctr = new CtrHorario(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(250,180,1000,500);
            frame.setVisible(true);
        }
    }
}
