import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PanelJefe extends JPanel implements VistaEasyJob {

    private String fuente = "Arial";

    public JButton VerEmpleados, Solicitudes, CerrarS, Conf, ChatJ,HelpJ;

    public ImagePanel imagenPanel;

    static String bVerEmpleados = "VER EMPLEADOS";
    static String bSolicitudes = "SOLICITUDES DE HORARIO";
    static String bCerrarS = "CERRAR SESION \n";
    static String bConf = "CONFIGURACION \n";
    static String bChatJ = "CHAT \n";
    static String bHelpJ = "HELP";

    ConexionBD conex = new ConexionBaseDatosJDBC();

    public PanelJefe() {

        setLayout(new GridLayout(1, 3, 5, 5));

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(8, 1, 5, 5));

        JPanel foto = new JPanel();
        foto.setLayout(new GridLayout(1, 1, 5, 5));

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

        VerEmpleados = new JButton(bVerEmpleados);
        VerEmpleados.setAlignmentX(Component.CENTER_ALIGNMENT);
        VerEmpleados.setFont(new Font(fuente, Font.BOLD, 20));

        Solicitudes = new JButton(bSolicitudes);
        Solicitudes.setFont(new Font(fuente, Font.BOLD, 20));
        Solicitudes.setAlignmentX(Component.CENTER_ALIGNMENT);

        CerrarS = new JButton(bCerrarS);
        CerrarS.setAlignmentX(Component.CENTER_ALIGNMENT);
        CerrarS.setFont(new Font(fuente, Font.BOLD, 20));

        Conf = new JButton(bConf);
        Conf.setAlignmentX(Component.CENTER_ALIGNMENT);
        Conf.setFont(new Font(fuente, Font.BOLD, 20));

        HelpJ = new JButton(bHelpJ);
        HelpJ.setAlignmentX(Component.CENTER_ALIGNMENT);
        HelpJ.setFont(new Font(fuente, Font.BOLD, 20));

        ChatJ = new JButton(bChatJ);
        ChatJ.setAlignmentX(Component.CENTER_ALIGNMENT);
        ChatJ.setFont(new Font(fuente, Font.BOLD, 20));

        botones.add(Box.createVerticalStrut(3));
        botones.add(VerEmpleados);
        botones.add(Solicitudes);
        botones.add(ChatJ);
        botones.add(Conf);
        botones.add(HelpJ);
        botones.add(CerrarS);
        botones.add(Box.createVerticalStrut(3));

        foto.add(imagenPanel);

        add(foto);
        add(botones);
        add(Box.createVerticalStrut(10));


    }

    public void controlador(ActionListener ctrl) {
        CerrarS.addActionListener(ctrl);
        Solicitudes.addActionListener(ctrl);
        VerEmpleados.addActionListener(ctrl);
        ChatJ.addActionListener(ctrl);
        Conf.addActionListener(ctrl);
        HelpJ.addActionListener(ctrl);
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
                g.drawImage(image,10,10,100,100,null);
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
