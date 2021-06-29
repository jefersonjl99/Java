/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;

/**
 *
 * @author Jeferson Jimenez
 */
public class OptimizadorRecursos {

    public static BufferedImage rotarSprite(BufferedImage imagen) {
        AffineTransform at = AffineTransform.getRotateInstance(Math.PI, imagen.getWidth() / 2, imagen.getHeight() / 2.0);
        return transformarSprite(imagen, at);
    }

    public static BufferedImage voltearSprite(BufferedImage imagen) {
        AffineTransform at = new AffineTransform();
        at.concatenate(AffineTransform.getScaleInstance(1, -1));
        at.concatenate(AffineTransform.getTranslateInstance(0, -imagen.getHeight()));
        return transformarSprite(imagen, at);
    }

    public static BufferedImage transformarSprite(BufferedImage imagen, AffineTransform at) {
        BufferedImage newImage = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.transform(at);
        g.drawImage(imagen, 0, 0, null);
        g.dispose();
        return newImage;
    }

    public static BufferedImage invertirSprite(BufferedImage imagen) {
        if (imagen.getType() != BufferedImage.TYPE_INT_ARGB) {
            imagen = convertirSpriteRGB(imagen);
        }
        LookupTable lookup = new LookupTable(0, 4) {
            @Override
            public int[] lookupPixel(int[] src, int[] dest) {
                dest[0] = (int) (255 - src[0]);
                dest[1] = (int) (255 - src[1]);
                dest[2] = (int) (255 - src[2]);
                return dest;
            }
        };
        LookupOp op = new LookupOp(lookup, new RenderingHints(null));
        return op.filter(imagen, null);
    }

    public static BufferedImage convertirSpriteRGB(BufferedImage imagen) {
        BufferedImage newImage = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(imagen, 0, 0, null);
        g.dispose();
        return newImage;
    }
}
