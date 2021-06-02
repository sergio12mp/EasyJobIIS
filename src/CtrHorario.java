import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrHorario implements ActionListener {
    VistaEasyJob vistaEasy;     // Vista

    public CtrHorario(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if (actComm.compareTo(PanelHorario.bSHorario) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("SOLICITAR HORARIO");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelSolicitudHorario panel = new PanelSolicitudHorario();
            CtrHSolicitud ctr = new CtrHSolicitud(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);


        } else if (actComm.compareTo(PanelHorario.bFav) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("FAVORITOS");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            PanelHFavoritos panel = new PanelHFavoritos();
            CtrHFavoritos ctr = new CtrHFavoritos(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);

        } else if (actComm.compareTo(PanelHorario.bHAtras) == 0) {

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
        }
    }
}
