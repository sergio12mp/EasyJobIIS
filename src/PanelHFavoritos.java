import com.sun.jdi.IntegerValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelHFavoritos extends JPanel implements VistaEasyJob {

    private String fuente = "Arial";


    private JButton fAtras;
    private JLabel fav, hFav;
    private DefaultListModel listModel;

    static String bFAtras = "ATRAS \n";

    ConexionBD conex = new ConexionBaseDatosJDBC();

    public PanelHFavoritos() {

        setLayout(new GridLayout(3, 3, 5, 5));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 3, 5, 5));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 3, 5, 5));



        fAtras = new JButton(bFAtras);
        fAtras.setFont(new Font(fuente, Font.BOLD, 18));
        fAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel fav = new JLabel("FAVORITOS");
        fav.setFont(new Font(fuente, Font.BOLD, 25));

        JScrollPane subpanelCentralDcho = new JScrollPane();


        Horario h = conex.horarioFavorito(PanelIniciarSesion.identificador);
        int semana[] = h.getSemana();
        Integer semana2[] = new Integer[7];
        for(int i=0;i<7;i++){
            semana2[i] = Integer.valueOf(semana[i]);
        }


        JList<Integer> listaSemana = new JList<Integer>(semana2);

        subpanelCentralDcho.setViewportView(listaSemana);


        p1.add(Box.createVerticalStrut(3));
        p1.add(Box.createVerticalStrut(3));
        p1.add(Box.createVerticalStrut(3));

        p1.add(Box.createVerticalStrut(3));
        p1.add(fav);
        p1.add(Box.createVerticalStrut(3));

        add(p1);

        add(subpanelCentralDcho);

        p2.add(Box.createVerticalStrut(3));
        p2.add(fAtras);
        p2.add(Box.createVerticalStrut(3));

        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));

        add(p2);

    }

    public void controlador(ActionListener ctrl) {
        fAtras.addActionListener(ctrl);
    }

}
