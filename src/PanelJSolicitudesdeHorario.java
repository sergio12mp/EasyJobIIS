
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.util.List;


public class PanelJSolicitudesdeHorario extends JPanel implements VistaEasyJob, ListSelectionListener {

    private String fuente = "Arial";

    ConexionBD conex = new ConexionBaseDatosJDBC();
    private JList<String> listaSolicitudes;

    private DefaultListModel listModel;
    public JButton volverAlMenu, Aceptar, Declinar;
    static String bVAM = "VOLVER AL MENU";
    static String bAceptar = "ACEPTAR";
    static String bDeclinar = "DECLINAR";
    static String seleccionado = "";
    private int index = -1;

    public PanelJSolicitudesdeHorario() {

        setLayout(new BorderLayout());

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1, 3, 5, 5));

        // Subpanel central derecho
        JScrollPane subpanelCentralDcho = new JScrollPane();

        List<SolicitudHorario> lista = conex.verSolicitudes();

        listModel = new DefaultListModel();

        for (SolicitudHorario s : lista) {
            listModel.addElement(s.toString());
        }
        listaSolicitudes = new JList<String>(listModel);
        listaSolicitudes.addListSelectionListener(this);
        subpanelCentralDcho.setViewportView(listaSolicitudes);


        volverAlMenu = new JButton(bVAM);
        volverAlMenu.setFont(new Font(fuente, Font.BOLD, 20));
        volverAlMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        volverAlMenu.setAlignmentY(Component.BOTTOM_ALIGNMENT);


        // Aceptar.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        Aceptar = new JButton(bAceptar);
        Aceptar.setAlignmentX(Component.LEFT_ALIGNMENT);
        Aceptar.setFont(new Font(fuente, Font.BOLD, 20));
        Aceptar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        Aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PanelJSolicitudesdeHorario.seleccionado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun mensaje");
                } else {
                    try {
                        int[] semana = new int[7];
                        String[] parts = seleccionado.split("[(, :)]" + "()" + " ");

                        int j = 0;
                        //dni 3
                        String[] fuera = parts[3].split(" ");
                        String dni = fuera[1];
                        for (int i = 5; i < parts.length; i = i + 2) {
                            if (parts[i].equals("Mañana")) {
                                semana[j] = 1;
                            } else if (parts[i].equals("Tarde")) {
                                semana[j] = 2;
                            } else if (parts[i].equals("Libre")) {
                                semana[j] = 0;
                            } else {
                                semana[j] = 3;
                            }
                            j++;

                        }

                         conex.cambiarHorario(dni, semana);

                        listModel.remove(index);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun mensaje");
                    }
                }
            }
        });


        Declinar = new JButton(bDeclinar);
        Declinar.setFont(new Font(fuente, Font.BOLD, 20));
        Declinar.setAlignmentX(Component.CENTER_ALIGNMENT);
        Declinar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PanelJSolicitudesdeHorario.seleccionado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun mensaje");
                } else {
                    try {
                        String[] parts = seleccionado.split(" ");
                        System.out.println(parts[0].length() + " " + parts[0]);
                        String c = parts[0].substring(1, parts[0].length() - 1);
                        System.out.println(c);
                        int id = Integer.parseInt(c);
                        conex.eliminarSolicitud(id);

                        listModel.remove(index);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun mensaje");
                    }
                }
            }
        });


        botones.add(Declinar);
        botones.add(Aceptar);
        botones.add(volverAlMenu);
        add(subpanelCentralDcho, BorderLayout.NORTH);
        add(botones, BorderLayout.SOUTH);

    }

    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (listaSolicitudes.getSelectedIndex() == -1) {
                //No selection, disable fire button.

            } else {
                //Selection, enable the fire button.
                seleccionado = listaSolicitudes.getSelectedValue();
                index = listaSolicitudes.getSelectedIndex();
            }
        }
    }

    public void controlador(ActionListener ctrl) {
        volverAlMenu.addActionListener(ctrl);
        Aceptar.addActionListener(ctrl);
        Declinar.addActionListener(ctrl);
    }


}