/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import javax.swing.JPanel;

/**
 *
 * @author Jeferson Jimenez
 */
public class Recursos extends JPanel {

    private final int ancho, alto;

    public Recursos() {
        ancho = 0;
        alto = 0;
    }

    public Recursos(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public static BufferedImage jugador = CargadorRecursos.ImageLoader("/recursos/jugador/Sprites-Jugador.png");
    public static Recursos tamJugador = new Recursos(44, 49);
    public static BufferedImage portada = CargadorRecursos.ImageLoader("/recursos/Portada.png");
    public static BufferedImage jugador_static;
    public static BufferedImage jugador_static0;
    public static BufferedImage jugador_static1;
    public static BufferedImage jugador_static2;
    public static BufferedImage jugador_down;
    public static BufferedImage jugador_down0;
    public static BufferedImage jugador_down1;
    public static BufferedImage jugador_down2;
    public static BufferedImage jugador_down3;
    public static BufferedImage jugador_down4;
    public static BufferedImage jugador_down5;
    public static BufferedImage jugador_up;
    public static BufferedImage jugador_up0;
    public static BufferedImage jugador_up1;
    public static BufferedImage jugador_up2;
    public static BufferedImage jugador_up3;
    public static BufferedImage jugador_up4;
    public static BufferedImage jugador_up5;
    public static BufferedImage jugador_right;
    public static BufferedImage jugador_right0;
    public static BufferedImage jugador_right1;
    public static BufferedImage jugador_right2;
    public static BufferedImage jugador_right3;
    public static BufferedImage jugador_right4;
    public static BufferedImage jugador_right5;
    public static BufferedImage jugador_diag_up;
    public static BufferedImage jugador_diag_up0;
    public static BufferedImage jugador_diag_up1;
    public static BufferedImage jugador_diag_up2;
    public static BufferedImage jugador_diag_up3;
    public static BufferedImage jugador_diag_up4;
    public static BufferedImage jugador_diag_up5;
    public static BufferedImage jugador_diag_down;
    public static BufferedImage jugador_diag_down0;
    public static BufferedImage jugador_diag_down1;
    public static BufferedImage jugador_diag_down2;
    public static BufferedImage jugador_diag_down3;
    public static BufferedImage jugador_diag_down4;
    public static BufferedImage jugador_diag_down5;
    public static BufferedImage jugador_corriendo_down0;
    public static BufferedImage jugador_corriendo_down1;
    public static BufferedImage jugador_corriendo_down2;
    public static BufferedImage jugador_corriendo_down3;
    public static BufferedImage jugador_corriendo_down4;
    public static BufferedImage jugador_corriendo_down5;
    public static BufferedImage jugador_corriendo_up0;
    public static BufferedImage jugador_corriendo_up1;
    public static BufferedImage jugador_corriendo_up2;
    public static BufferedImage jugador_corriendo_up3;
    public static BufferedImage jugador_corriendo_up4;
    public static BufferedImage jugador_corriendo_up5;
    public static BufferedImage jugador_corriendo_right0;
    public static BufferedImage jugador_corriendo_right1;
    public static BufferedImage jugador_corriendo_right2;
    public static BufferedImage jugador_corriendo_right3;
    public static BufferedImage jugador_corriendo_right4;
    public static BufferedImage jugador_corriendo_right5;
    public static BufferedImage jugador_corriendo_diag_up0;
    public static BufferedImage jugador_corriendo_diag_up1;
    public static BufferedImage jugador_corriendo_diag_up2;
    public static BufferedImage jugador_corriendo_diag_up3;
    public static BufferedImage jugador_corriendo_diag_up4;
    public static BufferedImage jugador_corriendo_diag_up5;
    public static BufferedImage jugador_corriendo_diag_down0;
    public static BufferedImage jugador_corriendo_diag_down1;
    public static BufferedImage jugador_corriendo_diag_down2;
    public static BufferedImage jugador_corriendo_diag_down3;
    public static BufferedImage jugador_corriendo_diag_down4;
    public static BufferedImage jugador_corriendo_diag_down5;

    public static BufferedImage policia = CargadorRecursos.ImageLoader("/recursos/Tombo/Tombo.png");
    public static Recursos tamPolicia = new Recursos(44, 49);
    public static BufferedImage policia_right;
    public static BufferedImage policia_right0;
    public static BufferedImage policia_right1;
    public static BufferedImage policia_right2;
    public static BufferedImage policia_right3;
    public static BufferedImage policia_right4;
    public static BufferedImage policia_right5;
    public static BufferedImage policia_diag_up;
    public static BufferedImage policia_diag_up0;
    public static BufferedImage policia_diag_up1;
    public static BufferedImage policia_diag_up2;
    public static BufferedImage policia_diag_up3;
    public static BufferedImage policia_diag_up4;
    public static BufferedImage policia_diag_up5;
    public static BufferedImage policia_up;
    public static BufferedImage policia_up0;
    public static BufferedImage policia_up1;
    public static BufferedImage policia_up2;
    public static BufferedImage policia_up3;
    public static BufferedImage policia_up4;
    public static BufferedImage policia_up5;
    public static BufferedImage policia_down;
    public static BufferedImage policia_down0;
    public static BufferedImage policia_down1;
    public static BufferedImage policia_down2;
    public static BufferedImage policia_down3;
    public static BufferedImage policia_down4;
    public static BufferedImage policia_down5;
    public static BufferedImage policia_diag_down;
    public static BufferedImage policia_diag_down0;
    public static BufferedImage policia_diag_down1;
    public static BufferedImage policia_diag_down2;
    public static BufferedImage policia_diag_down3;
    public static BufferedImage policia_diag_down4;
    public static BufferedImage policia_diag_down5;

    public void inicializar() {
        jugador_static = cortarImagen(jugador, 11, 0, tamJugador.ancho, tamJugador.alto);
        jugador_static0 = cortarImagen(jugador, 11, 1, tamJugador.ancho, tamJugador.alto);
        jugador_static1 = cortarImagen(jugador, 11, 2, tamJugador.ancho, tamJugador.alto);
        jugador_static2 = cortarImagen(jugador, 11, 3, tamJugador.ancho, tamJugador.alto);
        jugador_down = cortarImagen(jugador, 0, 0, tamJugador.ancho, tamJugador.alto);
        jugador_down0 = cortarImagen(jugador, 1, 0, tamJugador.ancho, tamJugador.alto);
        jugador_down1 = cortarImagen(jugador, 1, 1, tamJugador.ancho, tamJugador.alto);
        jugador_down2 = cortarImagen(jugador, 1, 2, tamJugador.ancho, tamJugador.alto);
        jugador_down3 = cortarImagen(jugador, 1, 3, tamJugador.ancho, tamJugador.alto);
        jugador_down4 = cortarImagen(jugador, 1, 4, tamJugador.ancho, tamJugador.alto);
        jugador_down5 = cortarImagen(jugador, 1, 5, tamJugador.ancho, tamJugador.alto);
        jugador_diag_down = cortarImagen(jugador, 0, 3, tamJugador.ancho, tamJugador.alto);
        jugador_diag_down0 = cortarImagen(jugador, 2, 0, tamJugador.ancho, tamJugador.alto);
        jugador_diag_down1 = cortarImagen(jugador, 2, 1, tamJugador.ancho, tamJugador.alto);
        jugador_diag_down2 = cortarImagen(jugador, 2, 2, tamJugador.ancho, tamJugador.alto);
        jugador_diag_down3 = cortarImagen(jugador, 2, 3, tamJugador.ancho, tamJugador.alto);
        jugador_diag_down4 = cortarImagen(jugador, 2, 4, tamJugador.ancho, tamJugador.alto);
        jugador_diag_down5 = cortarImagen(jugador, 2, 5, tamJugador.ancho, tamJugador.alto);
        jugador_right = cortarImagen(jugador, 0, 2, tamJugador.ancho, tamJugador.alto);
        jugador_right0 = cortarImagen(jugador, 3, 0, tamJugador.ancho, tamJugador.alto);
        jugador_right1 = cortarImagen(jugador, 3, 1, tamJugador.ancho, tamJugador.alto);
        jugador_right2 = cortarImagen(jugador, 3, 2, tamJugador.ancho, tamJugador.alto);
        jugador_right3 = cortarImagen(jugador, 3, 3, tamJugador.ancho, tamJugador.alto);
        jugador_right4 = cortarImagen(jugador, 3, 4, tamJugador.ancho, tamJugador.alto);
        jugador_right5 = cortarImagen(jugador, 3, 5, tamJugador.ancho, tamJugador.alto);
        jugador_diag_up = cortarImagen(jugador, 0, 3, tamJugador.ancho, tamJugador.alto);
        jugador_diag_up0 = cortarImagen(jugador, 4, 0, tamJugador.ancho, tamJugador.alto);
        jugador_diag_up1 = cortarImagen(jugador, 4, 1, tamJugador.ancho, tamJugador.alto);
        jugador_diag_up2 = cortarImagen(jugador, 4, 2, tamJugador.ancho, tamJugador.alto);
        jugador_diag_up3 = cortarImagen(jugador, 4, 3, tamJugador.ancho, tamJugador.alto);
        jugador_diag_up4 = cortarImagen(jugador, 4, 4, tamJugador.ancho, tamJugador.alto);
        jugador_diag_up5 = cortarImagen(jugador, 4, 5, tamJugador.ancho, tamJugador.alto);
        jugador_up = cortarImagen(jugador, 0, 4, tamJugador.ancho, tamJugador.alto);
        jugador_up0 = cortarImagen(jugador, 5, 0, tamJugador.ancho, tamJugador.alto);
        jugador_up1 = cortarImagen(jugador, 5, 1, tamJugador.ancho, tamJugador.alto);
        jugador_up2 = cortarImagen(jugador, 5, 2, tamJugador.ancho, tamJugador.alto);
        jugador_up3 = cortarImagen(jugador, 5, 3, tamJugador.ancho, tamJugador.alto);
        jugador_up4 = cortarImagen(jugador, 5, 4, tamJugador.ancho, tamJugador.alto);
        jugador_up5 = cortarImagen(jugador, 5, 5, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_down0 = cortarImagen(jugador, 6, 0, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_down1 = cortarImagen(jugador, 6, 1, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_down2 = cortarImagen(jugador, 6, 2, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_down3 = cortarImagen(jugador, 6, 3, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_down4 = cortarImagen(jugador, 6, 4, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_down5 = cortarImagen(jugador, 6, 5, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_down0 = cortarImagen(jugador, 7, 0, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_down1 = cortarImagen(jugador, 7, 1, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_down2 = cortarImagen(jugador, 7, 2, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_down3 = cortarImagen(jugador, 7, 3, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_down4 = cortarImagen(jugador, 7, 4, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_down5 = cortarImagen(jugador, 7, 5, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_right0 = cortarImagen(jugador, 8, 0, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_right1 = cortarImagen(jugador, 8, 1, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_right2 = cortarImagen(jugador, 8, 2, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_right3 = cortarImagen(jugador, 8, 3, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_right4 = cortarImagen(jugador, 8, 4, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_right5 = cortarImagen(jugador, 8, 5, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_up0 = cortarImagen(jugador, 9, 0, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_up1 = cortarImagen(jugador, 9, 1, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_up2 = cortarImagen(jugador, 9, 2, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_up3 = cortarImagen(jugador, 9, 3, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_up4 = cortarImagen(jugador, 9, 4, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_diag_up5 = cortarImagen(jugador, 9, 5, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_up0 = cortarImagen(jugador, 10, 0, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_up1 = cortarImagen(jugador, 10, 1, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_up2 = cortarImagen(jugador, 10, 2, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_up3 = cortarImagen(jugador, 10, 3, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_up4 = cortarImagen(jugador, 10, 4, tamJugador.ancho, tamJugador.alto);
        jugador_corriendo_up5 = cortarImagen(jugador, 10, 5, tamJugador.ancho, tamJugador.alto);
        
        policia_right = cortarImagen(policia, 0, 0, tamPolicia.ancho, tamPolicia.alto);
        policia_right0 = cortarImagen(policia, 0, 1, tamPolicia.ancho, tamPolicia.alto);
        policia_right1 = cortarImagen(policia, 0, 2, tamPolicia.ancho, tamPolicia.alto);
        policia_right2 = cortarImagen(policia, 0, 3, tamPolicia.ancho, tamPolicia.alto);
        policia_right3 = cortarImagen(policia, 0, 4, tamPolicia.ancho, tamPolicia.alto);
        policia_right4 = cortarImagen(policia, 0, 5, tamPolicia.ancho, tamPolicia.alto);
        policia_right5 = cortarImagen(policia, 0, 6, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_up = cortarImagen(policia, 1, 0, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_up0 = cortarImagen(policia, 1, 1, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_up1 = cortarImagen(policia, 1, 2, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_up3 = cortarImagen(policia, 1, 3, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_up4 = cortarImagen(policia, 1, 4, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_up5 = cortarImagen(policia, 1, 5, tamPolicia.ancho, tamPolicia.alto);
        policia_up = cortarImagen(policia, 2, 0, tamPolicia.ancho, tamPolicia.alto);
        policia_up0 = cortarImagen(policia, 2, 1, tamPolicia.ancho, tamPolicia.alto);
        policia_up1 = cortarImagen(policia, 2, 2, tamPolicia.ancho, tamPolicia.alto);
        policia_up2 = cortarImagen(policia, 2, 3, tamPolicia.ancho, tamPolicia.alto);
        policia_up3 = cortarImagen(policia, 2, 4, tamPolicia.ancho, tamPolicia.alto);
        policia_up4 = cortarImagen(policia, 2, 5, tamPolicia.ancho, tamPolicia.alto);
        policia_up5 = cortarImagen(policia, 2, 6, tamPolicia.ancho, tamPolicia.alto);
        policia_down = cortarImagen(jugador, 3, 0, tamPolicia.ancho, tamPolicia.alto);
        policia_down0 = cortarImagen(jugador, 3, 1, tamPolicia.ancho, tamPolicia.alto);
        policia_down1 = cortarImagen(jugador, 3, 2, tamPolicia.ancho, tamPolicia.alto);
        policia_down2 = cortarImagen(jugador, 3, 3, tamPolicia.ancho, tamPolicia.alto);
        policia_down3 = cortarImagen(jugador, 3, 4, tamPolicia.ancho, tamPolicia.alto);
        policia_down4 = cortarImagen(jugador, 3, 5, tamPolicia.ancho, tamPolicia.alto);
        policia_down5 = cortarImagen(jugador, 3, 6, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_down = cortarImagen(jugador, 4, 0, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_down0 = cortarImagen(jugador, 4, 1, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_down1 = cortarImagen(jugador, 4, 2, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_down2 = cortarImagen(jugador, 4, 3, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_down3 = cortarImagen(jugador, 4, 4, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_down4 = cortarImagen(jugador, 4, 5, tamPolicia.ancho, tamPolicia.alto);
        policia_diag_down5 = cortarImagen(jugador, 4, 6, tamPolicia.ancho, tamPolicia.alto);
    }

    public BufferedImage cortarImagen(BufferedImage imagen, int fila, int columna, int ancho, int alto) {
        Image img = createImage(new FilteredImageSource(imagen.getSource(), new CropImageFilter(ancho * columna, alto * fila, ancho, alto)));
        return toBufferedImage(img);
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
}

/*


        portada = CargadorRecursos.ImageLoader("/recursos/Portada.png");
        jugador_static = CargadorRecursos.ImageLoader("/recursos/jugador/fila-12-col-1.png");
        jugador_static0 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-12-col-2.png");
        jugador_static1 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-12-col-3.png");
        jugador_static2 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-12-col-4.png");
        jugador_down = cortarImagen(jugador, 0, 0, tamJugador.ancho, tamJugador.alto);
        jugador_down0 = cortarImagen(jugador, 1, 0, tamJugador.ancho, tamJugador.alto);
        jugador_down1 = cortarImagen(jugador, 1, 2, tamJugador.ancho, tamJugador.alto);
        jugador_down2 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-2-col-3.png");
        jugador_down3 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-2-col-4.png");
        jugador_down4 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-2-col-5.png");
        jugador_down5 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-2-col-6.png");
        jugador_up = CargadorRecursos.ImageLoader("/recursos/jugador/fila-1-col-5.png");
        jugador_up0 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-6-col-1.png");
        jugador_up1 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-6-col-2.png");
        jugador_up2 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-6-col-3.png");
        jugador_up3 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-6-col-4.png");
        jugador_up4 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-6-col-5.png");
        jugador_up5 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-6-col-6.png");
        jugador_right = CargadorRecursos.ImageLoader("/recursos/jugador/fila-1-col-3.png");
        jugador_right0 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-4-col-1.png");
        jugador_right1 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-4-col-2.png");
        jugador_right2 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-4-col-3.png");
        jugador_right3 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-4-col-4.png");
        jugador_right4 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-4-col-5.png");
        jugador_right5 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-4-col-6.png");
        jugador_diag_up = CargadorRecursos.ImageLoader("/recursos/jugador/fila-1-col-4.png");
        jugador_diag_up0 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-5-col-1.png");
        jugador_diag_up1 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-5-col-2.png");
        jugador_diag_up2 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-5-col-3.png");
        jugador_diag_up3 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-5-col-4.png");
        jugador_diag_up4 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-5-col-5.png");
        jugador_diag_up5 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-5-col-6.png");
        jugador_diag_down = CargadorRecursos.ImageLoader("/recursos/jugador/fila-1-col-2.png");
        jugador_diag_down0 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-3-col-1.png");
        jugador_diag_down1 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-3-col-2.png");
        jugador_diag_down2 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-3-col-3.png");
        jugador_diag_down3 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-3-col-4.png");
        jugador_diag_down4 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-3-col-5.png");
        jugador_diag_down5 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-3-col-6.png");
        jugador_corriendo_down0 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-7-col-1.png");
        jugador_corriendo_down1 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-7-col-2.png");
        jugador_corriendo_down2 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-7-col-3.png");
        jugador_corriendo_down3 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-7-col-4.png");
        jugador_corriendo_down4 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-7-col-5.png");
        jugador_corriendo_down5 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-7-col-6.png");
        jugador_corriendo_up0 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-11-col-1.png");
        jugador_corriendo_up1 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-11-col-2.png");
        jugador_corriendo_up2 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-11-col-3.png");
        jugador_corriendo_up3 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-11-col-4.png");
        jugador_corriendo_up4 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-11-col-5.png");
        jugador_corriendo_up5 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-11-col-6.png");
        jugador_corriendo_right0 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-9-col-1.png");
        jugador_corriendo_right1 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-9-col-2.png");
        jugador_corriendo_right2 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-9-col-3.png");
        jugador_corriendo_right3 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-9-col-4.png");
        jugador_corriendo_right4 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-9-col-5.png");
        jugador_corriendo_right5 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-9-col-6.png");
        jugador_corriendo_diag_up0 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-10-col-1.png");
        jugador_corriendo_diag_up1 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-10-col-2.png");
        jugador_corriendo_diag_up2 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-10-col-3.png");
        jugador_corriendo_diag_up3 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-10-col-4.png");
        jugador_corriendo_diag_up4 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-10-col-5.png");
        jugador_corriendo_diag_up5 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-10-col-6.png");
        jugador_corriendo_diag_down0 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-8-col-1.png");
        jugador_corriendo_diag_down1 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-8-col-2.png");
        jugador_corriendo_diag_down2 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-8-col-3.png");
        jugador_corriendo_diag_down3 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-8-col-4.png");
        jugador_corriendo_diag_down4 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-8-col-5.png");
        jugador_corriendo_diag_down5 = CargadorRecursos.ImageLoader("/recursos/jugador/fila-8-col-6.png");
 */
