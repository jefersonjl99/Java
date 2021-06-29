/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author jefer
 */
public class Hilo extends Thread {

    int n;
    Graphics g;
    Color fondo;

    Hilo(Graphics g, Color f) {
        this.g = g;
        fondo = f;
    }

    @Override
    public void run() {
        while (true) {

            n = (int) (Math.random() * 3);

            g.setColor(Color.red);
            dibujar(g, n);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException error) {

            }

            g.setColor(fondo);
            g.fillRect(15, 35, 100, 80);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException error) {

            }
        }
    }

    public void dibujar(Graphics g, int n) {

        switch (n) {
            case 0:
                g.drawOval(50, 50, 40, 40);
                break;
            case 1:
                g.drawRect(50, 50, 40, 40);
                break;
            case 2:
                Polygon p = new Polygon();
                p.addPoint(50, 50);
                p.addPoint(50, 100);
                p.addPoint(100, 50);
                g.drawPolygon(p);
                break;
            default:
                break;
        }
    }

}
