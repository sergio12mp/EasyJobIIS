import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelJVerEmpleados extends JPanel implements VistaEasyJob {
    private String fuente = "Arial";

    enum ProvinciaAndaluza {
        Almería, Cádiz, Córdoba, Granada, Huelva, Jaén, Málaga, Sevilla
    }

    JButton jAtras;
    static String bJVE = "VOLVER AL MENU";

    public PanelJVerEmpleados(){



        // Subpanel central derecho
        JScrollPane subpanelCentralDcho = new JScrollPane();
        // Suponemos que las entradas de la lista son las
        // provincias andaluzas
        ProvinciaAndaluza[] provs = new ProvinciaAndaluza[8];
        for (ProvinciaAndaluza prov : ProvinciaAndaluza.values()) {
            provs[prov.ordinal()] = prov;
        }
        JList listaProvs = new JList(provs);
        subpanelCentralDcho.setViewportView(listaProvs);


        jAtras = new JButton(bJVE);
        jAtras.setFont(new Font(fuente, Font.BOLD, 20));
        jAtras.setAlignmentX(Component.CENTER_ALIGNMENT);


        setLayout(new BorderLayout());
        add(subpanelCentralDcho, BorderLayout.CENTER);
        add(jAtras,BorderLayout.SOUTH);


    }

    public void controlador(ActionListener ctrl) {
        jAtras.addActionListener(ctrl);
    }

}
