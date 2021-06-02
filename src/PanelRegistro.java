import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PanelRegistro extends JPanel implements VistaEasyJob{

    private static final String BT_NEW_USUARIO_ACCION_COMMAND = "BT_NEW_USUARIO_ACCION_COMMAND" ;

    private JLabel registro, status, nom, apell, cor, tele, dn, cont;
    private JTextField nombre, apellidos, correo, telefono, dni, contrasena;
    private JButton registrar;

    ConexionBD conex = new ConexionBaseDatosJDBC();


    public PanelRegistro() {

        //setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
        //setLayout(new GridLayout(20, 2, 10, 10));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        registro = new JLabel("Introduzca los datos de registro");
        registro.setMaximumSize(new Dimension(180, 50));
        registro.setAlignmentX(Component.CENTER_ALIGNMENT);

        status = new JLabel("");
        status.setAlignmentX(Component.CENTER_ALIGNMENT);

        nom = new JLabel("Nombre: ");
        nom.setAlignmentX(Component.CENTER_ALIGNMENT);
        apell = new JLabel("Apellidos: ");
        apell.setAlignmentX(Component.CENTER_ALIGNMENT);
        cor = new JLabel("Correo electronico: ");
        cor.setAlignmentX(Component.CENTER_ALIGNMENT);
        tele = new JLabel("Telefono: ");
        tele.setAlignmentX(Component.CENTER_ALIGNMENT);
        dn = new JLabel("DNI: ");
        dn.setAlignmentX(Component.CENTER_ALIGNMENT);
        cont = new JLabel("Contraseña: ");
        cont.setAlignmentX(Component.CENTER_ALIGNMENT);

        nombre = new JTextField("", 20);
        nombre.setMaximumSize(new Dimension(300, 20));
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);

        apellidos = new JTextField("", 40);
        apellidos.setMaximumSize(new Dimension(300, 20));
        apellidos.setAlignmentX(Component.CENTER_ALIGNMENT);

        correo = new JTextField("", 40);
        correo.setMaximumSize(new Dimension(300, 20));
        correo.setAlignmentX(Component.CENTER_ALIGNMENT);

        telefono = new JTextField("" , 15);
        telefono.setMaximumSize(new Dimension(300, 20));
        telefono.setAlignmentX(Component.CENTER_ALIGNMENT);

        dni = new JTextField("", 20);
        dni.setMaximumSize(new Dimension(300, 20));
        dni.setAlignmentX(Component.CENTER_ALIGNMENT);

        contrasena = new JTextField("", 45);
        contrasena.setMaximumSize(new Dimension(300, 20));
        contrasena.setAlignmentX(Component.CENTER_ALIGNMENT);


        registrar = new JButton("Registrar");
        registrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomb = nombre.getText();
                String apellid = apellidos.getText();
                String corr = correo.getText();
                String telef = telefono.getText();
                String id = dni.getText();
                String contra = contrasena.getText();

                if(nomb.isEmpty() || apellid.isEmpty() || corr.isEmpty() || telef.isEmpty() || id.isEmpty() || contra.isEmpty()) {
                    //status.setText("Tienes que introducir todos los campos");
                    JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos");
                } else {
                    Usuario usu = new Empleado(nomb, apellid, corr, id, telef, contra);
                    //status.setText("Registrado con exito");

                    conex.introducirUsuario(usu);
                    JComponent comp = (JComponent) e.getSource();
                    Window win = SwingUtilities.getWindowAncestor(comp);
                    win.dispose();

                    JFrame frame = new JFrame("Login");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    PanelIniciarSesion panel = new PanelIniciarSesion();
                    //PanelVistaPrincipal panel = new PanelVistaPrincipal();
                    //PanelHorario panel = new PanelHorario();
                    CtrEasyJob ctr = new CtrEasyJob(panel);
                    panel.controlador(ctr);

                    frame.getContentPane().add(panel);
                    frame.pack();

                    frame.setSize(450, 200);
                    frame.setVisible(true);
                }
            }
        });

        add(registro);
        add(nom);
        add(nombre);
        add(Box.createVerticalStrut(2));
        add(apell);
        add(apellidos);
        add(Box.createVerticalStrut(2));
        add(cor);
        add(correo);
        add(Box.createVerticalStrut(2));
        add(tele);
        add(telefono);
        add(Box.createVerticalStrut(2));
        add(dn);
        add(dni);
        add(Box.createVerticalStrut(2));
        add(cont);
        add(contrasena);
        add(Box.createVerticalStrut(2));
        add(status);
        add(Box.createVerticalStrut(10));
        add(registrar);
    }

    public JTextField getNombre() {return nombre;}

    public JTextField getApellidos (){
        return apellidos;
    }

    public JTextField getDNI (){
        return dni;
    }

    public JTextField getCorreo (){
        return correo;
    }

    public JTextField getTelefono(){
        return telefono;
    }

    public JTextField getContrasena () {
        return contrasena;
    }

    public void controlador (CtrlNuevoUsuario c) {
        registrar.addActionListener(c);
        registrar.setActionCommand(BT_NEW_USUARIO_ACCION_COMMAND);
    }
}
