import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIniciarSesion extends JPanel implements VistaEasyJob{

        static final String botonLogin = "Entrar";
    static final String botonRegistrar = "Registrarse";

    JLabel login, blanco;
    JTextField dni, contrasena;
    JButton aceptar, registrar;

    public PanelIniciarSesion() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        login = new JLabel("Introduce tu DNI y contraseña: ");
        login.setMaximumSize(new Dimension(180, 40));
        login.setAlignmentX(Component.CENTER_ALIGNMENT);

        blanco = new JLabel("\n");
        blanco.setAlignmentX(Component.CENTER_ALIGNMENT);

        dni = new JTextField("", 20);
        dni.setMaximumSize(new Dimension(300, 20));
        dni.setAlignmentX(Component.CENTER_ALIGNMENT);

        contrasena = new JTextField("", 45);
        contrasena.setMaximumSize(new Dimension(300, 20));
        contrasena.setAlignmentX(Component.CENTER_ALIGNMENT);

        aceptar = new JButton(botonLogin);
        aceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dn = dni.getText();
                String cont = contrasena.getText();


                if(dn.isEmpty() || cont.isEmpty()) {
                    //status.setText("Tienes que introducir todos los campos");
                    JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos");
                } else {
                    System.out.println("BUSCAR USUARIO");

                    /*
                    JComponent comp = (JComponent) e.getSource();
                    Window win = SwingUtilities.getWindowAncestor(comp);
                    win.dispose();
                     */
                }
            }
        });

        registrar = new JButton(botonRegistrar);
        registrar.setAlignmentX(Component.CENTER_ALIGNMENT);

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
