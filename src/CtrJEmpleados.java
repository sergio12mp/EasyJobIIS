import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrJEmpleados implements ActionListener {

    VistaEasyJob vistaEasy;     // Vista
    ConexionBD conex = new ConexionBaseDatosJDBC();

    public CtrJEmpleados(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if(actComm.compareTo(PanelJVerEmpleados.bJVE) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("PanelJefe");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            PanelJefe panel = new PanelJefe();

            CtrJefe ctr = new CtrJefe(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(250,180,1000,500);
            frame.setVisible(true);

        }
    }
}
