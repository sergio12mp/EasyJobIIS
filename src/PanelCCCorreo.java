import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCCCorreo extends JPanel implements VistaEasyJob {

    JButton aceptar, atras;
    static final String bAceptar = "ACEPTAR";
    static final String bAtras = "ATRAS";

    private JLabel correoAnt, correoNuevo, correoConf;
    private JTextField antCorreo, nuevoCorreo, confCorreo;

    ConexionBD conex = new ConexionBaseDatosJDBC();

    public PanelCCCorreo(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        correoAnt = new JLabel("Correo antiguo");
        correoAnt.setAlignmentX(Component.CENTER_ALIGNMENT);

        correoNuevo = new JLabel("Correo nuevo");
        correoNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);

        correoConf = new JLabel("Confirmar correo");
        correoConf.setAlignmentX(Component.CENTER_ALIGNMENT);

        antCorreo = new JTextField("", 40);
        antCorreo.setMaximumSize(new Dimension(300, 20));
        antCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);

        nuevoCorreo = new JTextField("", 40);
        nuevoCorreo.setMaximumSize(new Dimension(300, 20));
        nuevoCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);

        confCorreo = new JTextField("", 40);
        confCorreo.setMaximumSize(new Dimension(300, 20));
        confCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);

        aceptar = new JButton(bAceptar);
        aceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String actual = antCorreo.getText();
                String nuevo = nuevoCorreo.getText();
                String confirmacion = confCorreo.getText();

                if(nuevo.compareTo(confirmacion) == 0 && !nuevo.isEmpty() && !actual.isEmpty() && !confirmacion.isEmpty()) {
<<<<<<< HEAD
                    
                    conex.cambiarCorreo(PanelIniciarSesion.identificador, nuevo);
=======
>>>>>>> a2c16c3a2901d7b9b1ef0fe8029b100458281cc5

                    conex.cambiarCorreo(PanelIniciarSesion.identificador, nuevo);

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
        add(correoAnt);
        add(antCorreo);
        add(Box.createVerticalStrut(2));
        add(correoNuevo);
        add(nuevoCorreo);
        add(Box.createVerticalStrut(2));
        add(correoConf);
        add(confCorreo);
        add(Box.createVerticalStrut(5));
        add(aceptar);
        add(Box.createVerticalStrut(2));
        add(atras);
    }




    public void controlador(ActionListener ctrl) {
        atras.addActionListener(ctrl);
    }

}
