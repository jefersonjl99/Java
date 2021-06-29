/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Jeferson Jimenez
 */
public class CargadorRecursos {

    public static BufferedImage ImageLoader(final String path) {

        try {
            return ImageIO.read(CargadorRecursos.class.getResource(path));
        } catch (IOException ex) {
            Logger.getLogger(CargadorRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
