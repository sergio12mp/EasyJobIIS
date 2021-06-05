import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class PanelCCFoto extends JPanel implements VistaEasyJob {

    JButton aceptar, atras;
    static final String bAceptar = "IMPORTAR IMAGEN";
    static final String bAtras = "ATRAS";

    private JLabel nuevaFoto;

    public ImagePanel imagenPanel;
    public BufferedImage img;

    ConexionBD conex = new ConexionBaseDatosJDBC();

    public PanelCCFoto(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nuevaFoto = new JLabel("Nueva imagen (Solo archivos PNG, JPG/JPEG) - Tamaño recomendado: 200x200px");
        nuevaFoto.setAlignmentX(Component.CENTER_ALIGNMENT);



        imagenPanel = new ImagePanel();

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 1, 5, 5));

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


        aceptar = new JButton(bAceptar);
        aceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                   JFileChooser browseImg = new JFileChooser();

                   FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES","png","jpg","jpeg");
                   browseImg.addChoosableFileFilter(fnef);

                   int showDialogue = browseImg.showOpenDialog(null);

                   if (showDialogue == JFileChooser.APPROVE_OPTION) {
                       File fileimg = browseImg.getSelectedFile();
                       try {
                           img = ImageIO.read(fileimg);
                       } catch (IOException ioException) {
                           ioException.printStackTrace();
                       }

                       imagenPanel.setImage(img);

                       String dni = PanelIniciarSesion.identificador;


                       byte[] bytes = new byte[0];
                       try {
                           bytes = toByteArray(img,"png");
                       } catch (IOException ioException) {
                           ioException.printStackTrace();
                       }
                       System.out.println(bytes.length);

                       conex.anadirFoto(bytes,dni);



                   }
            }
        });

        atras = new JButton(bAtras);
        atras.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(10));
        add(nuevaFoto);


        p3.add(Box.createVerticalStrut(3));
        p3.add(Box.createVerticalStrut(3));
        p3.add(imagenPanel);
        p3.add(Box.createVerticalStrut(3));
        p3.add(Box.createVerticalStrut(3));
        add(p3);


        add(Box.createVerticalStrut(5));
        add(aceptar);
        add(Box.createVerticalStrut(2));
        add(atras);
    }




    public void controlador(ActionListener ctrl) {
        atras.addActionListener(ctrl);
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
                g.drawImage(image, 0, 0, null);
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
