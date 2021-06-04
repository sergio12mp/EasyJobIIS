import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCambiarTelefono extends JPanel implements VistaEasyJob {

    JButton aceptar, atras;
    static final String bAceptar = "ACEPTAR";
    static final String bAtras = "ATRAS";

    private JLabel tlfnAnt, tlfnNuevo, tlfnConf;
    private JTextField anttlfn, nuevotlfn, conftlfn;

    ConexionBD conex = new ConexionBaseDatosJDBC();

    public PanelCambiarTelefono(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        tlfnAnt = new JLabel("Telefono antiguo");
        tlfnAnt.setAlignmentX(Component.CENTER_ALIGNMENT);

        tlfnNuevo = new JLabel("Telefono nuevo");
        tlfnNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);

        tlfnConf = new JLabel("Confirmar telefono");
        tlfnConf.setAlignmentX(Component.CENTER_ALIGNMENT);

        anttlfn = new JTextField("", 40);
        anttlfn.setMaximumSize(new Dimension(300, 20));
        anttlfn.setAlignmentX(Component.CENTER_ALIGNMENT);

        nuevotlfn = new JTextField("", 40);
        nuevotlfn.setMaximumSize(new Dimension(300, 20));
        nuevotlfn.setAlignmentX(Component.CENTER_ALIGNMENT);

        conftlfn = new JTextField("", 40);
        conftlfn.setMaximumSize(new Dimension(300, 20));
        conftlfn.setAlignmentX(Component.CENTER_ALIGNMENT);

        aceptar = new JButton(bAceptar);
        aceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String actual = anttlfn.getText();
                String nuevo = nuevotlfn.getText();
                String confirmacion = conftlfn.getText();

                if(nuevo.compareTo(confirmacion) == 0 && !nuevo.isEmpty() && !actual.isEmpty() && !confirmacion.isEmpty()) {

                    conex.cambiarTelefono(PanelIniciarSesion.identificador,actual, nuevo);

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

                } else {
                    JOptionPane.showMessageDialog(null, "Datos introducidos incorrectamente");
                }
            }
        });

        atras = new JButton(bAtras);
        atras.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(5));
        add(tlfnAnt);
        add(anttlfn);
        add(Box.createVerticalStrut(2));
        add(tlfnNuevo);
        add(nuevotlfn);
        add(Box.createVerticalStrut(2));
        add(tlfnConf);
        add(conftlfn);
        add(Box.createVerticalStrut(5));
        add(aceptar);
        add(Box.createVerticalStrut(2));
        add(atras);
    }


    public void controlador(ActionListener ctrl) {
        atras.addActionListener(ctrl);
    }




}
