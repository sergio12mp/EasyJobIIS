import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelJVerEmpleados extends JPanel implements VistaEasyJob, ListSelectionListener {
    private String fuente = "Arial";

    ConexionBD conex = new ConexionBaseDatosJDBC();

    private String usuarios[];
    private JList<String> listaUsuarios;
    static String seleccionado = "";
    private int index = -1;
    private DefaultListModel listModel;

    JButton borrar, ascender, jAtras;

    static String bBorrar = "BORRAR";
    static String bAscender = "ASCENDER";
    static String bJVE = "VOLVER AL MENU";

    public PanelJVerEmpleados(){

        setLayout(new BorderLayout());

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1, 3, 5, 5));

        JScrollPane subpanelCentralDcho = new JScrollPane();
        List<Usuario> lista = conex.verUsuarios();

        listModel = new DefaultListModel();

        for(Usuario u : lista) {
            listModel.addElement(u.toString());
        }


        listaUsuarios = new JList<String>(listModel);
        listaUsuarios.addListSelectionListener(this);
        subpanelCentralDcho.setViewportView(listaUsuarios);

        borrar = new JButton(bBorrar);
        borrar.setFont(new Font(fuente, Font.BOLD, 20));
        borrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PanelJVerEmpleados.seleccionado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun usuario");
                } else {
                    String[] parts = seleccionado.split(",");
                    conex.eliminarUsuario(parts[0]);
                    listModel.remove(index);
                }
            }
        });

        ascender = new JButton(bAscender);
        ascender.setFont(new Font(fuente, Font.BOLD, 20));
        ascender.setAlignmentX(Component.CENTER_ALIGNMENT);
        ascender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PanelJVerEmpleados.seleccionado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun usuario");
                } else {

                    System.out.println(seleccionado);

                    String aux = seleccionado;
                    String[] parts = aux.split(",");
                    String dni = parts[0];

                    boolean jefe = conex.esOnoJefe(dni);

                    conex.Ascender(dni, jefe);

                    listModel.remove(index);

                    if(!jefe) {
                        seleccionado = seleccionado + ", ES JEFE";
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for(int i=0; i<parts.length-2; i++) {
                            sb.append(parts[i]);
                            sb.append(", ");
                        }
                        sb.append(parts[parts.length-2]);
                        seleccionado = sb.toString();
                    }

                    listModel.add(index, seleccionado);
                }
            }
        });

        jAtras = new JButton(bJVE);
        jAtras.setFont(new Font(fuente, Font.BOLD, 20));
        jAtras.setAlignmentX(Component.CENTER_ALIGNMENT);


        botones.add(ascender);
        botones.add(borrar);
        botones.add(jAtras);

        add(subpanelCentralDcho, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);

    }

    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (listaUsuarios.getSelectedIndex() == -1) {
                //No selection, disable fire button.

            } else {
                //Selection, enable the fire button.
                seleccionado = listaUsuarios.getSelectedValue();
                index = listaUsuarios.getSelectedIndex();

            }
        }
    }

    public void controlador(ActionListener ctrl) {
        jAtras.addActionListener(ctrl);
    }

}
