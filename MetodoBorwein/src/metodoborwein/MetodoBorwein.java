/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodoborwein;

/**
 *
 * @author jefer
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class MetodoBorwein extends JFrame {

    int n = 50;

    Color color = new Color(50, 93, 127);

    Font fuente = new Font("TimesRoman", Font.BOLD, 25);

    JButton btn_calcular = new JButton("Calcular");

    JLabel respuesta = new JLabel("");
    
    JLabel imagen = new JLabel();

    public static void main(String[] args) {
        MetodoBorwein obj = new MetodoBorwein();
        obj.setSize(500, 220);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }

    public MetodoBorwein() {

        super("Metodo Borwein");
        Container m = getContentPane();
        m.setLayout(null);
        m.setBackground(color);

        setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\MetodoMontecarlo\\src\\imagenes\\43102.png").getImage());
        
        m.add(btn_calcular);
        m.add(respuesta);

        
        btn_calcular.setBounds(130, 40, 100, 20);
        respuesta.setBounds(40, 100, 400, 20);
        m.add(imagen);

        imagen.setBounds(320, 20, 150, 150);
        ImageIcon imag = new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\MetodoMontecarlo\\src\\imagenes\\ba38e6111932855459eb091da1372849-icono-de-dados-de-juego-by-vexels.png");
        Icon icon = new ImageIcon(imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icon);
        btn_calcular.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ActionListener oir = (ActionEvent e) -> {
            if (e.getSource() == btn_calcular) {

                double a = 0.3431457505;
                double y = 0.4142135624;

                for (int i = 0; i < n; i++) {
                    y = (1 - Math.pow(1 - Math.pow(y, 4), 0.25)) / (1 + Math.pow(1 - Math.pow(y, 4), 0.25));
                    a = (a * Math.pow(y + 1, 4)) - (Math.pow(2, (2 * i) + 3) * y * (1 + y + (y * y)));
                }
                System.out.println(a);
                double pi = 1 / a;

                System.out.println("π ~ " + pi);
                System.out.println("diferencia = "+(pi-Math.PI));

                respuesta.setForeground(Color.RED);
                respuesta.setFont(fuente);
                respuesta.setText("π ~ " + pi);

            }
        };
        btn_calcular.addActionListener(oir);

    }

}
