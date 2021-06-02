import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrJSolicitud implements ActionListener {

    VistaEasyJob vistaEasy;     // Vista

    public CtrJSolicitud(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

    }
}
