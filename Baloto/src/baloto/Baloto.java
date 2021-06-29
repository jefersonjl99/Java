/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baloto;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
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
public class Baloto extends JFrame {

    int n = 6;
    int i;
    double[] z = new double[3];
    JButton btn_jugar = new JButton("Jugar");
    Color color = new Color(50, 93, 127);

    JTextField[] leer = new JTextField[n];

    JLabel respuesta = new JLabel("");
    JLabel respuesta1 = new JLabel("");

    Font fuente = new Font("TimesRoman", Font.BOLD, 25);

    public static void main(String[] args) {
        Baloto obj = new Baloto();
        obj.setSize(500, 340);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }

    public Baloto() {
        super("");
        
        Container b = getContentPane();
        b.setLayout(null);
        b.setBackground(color);
        
        
        setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Baloto\\src\\imagenes\\logo1.png").getImage());
        

        b.add(btn_jugar);
        b.add(respuesta);
        b.add(respuesta1);

        btn_jugar.setBounds(200, 50, 100, 20);
        respuesta.setBounds(50, 200, 300, 100);

        respuesta1.setFont(fuente);

        btn_jugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        respuesta.setBackground(Color.lightGray);
        respuesta1.setForeground(Color.red);

        for (int x = 0; x < n; x++) {
            leer[x] = new JTextField();
            b.add(leer[x]);
            leer[x].setBounds((60 * (x + 1)), 20, 50, 20);
            leer[x].setText("" + (x + 1));
            leer[x].setBackground(Color.yellow);
            if (x == 5) {
                leer[x].setBackground(Color.red);
            }
        }

        ActionListener oir = (ActionEvent e) -> {
            //Hacer el arreglo de cocientes
            if (e.getSource() == btn_jugar) {

                Numeros n1 = new Numeros();
                for (i = 0; i < 6; i++) {
                    int dato = Integer.parseInt(leer[i].getText());
                    n1.asignar(dato);
                }
                System.out.println("\n\t...numeros tomados...\n");
                boolean repetir;
                do {
                    repetir = n1.generar(z);
                } while (repetir == false);

                respuesta1.setText("¡GANASTE!");
                respuesta1.setSize(respuesta1.getMinimumSize());
                System.out.println(respuesta1.getWidth());
                respuesta1.setBounds((250 - (respuesta1.getWidth() / 2)), 100, respuesta1.getWidth(), respuesta1.getHeight());
                respuesta.setText("<html>Coincidieron despues  de <html>" + (int) z[0] + "  semanas<p> Y jugo " + z[1] + "siglos<p><p>PD: Los primeros 5 numeros coincidieron: " + (int) z[2] + " veces");
                System.out.println("\n\t...Termino proceso... ");
            }
        };
        btn_jugar.addActionListener(oir);
    }

}
