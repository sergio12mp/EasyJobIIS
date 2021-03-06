import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelConfiguracion extends JPanel implements VistaEasyJob {
    private String fuente = "Arial";
    JButton CFoto, CContraseña, CCorreo, CTelefono, CAtras;
    static String bCFoto = "FOTO";
    static String bCContraseña = "CONTRASEÑA";
    static String bCCorreo = "CORREO";
    static String bCTelefono = "TELEFONO";
    static String bCAtras = "VOLVER A MENU";


    public PanelConfiguracion() {

        setLayout(new GridLayout(8, 3, 5, 5));


        CFoto = new JButton(bCFoto);
        CFoto.setFont(new Font(fuente, Font.BOLD, 20));
        CFoto.setAlignmentX(Component.CENTER_ALIGNMENT);

        CContraseña = new JButton(bCContraseña);
        CContraseña.setFont(new Font(fuente, Font.BOLD, 20));
        CContraseña.setAlignmentX(Component.CENTER_ALIGNMENT);

        CCorreo = new JButton(bCCorreo);
        CCorreo.setFont(new Font(fuente, Font.BOLD, 20));
        CCorreo.setAlignmentX(Component.CENTER_ALIGNMENT);

        CTelefono = new JButton(bCTelefono);
        CTelefono.setFont(new Font(fuente, Font.BOLD, 20));
        CTelefono.setAlignmentX(Component.CENTER_ALIGNMENT);


        CAtras = new JButton(bCAtras);
        CAtras.setFont(new Font(fuente, Font.BOLD, 20));
        CAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(CCorreo, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(CContraseña, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(CTelefono, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(CFoto, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(CAtras, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

    }

    public void controlador(ActionListener ctrl) {

        CFoto.addActionListener(ctrl);
        CContraseña.addActionListener(ctrl);
        CCorreo.addActionListener(ctrl);
        CTelefono.addActionListener(ctrl);
        CAtras.addActionListener(ctrl);
    }


}
