/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class Hilos extends JFrame {

    JLabel imagen = new JLabel();
    Color color = new Color(50, 93, 127);

    /**
     * @param args the command line arguments
     */
    JTextField numero1 = new JTextField("0");
    JTextField numero2 = new JTextField("0");

    JLabel N = new JLabel("N");
    JLabel M = new JLabel("M");

    static Graphics g;
    static Hilo hilo1;

    JButton b = new JButton("Calcular");
    JLabel l = new JLabel();
    static Color fondo;
    double fact = 0;

    public static void main(String[] args) {
        Hilos obj = new Hilos();
        obj.setSize(500, 200);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);
        fondo = new Color(50, 93, 127);
        g = obj.getGraphics();
        hilo1 = new Hilo(g, fondo);
        hilo1.start();
    }

    public Hilos() {
        super("Hilos");
        Container H = getContentPane();
        H.setLayout(null);
        H.setBackground(color);

        H.add(b);
        b.setBounds(100, 100, 100, 30);
        H.add(l);
        l.setBounds(250, 100, 250, 30);
        H.add(numero1);
        H.add(numero2);
        H.add(N);
        H.add(M);

        N.setBounds(65, 100, 20, 20);
        M.setBounds(65, 120, 20, 20);
        numero1.setBounds(20, 100, 40, 20);
        numero2.setBounds(20, 120, 40, 20);

        ActionListener oye = (ActionEvent e) -> {
            
            double n = Double.parseDouble(numero1.getText());
            System.out.println();
            double m = Double.parseDouble(numero2.getText());
            
            if (n >= m) {
                fact = (factorial(n)) / ((factorial(n - m)) * (factorial(m)));
                System.out.println(fact);
                l.setText(numero1.getText() + "C" + numero2.getText() + "=" + fact);
            } else if (n > 0 && m > 0) {
                l.setText("N debe ser mayor o igual a M");
            } else if (n < 0 || m < 0) {
                l.setText("Los numeros digitados no pueden ser menores a 0");
            } 
        };
        b.addActionListener(oye);

    }

    public double factorial(double numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * factorial(numero - 1);
        }
    }
}
