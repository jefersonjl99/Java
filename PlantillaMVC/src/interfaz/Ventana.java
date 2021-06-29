/*
 * Copyright <2021> <JEFERSON JIMENEZ>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining 
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package interfaz;

/**
 *
 * @author Jeferson Jimenez
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author ssrs_
 */
public class Ventana extends JFrame {

    private static final ImagenFondo IMAGEN_FONDO = new ImagenFondo();
    public static final int ANCHO = 800, ALTO = 600;

    private boolean es_suma, es_multiplicacion;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final Color COLOR = new Color(51, 51, 55);
    private static final Color COLOR1 = new Color(1, 153, 194);

    private static final Font FUENTE = new Font("TimesRoman", Font.BOLD, 18);

    private static final Border BORDE = BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE);

    private static JPanel panel_datos;
    private static JPanel panel_lista_innorden;
    private static JPanel panel_dibujo_arbol;

    private final JScrollPane scroll_lista_innorden = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private final JScrollPane scroll_dibujo_arbol = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private JLabel label_tam_matriz;
    private JLabel label_dimensiones;
    private JLabel label_nombre_matriz;

    private JLabel[][] label_salida_final;
    private JLabel[] label_salida_final_apunt;

    private final JTextField[] field_tam_matriz_a = new JTextField[2];
    private final JTextField[] field_tam_matriz_b = new JTextField[2];
    private final JTextField[] field_codigo = new JTextField[1];

    private final JButton boton_procesar = new JButton();

    private final JButton[] botones_operacion = new JButton[3];
    private final JButton[] botones_matrices = new JButton[2];

    public Ventana() {

        personalizar_ventana();
        iniciar_componentes();

    }

    private void personalizar_ventana() {
        setTitle("Matrices Dispersas");
        setIconImage(new ImageIcon(Ventana.class.getResource("/recursos/imagenes/icono.png")).getImage());
        setUndecorated(true);
        setLayout(null);
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(IMAGEN_FONDO);
        requestFocus();
        getRootPane().setBorder(BORDE);
        getContentPane().setLayout(null);
    }

    private void iniciar_componentes() {
        iniciar_paneles();
        iniciar_botones();
        iniciar_etiquetas();
        iniciar_campos_texto();

        panel_datos = new JPanel();
        panel_datos.setBackground(COLOR);
        panel_datos.setForeground(COLOR1);
        panel_datos.setBounds(5, 5, ANCHO - 15, 90);
        panel_datos.setBorder(BORDE);
        panel_datos.setLayout(null);
        panel_datos.requestFocus();

        label_tam_matriz = new JLabel("Ingrese el codigo y digite segun accion a realizar:");
        label_tam_matriz.setBounds(5, 5, 300, 15);
        label_tam_matriz.setForeground(COLOR1);

        panel_datos.add(label_tam_matriz);

        for (int i = 0; i < botones_operacion.length; i++) {

            switch (i) {
                case 0:
                    botones_operacion[i] = new JButton("Agregar");
                    break;
                case 1:
                    botones_operacion[i] = new JButton("Retirar");
                    break;
                default:
                    botones_operacion[i] = new JButton("Buscar");
                    break;
            }

            botones_operacion[i].setBounds(panel_datos.getWidth() / 2 - 50, -15 + ((i + 1) * 25), 100, 20);
            botones_operacion[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            botones_operacion[i].setForeground(COLOR1);
            botones_operacion[i].setBackground(COLOR);
            botones_operacion[i].setBorder(BORDE);
//            botones_operacion[i].requestFocus();
            botones_operacion[i].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    Object o = e.getSource();
                    if (o instanceof JButton) {
                        JButton boton = (JButton) o;

                        boton.setBackground((COLOR1));
                        boton.setForeground((COLOR));
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    Object o = e.getSource();
                    if (o instanceof JButton) {
                        JButton boton = (JButton) o;

                        boton.setBackground((COLOR));
                        boton.setForeground((COLOR1));
                    }
                }
            });
            botones_operacion[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent arg0) {
                    Object o = arg0.getSource();
                    if (o instanceof JButton) {
                        JButton boton = (JButton) o;

                        boton.setBackground((COLOR1));
                        boton.setForeground((COLOR));
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    Object o = e.getSource();
                    if (o instanceof JButton) {
                        JButton boton = (JButton) o;
                        boton.setBackground((COLOR));
                        boton.setForeground((COLOR1));
                    }
                }
            });

            panel_datos.add(botones_operacion[i]);
        }

        for (int i = 0; i < field_codigo.length; i++) {

            field_codigo[i] = new JTextField("" + (i + 1));

            field_codigo[i].setBounds(-80 + ((i + 1) * 110), 40, 100, 20);
            field_codigo[i].setBackground(COLOR1);
            field_codigo[i].setForeground(Color.BLACK);
            field_codigo[i].setBorder(BORDE);
//            field_codigo[i].requestFocus();
            field_codigo[i].addKeyListener(new KeyListener() {
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

                @Override
                public void keyPressed(KeyEvent e) {
                    if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                        botones_operacion[0].doClick();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });
            field_codigo[i].addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    Object o = e.getSource();
                    if (o instanceof JTextField) {
                        JTextField field_in_num_monedas = (JTextField) o;
                        field_in_num_monedas.setSelectionStart(0);
                        field_in_num_monedas.setSelectionEnd(field_in_num_monedas.getText().length());
                        field_in_num_monedas.setBackground(Color.BLACK);
                        field_in_num_monedas.setForeground(COLOR1);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    Object o = e.getSource();
                    if (o instanceof JTextField) {
                        JTextField field_in_num_monedas = (JTextField) o;
                        field_in_num_monedas.setBackground(COLOR1);
                        field_in_num_monedas.setForeground(Color.BLACK);
                    }
                }
            });

            panel_datos.add(field_codigo[i]);
            panel_datos.setComponentZOrder(field_codigo[i], 0);
        }

        scroll_lista_innorden.setBounds(5, 100, 200, 410);
        scroll_lista_innorden.setVisible(false);
        scroll_lista_innorden.setBorder(BORDE);
        scroll_lista_innorden.getHorizontalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_lista_innorden.getHorizontalScrollBar().setBackground(Color.BLACK);
        scroll_lista_innorden.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_lista_innorden.getVerticalScrollBar().setBackground(Color.BLACK);

        panel_lista_innorden = new JPanel();
        panel_lista_innorden.setBackground(COLOR);
        panel_lista_innorden.setForeground(COLOR1);
        panel_lista_innorden.setBounds(5, 100, 200, ALTO - 110);
        panel_lista_innorden.setBorder(BORDE);
        panel_lista_innorden.setLayout(null);
