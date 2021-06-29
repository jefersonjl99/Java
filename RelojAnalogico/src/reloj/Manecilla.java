/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jefer
 */
class Manecilla implements Runnable {

    int centrox = 195, centroy = 170;
    Graphics g;
    Color fondo;
    Sentido sentido;

    Manecilla(Graphics g, Color fondo, Sentido sentido) {
        this.sentido = sentido;
        this.g = g;
        this.fondo = fondo;
    }

    public void run() {
        double anguloNeg, anguloPos, sumando, x, y;
        anguloNeg = -(sentido.sent()-1.5708);
        anguloPos = sentido.sent()+1.5708;
        while (true) {
            
            y=0;
            x=0;
            g.setColor(Color.MAGENTA);
            g.drawOval(74, 49, 241, 241);
            g.setColor(Color.BLACK);
            g.fillOval(75, 50, 240, 240);
            g.setColor(Color.MAGENTA);
            g.fillOval(190, 165, 10, 10);
            g.setColor(Color.WHITE);
            g.drawString("12", 188, 70);
            g.drawString("3", 300, 175);
            g.drawString("6", 192, 280);
            g.drawString("9", 80, 175);

            if (sentido.sent() < 0) {
                anguloNeg = (anguloNeg + sentido.sent());
                y = 100 * Math.sin(anguloNeg);
                x = 100 * Math.cos(anguloNeg);
            } else {
                anguloPos = anguloPos + sentido.sent();
                y = 100 * Math.sin(anguloPos);
                x = 100 * Math.cos(anguloPos);
            }
            g.setColor(Color.MAGENTA);
            g.drawLine(centrox, centroy, (int) x + centrox, centroy - (int) y);
            //g.drawOval((int) x + 150, 200 - (int) y, 3, 3);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
            }
            g.setColor(fondo);
            g.drawLine(centrox, centroy, (int) x + centrox, centroy - (int) y);
        }
    }
}
