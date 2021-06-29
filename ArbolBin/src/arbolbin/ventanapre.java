/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ssrs_
 */
public class ventanapre extends JFrame implements ActionListener {

    JPanel panel0;
    JPanel panel;
    JPanel panel2;
    JLabel etiqueta1;
    JTextField listaNumsPRE = new JTextField();
    JTextField listaNumslIN = new JTextField();
    JButton ok, dibujar, salir;
    JLabel valores;
    ArbolBinario b = new ArbolBinario();
    char[] arrIN;
    char[] arrPRE;

    public ventanapre() {
        setTitle("Reconstrucción preorden");
        setLayout(null);
        setBounds(50, 50, 1300, 700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    void iniciarComponentes() {
        panel0 = new JPanel();
        panel0.setLayout(null);
        panel0.setBounds(0, 0, 1300, 50);
        panel0.setBackground(Color.WHITE);
        this.getContentPane().add(panel0);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 50, 1300, 200);
        panel.setBackground(Color.BLACK);
        this.getContentPane().add(panel);
        panel.setVisible(false);

        panel2 = new JPanel();
        panel2.setBounds(0, 250, 1300, 450);
        this.getContentPane().add(panel2);
        panel2.setBackground(Color.DARK_GRAY);
        panel2.setLayout(null);
        panel2.setVisible(false);

        etiqueta1 = new JLabel("Arreglo en preorden (LETRAS)");
        etiqueta1.setForeground(Color.BLUE);
        etiqueta1.setFont(new Font("berlin sans fb demi", Font.BOLD, 16));
        etiqueta1.setBounds(20, 10, 350, 20);
        panel0.add(etiqueta1);

        etiqueta1 = new JLabel("Arreglo en inorden (LETRAS)");
        etiqueta1.setForeground(Color.BLUE);
        etiqueta1.setFont(new Font("berlin sans fb demi", Font.BOLD, 16));
        etiqueta1.setBounds(20, 30, 350, 20);
        panel0.add(etiqueta1);

        panel0.add(listaNumsPRE);
        listaNumsPRE.setBounds(400, 10, 300, 20);

        panel0.add(listaNumslIN);
        listaNumslIN.setBounds(400, 30, 300, 20);

        ok = new JButton("OK");
        ok.setFont(new Font("berlin sans fb demi", Font.BOLD, 14));
        ok.setBounds(900, 20, 150, 20);
        panel0.add(ok);
        ok.addActionListener(this);

        dibujar = new JButton("Dibujar");
        dibujar.setFont(new Font("berlin sans fb demi", Font.BOLD, 14));
        dibujar.setBounds(50, 20, 150, 50);
        panel.add(dibujar);
        dibujar.addActionListener(this);

        salir = new JButton("Salir");
        salir.setFont(new Font("berlin sans fb demi", Font.BOLD, 14));
        salir.setBounds(900, 20, 150, 50);
        panel.add(salir);
        salir.addActionListener(this);

        valores = new JLabel();
        valores.setForeground(Color.BLUE);
        valores.setFont(new Font("berlin sans fb demi", Font.BOLD, 15));
        valores.setBounds(500, 10, 500, 200);
        panel.add(valores);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok) {

            String totalText = listaNumsPRE.getText();
            String totalTextl = listaNumslIN.getText();

            String[] textElements = totalText.split("");
            String[] textElementsIN = totalTextl.split("");

            arrPRE = new char[textElements.length];
            arrIN = new char[textElementsIN.length];

            for (int i = 0; i < textElements.length; i++) {
                arrPRE[i] = textElements[i].charAt(0);
            }
            for (int i = 0; i < textElementsIN.length; i++) {
                arrIN[i] = textElementsIN[i].charAt(0);
            }

            //b.insertarL(arrPRE, arrIN);
            panel.setVisible(true);
            panel2.setVisible(true);
        }
        if (e.getSource() == dibujar) {
            //DIBUJA BIEN
            //
            System.out.print("preorden: ");
            for (int i = 0; i < arrPRE.length; i++) {
                System.out.print(arrPRE[i] + " ");
            }
            System.out.println("");
            System.out.print("inorden: ");
            for (int i = 0; i < arrIN.length; i++) {
                System.out.print(arrIN[i] + " ");
            }
            dibujar d = new dibujar();
            b.initst();
            Graphics g;
            g = panel2.getGraphics();
            b.insertarArbolpre(arrPRE, arrIN, 10, 500, 80, g);

            //d.DibujaArbolL(panel2.getGraphics(), 30, b.getRaiz());
        }
        if (e.getSource() == salir) {
            b.initst();
            b.inicializarAr();
            dispose();
        }
    }

    public boolean isLetter(char caracter) {
        if (Character.isLetter(caracter)) {
            return true;
        } else {
            return false;
        }
    }
}
