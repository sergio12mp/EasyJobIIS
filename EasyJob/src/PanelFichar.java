import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class PanelFichar extends JPanel implements VistaEasyJob {
    private String fuente = "Arial";

    private JButton ficharAtras;
    private JLabel fichar,imagen;

    static String bFichar = "FICHAR";
    static String bMFichar = "VOLVER AL MENU";

    public PanelFichar() {
        setLayout(new GridLayout(3, 3, 5, 5));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 3, 5, 5));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 3, 5, 5));


        ficharAtras = new JButton(bMFichar);
        ficharAtras.setFont(new Font(fuente, Font.BOLD, 18));
        ficharAtras.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel fichar = new JLabel("              FICHAR");
        fichar.setFont(new Font(fuente, Font.BOLD, 25));

        JLabel imagen = new JLabel("AQUI VA EL QR PERSONAL");

        p1.add(Box.createVerticalStrut(3));
        p1.add(Box.createVerticalStrut(3));
        p1.add(Box.createVerticalStrut(3));

        p1.add(Box.createVerticalStrut(3));
        p1.add(fichar);
        p1.add(Box.createVerticalStrut(3));

        add(p1);

        add(imagen);

        p2.add(Box.createVerticalStrut(3));
        p2.add(ficharAtras);
        p2.add(Box.createVerticalStrut(3));

        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));

        add(p2);


    }
    public void controlador(ActionListener ctrl) {
        ficharAtras.addActionListener(ctrl);
    }

}
