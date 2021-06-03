import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelVerMensajes extends JPanel implements VistaEasyJob, ListSelectionListener {

    private String fuente = "Arial";

    ConexionBD conex = new ConexionBaseDatosJDBC();

    private String usuarios[];
    private JList<String> listaMensajes;
    static String seleccionado = "";
    private int index = -1;
    private DefaultListModel listModel;

    JButton borrar, jAtras;

    static String bBorrar = "BORRAR";
    static String bJVE = "VOLVER AL MENU";
    private final String separador = "-------------------------------------------------------------------------------------";

    public PanelVerMensajes(){

        setLayout(new BorderLayout());

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1, 2, 5, 5));

        JScrollPane subpanelCentralDcho = new JScrollPane();

        List<Mensaje> lista = conex.verMensajes();

        listModel = new DefaultListModel();

        for(Mensaje m : lista) {
            listModel.addElement(m.toString());
        }

        List<Mensaje> listaEnviados = conex.verMensajesEnviados();

        if(!lista.isEmpty()) {
            listModel.addElement(" ");
            listModel.addElement(separador);
            listModel.addElement(" ");
        }

        for(Mensaje m : listaEnviados) {
            listModel.addElement(m.toString());
        }


        listaMensajes = new JList<String>(listModel);
        listaMensajes.addListSelectionListener(this);
        subpanelCentralDcho.setViewportView(listaMensajes);

        borrar = new JButton(bBorrar);
        borrar.setFont(new Font(fuente, Font.BOLD, 20));
        borrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PanelVerMensajes.seleccionado.isEmpty() || PanelVerMensajes.seleccionado.compareTo(separador) == 0) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun mensaje");
                } else {
                    try {
                        String[] parts = seleccionado.split(" ");

                        String c = parts[0].substring(1, parts[0].length()-1);
                        int id = Integer.parseInt(c);
                        conex.BorrarMensaje(id);

                        listModel.remove(index);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun mensaje");
                    }
                }
            }
        });

        jAtras = new JButton(bJVE);
        jAtras.setFont(new Font(fuente, Font.BOLD, 20));
        jAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        botones.add(borrar);
        botones.add(jAtras);

        add(subpanelCentralDcho, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);

    }

    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (listaMensajes.getSelectedIndex() == -1) {
                //No selection, disable fire button.

            } else {
                //Selection, enable the fire button.
                seleccionado = listaMensajes.getSelectedValue();
                index = listaMensajes.getSelectedIndex();
            }
        }
    }

    public void controlador(ActionListener ctrl) {
        jAtras.addActionListener(ctrl);
    }

}