//        panel_lista_innorden.requestFocus();

        panel_dibujo_arbol = new JPanel();
        panel_dibujo_arbol.setBackground(COLOR);
        panel_dibujo_arbol.setForeground(COLOR1);
        panel_dibujo_arbol.setBounds(210, 100, ANCHO - 220, ALTO - 110);
        panel_dibujo_arbol.setVisible(false);
        panel_dibujo_arbol.setBorder(BORDE);
        panel_dibujo_arbol.setLayout(null);
//        panel_dibujo_arbol.requestFocus();

        scroll_dibujo_arbol.setBounds(210, 100, ANCHO - 220, ALTO - 110);
        scroll_dibujo_arbol.setVisible(false);
        scroll_dibujo_arbol.setBorder(BORDE);
        scroll_dibujo_arbol.getHorizontalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_dibujo_arbol.getHorizontalScrollBar().setBackground(Color.BLACK);
        scroll_dibujo_arbol.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_dibujo_arbol.getVerticalScrollBar().setBackground(Color.BLACK);

        add(panel_datos);
        add(panel_lista_innorden);
        add(scroll_dibujo_arbol);
        panel_datos.requestFocus();
        field_codigo[0].requestFocus();

    }
    
    

    private void iniciar_paneles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void iniciar_botones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void iniciar_etiquetas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void iniciar_campos_texto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            imagen = ImageIO.read(ImagenFondo.class.getResource("/recursos/imagenes/kod-dvoichnyi-kod-nuli-edinitsy-programmirovanie-binarnyi.jpg"));
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
