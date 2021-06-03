import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtrHelp implements ActionListener {
    VistaEasyJob vistaEasy;     // Vista

    public CtrHelp(VistaEasyJob vb) {
        vistaEasy = vb;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String actComm = e.getActionCommand();

        if (!(PanelIniciarSesion.esJefe) && (actComm.compareTo(PanelHelp.bHAtras) == 0)) {

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
        }else  if ((PanelIniciarSesion.esJefe) && (actComm.compareTo(PanelHelp.bHAtras) == 0)) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("MENU");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelJefe panel = new PanelJefe();
            CtrJefe ctr = new CtrJefe(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);
        }else if ( actComm.compareTo(PanelHelp.bHEnviar) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("MENU");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelJefe panel = new PanelJefe();
            CtrJefe ctr = new CtrJefe(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(1000, 500);
            frame.setVisible(true);
        }

        
    }

}
