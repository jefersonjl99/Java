/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadoblementeenlazada;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Jeferson Jimenez
 */
public class SumaDeNumerosGrandes extends JFrame implements KeyListener {

    private final ImagenFondo imagenFondo = new ImagenFondo();
    public static JTextField field_ingreso;
    public static JTextField field_ingreso1;
    private static JLabel label_entrada;
    private static JLabel label_salida;
    private static JPanel panel_entrada;
    private static Border borde_0;

    private static final Color COLOR_0 = new Color(51, 51, 55);
    private static final Color COLOR_1 = new Color(1, 153, 194);
    private static final Color COLOR_BORDES = new Color(54, 155, 140);
    private static final Font FUENTE_0 = new Font("Arial", Font.BOLD, 16);

    public static final int ANCHO = 800, ALTO = 500;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SumaDeNumerosGrandes listaDoblementeEnlazada = new SumaDeNumerosGrandes();
        listaDoblementeEnlazada.setVisible(true);
    }

    public SumaDeNumerosGrandes() {
        setTitle("Lista Doble");
        setIconImage(new ImageIcon(SumaDeNumerosGrandes.class.getResource("/imagenes/736663fe6f9e03fcb39ace9020c42b4c-icono-estacionario-de-la-calculadora-by-vexels.png")).getImage());
        setUndecorated(true);
        setLayout(null);
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(imagenFondo);
        requestFocus();
        getRootPane().setBorder(BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE));
        getContentPane().setLayout(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panel_entrada = new JPanel();
        field_ingreso = new JTextField("123456787435647887643274623874628736473267426789101112");
        field_ingreso1 = new JTextField("12345673576756476576437657436583465764375634654836534589");
        label_entrada = new JLabel("Ingrese los dos numeros a operar:");
        label_salida = new JLabel("Aqui se mostrara la respuesta");
        panel_entrada.setBounds(50, 50, ANCHO - 100, ALTO - 130);
        panel_entrada.setLayout(null);
        borde_0 = BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE);
        panel_entrada.setBorder(borde_0);
        panel_entrada.setBackground(COLOR_0);

        field_ingreso.setBounds(100, 100, 500, 20);
        field_ingreso.setBackground(COLOR_1);
        field_ingreso.setForeground(Color.BLACK);
        field_ingreso.setBorder(borde_0);
        field_ingreso.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        field_ingreso.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                Object o = e.getSource();
                if (o instanceof JTextField) {
                    JTextField field_in_num_monedas = (JTextField) o;
                    field_in_num_monedas.setSelectionStart(0);
                    field_in_num_monedas.setSelectionEnd(field_in_num_monedas.getText().length());
                    field_in_num_monedas.setBackground(Color.BLACK);
                    field_in_num_monedas.setForeground(COLOR_1);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                Object o = e.getSource();
                if (o instanceof JTextField) {
                    JTextField field_in_num_monedas = (JTextField) o;
                    field_in_num_monedas.setBackground(COLOR_1);
                    field_in_num_monedas.setForeground(Color.BLACK);
                }
            }
        });
        field_ingreso.addKeyListener(this);

        field_ingreso1.setBounds(100, 120, 500, 20);
        field_ingreso1.setBackground(COLOR_1);
        field_ingreso1.setForeground(Color.BLACK);
        field_ingreso1.setBorder(borde_0);
        field_ingreso1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        field_ingreso1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                Object o = e.getSource();
                if (o instanceof JTextField) {
                    JTextField field_in_num_monedas = (JTextField) o;
                    field_in_num_monedas.setSelectionStart(0);
                    field_in_num_monedas.setSelectionEnd(field_in_num_monedas.getText().length());
                    field_in_num_monedas.setBackground(Color.BLACK);
                    field_in_num_monedas.setForeground(COLOR_1);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                Object o = e.getSource();
                if (o instanceof JTextField) {
                    JTextField field_in_num_monedas = (JTextField) o;
                    field_in_num_monedas.setBackground(COLOR_1);
                    field_in_num_monedas.setForeground(Color.BLACK);
                }
            }
        });
        field_ingreso1.addKeyListener(this);

        label_entrada.setBounds(100, 60, 300, 20);
        label_entrada.setForeground(COLOR_1);
        label_entrada.setFont(FUENTE_0);
        label_salida.setBounds(100, 140, 600, 200);
        label_salida.setForeground(COLOR_1);
        label_salida.setFont(FUENTE_0);
        panel_entrada.add(field_ingreso);
        panel_entrada.add(field_ingreso1);
        panel_entrada.add(label_entrada);
        panel_entrada.add(label_salida);
        field_ingreso.requestFocus();
        add(panel_entrada);
    }

    private void generar() {
        Suma suma = new Suma();
        suma.sumar(field_ingreso, field_ingreso1, label_salida);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == field_ingreso) {
            if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                field_ingreso1.requestFocus();
            }
            if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
                System.exit(0);
            }
        }
        if (e.getSource() == field_ingreso1) {
            if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                generar();
            }
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
}
