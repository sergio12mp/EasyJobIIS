import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrJModificarHorarios implements ActionListener {

    VistaEasyJob vistaEasy;     // Vista

    public CtrJModificarHorarios(VistaEasyJob vb) {
        vistaEasy = vb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String actComm = e.getActionCommand();

    }

}
