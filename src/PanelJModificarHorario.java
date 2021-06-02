import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelJModificarHorario extends JPanel implements VistaEasyJob {

    private String fuente = "Arial";


    public JButton volverAlMenu;
    public JLabel  modH;

    static String bVAM = "VOLVER AL MENU";

public PanelJModificarHorario(){

    JLabel modH = new JLabel("MODIFICAR HORARIO");
    modH.setAlignmentX(Component.CENTER_ALIGNMENT);
    modH.setAlignmentY(Component.TOP_ALIGNMENT);
    //------------
    JPanel subpanelCentralIzqdo = new JPanel();
    subpanelCentralIzqdo.setLayout(new BorderLayout());
    JLabel lDesc = new JLabel("Descripción");
    JTextArea taDesc = new JTextArea(10, 20);
    taDesc.setText("Introducir descrición");
    subpanelCentralIzqdo.add(lDesc, BorderLayout.NORTH);
    subpanelCentralIzqdo.add(new JScrollPane(taDesc), BorderLayout.CENTER);
    //-----------

    volverAlMenu = new JButton(bVAM);
    volverAlMenu.setFont(new Font(fuente, Font.BOLD, 20));
    volverAlMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
    volverAlMenu.setAlignmentY(Component.BOTTOM_ALIGNMENT);

    add(modH);
    add(subpanelCentralIzqdo);
    add(volverAlMenu);

}   public void controlador(ActionListener ctrl) {
        volverAlMenu.addActionListener(ctrl);
    }


}
