/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package determinante;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class Determinante extends JFrame {

    /**
     * @param args the command line arguments
     */
    double determinante = 0.0;
    final int n = 3;
    double variables[][] = new double[n][n];
    
    
    JTextArea[][] texto = new JTextArea[n][n];
    JTextField[][] leer = new JTextField[n][n];
    JButton calcular = new JButton("Calcular Determinante");
    JButton llenar = new JButton("Llenar Aleatoriamente");
    JLabel respuesta = new JLabel("");
    Font fuente = new Font("Arial", Font.BOLD, 20);

    Dimension dimension = new Dimension();

    public static void main(String[] args) {
        // TODO code application logic here
        Determinante obj = new Determinante();
        obj.setSize(800, 600);
        obj.setLocationRelativeTo(null);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public Determinante() {
        super("Determinante de una matriz 3X3");
        Container d = getContentPane();
        d.setLayout(null);
        
        d.add(calcular);
        d.add(llenar);
        d.add(respuesta);

        calcular.setBackground(Color.black);
        calcular.setForeground(Color.white);
        calcular.setSize(calcular.getMinimumSize());
        calcular.setBounds(290, 20, (int) calcular.getWidth(), 40);
        calcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        llenar.setSize(llenar.getMinimumSize());
        llenar.setBounds(290, 60, (int) llenar.getWidth(), 20);
        llenar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                leer[x][y] = new JTextField();
                texto[x][y] = new JTextArea();
                d.add(texto[x][y]);
                d.add(leer[x][y]);
                leer[x][y].setBounds((70 * (x + 1)), -20 + (20 * (y + 2)), 50, 20);
                texto[x][y].setBounds(50 + (70 * (x + 1)), -20 + (20 * (y + 2)), 20, 20);
                texto[x][y].setText("X" + (x + 1));
                texto[x][y].setEditable(false);
                texto[x][y].setBackground(null);
                texto[x][y].setForeground(Color.blue);
                leer[x][y].setText("0");
            }
        }

        ActionListener oir = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == calcular) {
                    for (int y = 0; y < n; y++) {
                        for (int x = 0; x < n; x++) {
                            variables[x][y] = Double.parseDouble(leer[x][y].getText());
                        }

                    }
                    determinante = variables[0][0] * variables[1][1] * variables[2][2]
                            + variables[0][1] * variables[1][2] * variables[2][0]
                            + variables[0][2] * variables[1][0] * variables[2][1]
                            - (variables[0][2] * variables[1][1] * variables[2][0]
                            + variables[0][1] * variables[1][0] * variables[2][2]
                            + variables[0][0] * variables[1][2] * variables[2][1]);
                    respuesta.setText("El determinante para la matriz dada es: D=" + determinante);
                    respuesta.setFont(fuente);
                    respuesta.setSize(respuesta.getMaximumSize());
                    respuesta.setBounds(10, 100, respuesta.getWidth(), respuesta.getHeight());
                    respuesta.setForeground(Color.red);

                }
                if (e.getSource() == llenar) {
                    for (int y = 0; y < n; y++) {
                        for (int x = 0; x < n; x++) {
                            double s = (Math.random() * (9 + 1));
                            leer[x][y].setText(Double.toString(Math.round(s * 10d) / 10d));
                            variables[x][y] = Double.parseDouble(leer[x][y].getText());
                        }

                    }
                }
            }

        };
        calcular.addActionListener(oir);
        llenar.addActionListener(oir);
    }
}
