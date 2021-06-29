/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosJuego;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import math.Posicion;

/**
 *
 * @author Jeferson Jimenez
 */
/*
En esta clase hacemos uso del patron Strategy donde damos como prototipo a cada una de las clases hijo los parametros de los cuales va a depender
los estados de cada uno, como por ejemplo, la posicion, la velociadad, y la textura o grupo de texturas que maneja cada uno de estos en su determinado estado
pero a su vez este tendra diferente comportamiento dependeiendo de cada clase que este implementando esta misma.
*/
public abstract class  ObjetoMovible extends ObjetoJuego {

    protected Posicion velocidad;
    protected AffineTransform at;
    protected double angulo;
    
    public ObjetoMovible(Posicion posicion,Posicion velocidad, BufferedImage textura) {
        super(posicion, textura);
        this.velocidad=velocidad;
        angulo=0;
    }
    
    public abstract void cambiarRecurso(boolean corriendo, int numGrafico);
    
}
