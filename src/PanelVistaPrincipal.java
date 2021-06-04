import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PanelVistaPrincipal extends JPanel implements VistaEasyJob {

    private JButton Horario, Chat, Fichar, Configuracion, Help, CS;
    private String fuente = "Arial";

     static String bHorario = "HORARIO";
     static String bChat = "CHAT";
     static String bFichar = "FICHAR";
     static String bConfiguracion = "CONFIGURACION";
     static String bHelp = "HELP";
     static String bCS = "CERRAR SESION";
     public ImagePanel imagenPanel;

    ConexionBD conex = new ConexionBaseDatosJDBC();


    public PanelVistaPrincipal() {


        // setLayout(null);
        setLayout(new GridLayout(0, 3, 5, 5));

        //Inicializamos las variables

        imagenPanel = new ImagePanel();


        if (conex.tieneFoto(PanelIniciarSesion.identificador)){
            byte[] QRBytes = conex.getFoto(PanelIniciarSesion.identificador);

            InputStream is = new ByteArrayInputStream(QRBytes);
            BufferedImage newBi = null;
            try {
                newBi = ImageIO.read(is);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            imagenPanel.setImage(newBi);

        }

        Horario = new JButton(bHorario);
        Horario.setFont(new Font(fuente, Font.BOLD, 20));
        Horario.setAlignmentX(Component.CENTER_ALIGNMENT);


        Chat = new JButton(bChat);
        Chat.setAlignmentX(Component.CENTER_ALIGNMENT);
        Chat.setFont(new Font(fuente, Font.BOLD, 20));


        Fichar = new JButton(bFichar);
        Fichar.setAlignmentX(Component.CENTER_ALIGNMENT);
        Fichar.setFont(new Font(fuente, Font.BOLD, 20));


        Configuracion = new JButton(bConfiguracion);
        Configuracion.setAlignmentX(Component.CENTER_ALIGNMENT);
        Configuracion.setFont(new Font(fuente, Font.BOLD, 20));


        Help = new JButton(bHelp);
        Help.setAlignmentX(Component.CENTER_ALIGNMENT);
        Help.setFont(new Font(fuente, Font.BOLD, 20));


        CS = new JButton(bCS);
        CS.setAlignmentX(Component.CENTER_ALIGNMENT);
        CS.setFont(new Font(fuente, Font.BOLD, 20));





        //AÑADIMOS AL PANEL

        add(Box.createVerticalStrut(3));
        add(imagenPanel);


        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));
        add(Horario, BorderLayout.NORTH);
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Chat);
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Fichar);
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Configuracion);
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(Help);
        add(Box.createVerticalStrut(3));
        add(Box.createVerticalStrut(3));

        add(CS);
        add(Box.createVerticalStrut(3));
    }

    public void controlador(ActionListener ctrl) {
        Horario.addActionListener(ctrl);
        Fichar.addActionListener(ctrl);
        Chat.addActionListener(ctrl);
        Configuracion.addActionListener(ctrl);
        Help.addActionListener(ctrl);
        CS.addActionListener(ctrl);

    }

    private static class ImagePanel extends JPanel
    {
        private BufferedImage image;

        void setImage(BufferedImage image)
        {
            this.image = image;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if (image != null)
            {
                g.drawImage(image,10,10,50,50,null);
            }
        }

    }

    public static byte[] toByteArray(BufferedImage bi, String format)
            throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, format, baos);
        byte[] bytes = baos.toByteArray();
        return bytes;

    }

}
