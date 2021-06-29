/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complejidad;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jefer
 */
public class VentanaQuickMerge extends JFrame implements ActionListener {

    BusquedaBinaria busquedaBinaria = new BusquedaBinaria();

    QuickSort quickSort = new QuickSort();

    MergeSort mergeSort = new MergeSort();

    JButton boton_graficar = new JButton("Graficar");

    int n_totales, n, y0 = 650, x0 = 85, factor;
    double y_in = 650, x_in = 80, x_fin = 80, y_fin = 650, operaciones;

    public VentanaQuickMerge(int h) {

        setTitle("Binario");
        setLayout(null);
        setSize(620, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusableWindowState(false);
        add(boton_graficar);

        n = h;
        boton_graficar.setBackground(Color.RED);
        boton_graficar.setForeground(Color.WHITE);
        boton_graficar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_graficar.setBounds(360, 20, 100, 20);
        boton_graficar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_graficar) {
            Graphics g;
            g = getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 70, 620, 700);
            g.setColor(Color.BLACK);

            for (int i = 0; i <= 500; i++) {
                if (i % 100 == 0) {
                    String s = Integer.toString(i);
                    g.drawString(s, i + x0, 665);
                }
            }

            g.drawLine(x0, y0, x0 + 500, y0);
            g.drawLine(x0, y0, x0, y0 - 500);

            /////////////////////////////Quick////////////
            g.setColor(Color.BLACK);
            y_fin = y0;
            x_fin = x0;
            for (int i = 1; i <= n; i++) {//Quick

                x_in = x_fin;
                y_in = y_fin;
                x_fin = i + x0;
                quickSort.crearMatrizAleat(500);
                operaciones = quickSort.complejidad(500, n_totales);
                y_fin = y0 - (operaciones / 30);
                g.drawString(".", (int) x_fin, (int) y_fin);

            }

            g.drawString("QuickSort", (int) x_fin - 50, (int) y_fin);
            g.drawString(Integer.toString((int) operaciones) + "--", 30, (int) y_fin + 4);
            System.out.println("QuickSort: " + operaciones);
            System.out.println("Ec Temporal: 44 - 23 N + 13 N lg(N)= " + operaciones);
            /////////////////////////////Merge////////////
            g.setColor(Color.CYAN);
            y_fin = y0;
            x_fin = x0;
            for (int i = 1; i <= n; i++) {//Merge

                x_in = x_fin;
                y_in = y_fin;
                x_fin = i + x0;
                operaciones = mergeSort.llenarAleat(500,i);
                y_fin = y0 - ((double)operaciones / 900);
                g.drawString(".", (int) x_fin, (int) y_fin);

            }

            g.drawString("MergeSort", (int) x_fin - 50, (int) y_fin);
            g.drawString(Integer.toString((int) operaciones) + "--", 30, (int) y_fin + 4);
            System.out.println("MergeSort: " + operaciones);
            System.out.println("Ec Temporal: 44 - 23 N + 13 N lg(N)= " + operaciones);
            ////////////////////////////////////log/////////////////
            g.setColor(Color.red);
            y_fin = y0 = 550;
            x_fin = x0;
            for (int i = 1; i <= n; i++) {//burbuja

                x_in = x_fin;
                y_in = y_fin;
                x_fin = i + x0;
                double log = (Math.log10(i) / Math.log10(2));

                y_fin = y0 - ((i * log) / 500);
                /* if (i % 100 == 0) {

                    g.drawString("log2( " + i + ")= " + Integer.toString(((int) (Math.log10(i) / Math.log10(2)))), 10, (int) (y_fin));
                }*/
                g.drawLine((int) x_in, (int) y_in, (int) x_fin, (int) y_fin);

            }
            g.drawString("nlog2(n)", (int) x_fin - 50, (int) y_fin);

        }
    }

}
