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

        if(actComm.compareTo(PanelIniciarSesion.botonLogin) == 0) {


        } else if(actComm.compareTo(PanelIniciarSesion.botonRegistrar) == 0){

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

        }

    }
}
