/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
class Reloj extends JFrame {

    static Color fondo;
    static Sentido sentido = new Sentido();
    static Thread hilo;
    JButton boton_atras = new JButton("<<");
    JButton boton_adelante = new JButton(">>");

    public static void main(String[] linea) {
        Reloj obj = new Reloj();
        obj.setSize(400, 340);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
        Graphics g = obj.getContentPane().getGraphics();
        Manecilla circulo = new Manecilla(g, fondo, sentido);
        hilo = new Thread(circulo);
        hilo.start();
    }

    Reloj() {
        super("Reloj");
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(boton_atras);
        getContentPane().add(boton_adelante);
        getContentPane().setBackground(new Color(50, 93, 127));

        boton_atras.setBackground(Color.CYAN);
        boton_adelante.setBackground(Color.CYAN);

        boton_atras.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_adelante.setCursor(new Cursor(Cursor.HAND_CURSOR));

        fondo = getBackground();

        ActionListener oye = (ActionEvent e) -> {
            if (e.getSource() == boton_atras) {
                String temp = boton_atras.getText();
                int num = 2;
                sentido.cambiar(num);
            }
            if (e.getSource() == boton_adelante) {
                String temp = boton_atras.getText();
                int num = 1;
                sentido.cambiar(num);
            }

        }; // ActionListener
        boton_adelante.addActionListener(oye);
        boton_atras.addActionListener(oye);
    }
}
