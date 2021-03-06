import javax.swing.*;
import java.io.IOException;

public class Main {

    private static void createAndShowGui() {

        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500,300,500,200);
        PanelIniciarSesion panel = new PanelIniciarSesion();

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
