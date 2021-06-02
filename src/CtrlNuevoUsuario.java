import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlNuevoUsuario implements ActionListener {

    private ConexionBD conexionbd;
    private PanelRegistro panel;


    public CtrlNuevoUsuario (ConexionBD cb, PanelRegistro pr) {
        conexionbd = cb;
        panel = pr;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Empleado u = new Empleado(panel.getNombre().getText(), panel.getApellidos().getText()
                ,panel.getCorreo().getText(), panel.getDNI().getText(),
                panel.getTelefono().getText(), panel.getContrasena().getText());
    }



}
