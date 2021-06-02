import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelSolicitudHorario extends JPanel implements VistaEasyJob, ListSelectionListener {

    private String fuente = "Arial";
    JList<String> listOpciones;


    private JButton solAtras;
    private JLabel hDisponible;

    static String bSAtras= "VOLVER A HORARIO";





    public PanelSolicitudHorario(){

        setLayout(new GridLayout(3,3,5,5));

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 3, 5, 5));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 3, 5, 5));



        String opcionesLista[] = {"LUNES","MARTES","MIERCOLES","JUEVES","VIERNES","SABADO","DOMINGO"};
        listOpciones = new JList<>(opcionesLista);
        //??
        listOpciones.addListSelectionListener(this);
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        solAtras = new JButton(bSAtras);
        solAtras.setFont(new Font(fuente, Font.BOLD, 18));
        solAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        //JLabel hDisponible = new JLabel("AQUI VAN LOS HORARIOS FAVORITOS");

        JLabel hDisponible = new JLabel(" HORARIOS DISPONIBLES");
        hDisponible.setFont(new Font(fuente, Font.BOLD, 25));

        add(listOpciones);


        p1.add(Box.createVerticalStrut(3));
        p1.add(Box.createVerticalStrut(3));
        p1.add(Box.createVerticalStrut(3));

        p1.add(Box.createVerticalStrut(3));
        p1.add(hDisponible);
        p1.add(Box.createVerticalStrut(3));

        add(p1);

        add(listOpciones);

        p2.add(Box.createVerticalStrut(3));
        p2.add(solAtras);
        p2.add(Box.createVerticalStrut(3));

        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));

        add(p2);



    }

    public void controlador(ActionListener ctrl) {
        solAtras.addActionListener(ctrl);
    }
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (listOpciones.getSelectedIndex() == -1) {
                //No selection, disable fire button.
                System.out.println("Ningún elemento seleccionado");

            } else {
                //Selection, enable the fire button.
                for(String selecc: listOpciones.getSelectedValuesList()) {
                    System.out.println(selecc);
                }
            }
        }
    }
}
