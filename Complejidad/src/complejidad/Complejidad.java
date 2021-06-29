/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complejidad;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class Complejidad extends JFrame implements ActionListener {

    Color color = new Color(50, 93, 127);
    Font fuente = new Font("TimesRoman", Font.BOLD, 20);
    int n_totales, n, y0 = 650, x0 = 85, factor;
    double y_in = 650, x_in = 80, x_fin = 80, y_fin = 650, operaciones;

    Burbuja burbuja = new Burbuja();
    Insercion insercion = new Insercion();
    Seleccion seleccion = new Seleccion();
    RadixSort radixSort = new RadixSort();
    QuickSort quickSort = new QuickSort();
    MergeSort mergeSort = new MergeSort();
    VentanaBinario ventanaBinario;
    VentanaQuickMerge ventanaQuickMerge;

    JTextField in_tamaño = new JTextField("0");

    JLabel texto_in = new JLabel("Digite los n tamaños totales para el arreglo: ");
    JLabel texto = new JLabel();
    JLabel texto_oe = new JLabel("<html><div style='text-align: center;'>O<p>p<p>e<p>r<p>a<p>c<p>i<p>o<p>n<p>e<p>s<p><p>E<p>l<p>e<p>m<p>e<p>n<p>t<p>a<p>l<p>e<p>s</div><html>");
    JLabel texto_tam_array = new JLabel("<html><div style='text-align: center;'>Tamaño Arreglo</div></html>");

    /*JButton boton_caso1 = new JButton("Mejor Caso");
    JButton boton_caso2 = new JButton("Peor Caso");
    JButton boton_caso3 = new JButton("Aleatorio");*/
    JButton boton_binario = new JButton("Binario");
    JButton boton_Quick_Merge = new JButton("Quick y Merge");
    JButton boton_graficar = new JButton("Graficar");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Complejidad obj = new Complejidad();
        obj.setSize(620, 700);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);

    }

    public Complejidad() {
        super("Complejidad");
        Container N = getContentPane();
        N.setLayout(null);
        N.setBackground(color);

        setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Complejidad\\src\\imagenes\\24392.png").getImage());

        N.add(boton_graficar);
        N.add(boton_binario);
        N.add(boton_Quick_Merge);
        //N.add(in_tamaño);
        //N.add(texto_in);

        /*boton_caso1.setBackground(Color.BLACK);
        boton_caso2.setBackground(Color.BLACK);
        boton_caso3.setBackground(Color.BLACK);
        
        boton_caso1.setForeground(Color.CYAN);
        boton_caso2.setForeground(Color.CYAN);
        boton_caso3.setForeground(Color.CYAN);
        
        boton_caso1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_caso2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_caso3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        boton_caso1.setBounds(20, 20, 100, 20);
        boton_caso2.setBounds(130, 20, 100, 20);
        boton_caso3.setBounds(240, 20, 100, 20);
        
        boton_caso1.addActionListener(this);
        boton_caso2.addActionListener(this);
        boton_caso3.addActionListener(this);
         */
        texto_in.setBounds(20, 20, 300, 20);;

        in_tamaño.setBounds(340, 20, 50, 20);

        boton_graficar.setBackground(Color.RED);
        boton_graficar.setForeground(Color.WHITE);
        boton_graficar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_graficar.setBounds(360, 20, 100, 20);
        boton_graficar.addActionListener(this);

        boton_binario.setBackground(Color.BLACK);
        boton_binario.setForeground(Color.CYAN);
        boton_binario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_binario.setBounds(240, 20, 100, 20);
        boton_binario.addActionListener(this);

        boton_Quick_Merge.setBackground(Color.BLACK);
        boton_Quick_Merge.setForeground(Color.CYAN);
        boton_Quick_Merge.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_Quick_Merge.setBounds(120, 20, 100, 20);
        boton_Quick_Merge.addActionListener(this);

        n_totales = 2;
        n = n_totales;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_graficar) {

            factor = n * 6;
            System.out.println(factor);

            add(texto_oe);
            add(texto_tam_array);

            Graphics g;
            g = getGraphics();
            g.setColor(color);
            g.fillRect(0, 70, 620, 700);
            g.setColor(Color.BLACK);

            texto_oe.setBounds(10, 120, 10, 400);
            texto_tam_array.setBounds(240, 640, 100, 20);

            /*int cif = Integer.toString(n).length();
            int mod = 1;

            for (int i = 1; i < cif; i++) {
                mod *= 10;
            }
            
            int cifras = Integer.toString(n*(n * 6)).length();
            int modulo = 1;

            for (int i = 1; i < cifras-1; i++) {
                modulo *= 10;
            }*/
            for (int i = 0; i <= 500; i++) {
                if (i % 100 == 0) {
                    String s = Integer.toString(i);
                    g.drawString(s, i + x0, 665);
                }
            }

            for (int i = 12; i > 0; i--) {////////////////////////////////////////////////////////////////////borrar esta mierda
                System.out.print(i + "x");
            }
            System.out.println("liNEA 162");
            for (int i = 0; i <= 1500000; i++) {
                if (i % 100000 == 0) {
                    String s = Integer.toString(i);
                    g.drawString(s, 30, (y0 + 4 - i / factor));
                    g.drawString("_", x0 - 3, (y0 - 1 - i / factor));
                }
            }

            g.drawLine(x0, y0, x0 + 500, y0);
            g.drawLine(x0, y0, x0, y0 - 500);

            ///////////////////////////////Burbuja////////////////////////////////////////////
            g.setColor(Color.CYAN);
            y_fin = y0;
            x_fin = x0;
            for (int i = 1; i <= n; i++) {//burbuja

                x_in = x_fin;
                y_in = y_fin;
                x_fin = i + x0;
                operaciones = burbuja.complejidad(i, n_totales);
                y_fin = y0 - (operaciones / factor);
                g.drawLine((int) x_in, (int) y_in, (int) x_fin, (int) y_fin);

            }
            g.drawString("Burbuja", (int) x_fin - 50, (int) y_fin);
            g.drawString(Integer.toString((int) operaciones) + "--", 30, (int) y_in + 4);
            System.out.println("Burbuja: " + operaciones);

            //////////////////////////////////Seleccion///////////////////////////////////////
            g.setColor(Color.GREEN);
            y_fin = y0;
            x_fin = x0;
            for (int i = 1; i <= n; i++) {//seleccion

                x_in = x_fin;
                y_in = y_fin;
                x_fin = i + x0;
                operaciones = seleccion.complejidad(i, n_totales);
                y_fin = y0 - (operaciones / factor);
                g.drawLine((int) x_in, (int) y_in, (int) x_fin, (int) y_fin);

            }
            g.drawString("Seleccion", (int) x_fin - 50, (int) y_fin);
            g.drawString(Integer.toString((int) operaciones) + "--", 30, (int) y_fin + 4);
            System.out.println("Seleccion: " + operaciones);

            //////////////////////////////////Insercion///////////////////////////////////////
            g.setColor(Color.MAGENTA);
            y_fin = y0;
            x_fin = x0;

            for (int i = 1; i <= n; i++) {//Insercion

                x_in = x_fin;
                y_in = y_fin;
                x_fin = i + x0;
                operaciones = insercion.complejidad(i, n_totales);
                y_fin = y0 - (operaciones / factor);
                g.drawLine((int) x_in, (int) y_in, (int) x_fin, (int) y_fin);

            }
            g.drawString("Insercion", (int) x_fin - 50, (int) y_fin);
            g.drawString(Integer.toString((int) operaciones) + "--", 30, (int) y_fin + 4);
            System.out.println("Insercion: " + operaciones);
            ///////////////////////////////////Radix////////////////////////////////////////
            g.setColor(Color.ORANGE);
            y_fin = y0;
            x_fin = x0;

            for (int i = 1; i <= n; i++) {//Radix

                x_in = x_fin;
                y_in = y_fin;
                x_fin = i + x0;
                operaciones = radixSort.complejidad(i, n_totales);
                y_fin = y0 - (operaciones / factor);
                g.drawLine((int) x_in, (int) y_in, (int) x_fin, (int) y_fin);

            }
            g.drawString("RadixSort", (int) x_fin - 50, (int) y_fin);
            g.drawString(Integer.toString((int) operaciones) + "--", 30, (int) y_fin + 4);
            System.out.println("RadixSort: " + operaciones);
            ///////////////////////////////////Quick////////////////////////////////////////
            g.setColor(Color.WHITE);
            y_fin = y0;
            x_fin = x0;

            for (int i = 1; i <= n; i++) {//Quick

                x_in = x_fin;
                y_in = y_fin;
                x_fin = i + x0;
                quickSort.crearMatriz(i);
                operaciones = quickSort.complejidad(i, n_totales);
                y_fin = y0 - (operaciones / factor);
                g.drawLine((int) x_in, (int) y_in, (int) x_fin, (int) y_fin);

            }

            g.drawString("QuickSort", (int) x_fin - 50, (int) y_fin);
            g.drawString(Integer.toString((int) operaciones) + "--", 30, (int) y_fin + 4);
            System.out.println("QuickSort: " + operaciones);
            System.out.println("Ec Temporal: 44 - 23 N + 13 N lg(N)= " + operaciones);

            /////////////////////////////Merge////////////
            g.setColor(Color.LIGHT_GRAY);
            y_fin = y0;
            x_fin = x0;
            for (int i = 2; i <=n; i++) {//Merge

                x_in = x_fin;
                y_in = y_fin;
                x_fin = i + x0;
                operaciones = mergeSort.llenar(i,n);
                y_fin = y0 - (operaciones / factor);
                g.drawLine((int) x_in, (int) y_in, (int) x_fin, (int) y_fin);

            }

            g.drawString("MergeSort", (int) x_fin - 50, (int) y_fin);
            g.drawString(Integer.toString((int) operaciones) + "--", 30, (int) y_fin + 4);
            System.out.println("MergeSort: " + operaciones);
            System.out.println("Ec Temporal: 70 - 68N + 39 N lg(N)= " + operaciones);

        }//Fin boton graficar

        if (e.getSource() == boton_binario) {
            ventanaBinario = new VentanaBinario(n);
            ventanaBinario.setVisible(true);
        }//Boton Binario

        if (e.getSource() == boton_Quick_Merge) {
            ventanaQuickMerge = new VentanaQuickMerge(n);
            ventanaQuickMerge.setVisible(true);
        }//Quick y merge buton
    }

}
