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

        if (actComm.compareTo(PanelIniciarSesion.botonLogin) == 0) {

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

        } else if (actComm.compareTo(PanelVistaPrincipal.bHorario) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("Horario");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            PanelRegistro panel = new PanelRegistro();

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(600, 400);
            frame.setVisible(true);

        }

    }
}
