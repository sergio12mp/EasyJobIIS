import javax.swing.*;
import javax.swing.undo.UndoableEditSupport;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class PanelJVerEmpleados extends JPanel implements VistaEasyJob {
    private String fuente = "Arial";

    ConexionBD conex = new ConexionBaseDatosJDBC();

    JButton jAtras;
    static String bJVE = "VOLVER AL MENU";

    public PanelJVerEmpleados(){

        // Subpanel central derecho
        JScrollPane subpanelCentralDcho = new JScrollPane();
        // Tenemos la lista
        List<Usuario> lista = conex.verUsuarios();
        String usuarios[] = new String[lista.size()];

        int i=0;
        for(Usuario u: lista){
            usuarios[i] = u.toString();
            i++;
        }

        JList listaUsuarios = new JList(usuarios);
        //add(listaUsuarios);
        subpanelCentralDcho.setViewportView(listaUsuarios);


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
