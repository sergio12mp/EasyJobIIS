import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCCFoto extends JPanel implements VistaEasyJob {

    JButton aceptar, atras;
    static final String bAceptar = "ACEPTAR";
    static final String bAtras = "ATRAS";

    private JLabel nuevaFoto;
    private JTextField fotoNueva;

    ConexionBD conex = new ConexionBaseDatosJDBC();

    public PanelCCFoto(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nuevaFoto = new JLabel("Nueva URL");
        nuevaFoto.setAlignmentX(Component.CENTER_ALIGNMENT);


        fotoNueva = new JTextField("", 40);
        fotoNueva.setMaximumSize(new Dimension(300, 20));
        fotoNueva.setAlignmentX(Component.CENTER_ALIGNMENT);

        aceptar = new JButton(bAceptar);
        aceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String actual = fotoNueva.getText();

                if(!actual.isEmpty()) {

                    conex.cambiarFoto(PanelIniciarSesion.identificador, actual);

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

        add(Box.createVerticalStrut(10));
        add(nuevaFoto);
        add(fotoNueva);
        add(Box.createVerticalStrut(5));
        add(aceptar);
        add(Box.createVerticalStrut(2));
        add(atras);
    }




    public void controlador(ActionListener ctrl) {
        atras.addActionListener(ctrl);
    }

}
