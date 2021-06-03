import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;



public class PanelFichar extends JPanel implements VistaEasyJob {
    private String fuente = "Arial";

    public ImagePanel imagenPanel;
    public ConexionBD conex = new ConexionBaseDatosJDBC();
    public BufferedImage img;

    private JButton ficharAtras, generarCodigoQR;
    private JLabel fichar,imagen;

    static String bFichar = "FICHAR";
    static String bMFichar = "VOLVER AL MENU";
    static String bQR = "GENERAR EL QR";

    public PanelFichar() throws IOException {




        setLayout(new GridLayout(3, 3, 5, 5));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 3, 5, 5));

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 3, 5, 5));

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 3, 5, 5));


        ficharAtras = new JButton(bMFichar);
        ficharAtras.setFont(new Font(fuente, Font.BOLD, 18));
        ficharAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        generarCodigoQR = new JButton(bQR);
        generarCodigoQR.setFont(new Font(fuente, Font.BOLD, 18));
        generarCodigoQR.setAlignmentX(Component.CENTER_ALIGNMENT);

        imagenPanel = new ImagePanel();

        JLabel fichar = new JLabel("              FICHAR");
        fichar.setFont(new Font(fuente, Font.BOLD, 25));

        p1.add(Box.createVerticalStrut(3));
        p1.add(Box.createVerticalStrut(3));
        p1.add(Box.createVerticalStrut(3));

        p1.add(Box.createVerticalStrut(3));
        p1.add(fichar);
        p1.add(Box.createVerticalStrut(3));

        add(p1);


        p3.add(Box.createVerticalStrut(3));
        p3.add(imagenPanel);
        p3.add(Box.createVerticalStrut(3));
        add(p3);

        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));
        p2.add(generarCodigoQR);
        p2.add(ficharAtras);
        p2.add(Box.createVerticalStrut(3));

        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));
        p2.add(Box.createVerticalStrut(3));

        add(p2);


    }
    public void controlador(ActionListener ctrl) {

        ficharAtras.addActionListener(ctrl);
        generarCodigoQR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    generarQR();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });



    }

    public void generarQR() throws IOException {

        if (conex.tieneQR(PanelIniciarSesion.identificador)){
            byte[] QRBytes = conex.getQR(PanelIniciarSesion.identificador);

            InputStream is = new ByteArrayInputStream(QRBytes);
            BufferedImage newBi = ImageIO.read(is);
            imagenPanel.setImage(newBi);

        } else {
            try {
                String qrCodeData = PanelIniciarSesion.identificador + Math.round(Math.random()*100);
                String charset = "UTF-8"; // or "ISO-8859-1"
                Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap< EncodeHintType, ErrorCorrectionLevel >();
                hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
                BitMatrix matrix = new MultiFormatWriter().encode(
                        new String(qrCodeData.getBytes(charset), charset),
                        BarcodeFormat.QR_CODE, 200, 200, hintMap);
                img = MatrixToImageWriter.toBufferedImage(matrix);

                BufferedImage image = img;
                imagenPanel.setImage(image);
                String dni = PanelIniciarSesion.identificador;


                byte[] bytes = toByteArray(image,"png");
                System.out.println(bytes.length);

                conex.anadirQR(bytes,dni);


                System.out.println("QR Code image created successfully!");
            } catch (Exception e) {
                System.err.println(e);
            }
        }




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
