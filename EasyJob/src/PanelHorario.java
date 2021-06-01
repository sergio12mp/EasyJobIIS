import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelHorario extends JPanel implements VistaEasyJob {

    private String fuente = "Arial";


    private JButton Favoritos, sHorario, hAtras;
    private JLabel horas;

    static String bFav = "FAVORITOS";
    static String bSHorario = "SOLICITAR HORARIO";
    static String bHAtras = "ATRAS";

    public PanelHorario() {

        setLayout(new GridLayout(3, 3, 5, 5));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 3, 5, 5));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 3, 5, 5));

        Favoritos = new JButton(bFav);
        Favoritos.setFont(new Font(fuente, Font.BOLD, 18));
        Favoritos.setAlignmentX(Component.CENTER_ALIGNMENT);


        sHorario = new JButton(bSHorario);
        sHorario.setFont(new Font(fuente, Font.BOLD, 18));
        sHorario.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel horas = new JLabel("AQUI TIENE QUE IR LOS HORARIOS");

        hAtras = new JButton(bHAtras);
        hAtras.setFont(new Font(fuente, Font.BOLD, 18));
        hAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        p1.add(Box.createVerticalStrut(3));
        p1.add(Box.createVerticalStrut(3));
        p1.add(Box.createVerticalStrut(3));

        p1.add(Box.createVerticalStrut(3));
        p1.add(Favoritos);
        p1.add(Box.createVerticalStrut(3));

        add(p1);

        add(horas);

        p2.add(Box.createVerticalStrut(3));
        p2.add(sHorario);
        p2.add(Box.createVerticalStrut(3));

        p2.add(Box.createVerticalStrut(3));
        p2.add(hAtras);
        p2.add(Box.createVerticalStrut(3));

        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));

        add(p2);

    }

    public void controlador(ActionListener ctrl) {
        Favoritos.addActionListener(ctrl);
        sHorario.addActionListener(ctrl);
        hAtras.addActionListener(ctrl);
    }

}



