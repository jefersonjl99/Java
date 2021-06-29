/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizdispersa;

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
 * @author Jeferson Jimenez
 */
public class Ventana extends JFrame implements ActionListener, KeyListener {

    private static final ImagenFondo IMAGEN_FONDO = new ImagenFondo();
    public static final int ANCHO = 720, ALTO = 520;

    private boolean es_suma, es_multiplicacion;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final Color COLOR = new Color(51, 51, 55);
    private static final Color COLOR1 = new Color(1, 153, 194);

    private static final Font FUENTE = new Font("TimesRoman", Font.BOLD, 18);

    private static final Border BORDE = BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE);

    private static JPanel panel_tam_matricez;
    private static JPanel panel_dimensiones;

    private final JScrollPane scroll_matriz_a = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private final JScrollPane scroll_matriz_b = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private final JScrollPane scroll_matriz_result = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private JLabel label_tam_matriz;
    private JLabel label_dimensiones;
    private JLabel label_nombre_matriz;

    private JLabel[][] label_salida_final;
    private JLabel[] label_salida_final_apunt;

    private final JTextField[] field_tam_matriz_a = new JTextField[2];
    private final JTextField[] field_tam_matriz_b = new JTextField[2];
    private final JTextField[] field_dimensiones = new JTextField[3];

    private final JButton boton_procesar = new JButton();

    private final JButton[] botones_operacion = new JButton[2];
    private final JButton[] botones_accion = new JButton[2];
    private final JButton[] botones_matrices = new JButton[2];

    private final Matriz matriz_a = new Matriz("A");
    private final Matriz matriz_b = new Matriz("B");
    private Matriz matriz_resultado = new Matriz();

    private Suma suma;
    private Multiplicacion multiplicacion;

    public Ventana() {

        setTitle("Matrices Dispersas");
        setIconImage(new ImageIcon(Ventana.class.getResource("/imagenes/icono.png")).getImage());
        setUndecorated(true);
        setLayout(null);
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(IMAGEN_FONDO);
        requestFocus();
        addKeyListener(this);
        getRootPane().setBorder(BORDE);
        getContentPane().setLayout(null);

        iniciarComponentes();

    }

    private void iniciarComponentes() {

        panel_tam_matricez = new JPanel();
        panel_tam_matricez.setBackground(COLOR);
        panel_tam_matricez.setForeground(COLOR1);
        panel_tam_matricez.setBounds(5, 5, 200, 90);
        panel_tam_matricez.setBorder(BORDE);
        panel_tam_matricez.setLayout(null);
        panel_tam_matricez.requestFocus();
        panel_tam_matricez.addKeyListener(this);

        for (int i = 0; i < botones_operacion.length; i++) {

            if (i == 0) {
                botones_operacion[i] = new JButton("Suma");
            } else {
                botones_operacion[i] = new JButton("Multiplicacion");
            }
            botones_operacion[i].setBounds(panel_tam_matricez.getWidth() / 2 - 50, ((i + 1) * 25), 100, 20);
            botones_operacion[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            botones_operacion[i].setForeground(COLOR1);
            botones_operacion[i].setBackground(COLOR);
            botones_operacion[i].setBorder(BORDE);
            botones_operacion[i].addActionListener(this);
            botones_operacion[i].addKeyListener(this);
            botones_operacion[i].requestFocus();
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

            panel_tam_matricez.add(botones_operacion[i]);
        }
        label_tam_matriz = new JLabel("Digite segun operacion a realizar:");
        label_tam_matriz.setBounds(5, 5, 200, 15);
        label_tam_matriz.setForeground(COLOR1);

        panel_tam_matricez.add(label_tam_matriz);

        panel_dimensiones = new JPanel();
        panel_dimensiones.setBounds(210, 5, 500, 90);
        panel_dimensiones.setBackground(COLOR);
        panel_dimensiones.setForeground(COLOR1);
        panel_dimensiones.setBorder(BORDE);
        panel_dimensiones.setLayout(null);
        panel_dimensiones.requestFocus();
        panel_dimensiones.addKeyListener(this);
        panel_dimensiones.setVisible(false);

        boton_procesar.setBounds(5, 65, 100, 20);
        boton_procesar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_procesar.setForeground(COLOR1);
        boton_procesar.setBackground(COLOR);
        boton_procesar.setBorder(BORDE);
        boton_procesar.addActionListener(this);
        boton_procesar.addKeyListener(this);
        boton_procesar.addFocusListener(new FocusListener() {
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
        boton_procesar.addMouseListener(new MouseAdapter() {
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

        scroll_matriz_a.setBounds(5, 100, 350, 200);
        scroll_matriz_a.setVisible(false);
        scroll_matriz_a.setBorder(BORDE);
        scroll_matriz_a.getHorizontalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_matriz_a.getHorizontalScrollBar().setBackground(Color.BLACK);
        scroll_matriz_a.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_matriz_a.getVerticalScrollBar().setBackground(Color.BLACK);

        scroll_matriz_b.setBounds(360, 100, 350, 200);
        scroll_matriz_b.setVisible(false);
        scroll_matriz_b.setBorder(BORDE);
        scroll_matriz_b.getHorizontalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_matriz_b.getHorizontalScrollBar().setBackground(Color.BLACK);
        scroll_matriz_b.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_matriz_b.getVerticalScrollBar().setBackground(Color.BLACK);

        scroll_matriz_result.setBounds(5, 305, 705, 205);
        scroll_matriz_result.setVisible(false);
        scroll_matriz_result.setBorder(BORDE);
        scroll_matriz_result.getHorizontalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_matriz_result.getHorizontalScrollBar().setBackground(Color.BLACK);
        scroll_matriz_result.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_matriz_result.getVerticalScrollBar().setBackground(Color.BLACK);

        add(panel_dimensiones);
        add(panel_tam_matricez);
        add(scroll_matriz_a);
        add(scroll_matriz_b);
        add(scroll_matriz_result);
    }

////////////////////////////////////////////ACTION LISTENER///////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {

        /////////////////////////////BOTON SUMA//////////////////////////
        if (e.getSource() == botones_operacion[0]) {

            panel_tam_matricez.removeAll();
            es_suma = true;
            es_multiplicacion = false;

            label_tam_matriz.setBounds(5, 5, 200, 45);
            label_tam_matriz.setText("<html>Tamaño de las matrices: <p><p> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; F &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; x C<html>");
            panel_tam_matricez.add(label_tam_matriz);

            for (int i = 0; i < field_tam_matriz_a.length; i++) {

                field_tam_matriz_a[i] = new JTextField("" + (i + 1));

                field_tam_matriz_a[i].setBounds(-30 + ((i + 1) * 70), 30, 50, 20);
                field_tam_matriz_a[i].setBackground(COLOR1);
                field_tam_matriz_a[i].setForeground(Color.BLACK);
                field_tam_matriz_a[i].setBorder(BORDE);
                field_tam_matriz_a[i].addKeyListener(this);
                field_tam_matriz_a[i].addKeyListener(new KeyListener() {
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
                            botones_accion[0].doClick();
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
                field_tam_matriz_a[i].addFocusListener(new FocusListener() {
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

                panel_tam_matricez.add(field_tam_matriz_a[i]);
                panel_tam_matricez.setComponentZOrder(field_tam_matriz_a[i], 0);
            }

            for (int i = 0; i < botones_accion.length; i++) {

                if (i == 0) {
                    botones_accion[i] = new JButton("Sumar");
                } else {
                    botones_accion[i] = new JButton("Regresar");
                }
                botones_accion[i].setBounds(-90 + ((i + 1) * 100), 65, 80, 20);
                botones_accion[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                botones_accion[i].setForeground(COLOR1);
                botones_accion[i].setBackground(COLOR);
                botones_accion[i].setBorder(BORDE);
                botones_accion[i].addActionListener(this);
                botones_accion[i].addKeyListener(this);
                botones_accion[i].addFocusListener(new FocusListener() {
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
                botones_accion[i].addMouseListener(new MouseAdapter() {
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

                panel_tam_matricez.add(botones_accion[i]);
            }

            field_tam_matriz_a[0].requestFocus();
            panel_tam_matricez.repaint();

        }/////////////////////////////BOTON SUMA//////////////////////////

        /////////////////////////////BOTON MULTIPLICACION//////////////////////////
        if (e.getSource() == botones_operacion[1]) {

            panel_tam_matricez.removeAll();

            es_suma = false;
            es_multiplicacion = true;

            label_tam_matriz.setBounds(5, 5, 200, 45);
            label_tam_matriz.setText("<html>Tamaño de las matrices: "
                    + "<p> &nbsp;&nbsp; A: F &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; x C "
                    + "<p> &nbsp;&nbsp; B: F &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; x C </html>");
            panel_tam_matricez.add(label_tam_matriz);

            for (int i = 0; i < field_tam_matriz_a.length; i++) {

                field_tam_matriz_a[i] = new JTextField("" + (i + 1));
                field_tam_matriz_b[i] = new JTextField("" + (i + 2));

                field_tam_matriz_a[i].setBounds(-30 + ((i + 1) * 70), 17, 50, 18);
                field_tam_matriz_a[i].setBackground(COLOR1);
                field_tam_matriz_a[i].setForeground(Color.BLACK);
                field_tam_matriz_a[i].setBorder(BORDE);
                field_tam_matriz_a[i].addKeyListener(this);
                field_tam_matriz_a[i].addKeyListener(new KeyListener() {
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
                            botones_accion[0].doClick();
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
                field_tam_matriz_a[i].addFocusListener(new FocusListener() {
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

                field_tam_matriz_b[i].setBounds(-30 + ((i + 1) * 70), 35, 50, 18);
                field_tam_matriz_b[i].setBackground(COLOR1);
                field_tam_matriz_b[i].setForeground(Color.BLACK);
                field_tam_matriz_b[i].setBorder(BORDE);
                field_tam_matriz_b[i].addKeyListener(this);
                field_tam_matriz_b[i].addKeyListener(new KeyListener() {
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
                            botones_accion[0].doClick();
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
                field_tam_matriz_b[i].addFocusListener(new FocusListener() {
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

                panel_tam_matricez.add(field_tam_matriz_a[i]);
                panel_tam_matricez.add(field_tam_matriz_b[i]);
                panel_tam_matricez.setComponentZOrder(field_tam_matriz_a[i], 0);
                panel_tam_matricez.setComponentZOrder(field_tam_matriz_b[i], 0);

            }

            for (int i = 0; i < botones_accion.length; i++) {

                if (i == 0) {
                    botones_accion[i] = new JButton("Multiplicar");
                } else {
                    botones_accion[i] = new JButton("Regresar");
                }
                botones_accion[i].setBounds(-90 + ((i + 1) * 100), 65, 80, 20);
                botones_accion[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                botones_accion[i].setForeground(COLOR1);
                botones_accion[i].setBackground(COLOR);
                botones_accion[i].setBorder(BORDE);
                botones_accion[i].addActionListener(this);
                botones_accion[i].addKeyListener(this);
                botones_accion[i].addFocusListener(new FocusListener() {
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
                botones_accion[i].addMouseListener(new MouseAdapter() {
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

                panel_tam_matricez.add(botones_accion[i]);
            }

            field_tam_matriz_a[0].requestFocus();
            panel_tam_matricez.repaint();
//            update(this.getGraphics());

        }/////////////////////////////BOTON MULTIPLICACION//////////////////////////

        /////////////////////////////BOTON REGRESAR//////////////////////////
        if (e.getSource() == botones_accion[1]) {

            es_multiplicacion = false;
            es_suma = false;

            panel_tam_matricez.removeAll();
            label_tam_matriz.setBounds(5, 5, 200, 15);
            label_tam_matriz.setText("Digite segun operacion a realizar:");
            panel_tam_matricez.add(label_tam_matriz);
            panel_dimensiones.removeAll();
            panel_dimensiones.setVisible(false);
            scroll_matriz_a.setVisible(false);
            scroll_matriz_b.setVisible(false);
            scroll_matriz_result.setVisible(false);

            matriz_a.clear();
            matriz_b.clear();

            for (int i = 0; i < botones_operacion.length; i++) {

                if (i == 0) {
                    botones_operacion[i] = new JButton("Suma");
                } else {
                    botones_operacion[i] = new JButton("Multiplicacion");
                }

                botones_operacion[i].setBounds(panel_tam_matricez.getWidth() / 2 - 50, ((i + 1) * 25), 100, 20);
                botones_operacion[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                botones_operacion[i].setForeground(COLOR1);
                botones_operacion[i].setBackground(COLOR);
                botones_operacion[i].setBorder(BORDE);
                botones_operacion[i].addActionListener(this);
                botones_operacion[i].addKeyListener(this);
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

                panel_tam_matricez.add(botones_operacion[i]);
            }

            botones_operacion[0].requestFocus();
            panel_tam_matricez.repaint();

        }/////////////////////////////BOTON REGRESAR//////////////////////////

        /////////////////////////////BOTON SUMAR & MULTIPLICAR//////////////////////////
        if (e.getSource() == botones_accion[0]) {

            int error = 0;
            panel_dimensiones.removeAll();

            matriz_a.clear();
            mostrarMatriz(scroll_matriz_a, matriz_a);
            matriz_b.clear();
            mostrarMatriz(scroll_matriz_b, matriz_b);
            matriz_resultado.clear();
            mostrarMatriz(scroll_matriz_result, matriz_resultado);

            if ("Sumar".equals(e.getActionCommand())) {
                boton_procesar.setText("Sumar");
                matriz_a.setFilas(Integer.parseInt(field_tam_matriz_a[0].getText()));
                matriz_b.setFilas(Integer.parseInt(field_tam_matriz_a[0].getText()));
                matriz_a.setColumnas(Integer.parseInt(field_tam_matriz_a[1].getText()));
                matriz_b.setColumnas(Integer.parseInt(field_tam_matriz_a[1].getText()));
            }
            if ("Multiplicar".equals(e.getActionCommand())) {
                if (Integer.parseInt(field_tam_matriz_a[1].getText()) != Integer.parseInt(field_tam_matriz_b[0].getText())) {
                    error = 1;
                    JOptionPane.showMessageDialog(null, "El numero de columnas de A debe ser igual al numero de filas de B ");
                }
                boton_procesar.setText("Multiplicar");
                matriz_a.setFilas(Integer.parseInt(field_tam_matriz_a[0].getText()));
                matriz_a.setColumnas(Integer.parseInt(field_tam_matriz_a[1].getText()));
                matriz_b.setFilas(Integer.parseInt(field_tam_matriz_b[0].getText()));
                matriz_b.setColumnas(Integer.parseInt(field_tam_matriz_b[1].getText()));
            }
            panel_dimensiones.add(boton_procesar);
            if (error != 1) {

                label_dimensiones = new JLabel();
                panel_dimensiones.add(label_dimensiones);
                label_dimensiones.setBounds(5, 5, 400, 40);
                label_dimensiones.setForeground(COLOR1);
                label_dimensiones.setText("<html>Ingrese Datos:<p> Fila: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + " Columna: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "
                        + "Valor: </html>");

                for (int i = 0; i < field_dimensiones.length; i++) {

                    field_dimensiones[i] = new JTextField("" + (i + 1));

                    field_dimensiones[i].setBounds(-80 + ((i + 1) * 110), 25, 50, 20);
                    field_dimensiones[i].setBackground(COLOR1);
                    field_dimensiones[i].setForeground(Color.BLACK);
                    field_dimensiones[i].setBorder(BORDE);
                    field_dimensiones[i].addKeyListener(this);
                    field_dimensiones[i].addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            char caracter = e.getKeyChar();

                            // Verificar si la tecla pulsada no es un digito
                            if (((caracter < '0')
                                    || (caracter > '9'))
                                    && (caracter != '-' /*corresponde a BACK_SPACE*/)) {
                                e.consume();  // ignorar el evento de teclado
                            }
                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                            if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                                boton_procesar.doClick();
                            }
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                        }
                    });
                    field_dimensiones[i].addFocusListener(new FocusListener() {
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

                    panel_dimensiones.add(field_dimensiones[i]);
                    panel_dimensiones.setComponentZOrder(field_dimensiones[i], 0);
                }

                for (int i = 0; i < botones_matrices.length; i++) {

                    if (i == 0) {
                        botones_matrices[i] = new JButton("Agregar en A");
                    } else {
                        botones_matrices[i] = new JButton("Agregar en B");
                    }
                    botones_matrices[i].setBounds(305, (25 * (i + 1)), 100, 20);
                    botones_matrices[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                    botones_matrices[i].setForeground(COLOR1);
                    botones_matrices[i].setBackground(COLOR);
                    botones_matrices[i].setBorder(BORDE);
                    botones_matrices[i].addActionListener(this);
                    botones_matrices[i].addKeyListener(this);
                    botones_matrices[i].requestFocus();
                    botones_matrices[i].addFocusListener(new FocusListener() {
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
                    botones_matrices[i].addMouseListener(new MouseAdapter() {
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

                    panel_dimensiones.add(botones_matrices[i]);
//                    panel_dimensiones.add(botones_matriz_B[i]);
                }

                panel_dimensiones.setVisible(true);
                field_dimensiones[0].requestFocus();
            } else {
                panel_dimensiones.setVisible(false);
            }

        }/////////////////////////////BOTON SUMAR & MULTIPLICAR//////////////////////////

        /////////////////////////////BOTON AGREGAR EN A//////////////////////////
        if (e.getSource() == botones_matrices[0]) {

            if (Integer.parseInt(field_dimensiones[0].getText()) <= 0 || Integer.parseInt(field_dimensiones[0].getText()) > Integer.parseInt(field_tam_matriz_a[0].getText())) {

                JOptionPane.showMessageDialog(null, "Ingrese una fila correcta");

            } else if (Integer.parseInt(field_dimensiones[1].getText()) <= 0 || Integer.parseInt(field_dimensiones[1].getText()) > Integer.parseInt(field_tam_matriz_a[1].getText())) {

                JOptionPane.showMessageDialog(null, "Ingrese una columna correcta");

            } else {

                matriz_a.insertar(Integer.parseInt(field_dimensiones[0].getText()), Integer.parseInt(field_dimensiones[1].getText()), Integer.parseInt(field_dimensiones[2].getText()));

            }

            matriz_a.print();

            mostrarMatriz(scroll_matriz_a, matriz_a);
            field_dimensiones[0].requestFocus();
        }/////////////////////////////BOTON AGREGAR EN A//////////////////////////

        /////////////////////////////BOTON AGREGAR EN B//////////////////////////
        if (e.getSource() == botones_matrices[1]) {
            if (es_suma) {

                if (Integer.parseInt(field_dimensiones[0].getText()) <= 0 || Integer.parseInt(field_dimensiones[0].getText()) > Integer.parseInt(field_tam_matriz_a[0].getText())) {

                    JOptionPane.showMessageDialog(null, "Ingrese una fila correcta");

                } else if (Integer.parseInt(field_dimensiones[1].getText()) <= 0 || Integer.parseInt(field_dimensiones[1].getText()) > Integer.parseInt(field_tam_matriz_a[1].getText())) {

                    JOptionPane.showMessageDialog(null, "Ingrese una columna correcta");

                } else {

                    matriz_b.insertar(Integer.parseInt(field_dimensiones[0].getText()), Integer.parseInt(field_dimensiones[1].getText()), Integer.parseInt(field_dimensiones[2].getText()));

                }
            } else if (es_multiplicacion) {

                if (Integer.parseInt(field_dimensiones[0].getText()) <= 0 || Integer.parseInt(field_dimensiones[0].getText()) > Integer.parseInt(field_tam_matriz_b[0].getText())) {

                    JOptionPane.showMessageDialog(null, "Ingrese una fila correcta");

                } else if (Integer.parseInt(field_dimensiones[1].getText()) <= 0 || Integer.parseInt(field_dimensiones[1].getText()) > Integer.parseInt(field_tam_matriz_b[1].getText())) {

                    JOptionPane.showMessageDialog(null, "Ingrese una columna correcta");

                } else {

                    matriz_b.insertar(Integer.parseInt(field_dimensiones[0].getText()), Integer.parseInt(field_dimensiones[1].getText()), Integer.parseInt(field_dimensiones[2].getText()));

                }
            }

            matriz_b.print();

            mostrarMatriz(scroll_matriz_b, matriz_b);
            field_dimensiones[0].requestFocus();
        }/////////////////////////////BOTON AGREGAR EN B//////////////////////////

        /////////////////////////////BOTON PROCESAR//////////////////////////
        if (e.getSource() == boton_procesar) {

            /////////////////////////////BOTON SUMAR//////////////////////////
            if ("Sumar".equals(e.getActionCommand())) {
                matriz_resultado = new Matriz();
                suma = new Suma(matriz_a, matriz_b);
                matriz_resultado = suma.getResultado();
                matriz_resultado.setNombre("SUMA");
                mostrarMatriz(scroll_matriz_result, matriz_resultado);

            } /////////////////////////////BOTON SUMAR//////////////////////////
            ///////////////////////////////BOTON MULTIPLICAR//////////////////////////
            else if ("Multiplicar".equals(e.getActionCommand())) {
                matriz_resultado = new Matriz();
                multiplicacion = new Multiplicacion(matriz_a, matriz_b);
                matriz_resultado = multiplicacion.getResultado();
                matriz_resultado.setNombre("PRODUCTO");
                mostrarMatriz(scroll_matriz_result, matriz_resultado);
            }/////////////////////////////BOTON MULTIPLICAR//////////////////////////

            field_dimensiones[0].requestFocus();
        }

    }

    public void mostrarMatriz(JScrollPane scroll_pane, Matriz m) {

        int columnas = m.obtenerTamañoMatriz()[1] - 1;
        JPanel panel = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.magenta);
                if (columnas > -1) {
                    drawArrow(g, 50, 45, 70, 45);
                }
                for (int i = 0; i < columnas; i++) {
                    drawArrow(g, (i + 1) * 70 + 50, 45, (i + 2) * 70, 45);
                }
                int i, j = 0;
                for (NodoColumna x = m.getCabeza(); x != null; x = x.getSiguienteElemento()) {
                    i = 0;
                    for (NodoFila y = x.getElementoAbajo(); y != null; y = y.getSiguienteElemento()) {
                        drawArrow(g, 25 + ((j + 1) * 70), ((i + 1) * 70), 25 + ((j + 1) * 70), 20 + ((i + 1) * 70));
                        i++;
                    }
                    j++;
                }

            }

            public void drawArrow(Graphics g, int x0, int y0, int x1, int y1) {

                g.setColor(Color.MAGENTA);
                double alfa = Math.atan2(y1 - y0, x1 - x0);
                g.drawLine(x0, y0, x1, y1);
                int k = 5;
                int xa = (int) (x1 - k * Math.cos(alfa + 1));
                int ya = (int) (y1 - k * Math.sin(alfa + 1));
                // Se dibuja un extremo de la dirección de la flecha.
                g.drawLine(xa, ya, x1, y1);
                xa = (int) (x1 - k * Math.cos(alfa - 1));
                ya = (int) (y1 - k * Math.sin(alfa - 1));
                // Se dibuja el otro extremo de la dirección de la flecha.
                g.drawLine(xa, ya, x1, y1);
            }
        };
        panel.setBackground(COLOR);
        panel.setLayout(null);
        panel.setBorder(BORDE);
        panel.requestFocus();
        panel.addKeyListener(this);

        label_nombre_matriz = new JLabel("" + m.getNombre());
        label_nombre_matriz.setForeground(Color.YELLOW);
        label_nombre_matriz.setFont(FUENTE);
        label_nombre_matriz.setBounds(5, 5, (int) label_nombre_matriz.getMinimumSize().getWidth(), 20);

        panel.add(label_nombre_matriz);

//        field_dimensiones[0].requestFocus();
        label_salida_final = new JLabel[(m.obtenerTamañoMatriz()[0] + 1)][m.obtenerTamañoMatriz()[1]];
        label_salida_final_apunt = new JLabel[m.obtenerTamañoMatriz()[1] + 1];

        label_salida_final_apunt[m.obtenerTamañoMatriz()[1]] = new JLabel();
        panel.add(label_salida_final_apunt[m.obtenerTamañoMatriz()[1]]);

        label_salida_final_apunt[m.obtenerTamañoMatriz()[1]].setBounds(40, 33, 10, 25);
        label_salida_final_apunt[m.obtenerTamañoMatriz()[1]].setForeground(Color.MAGENTA);
        label_salida_final_apunt[m.obtenerTamañoMatriz()[1]].setText("·");
        label_salida_final_apunt[m.obtenerTamañoMatriz()[1]].setVerticalAlignment(SwingConstants.CENTER);
        label_salida_final_apunt[m.obtenerTamañoMatriz()[1]].setHorizontalAlignment(SwingConstants.CENTER);
        label_salida_final_apunt[m.obtenerTamañoMatriz()[1]].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));

        int i, j = 0;
        for (NodoColumna x = m.getCabeza(); x != null; x = x.getSiguienteElemento()) {

            i = 0;

            label_salida_final[i][j] = new JLabel();
            label_salida_final_apunt[j] = new JLabel();

            panel.add(label_salida_final[i][j]);
            panel.add(label_salida_final_apunt[j]);

            label_salida_final[i][j].setBounds((j + 1) * 70, (i + 1) * 20, 50, 50);
            label_salida_final[i][j].setVerticalAlignment(SwingConstants.CENTER);
            label_salida_final[i][j].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
            label_salida_final[i][j].setForeground(Color.WHITE);
            label_salida_final[i][j].setText("<html><div style='text-align: center;'>" + x.getColumna() + "</div>" + "<p><font color='#DD09DD'>_______</font></p><html>");

            label_salida_final_apunt[j].setBounds(40 + (j + 1) * 70, 20, 10, 50);
            label_salida_final_apunt[j].setForeground(Color.MAGENTA);
            label_salida_final_apunt[j].setText("·");
            label_salida_final_apunt[j].setVerticalAlignment(SwingConstants.CENTER);
            label_salida_final_apunt[j].setHorizontalAlignment(SwingConstants.CENTER);
            label_salida_final_apunt[j].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));

            for (NodoFila y = x.getElementoAbajo(); y != null; y = y.getSiguienteElemento()) {

                label_salida_final[i][j] = new JLabel();

                panel.add(label_salida_final[i][j]);

                label_salida_final[i][j].setBounds((j + 1) * 70, 20 + (i + 1) * 70, 50, 50);
                label_salida_final[i][j].setVerticalAlignment(SwingConstants.CENTER);
                label_salida_final[i][j].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
                label_salida_final[i][j].setForeground(Color.WHITE);

                label_salida_final[i][j].setText("<html><div style='text-align: center;'>" + y.getFila() + " | " + y.getValor() + "</div><p><font color='#DD09DD'>_______</font><html>");

                i++;
            }
            j++;
        }

        panel.setPreferredSize(new Dimension(((m.obtenerTamañoMatriz()[1] + 1) * 70) - 10, ((m.obtenerTamañoMatriz()[0] + 1) * 70) + 20));
        scroll_pane.setViewportView(panel);
        scroll_pane.setVisible(true);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
            System.exit(0);
        }

        Object o = e.getSource();
        if (o instanceof JButton) {
            JButton boton = (JButton) o;

            boton.doClick();
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
