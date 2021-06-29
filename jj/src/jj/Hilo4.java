/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jj;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Sentido {

    double ang;

    Sentido() {
        ang = 0.0174532;
    }

    void cambiar(int num) {
        if (num % 2 == 0) {
            ang = 0.0174532;
        } else {
            ang = -0.0174532;
        }
    }

    double sent() {
        return ang;
    }
}

class Circulo implements Runnable {

    Graphics g;
    Color fondo;
    Sentido sentido;

    Circulo(Graphics g, Color fondo, Sentido sentido) {
        this.sentido = sentido;
        this.g = g;
        this.fondo = fondo;
    }

    public void run() {
        double anguloNeg, anguloPos, sumando, x, y;
        anguloNeg = -sentido.sent();
        anguloPos = sentido.sent();
        while (true) {

            if (sentido.sent() < 0) {
                anguloNeg = anguloNeg + sentido.sent();
                y = 20 * Math.sin(anguloNeg);
                x = 20 * Math.cos(anguloNeg);
            } else {
                anguloPos = anguloPos + sentido.sent();
                y = 20 * Math.sin(anguloPos);
                x = 20 * Math.cos(anguloPos);
            }
            g.setColor(Color.black);
            g.drawOval((int) x + 150, 200 - (int) y, 3, 3);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e1) {
            }
            g.setColor(fondo);
            g.drawOval((int) x + 150, 200 - (int) y, 3, 3);
        }
    }
}

class Hilo4 extends JFrame {

    static Color fondo;
    static Sentido sentido = new Sentido();
    static Thread hilo;
    JLabel l1 = new JLabel("dato1");
    JTextField t1 = new JTextField(5);
    JButton boton = new JButton("Calcular");

    public static void main(String[] linea) {
        Hilo4 marco = new Hilo4("Par o impar");
        marco.setSize(600, 300);
        marco.setVisible(true);
        Graphics g = marco.getContentPane().getGraphics();
        Circulo circulo = new Circulo(g, fondo, sentido);
        hilo = new Thread(circulo);
        hilo.start();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    Hilo4(String nombre) {
        super(nombre);
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(l1);
        getContentPane().add(t1);
        getContentPane().add(boton);
        fondo = getBackground();
        ActionListener oye = (ActionEvent e1) -> {
            String temp = t1.getText();
            int num = Integer.parseInt(temp);
            sentido.cambiar(num);
        } // actionPerformed
        ; // ActionListener
        boton.addActionListener(oye);
    }
}
