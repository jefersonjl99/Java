/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebastack;

/**
 *
 * @author Jeferson Jimenez
 */
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Pila extends JFrame implements KeyListener {

    ImagenFondo imagenFondo = new ImagenFondo();
    JTextField ingreso;
    JLabel salida;
    JPanel panel0;
    Border borde;

    Color color = new Color(51, 51, 55);
    Color color1 = new Color(1, 153, 194);
    Color color_bordes = new Color(54, 155, 140);

    public static final int ANCHO = 800, ALTO = 600;
    private boolean z, ctrl, enter = false;
    private Set<Integer> pressed = new HashSet<>();
    private Stack<String> pila = new Stack<>();
    //private Stack<String> pila1 = new Stack<>();

    public static void main(String[] args) {
        Pila pruebaStack = new Pila();
        pruebaStack.setVisible(true);
    }

    public Pila() {
        setTitle("PILAS");
        setLayout(null);
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(imagenFondo);
        setFocusable(true);
        getRootPane().setBorder(BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE));
        getContentPane().setLayout(null);
        iniciarComponentes();
        generar();
    }

    private void iniciarComponentes() {
        panel0 = new JPanel();
        panel0.setBounds(50, 50, ANCHO - 100, ALTO - 130);
        panel0.setLayout(null);
        borde = BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE);
        panel0.setBorder(borde);
        panel0.setBackground(color);

        ingreso = new JTextField("Ingresar aqui una buena frase");
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
        salida.setText(ingreso.getText());
        salida.setBounds(100, 120, 200, 20);
        salida.setForeground(color1);
        panel0.add(ingreso);
        panel0.add(salida);
        ingreso.addKeyListener(this);
        add(panel0);
    }

    private void generar() {
        String s;
        if (enter) {
            s = ingreso.getText();
            pila.push(s);
            salida.setText(ingreso.getText());
            imprimirPila(pila);
        }
        if (ctrl && z) {
            if (pila.empty()) {
                salida.setText("");
                ingreso.setText("");
            } else {
                salida.setText(pila.get(pila.size() - 1));
                ingreso.setText(pila.get(pila.size() - 1));
                pila.pop();
            }
            imprimirPila(pila);
        }
        z = false;
        ctrl = false;
        enter = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == ingreso) {
            if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
                z = true;
                ctrl = true;
                generar();
            }
            if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                enter = true;
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

    private void imprimirPila(Stack<String> pila) {
        if (pila.empty()) {
            System.out.print("la pila esta vacia\n\n");
        } else {
            System.out.print("la pila contiene: ");
            for (String numero : pila) {
                System.out.printf("%s ", numero);
            }
            System.out.print("(final) \n\n");
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
}
