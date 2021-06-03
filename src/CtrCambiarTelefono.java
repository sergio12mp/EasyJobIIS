import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrCambiarTelefono implements ActionListener {

    VistaEasyJob vistaEasy;     // Vista

    public CtrCambiarTelefono(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if(actComm.compareTo(PanelCambiarTelefono.bAtras) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("CONFIGURACION");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelConfiguracion panel = new PanelConfiguracion();
            CtrConfiguracion ctr = new CtrConfiguracion(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);

        }

    }
}
