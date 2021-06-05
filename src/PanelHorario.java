import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelHorario extends JPanel implements VistaEasyJob {

    private String fuente = "Arial";


    private JButton sHorario, hAtras;

    static String bSHorario = "SOLICITAR HORARIO";
    static String bHAtras = "ATRAS";

    private DefaultListModel listModel;
    private String[] dias = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sábado","Domingo"};
    static String bFAtras = "ATRAS \n";

    ConexionBD conex = new ConexionBaseDatosJDBC();

    public PanelHorario() {

        setLayout(new BorderLayout());

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1, 2, 5, 5));

        sHorario = new JButton(bSHorario);
        sHorario.setFont(new Font(fuente, Font.BOLD, 18));
        sHorario.setAlignmentX(Component.CENTER_ALIGNMENT);

        hAtras = new JButton(bHAtras);
        hAtras.setFont(new Font(fuente, Font.BOLD, 18));
        hAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        JScrollPane subpanelCentralDcho = new JScrollPane();

        Horario h = conex.horarioFavorito(PanelIniciarSesion.identificador);
        int semana[] = h.getSemana();
        String semana2[] = new String[10];
        semana2[0] = "\n";
        semana2[1] = "\n";
        semana2[2] = "\n";
        for (int i = 0; i < 7; i++) {
            if(semana[i] == 0){
                semana2[i+3] = dias[i] + ":       " + "Libre";
            }else if(semana[i] == 1){
                semana2[i+3] = dias[i] + ":       "+ "Mañana";
            }else if(semana[i] == 2){
                semana2[i+3] = dias[i] + ":       "+ "Tarde";
            }else{
                semana2[i+3] = dias[i] + ":       "+ "Mañana y Tarde";
            }
        }

        JList listaSemana = new JList(semana2);

        listaSemana.setFont(new Font("Arial",Font.BOLD,20));

        DefaultListCellRenderer renderer = (DefaultListCellRenderer) listaSemana.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        subpanelCentralDcho.setViewportView(listaSemana);

        botones.add(sHorario);
        botones.add(hAtras);

        add(subpanelCentralDcho, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
    }

    public void controlador(ActionListener ctrl) {
        sHorario.addActionListener(ctrl);
        hAtras.addActionListener(ctrl);
    }
}



