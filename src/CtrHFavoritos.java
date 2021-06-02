import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrHFavoritos implements ActionListener {
    VistaEasyJob vistaEasy;     // Vista

    public CtrHFavoritos(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if (actComm.compareTo(PanelHFavoritos.bFAtras) == 0) {

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

            frame.setSize(600, 400);
            frame.setVisible(true);
        }
    }
}
