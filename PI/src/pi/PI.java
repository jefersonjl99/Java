/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

/**
 *
 * @author jefer
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author jefer
 */
public class PI extends JFrame {

    int n = 50;
    double pi;
    long startTime = 0, endTime = 0, diferenciaTiempo = 0, ultimoTiempo = 0;
    //long tiempoLebniz, tiempoMontecarlo, tiempoBorwein;

    Lebniz lebniz = new Lebniz();
    Montecarlo montecarlo = new Montecarlo();
    Borwein borwein = new Borwein();

    Color color = new Color(50, 93, 127);

    Font fuente = new Font("TimesRoman", Font.BOLD, 25);

    JButton btn_todos = new JButton("Todos");
    JButton btn_lebniz = new JButton("Lebniz");
    JButton btn_montecarlo = new JButton("Montecarlo");
    JButton btn_borwein = new JButton("Borwein");
    JButton btn_comparar = new JButton("Comparar");

    JLabel texto = new JLabel("Digite segun el metodo a usar: ");
    JLabel texto2 = new JLabel("" + Math.PI);

    JLabel respuesta = new JLabel("");
    JLabel respuesta_lebniz = new JLabel("");
    JLabel respuesta_montecarlo = new JLabel("");
    JLabel respuesta_borwein = new JLabel("");
    JLabel respuesta_tiempo = new JLabel("");

    JLabel imagen = new JLabel();

    public static void main(String[] args) {
        PI obj = new PI();
        obj.setSize(500, 230);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }

