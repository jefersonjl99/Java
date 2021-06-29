package grados;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Grados extends JFrame {

    JRadioButton b1 = new JRadioButton("Farenheit");
    JRadioButton b2 = new JRadioButton("Kelvin");
    JTextField texto = new JTextField("0");
    JLabel lb = new JLabel();
    Font letra = new Font("Arial", Font.ITALIC, 12);
    ButtonGroup grupo = new ButtonGroup();
    Color fondo;

    public static void main(String[] args) {
        Grados marco = new Grados();
        marco.setSize(500, 500);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    Grados() {
        super("Calcular grados");
        fondo = getBackground();
        Container c = getContentPane();
        c.setLayout(null);
        c.add(b1);
        c.add(b2);
        c.add(lb);
        c.add(texto);
        grupo.add(b1);
        grupo.add(b2);

        b1.setBounds(80, 10, 80, 40);
        b2.setBounds(170, 10, 80, 40);
        texto.setBounds(260, 20, 40, 20);
        lb.setBounds(80, 40, 200, 40);
        ActionListener oyente = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    Graphics g;
                    g = getGraphics();
                    g.setFont(letra);
                    g.setColor(new Color(0xFF, 0x7F, 0x50));
                    double n, resultado;
                    String s;
                    s = texto.getText();
                    n = Integer.parseInt(s);
                    resultado = (double) ((n * 1.8) + 32);
                    lb.setFont(letra);
                    lb.setText("Resultado en Farenheit es :" + resultado + "F");

                }
                if (e.getSource() == b2) {
                    Graphics g;
                    g = getGraphics();
                    g.setFont(letra);
                    g.setColor(new Color(0xFF, 0x7F, 0x50));
                    double n, resultado;
                    String s;
                    s = texto.getText();
                    n = Integer.parseInt(s);
                    resultado = (double) ((n + 273.15));
                    lb.setFont(letra);
                    lb.setText("Resultado en Kelvin es :" + resultado + "K");

                }

            }
        };
        b1.addActionListener(oyente);
        ;
        b2.addActionListener(oyente);

    }
}
