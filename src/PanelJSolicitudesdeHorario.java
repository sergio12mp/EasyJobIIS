
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.util.List;


public class PanelJSolicitudesdeHorario extends JPanel implements VistaEasyJob {

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



    enum xProvinciaAndaluza {
        Almería, Cádiz, XCórdobaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa, Granada, Huelva, Jaén, Málaga, Sevilla
    }


    public PanelJSolicitudesdeHorario() {

        setLayout(new BorderLayout());

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(1,3,5,5));



        // Subpanel central derecho
        JScrollPane subpanelCentralDcho = new JScrollPane();
        
        List<SolicitudHorario> lista = conex.verSolicitudes();

         listModel = new DefaultListModel();
        
         for(SolicitudHorario s:lista){
             listModel.addElement(s.toString());
         }


        volverAlMenu = new JButton(bVAM);
        volverAlMenu.setFont(new Font(fuente, Font.BOLD, 20));
        volverAlMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        volverAlMenu.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        Aceptar = new JButton(bAceptar);
        Aceptar.setFont(new Font(fuente, Font.BOLD, 20));
        Aceptar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        Aceptar.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Aceptar.setAlignmentY(Component.BOTTOM_ALIGNMENT);

   

        Declinar = new JButton(bDeclinar);
        Declinar.setFont(new Font(fuente, Font.BOLD, 20));
        Declinar.setAlignmentX(Component.CENTER_ALIGNMENT);
        Declinar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(PanelJSolicitudesdeHorario.seleccionado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun mensaje");
                } else {
                    try {
                        String[] parts = seleccionado.split(" ");
                        System.out.println(parts[0].length() + " " + parts[0]);
                        String c = parts[0].substring(1, parts[0].length()-1);
                        System.out.println(c);
                        int id = Integer.parseInt(c);
                        conex.BorrarMensaje(id);

                        listModel.remove(index);
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun mensaje");
                    }
                }
            }
        });




        add(subpanelCentralDcho, BorderLayout.NORTH);
        add(Declinar, BorderLayout.SOUTH);
        add(Aceptar, BorderLayout.SOUTH);
        add(volverAlMenu, BorderLayout.SOUTH);
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