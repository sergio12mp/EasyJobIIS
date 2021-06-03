import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCCContraseña extends JPanel implements VistaEasyJob {
    private String fuente = "Arial";

    JButton CContraseñaAtras, CContraseñaActualizar;
    JPasswordField contraseñaAntigua, contraseñaNueva,contraseñaConf;

    JLabel LcontraseñaAntigua, LcontraseñaNueva,LcontraseñaConf;


    static String bCContraseñaAtras = "ATRAS";
    static String bCContraseñaActualizar = "ACTUALIZAR";

    ConexionBD conex = new ConexionBaseDatosJDBC();


    public PanelCCContraseña() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel LcontraseñaAntigua = new JLabel("Contraseña actual");
        LcontraseñaAntigua.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel LcontraseñaNueva = new JLabel("Contraseña nueva");
        LcontraseñaNueva.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel LcontraseñaConf = new JLabel("Confirmar contraseña");
        LcontraseñaConf.setAlignmentX(Component.CENTER_ALIGNMENT);


        contraseñaAntigua = new JPasswordField("", 45);
        contraseñaAntigua.setMaximumSize(new Dimension(300, 20));
        contraseñaAntigua.setAlignmentX(Component.CENTER_ALIGNMENT);

        contraseñaNueva = new JPasswordField("", 45);
        contraseñaNueva.setMaximumSize(new Dimension(300, 20));
        contraseñaNueva.setAlignmentX(Component.CENTER_ALIGNMENT);

        contraseñaConf = new JPasswordField("", 45);
        contraseñaConf.setMaximumSize(new Dimension(300, 20));
        contraseñaConf.setAlignmentX(Component.CENTER_ALIGNMENT);

        CContraseñaAtras = new JButton(bCContraseñaAtras);
        CContraseñaAtras.setAlignmentX(Component.CENTER_ALIGNMENT);
        CContraseñaAtras.setFont(new Font(fuente, Font.BOLD, 20));

        CContraseñaActualizar = new JButton(bCContraseñaActualizar);
        CContraseñaActualizar.setAlignmentX(Component.CENTER_ALIGNMENT);
        CContraseñaActualizar.setFont(new Font(fuente, Font.BOLD, 20));
        CContraseñaActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String actual = contraseñaAntigua.getText();
                String nuevo = contraseñaNueva.getText();
                String confirmacion = contraseñaConf.getText();

                if(nuevo.compareTo(confirmacion) == 0 && !nuevo.isEmpty() && !actual.isEmpty() && !confirmacion.isEmpty()) {

                    conex.cambiarContraseña(PanelIniciarSesion.identificador, nuevo);

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



        add(Box.createVerticalStrut(10));
        add(LcontraseñaAntigua);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(contraseñaAntigua);
        add(Box.createVerticalStrut(3));


        add(Box.createVerticalStrut(3));
        add(LcontraseñaNueva);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(contraseñaNueva);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(LcontraseñaConf);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(contraseñaConf);
        add(Box.createVerticalStrut(3));


        add(Box.createVerticalStrut(3));
        add(CContraseñaAtras);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(CContraseñaActualizar);
        add(Box.createVerticalStrut(3));

    }


    public void controlador(ActionListener ctr) {
        contraseñaAntigua.addActionListener(ctr);
        contraseñaNueva.addActionListener(ctr);
        CContraseñaActualizar.addActionListener(ctr);
        CContraseñaAtras.addActionListener(ctr);
    }

}
