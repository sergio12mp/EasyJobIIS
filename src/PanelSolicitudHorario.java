import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class PanelSolicitudHorario extends JPanel implements VistaEasyJob {

    private String fuente = "Arial";


    private JButton solicitar, solAtras;
    private JLabel ljefe, lunes, martes, miercoles, jueves, viernes, sabado, domingo;
    private JTextField jefe;

    private JCheckBox lunesMañana, lunesTarde, martesMañana, martesTarde, miercolesMañana, miercolesTarde;
    private JCheckBox juevesMañana, juevesTarde, viernesMañana, viernesTarde, sabadoMañada, sabadoTarde, domignoMañana, domingoTarde;

    static String bSolicitud= "SOLICITAR HORARIO";
    static String bSAtras= "VOLVER A HORARIO";

    ConexionBD conex = new ConexionBaseDatosJDBC();

    public PanelSolicitudHorario(){

        setLayout(new BorderLayout());

        JPanel jefeDNI = new JPanel();
        jefeDNI.setLayout(new BoxLayout(jefeDNI, BoxLayout.Y_AXIS));


        JPanel checkboxes = new JPanel();
        checkboxes.setLayout(new GridLayout(8, 7, 5, 3));

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1, 2, 5, 5));

        solAtras = new JButton(bSAtras);
        solAtras.setFont(new Font(fuente, Font.BOLD, 18));
        solAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        ljefe = new JLabel("DNI del jefe al que se quiere solicitar");
        ljefe.setMaximumSize(new Dimension(300, 20));
        ljefe.setAlignmentX(Component.CENTER_ALIGNMENT);

        jefe = new JTextField("", 20);
        ljefe.setMaximumSize(new Dimension(300, 20));
        jefe.setAlignmentX(Component.CENTER_ALIGNMENT);


        //JLabel hDisponible = new JLabel("AQUI VAN LOS HORARIOS FAVORITOS");

        JLabel lunes = new JLabel("LUNES");
        JLabel martes = new JLabel("MARTES");
        JLabel miercoles = new JLabel("MIERCOLES");
        JLabel jueves = new JLabel("JUEVES");
        JLabel viernes = new JLabel("VIERNES");
        JLabel sabado = new JLabel("SABADO");
        JLabel domingo = new JLabel("DOMINGO");

        JCheckBox lunesMañana = new JCheckBox("Mañana");
        JCheckBox lunesTarde = new JCheckBox("Tarde");
        JCheckBox martesMañana = new JCheckBox("Mañana");
        JCheckBox martesTarde = new JCheckBox("Tarde");
        JCheckBox miercolesMañana = new JCheckBox("Mañana");
        JCheckBox miercolesTarde = new JCheckBox("Tarde");
        JCheckBox juevesMañana = new JCheckBox("Mañana");
        JCheckBox juevesTarde = new JCheckBox("Tarde");
        JCheckBox viernesMañana = new JCheckBox("Mañana");
        JCheckBox viernesTarde = new JCheckBox("Tarde");
        JCheckBox sabadoMañana = new JCheckBox("Mañana");
        JCheckBox sabadoTarde = new JCheckBox("Tarde");
        JCheckBox domingoMañana = new JCheckBox("Mañana");
        JCheckBox domingoTarde = new JCheckBox("Tarde");

        solicitar = new JButton(bSolicitud);
        solicitar.setFont(new Font(fuente, Font.BOLD, 18));
        solicitar.setAlignmentX(Component.CENTER_ALIGNMENT);
        solicitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int[] solicitud = new int[7];

                boolean incorrecto = true;
                int j = 0;

                String destinatario = jefe.getText();

                if(!destinatario.isEmpty()) {

                    JCheckBox[] checkBoxesMañana = new JCheckBox[7];
                    checkBoxesMañana[0] = lunesMañana;
                    checkBoxesMañana[1] = martesMañana;
                    checkBoxesMañana[2] = miercolesMañana;
                    checkBoxesMañana[3] = juevesMañana;
                    checkBoxesMañana[4] = viernesMañana;
                    checkBoxesMañana[5] = sabadoMañana;
                    checkBoxesMañana[6] = domingoMañana;

                    JCheckBox[] checkBoxesTarde = new JCheckBox[7];
                    checkBoxesTarde[0] = lunesTarde;
                    checkBoxesTarde[1] = martesTarde;
                    checkBoxesTarde[2] = miercolesTarde;
                    checkBoxesTarde[3] = juevesTarde;
                    checkBoxesTarde[4] = viernesTarde;
                    checkBoxesTarde[5] = sabadoTarde;
                    checkBoxesTarde[6] = domingoTarde;


                    for (int i = 0; i < solicitud.length; i++) {
                        solicitud[i] = 0;
                    }

                    for (int i = 0; i < checkBoxesMañana.length; i++) {

                        if (checkBoxesMañana[i].isSelected() && checkBoxesTarde[i].isSelected()) {
                            solicitud[i] = 3;
                            j = j+2;
                        } else {
                            if (checkBoxesMañana[i].isSelected()) {
                                solicitud[i] = 1;
                                j++;
                            }
                            if (checkBoxesTarde[i].isSelected()) {
                                solicitud[i] = 2;
                                j++;
                            }
                        }
                    }

                    if(j<4) {
                        JOptionPane.showMessageDialog(null, "Tienes que seleccionar al menos 4 franjas");
                    } else {

                        conex.añadirSolicitud(destinatario, solicitud);

                        JComponent comp = (JComponent) e.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();

                        JFrame frame = new JFrame("HORARIOS");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                        PanelHorario panel = new PanelHorario();
                        CtrHorario ctr = new CtrHorario(panel);
                        panel.controlador(ctr);

                        frame.getContentPane().add(panel);
                        frame.pack();

                        frame.setSize(1000, 500);
                        frame.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos");
                }

            }
        });

        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(lunes);
        checkboxes.add(lunesMañana);
        checkboxes.add(lunesTarde);
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));

        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(martes);
        checkboxes.add(martesMañana);
        checkboxes.add(martesTarde);
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));

        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(miercoles);
        checkboxes.add(miercolesMañana);
        checkboxes.add(miercolesTarde);
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));

        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(jueves);
        checkboxes.add(juevesMañana);
        checkboxes.add(juevesTarde);
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));

        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(viernes);
        checkboxes.add(viernesMañana);
        checkboxes.add(viernesTarde);
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));

        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(sabado);
        checkboxes.add(sabadoMañana);
        checkboxes.add(sabadoTarde);
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));

        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(domingo);
        checkboxes.add(domingoMañana);
        checkboxes.add(domingoTarde);
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));

        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));
        checkboxes.add(Box.createVerticalStrut(3));

        botones.add(solicitar);
        botones.add(solAtras);

        jefeDNI.add(ljefe);
        jefeDNI.add(jefe);

        add(jefeDNI, BorderLayout.NORTH);
        add(checkboxes, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);


    }

    public void controlador(ActionListener ctrl) {
        solAtras.addActionListener(ctrl);
    }

}
