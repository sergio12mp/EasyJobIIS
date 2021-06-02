import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrJEmpleados implements ActionListener {

    VistaEasyJob vistaEasy;     // Vista

    public CtrJEmpleados(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

        if(actComm.compareTo(PanelJVerEmpleados.bJVE) == 0) {

        }

    }
}
