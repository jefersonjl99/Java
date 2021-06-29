/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraposfija;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Jeferson Jimenez
 */
public class CalculadoraPosfija extends JFrame implements KeyListener {

    ImagenFondo imagenFondo = new ImagenFondo();
    JTextField ingreso;
    public static JLabel salida;
    JPanel panel0;
    Border borde;

    Font fuente = new Font("Arial", Font.BOLD, 16);
    Color color = new Color(51, 51, 55);
    Color color1 = new Color(1, 153, 194);
    Color color_bordes = new Color(54, 155, 140);

    private boolean enter = false;

    public static final int ANCHO = 500, ALTO = 400;

    public static void main(String[] args) {
        CalculadoraPosfija calculadoraPosfija = new CalculadoraPosfija();
        calculadoraPosfija.setVisible(true);
    }

    public CalculadoraPosfija() {
        setTitle("PILAS");
        setLayout(null);
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(imagenFondo);
        setFocusable(true);
        getRootPane().setBorder(BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE));
        getContentPane().setLayout(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panel0 = new JPanel();
        panel0.setBounds(50, 50, ANCHO - 100, ALTO - 100);
        panel0.setLayout(null);
        borde = BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE);
        panel0.setBorder(borde);
        panel0.setBackground(color);
        panel0.requestFocus(true);

        ingreso = new JTextField("((2^3)-1)/2*3");
        salida = new JLabel();
        ingreso.setBounds(100, 100, 200, 20);
        ingreso.setBackground(color1);
        ingreso.setForeground(Color.BLACK);
        ingreso.setBorder(borde);
        ingreso.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                Object o = e.getSource();
                if (o instanceof JTextField) {
                    JTextField field_in_num_monedas = (JTextField) o;
                    field_in_num_monedas.setSelectionStart(0);
                    field_in_num_monedas.setSelectionEnd(field_in_num_monedas.getText().length());
                    field_in_num_monedas.setBackground(Color.BLACK);
                    field_in_num_monedas.setForeground(color1);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                Object o = e.getSource();
                if (o instanceof JTextField) {
                    JTextField field_in_num_monedas = (JTextField) o;
                    field_in_num_monedas.setBackground(color1);
                    field_in_num_monedas.setForeground(Color.BLACK);
                }
            }
        });
        salida.setText("Aqui se mostrara la funcion posfija");
        salida.setBounds(100, 120, 300, 40);
        salida.setFont(fuente);
        salida.setForeground(color1);
        panel0.add(ingreso);
        panel0.add(salida);
        ingreso.addKeyListener(this);
        panel0.addKeyListener(this);
        add(panel0);
    }

    private void iniciar() {
        Convertidor parseador = new Convertidor();
        String entrada = ingreso.getText();
        String s = parseador.convertir(entrada);
        //System.out.println(entrada);
        double b = parseador.resolver(s, 0);
        //System.out.println(s);
        if (b >= 0 || b < 0&&b!=Double.POSITIVE_INFINITY&&b!=Double.NEGATIVE_INFINITY) {
            salida.setText("<html>Posfijo: " + s + "<p>Resultado: " + b + "</html>");
        } else {
            salida.setText("<html>Posfijo: " + s + "<p>Resultado:Error en la expresion</html>");
        }
        //System.out.println(b);
        enter = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == ingreso) {
            if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                enter = true;
                iniciar();
            }
            if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
                System.exit(0);
            }
        }
        if (e.getSource() == panel0) {
            if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
                System.exit(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
////////////////////////////////////////////////////////
////////////Cambia el fondo//////////////////
//////////////////////////////////////////////////////

class ImagenFondo extends JPanel {

    private Image imagen;

    @Override
    public void paint(Graphics g) {
        try {
            imagen = ImageIO.read(ImagenFondo.class.getResource("/imagenes/kod-dvoichnyi-kod-nuli-edinitsy-programmirovanie-binarnyi.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(ImagenFondo.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        setOpaque(false);
        super.paint(g);
    }

}
///////////////////////////////////////////////////////////////////////
////////////////////////////////////////
//&& e.getKeyChar() != 'z' 
