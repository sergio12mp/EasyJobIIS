import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrConfiguracion implements ActionListener {
    VistaEasyJob vistaEasy;     // Vista

    public CtrConfiguracion(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if (!(PanelIniciarSesion.esJefe) && (actComm.compareTo(PanelConfiguracion.bCAtras) == 0)) {

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

            frame.setBounds(250,180,1000,500);
            frame.setVisible(true);
        } else if ((actComm.compareTo(PanelConfiguracion.bCAtras) == 0)&&(PanelIniciarSesion.esJefe)) {

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

            frame.setBounds(250,180,1000,500);
            frame.setVisible(true);
        }else if (actComm.compareTo(PanelConfiguracion.bCContraseña) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("CAMBIAR CONTRASEÑA");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelCCContraseña panel = new PanelCCContraseña();
            CtrCCContraseña ctr = new CtrCCContraseña(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(450,200,600,300);
            frame.setVisible(true);
        }else if (actComm.compareTo(PanelConfiguracion.bCCorreo) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("CAMBIAR CORREO");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelCCCorreo panel = new PanelCCCorreo();
            CtrCambCorreo ctr = new CtrCambCorreo(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(450,200,600,400);
            frame.setVisible(true);

        } else if (actComm.compareTo(PanelConfiguracion.bCTelefono) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("CAMBIAR TELEFONO");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelCambiarTelefono panel = new PanelCambiarTelefono();
            CtrCambiarTelefono ctr = new CtrCambiarTelefono(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setBounds(450,200,600,300);
            frame.setVisible(true);

        }else if (actComm.compareTo(PanelConfiguracion.bCFoto) == 0) {


            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("CAMBIAR FOTO");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelCCFoto panel = new PanelCCFoto();
            CtrCCFoto ctr = new CtrCCFoto(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();


            frame.setSize(1000, 500);

            frame.setBounds(450,300,600,200);

            frame.setVisible(true);

        }/*else if (actComm.compareTo(PanelConfiguracion.bCIdioma) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("CAMBIAR IDIOMA");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelCCIdioma panel = new PanelCCIdioma();
            CtrCCIdioma ctr = new CtrCCIdioma(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(600, 400);
            frame.setVisible(true);
        }else if (actComm.compareTo(PanelConfiguracion.bCModo) == 0) {

            JComponent comp = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();

            JFrame frame = new JFrame("MODO");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            PanelCCModo panel = new PanelCCModo();
            CtrCCModo ctr = new CtrCCModo(panel);
            panel.controlador(ctr);

            frame.getContentPane().add(panel);
            frame.pack();

            frame.setSize(600, 400);
            frame.setVisible(true);
        }
        */
    }
}

