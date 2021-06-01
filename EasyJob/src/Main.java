import javax.swing.*;
import java.io.IOException;

public class Main {

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelIniciarSesion panel = new PanelIniciarSesion();
      //  PanelVistaPrincipal panel = new PanelVistaPrincipal();

        CtrEasyJob ctr = new CtrEasyJob(panel);
          panel.controlador(ctr);

        frame.getContentPane().add(panel);
        frame.pack();

        frame.setSize(450, 200);
        frame.setVisible(true);


    }

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGui();
            }
        });
    }
}
