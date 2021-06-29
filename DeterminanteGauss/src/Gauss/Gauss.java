/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gauss;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class Gauss extends JFrame implements ActionListener {

    Color color = new Color(245, 245, 245);
    Color color1 = new Color(50, 93, 127);
    Font fuente = new Font("TimesRoman", Font.BOLD, 10);
    Font fuente1 = new Font("TimesRoman", Font.BOLD, 20);
    Panel p;

    int m, n, oe, rango;
    int sig_oe[] = new int[2];
    double determinante = 1.0;
    double variables[][];
    double matriz[][];

    
    Determinante determi = new Determinante();
    TrSup trian;

    String newline = "\n\n";

    JLabel range = new JLabel();
    ;
    JLabel[][] texto;
    JTextArea tr = new JTextArea(15, 20);
    JTextField[][] leer;

    JButton boton_graficar = new JButton("Graficar");
    JButton btn_calcular = new JButton("Calcular Determinante (Matriz Cuadrada)");
    JButton btn_llenar = new JButton("Llenar Aleatoriamente");
    JButton btn_rango = new JButton("Escalonar matriz y calcular rango");
    JLabel respuesta = new JLabel("");

    JScrollPane jsp = new JScrollPane(tr, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    public static void main(String[] args) {
        Gauss obj = new Gauss();
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setBounds(100, 100, 1000, 1000);
        obj.setResizable(false);
    }

    public Gauss() {
        super("Determinante");
        Container d = getContentPane();
        d.setLayout(null);
        d.setBackground(color1);
        d.setBounds(0, 0, 500, 1000);

        //setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Complejidad\\src\\imagenes\\24392.png").getImage());
        d.add(btn_calcular);
        d.add(btn_llenar);
        d.add(respuesta);

        btn_calcular.setBackground(Color.black);
        btn_calcular.setForeground(Color.white);
        btn_calcular.setSize(btn_calcular.getMinimumSize());
        btn_calcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_llenar.setSize(btn_llenar.getMinimumSize());
        btn_llenar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn_llenar.addActionListener(this);
        btn_calcular.addActionListener(this);

        n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la matriz Filas:"));
        m = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la matriz Columnas:"));

        trian = new TrSup(m, n);

        if ((n * 80) + 20 < btn_calcular.getWidth() + 20) {
            setSize(btn_calcular.getWidth() + 20, (n * 40) + 150);
        } else {
            setSize((n * 80) + 20, (n * 40) + 150);
        }

        btn_calcular.setBounds(this.getWidth() / 2 - (int) btn_calcular.getWidth() / 2, 20, (int) btn_calcular.getWidth(), 40);
        btn_llenar.setBounds(this.getWidth() / 2 - (int) btn_llenar.getWidth() / 2, 60, (int) btn_llenar.getWidth(), 20);

        variables = new double[m][n];
        matriz = new double[n][m];
        texto = new JLabel[m][n];
        leer = new JTextField[m][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                leer[x][y] = new JTextField();
                texto[x][y] = new JLabel();
                d.add(texto[x][y]);
                d.add(leer[x][y]);
                leer[x][y].setBounds(-70 + (80 * (x + 1)), 50 + (20 * (y + 2)), 50, 20);
                texto[x][y].setBounds(-17 + (80 * (x + 1)), 50 + (20 * (y + 2)), 30, 20);
                texto[x][y].setText(" " + (x + 1) + "," + (y + 1));
                texto[x][y].setBackground(null);
                texto[x][y].setFont(fuente);
                texto[x][y].setForeground(Color.DARK_GRAY);
                leer[x][y].setText("1");
                leer[x][y].setBackground(Color.LIGHT_GRAY);
            }
            respuesta.setBounds(this.getWidth() / 2 - 100, (20 * (y + 2)) + 80, 300, 70);
            respuesta.setForeground(Color.BLACK);
        }
        p = new Panel();
        p.setLayout(null);
        d.add(p);
        p.setBackground(color1);
        p.setBounds(500, 0, 500, 1000);
        btn_rango.addActionListener(this);
        btn_rango.setBounds(150, 30, 200, 40);
        p.add(btn_rango);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn_calcular) {
            if(n==m){
            int signo;
            int ceros = 0;
            determinante = 1;
            rango = 0;

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    variables[x][y] = Double.parseDouble(leer[x][y].getText());
                    if (variables[x][y] == 0.0) {
                        ceros += 1;
                    }
                }
            }
            if (ceros == n) {
                determinante = 0;
                rango = 1;
            } else {

                determi.calculoDeterminante(variables, n, sig_oe);

                oe = sig_oe[0];
                signo = sig_oe[1];

                for (int i = 0; i < n; i++) {
                    oe += 7;
                    determinante *= variables[i][i] * signo;
                }
            }

            respuesta.setText("<html>Determinante: <html>" + determinante + "<p>OE: " + oe + "<p>Formula (32n<sup>3</sup>-33n<sup>2</sup>+97n-24)/6 =" + ((32 * n * n * n - 33 * n * n + 97 * n - 24) / 6)+"<p>O()");
            }else{
                respuesta.setText("La matriz no es cuadrada");
            }
            //((((double) 16 / 6) * (n * (n - 1) * (2 * (n - 1) + 1))) + (5 * ((n * n) - (((n * n) - n) / 2) - n)) + (3 * (n - 1)) + (6 * (n - 1)) + (7 * n) + 5)
        } else if (e.getSource() == btn_llenar) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    int s = (int) (Math.random() * (9 + 1));
                    leer[x][y].setText(Integer.toString((s)));
                    variables[x][y] = Double.parseDouble(leer[x][y].getText());
                }
            }
        } else if (e.getSource() == btn_rango) {
            tr.setText("");
            int cont = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    matriz[y][x] = Double.parseDouble(leer[x][y].getText());
                }
                System.out.println("");
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println("");
            }
            trian.dejarTRSuperior(n, m, matriz);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println("");
            }
            p.add(jsp);
            p.add(range);
            jsp.setBounds(20, 100, 300, 300);
            for (int y = 0; y < n; y++) {
                String pos = "";
                for (int x = 0; x < m; x++) {
                    pos += (Double.toString(matriz[y][x]) + "  \t  ");
                }
                tr.append(pos + newline);
            }
            range.setBounds(100, 450, 300, 70);
            range.setForeground(Color.BLACK);
            range.setText("Rango:  " + Integer.toString(trian.calculoRango(matriz)));
        }

    }

}
/*
1 0
2 1  1 
3 5  3
4 14 6
5 30 10
6 55 15
7 91 21

 */