    public PI() {

        super("Calculo de π");
        Container p = getContentPane();
        p.setLayout(null);
        p.setBackground(color);

        setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\MetodoMontecarlo\\src\\imagenes\\43102.png").getImage());

        p.add(texto);
        p.add(btn_todos);
        p.add(btn_lebniz);
        p.add(btn_montecarlo);
        p.add(btn_borwein);
        p.add(respuesta);
        p.add(imagen);
        p.add(texto2);
        p.add(respuesta_lebniz);
        p.add(respuesta_montecarlo);
        p.add(respuesta_borwein);
        p.add(btn_comparar);
        p.add(respuesta_tiempo);

        texto.setBounds(20, 10, 200, 20);
        btn_todos.setBounds(220, 10, 100, 20);
        btn_lebniz.setBounds(20, 40, 100, 20);
        btn_montecarlo.setBounds(120, 40, 100, 20);
        btn_borwein.setBounds(220, 40, 100, 20);
        respuesta.setBounds(20, 100, 300, 20);
        texto2.setBounds(340, 125, 200, 20);
        respuesta_lebniz.setBounds(20, 80, 300, 20);
        respuesta_montecarlo.setBounds(20, 110, 300, 20);
        respuesta_borwein.setBounds(20, 140, 300, 20);
        btn_comparar.setBounds(348, 150, 100, 20);
        respuesta_tiempo.setBounds(20, 160, 300, 30);

        texto.setForeground(Color.BLACK);

        respuesta.setFont(fuente);
        respuesta_lebniz.setFont(fuente);
        respuesta_montecarlo.setFont(fuente);
        respuesta_borwein.setFont(fuente);

        btn_todos.setForeground(Color.WHITE);
        btn_todos.setBackground(Color.BLACK);
        btn_lebniz.setBackground(Color.YELLOW);
        btn_montecarlo.setBackground(Color.GREEN);
        btn_borwein.setBackground(Color.CYAN);
        btn_comparar.setBackground(Color.MAGENTA);

        imagen.setBounds(340, 20, 100, 100);
        ImageIcon imag = new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\MetodoMontecarlo\\src\\imagenes\\43102.png");
        Icon icon = new ImageIcon(imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icon);

        btn_lebniz.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_montecarlo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_borwein.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_todos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_comparar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ActionListener oir = (ActionEvent e) -> {

            if (e.getSource() == btn_lebniz) {

                startTime = System.nanoTime();

                respuesta_lebniz.setText(null);
                respuesta_montecarlo.setText(null);
                respuesta_borwein.setText(null);

                pi = lebniz.calcular_pi();

                respuesta.setForeground(Color.YELLOW);
                respuesta.setText("π ~ " + pi);

                endTime = (System.nanoTime() - startTime);
                if (endTime > ultimoTiempo) {
                    diferenciaTiempo = endTime - ultimoTiempo;
                } else {
                    diferenciaTiempo = ultimoTiempo - endTime;
                }
                ultimoTiempo=endTime;

                System.out.println(endTime);
                System.out.println("Duración: " + (endTime) / 1e6 + " ms");
                respuesta_tiempo.setText("Duración: " + (endTime) / 1e6 + " ms");
            }

            if (e.getSource() == btn_montecarlo) {

                startTime = System.nanoTime();

                respuesta_lebniz.setText(null);
                respuesta_montecarlo.setText(null);
                respuesta_borwein.setText(null);

                pi = montecarlo.calcular_pi();

                respuesta.setForeground(Color.GREEN);
                respuesta.setText("π ~ " + pi);

                endTime = (System.nanoTime() - startTime);
                if (endTime > ultimoTiempo) {
                    diferenciaTiempo = endTime - ultimoTiempo;
                } else {
                    diferenciaTiempo = ultimoTiempo - endTime;
                }
                ultimoTiempo=endTime;

                System.out.println(endTime);
                System.out.println("Duración: " + (endTime) / 1e6 + " ms");
                respuesta_tiempo.setText("Duración: " + (endTime) / 1e6 + " ms");
            }

            if (e.getSource() == btn_borwein) {

                startTime = System.nanoTime();

                respuesta_lebniz.setText(null);
                respuesta_montecarlo.setText(null);
                respuesta_borwein.setText(null);

                pi = borwein.calcular_pi();

                respuesta.setForeground(Color.CYAN);
                respuesta.setText("π ~ " + pi);

                endTime = (System.nanoTime() - startTime);
                if (endTime > ultimoTiempo) {
                    diferenciaTiempo = endTime - ultimoTiempo;
                } else {
                    diferenciaTiempo = ultimoTiempo - endTime;
                }
                ultimoTiempo=endTime;

                System.out.println(endTime);
                System.out.println("Duración: " + (endTime) / 1e6 + " ms");
                respuesta_tiempo.setText("Duración: " + (endTime) / 1e6 + " ms");
            }

            if (e.getSource() == btn_todos) {

                respuesta.setText(null);
                respuesta_tiempo.setText(null);

                respuesta_montecarlo.setBounds(20, 110, 300, 20);
                respuesta_montecarlo.setFont(fuente);

                pi = lebniz.calcular_pi();

                respuesta_lebniz.setForeground(Color.YELLOW);
                respuesta_lebniz.setText("" + pi);

                pi = montecarlo.calcular_pi();

                respuesta_montecarlo.setForeground(Color.GREEN);
                respuesta_montecarlo.setText("" + pi);

                pi = borwein.calcular_pi();

                respuesta_borwein.setForeground(Color.CYAN);
                respuesta_borwein.setText("" + pi);

            }

            if (e.getSource() == btn_comparar) {
                respuesta_montecarlo.setForeground(Color.BLACK);
                respuesta_montecarlo.setFont(null);
                respuesta_montecarlo.setBounds(20, 120, 300, 20);

                respuesta_montecarlo.setText("Diferencia con el valor real:");
                respuesta_borwein.setForeground(Color.MAGENTA);
                respuesta_borwein.setText("" + (pi - Math.PI));

                respuesta_tiempo.setForeground(Color.BLACK);
                respuesta_tiempo.setFont(null);
                respuesta_tiempo.setText("<html>Diferencia en tiempo con el metodo anterior usado:<p><html>" + (diferenciaTiempo) / 1e6 + " ms");
            }
        };
        btn_lebniz.addActionListener(oir);
        btn_montecarlo.addActionListener(oir);
        btn_borwein.addActionListener(oir);
        btn_todos.addActionListener(oir);
        btn_comparar.addActionListener(oir);

    }
}
