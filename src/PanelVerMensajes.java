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

        listModel.addElement(" ");
        listModel.addElement("-------------------------------------------------------------------------------------");
        listModel.addElement(" ");

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
                if(PanelVerMensajes.seleccionado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun mensaje");
                } else {
                    String[] parts = seleccionado.split(" ");
                    System.out.println(parts[0]);

                    char c = parts[0].charAt(1);
                    int id = Character.getNumericValue(c);
                    conex.BorrarMensaje(id);

                    listModel.remove(index);
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
                System.out.println("Ningún elemento seleccionado");

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
