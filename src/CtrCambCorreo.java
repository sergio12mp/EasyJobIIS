import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrCambCorreo implements ActionListener {

    VistaEasyJob vistaEasy;     // Vista

    public CtrCambCorreo(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if(actComm.compareTo(PanelCCCorreo.bAtras) == 0) {

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

            frame.setBounds(250,180,1000,500);            frame.setVisible(true);

        }

    }
}
