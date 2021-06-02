import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class PanelIniciarSesion extends JPanel implements VistaEasyJob {

    static final String botonLogin = "Entrar";
    static final String botonRegistrar = "Registrarse";

    private JLabel login, blanco;
    private JTextField dni;
    private JPasswordField contrasena;
    private JButton aceptar, registrar;

    ConexionBD conex = new ConexionBaseDatosJDBC();

    public PanelIniciarSesion() {

        // Elegimos el Layout del panel

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Inicializamos todos los componentes

        login = new JLabel("Introduce tu DNI y contraseña: ");
        login.setMaximumSize(new Dimension(180, 40));
        login.setAlignmentX(Component.CENTER_ALIGNMENT);

        blanco = new JLabel("\n");
        blanco.setAlignmentX(Component.CENTER_ALIGNMENT);

        dni = new JTextField("", 20);
        dni.setMaximumSize(new Dimension(300, 20));
        dni.setAlignmentX(Component.CENTER_ALIGNMENT);

        contrasena = new JPasswordField("", 45);
        contrasena.setMaximumSize(new Dimension(300, 20));
        contrasena.setAlignmentX(Component.CENTER_ALIGNMENT);

        aceptar = new JButton(botonLogin);
        aceptar.setMinimumSize(new Dimension(150, 20));
        aceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dn = dni.getText();
                String cont = contrasena.getText();

                if (dn.isEmpty() || cont.isEmpty()) {
                    //status.setText("Tienes que introducir todos los campos");
                    JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos");
                } else {
                    if (!conex.buscarUsuario(dn, cont)) {
                        JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrectos");
                    } else {
                        if (!conex.esJefe(dn, cont)) {
                            //JOptionPane.showMessageDialog(null, "Usuario y contraseña correctos");

                            JComponent comp = (JComponent) e.getSource();
                            Window win = SwingUtilities.getWindowAncestor(comp);
                            win.dispose();

                            JFrame frame = new JFrame("MENU");
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


                            PanelVistaPrincipal panel = new PanelVistaPrincipal();

                            CtrEasyJob ctr = new CtrEasyJob(panel);
                            panel.controlador(ctr);

                            frame.getContentPane().add(panel);
                            frame.pack();

                            frame.setSize(1000, 500);
                            frame.setVisible(true);

                        } else {

                            JComponent comp = (JComponent) e.getSource();
                            Window win = SwingUtilities.getWindowAncestor(comp);
                            win.dispose();

                            JFrame frame = new JFrame("MENU JEFE");
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


                            PanelJefe panel = new PanelJefe();

                            CtrEasyJob ctr = new CtrEasyJob(panel);
                            panel.controlador(this);

                            frame.getContentPane().add(panel);
                            frame.pack();

                            frame.setSize(1000, 500);
                            frame.setVisible(true);

                        }
                    }
                }
            }
        });

        registrar = new JButton(botonRegistrar);
        registrar.setMinimumSize(new Dimension(150, 20));
        registrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadimos al panel

        add(login);
        add(dni);
        add(Box.createVerticalStrut(3));
        add(contrasena);
        add(Box.createVerticalStrut(10));
        add(aceptar);
        add(Box.createVerticalStrut(5));
        add(registrar);
    }

    public void controlador(ActionListener contrl) {
        aceptar.addActionListener(contrl);
        registrar.addActionListener(contrl);
    }

}
