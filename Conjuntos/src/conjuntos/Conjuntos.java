/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

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
import javax.swing.JOptionPane;

/**
 *
 * @author jefer
 */
public class Conjuntos extends JFrame {

    int n_a, n_b, n_r;
    String rta = "";

    //long tiempoLebniz, tiempoMontecarlo, tiempoBorwein;
    Interseccion interseccion = new Interseccion();
    Union union = new Union();
    Diferencia diferencia = new Diferencia();

    Color color = new Color(50, 93, 127);

    Font fuente = new Font("TimesRoman", Font.BOLD, 25);

    JButton btn_interseccion = new JButton("Interseccion");
    JButton btn_union = new JButton("Union");
    JButton btn_diferencia = new JButton("Diferencia");

    JLabel texto = new JLabel("Digite segun la operacion a usar: ");

    JLabel respuesta_A = new JLabel("");
    JLabel respuesta_B = new JLabel("");
    JLabel respuesta = new JLabel("");

    JLabel imagen = new JLabel();

    public static void main(String[] args) {
        Conjuntos obj = new Conjuntos();
        obj.setSize(500, 230);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);

    }

    public Conjuntos() {

        super("Operaciones entre Conjuntos");
        Container p = getContentPane();
        p.setLayout(null);
        p.setBackground(color);

        setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Conjuntos\\src\\imagenes\\fb-sets.png").getImage());

        p.add(texto);
        p.add(btn_interseccion);
        p.add(btn_union);
        p.add(btn_diferencia);
        p.add(imagen);
        p.add(respuesta_A);
        p.add(respuesta_B);
        p.add(respuesta);

        texto.setBounds(20, 10, 200, 20);
        btn_interseccion.setBounds(20, 40, 120, 20);
        btn_union.setBounds(140, 40, 100, 20);
        btn_diferencia.setBounds(240, 40, 100, 20);
        respuesta_A.setBounds(20, 80, 300, 20);
        respuesta_B.setBounds(20, 110, 300, 20);
        respuesta.setBounds(20, 140, 300, 20);

        texto.setForeground(Color.BLACK);

        respuesta.setFont(fuente);

        btn_interseccion.setBackground(Color.YELLOW);
        btn_union.setBackground(Color.GREEN);
        btn_diferencia.setBackground(Color.CYAN);

        imagen.setBounds(360, 20, 100, 100);
        ImageIcon imag = new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Conjuntos\\src\\imagenes\\fb-sets.png");
        Icon icon = new ImageIcon(imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icon);

        btn_interseccion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_union.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_diferencia.setCursor(new Cursor(Cursor.HAND_CURSOR));

        n_a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del conjunto A:"));
        JOptionPane.showMessageDialog(null, "Tamaño de A = " + n_a);

        n_b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del conjunto B:"));
        JOptionPane.showMessageDialog(null, "Tamaño de B = " + n_b);

        int[] a = new int[n_a];
        int[] b = new int[n_b];
        int[] r = new int[n_a + n_b];

        for (int i = 0; i < n_a; i++) {
            a[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento de el conjunto A en la posicion " + (i + 1)));
            if (i < n_b - 1 && n_a > 1) {
                rta += (" " + a[i] + ",");
            } else {
                rta += (" " + a[i]);
            }
        }
        respuesta_A.setText("Conjunto A: [" + rta + "]");
        rta = "";

        for (int i = 0; i < n_b; i++) {
            b[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el elemento de el conjunto B en la posicion " + (i + 1)));
            if (i < n_b - 1 && n_b > 1) {
                rta += (" " + b[i] + ",");
            } else {
                rta += (" " + b[i]);
            }
        }
        respuesta_B.setText("Conjunto B: [" + rta + "]");
        rta = "";

        ActionListener oir = (ActionEvent e) -> {

            if (e.getSource() == btn_interseccion) {
                rta = "";
                n_r = interseccion.calcular(a, b, r, n_a, n_b);
                for (int i = 0; i < n_r; i++) {
                    rta += (" " + r[i]);
                }
                respuesta.setForeground(Color.YELLOW);
                respuesta.setText(rta);
            }

            if (e.getSource() == btn_union) {
                rta = "";
                n_r = union.calcular(a, b, r, n_a, n_b);
                for (int i = 0; i < n_r; i++) {
                    rta += (" " + r[i]);
                }
                respuesta.setForeground(Color.GREEN);
                respuesta.setText(rta);
            }

            if (e.getSource() == btn_diferencia) {
                rta = "";
                n_r = diferencia.calcular(a, b, r, n_a, n_b);
                for (int i = 0; i < n_r; i++) {
                    rta += (" " + r[i]);
                }
                respuesta.setForeground(Color.CYAN);
                respuesta.setText(rta);
            }

        };
        btn_interseccion.addActionListener(oir);
        btn_union.addActionListener(oir);
        btn_diferencia.addActionListener(oir);

    }
}
