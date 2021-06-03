
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;


public class PanelJSolicitudesdeHorario extends JPanel implements VistaEasyJob {

    private String fuente = "Arial";

    public JButton volverAlMenu, Aceptar, Declinar;
    static String bVAM = "VOLVER AL MENU";
    static String bAceptar = "ACEPTAR";
    static String bDeclinar = "DECLINAR";


    enum xProvinciaAndaluza {
        Almería, Cádiz, XCórdobaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa, Granada, Huelva, Jaén, Málaga, Sevilla
    }


    public PanelJSolicitudesdeHorario() {


        // Subpanel central derecho
        JScrollPane subpanelCentralDcho = new JScrollPane();
        // Suponemos que las entradas de la lista son las
        // provincias andaluzas
        xProvinciaAndaluza[] provs = new PanelJSolicitudesdeHorario.xProvinciaAndaluza[8];
        for (PanelJSolicitudesdeHorario.xProvinciaAndaluza prov : PanelJSolicitudesdeHorario.xProvinciaAndaluza.values()) {
            provs[prov.ordinal()] = prov;
        }
        JList listaProvs = new JList(provs);
        subpanelCentralDcho.setViewportView(listaProvs);


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
        Declinar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        Declinar.setAlignmentX(Component.RIGHT_ALIGNMENT);


        add(subpanelCentralDcho, BorderLayout.NORTH);
        add(Declinar, BorderLayout.SOUTH);
        add(Aceptar, BorderLayout.SOUTH);
        add(volverAlMenu, BorderLayout.SOUTH);
    }

    public void controlador(ActionListener ctrl) {
        volverAlMenu.addActionListener(ctrl);
        Aceptar.addActionListener(ctrl);
        Declinar.addActionListener(ctrl);
    }



}