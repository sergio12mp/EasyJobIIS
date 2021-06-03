import javax.swing.*;
import java.awt.*;

public class PanelCCContraseña extends JPanel implements VistaEasyJob {
    private String fuente = "Arial";

    JButton CContraseñaAtras, CContraseñaActualizar;
    JPasswordField contraseñaAntigua, contraseñaNueva;

    JLabel LcontraseñaAntigua, LcontraseñaNueva;


    static String bCContraseñaAtras = "ATRAS";
    static String bCContraseñaActualizar = "ACTUALIZAR";


    public PanelCCContraseña() {

        setLayout(new GridLayout(7, 4, 5, 5));

        JLabel LcontraseñaAntigua = new JLabel("CONTRASEÑA ACTUAL:");
        JLabel LcontraseñaActual = new JLabel("CONTRASEÑA NUEVA:");


        contraseñaAntigua = new JPasswordField("", 45);
        contraseñaAntigua.setMaximumSize(new Dimension(300, 20));
        contraseñaAntigua.setAlignmentX(Component.CENTER_ALIGNMENT);

        contraseñaNueva = new JPasswordField("", 45);
        contraseñaNueva.setMaximumSize(new Dimension(300, 20));
        contraseñaNueva.setAlignmentX(Component.CENTER_ALIGNMENT);

        CContraseñaAtras = new JButton(bCContraseñaAtras);
        CContraseñaAtras.setAlignmentX(Component.CENTER_ALIGNMENT);
        CContraseñaAtras.setFont(new Font(fuente, Font.BOLD, 20));

        CContraseñaActualizar = new JButton(bCContraseñaActualizar);
        CContraseñaActualizar.setAlignmentX(Component.CENTER_ALIGNMENT);
        CContraseñaActualizar.setFont(new Font(fuente, Font.BOLD, 20));


        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Box.createVerticalStrut(3));
        add(LcontraseñaAntigua);
        add(contraseñaAntigua);
        add(Box.createVerticalStrut(3));


        add(Box.createVerticalStrut(3));
        add(LcontraseñaNueva);
        add(contraseñaNueva);
        add(Box.createVerticalStrut(3));


        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
    }


    public void controlador(CtrCCContraseña ctr) {
        contraseñaAntigua.addActionListener(ctr);
        contraseñaNueva.addActionListener(ctr);
        CContraseñaActualizar.addActionListener(ctr);
        CContraseñaAtras.addActionListener(ctr);
    }
}
