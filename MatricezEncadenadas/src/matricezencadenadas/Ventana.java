/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricezencadenadas;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class Ventana extends JFrame implements ActionListener, KeyListener {

    private static final ImagenFondo IMAGEN_FONDO = new ImagenFondo();
    public static final int ANCHO = 720, ALTO = 520;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final Color COLOR = new Color(51, 51, 55);
    private static final Color COLOR1 = new Color(1, 153, 194);

    private static final Border BORDE = BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE);
    ;

    private static final Font FUENTE = new Font("TimesRoman", Font.BOLD, 10);

    private final JPanel panel_num_matricez = new JPanel();
    private static JPanel panel_dimensiones;
    private static JPanel panel_salida_matriz;

    private final JScrollPane scroll_Dimensiones = new JScrollPane(panel_dimensiones, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private final JScrollPane scroll_Tabla = new JScrollPane(panel_salida_matriz, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private final JLabel label_num_matricez = new JLabel("Numero Matrices:");
    private JLabel label_dimensiones;
    private JLabel texto_out_final;
    private final JTextField field_num_matricez = new JTextField("6");
    private JTextField[] field_dimensiones;
    private JLabel[] label_tamaño_matriz;

    private JLabel[][] label_salida_final;

    private final JButton boton_generar = new JButton("Generar Campos");
    private final JButton boton_procesar = new JButton("Procesar");

    public Ventana() {
        setTitle("Matrices Encadenadas");
        setIconImage(new ImageIcon(Ventana.class.getResource("/imagenes/icono.png")).getImage());
        setUndecorated(true);
        setLayout(null);
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(IMAGEN_FONDO);
        requestFocus();
        getRootPane().setBorder(BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE));
        getContentPane().setLayout(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panel_num_matricez.setBackground(COLOR);
        panel_num_matricez.setForeground(COLOR1);
        panel_num_matricez.setBounds(5, 5, 200, 90);
        panel_num_matricez.setBorder(BORDE);
        panel_num_matricez.setLayout(null);

        label_num_matricez.setBounds(5, 10, 150, 20);
        label_num_matricez.setForeground(COLOR1);

        field_num_matricez.setBounds(140, 10, 50, 20);
        field_num_matricez.setBackground(COLOR1);
        field_num_matricez.setForeground(Color.BLACK);
        field_num_matricez.setBorder(BORDE);
        field_num_matricez.addKeyListener(this);
        field_num_matricez.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        field_num_matricez.addFocusListener(new FocusListener() {
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

        boton_generar.setBounds(25, 60, 150, 20);
        boton_generar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_generar.setForeground(COLOR1);
        boton_generar.setBackground(COLOR);
        boton_generar.setBorder(BORDE);
        boton_generar.addActionListener(this);
        boton_generar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                boton_generar.setBackground((COLOR1));
                boton_generar.setForeground((COLOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton_generar.setBackground((COLOR));
                boton_generar.setForeground((COLOR1));
            }
        });

        boton_procesar.setBounds(5, 50, 100, 15);
        boton_procesar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_procesar.setForeground(COLOR1);
        boton_procesar.setBackground(COLOR);
        boton_procesar.setBorder(BORDE);
        boton_procesar.addActionListener(this);
        boton_procesar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                boton_procesar.setBackground((COLOR1));
                boton_procesar.setForeground((COLOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton_procesar.setBackground((COLOR));
                boton_procesar.setForeground((COLOR1));
            }
        });
        panel_num_matricez.add(label_num_matricez);
        panel_num_matricez.add(field_num_matricez);
        panel_num_matricez.add(boton_generar);

        scroll_Dimensiones.setBounds(210, 5, 500, 90);
        scroll_Dimensiones.setVisible(false);
        scroll_Dimensiones.setBorder(BORDE);
        scroll_Dimensiones.getHorizontalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_Dimensiones.getHorizontalScrollBar().setBackground(Color.BLACK);

        scroll_Tabla.setBounds(5, 100, 705, 410);
        scroll_Tabla.setVisible(false);
        scroll_Tabla.setBorder(BORDE);
        scroll_Tabla.getHorizontalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_Tabla.getHorizontalScrollBar().setBackground(Color.BLACK);
        scroll_Tabla.setBorder(BORDE);
        scroll_Tabla.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_Tabla.getVerticalScrollBar().setBackground(Color.BLACK);

        add(scroll_Dimensiones);
        add(scroll_Tabla);
        add(panel_num_matricez);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ////////////////////BOTON GENERAR//////////////////////////////////
        if (e.getSource() == boton_generar) {

            texto_out_final = new JLabel("Digite valores y presione procesar");
            texto_out_final.setBounds(110, 50, 100 * Integer.parseInt(field_num_matricez.getText()), 15);
            texto_out_final.setForeground(COLOR1);
            panel_dimensiones = new JPanel();
            panel_dimensiones.requestFocus();
            panel_dimensiones.addKeyListener(this);
            scroll_Dimensiones.setViewportView(panel_dimensiones);
            scroll_Dimensiones.setVisible(true);
            panel_dimensiones.setLayout(null);
            panel_dimensiones.setBackground(COLOR);
            panel_dimensiones.add(boton_procesar);
            panel_dimensiones.add(texto_out_final);
            panel_dimensiones.setPreferredSize(new Dimension((Integer.parseInt(field_num_matricez.getText()) * 30) + 75, 80));

            field_dimensiones = new JTextField[Integer.parseInt(field_num_matricez.getText())];
            label_tamaño_matriz = new JLabel[Integer.parseInt(field_num_matricez.getText())];
            label_dimensiones = new JLabel("Dimensiones:");

            int cont = 0, dim = 1, limite_matricez = Integer.parseInt(field_num_matricez.getText());
            String dim_iniciales;
            char w;

            for (w = 'A'; w <= 'Z'; w++) {
                if (cont == limite_matricez) {
                    break;
                } else {
                    label_tamaño_matriz[cont] = new JLabel(Character.toString(w));
                    cont++;
                }
            }
            label_dimensiones.setForeground(COLOR1);
            label_dimensiones.setBounds(5, -15 + (20 * (0 + 1)), 100, 20);
            panel_dimensiones.add(label_dimensiones);

            for (int x = 0; x < Integer.parseInt(field_num_matricez.getText()); x++) {
                dim_iniciales = dim + "," + (dim + 1);
                field_dimensiones[x] = new JTextField();

                panel_dimensiones.add(field_dimensiones[x]);
                panel_dimensiones.add(label_tamaño_matriz[x]);

                field_dimensiones[x].setBounds(80 + (31 * (x + 1)), 5, 30, 20);
                label_tamaño_matriz[x].setBounds(90 + (31 * (x + 1)), 25, 30, 20);
                label_tamaño_matriz[x].setForeground(COLOR1);

                field_dimensiones[x].setText(dim_iniciales);
                field_dimensiones[x].setBackground(COLOR1);
                field_dimensiones[x].setForeground(Color.BLACK);
                field_dimensiones[x].setBorder(BORDE);
                field_dimensiones[x].addKeyListener(new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                            boton_procesar.doClick();
                        }
                        if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
                            System.exit(0);
                        }
                    }

                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
                field_dimensiones[x].addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char caracter = e.getKeyChar();
                        // Verificar si la tecla pulsada no es un digito
                        if (((caracter < '0') || (caracter > '9')) && (caracter != ',')) {
                            e.consume();  // ignorar el evento de teclado
                        }
                    }
                });
                field_dimensiones[x].addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        Object o = e.getSource();
                        if (o instanceof JTextField) {
                            JTextField field_in_valores_monedas = (JTextField) o;
                            field_in_valores_monedas.setSelectionStart(0);
                            field_in_valores_monedas.setSelectionEnd(field_in_valores_monedas.getText().length());
                            field_in_valores_monedas.setBackground(Color.BLACK);
                            field_in_valores_monedas.setForeground(COLOR1);
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        Object o = e.getSource();
                        if (o instanceof JTextField) {
                            JTextField field_in_valores_monedas = (JTextField) o;
                            field_in_valores_monedas.setBackground(COLOR1);
                            field_in_valores_monedas.setForeground(Color.BLACK);
                        }
                    }
                });

                dim++;
            }
            field_dimensiones[0].requestFocus();
        }////////////////////BOTON GENERAR//////////////////////////////////

        ///////////////////////BOTON PROCESAR///////////////////
        if (e.getSource() == boton_procesar) {

            panel_salida_matriz = new JPanel();
            panel_salida_matriz.setBackground(COLOR);
            panel_salida_matriz.setLayout(null);
            panel_salida_matriz.setBorder(BORDE);
            panel_salida_matriz.requestFocus();
            panel_salida_matriz.addKeyListener(this);
            field_dimensiones[0].requestFocus();

            int nmatrices, tamaño_max_x = 0, tamaño_max_y, tamaños_max_x[], tamaños_max_y[], error = 0;
            nmatrices = Integer.parseInt(field_num_matricez.getText());

            String totalText = "";
            for (int i = 0; i < nmatrices; i++) {
                totalText += field_dimensiones[i].getText() + ",";
            }
            String[] textElements = totalText.split(",");
            System.out.println(Arrays.toString(textElements));

            int dimensiones[] = new int[field_dimensiones.length + 1];
            int cont = 1;
            for (int i = 1; i < textElements.length - 1; i += 2) {
                int elemento_actual = Integer.parseInt(textElements[i]);
                for (int j = i; j < i + 2; j++) {
                    if (Integer.parseInt(textElements[j]) == elemento_actual) {
                        dimensiones[cont] = Integer.parseInt(textElements[j]);
                    } else {
                        System.out.println("error");
                        error = 1;
                        break;
                    }
                    elemento_actual = Integer.parseInt(textElements[j]);
                }
                cont++;
            }

            dimensiones[0] = Integer.parseInt(textElements[0]);
            dimensiones[dimensiones.length - 1] = Integer.parseInt(textElements[textElements.length - 1]);
            System.out.println(Arrays.toString(dimensiones));

            if (error != 1) {

                OptimizacionProductoMatricez optimizar = new OptimizacionProductoMatricez(dimensiones);
                ArrayList<String>[][] cadenas = optimizar.getMatriz_cadenas();
                ArrayList<Integer>[][] numeros = optimizar.getMatriz_numeros();
                ArrayList<String>[][] minimos = optimizar.getMatriz_min_cad();

                label_salida_final = new JLabel[nmatrices + 1][nmatrices + 1];
                for (int i = 0; i < nmatrices + 1; i++) {
                    for (int j = 0; j < nmatrices + 1; j++) {

                        label_salida_final[i][j] = new JLabel();
                        panel_salida_matriz.add(label_salida_final[i][j]);

                        if (i == 0 && j == 0) {
                            label_salida_final[i][j].setText("");
                        } else if (i == 0) {
                            label_salida_final[i][j].setText(" j = " + (j - 1) + " ");
                        } else if (j == 0) {
                            label_salida_final[i][j].setText(" i = " + (i - 1) + " ");
                        } else if (i >= j) {
                            label_salida_final[i][j].setText("0");
                        } else {

                            String s = "";
                            for (int k = 0; k < cadenas[i][j].size(); k++) {

                                s += "<html><p><div style='text-align: center;'><font color='red'>k=" + (k + i - 1) + "</font> Asigno " + numeros[i][j].get(k) + "<p>" + minimos[i][j].get(k) + "<p>" + cadenas[i][j].get(k) + "</div><p><html>";
                            }
                            s += "<html><p>= <font color='#3BFF00'>" + numeros[i][j].get(numeros[i][j].size() - 1) + "</font> <font color='yellow'>" + cadenas[i][j].get(cadenas[i][j].size() - 1) + "</font><html>";
                            label_salida_final[i][j].setText(s);
                        }
                    }
                }

                tamaños_max_x = new int[nmatrices + 1];
                tamaños_max_y = new int[nmatrices + 1];
                for (int i = 0; i < nmatrices + 1; i++) {
                    tamaño_max_y = 0;
                    for (int j = 0; j < nmatrices + 1; j++) {
                        if (tamaño_max_y < label_salida_final[i][j].getMinimumSize().getHeight()) {
                            tamaño_max_y = (int) label_salida_final[i][j].getMinimumSize().getHeight() + 20;
                        }
                    }
                    tamaños_max_y[i] = tamaño_max_y;
                }

                for (int j = 0; j < nmatrices + 1; j++) {
                    tamaño_max_x = 0;
                    for (int i = 0; i < nmatrices + 1; i++) {
                        if (tamaño_max_x < label_salida_final[i][j].getMinimumSize().getWidth()) {
                            tamaño_max_x = (int) label_salida_final[i][j].getMinimumSize().getWidth() * (int) ((j + 1) * 2) - 20;
                        }
                    }
                    tamaños_max_x[j] = tamaño_max_x;
                }

                int suma_tamaños_Y = 5, suma_tamaños_X = 5;
                for (int i = 0; i < nmatrices + 1; i++) {
                    suma_tamaños_X = 5;
                    for (int j = 0; j < nmatrices + 1; j++) {

                        if (i == 0 && j == 0) {
                            label_salida_final[i][j].setBounds(suma_tamaños_X, suma_tamaños_Y, tamaños_max_x[j], tamaños_max_y[i] - 20);
                        } else if (i == 0) {
                            label_salida_final[i][j].setBounds(suma_tamaños_X, suma_tamaños_Y, tamaños_max_x[j], tamaños_max_y[i] - 20);
                        } else if (j == 0) {
                            label_salida_final[i][j].setBounds(suma_tamaños_X, suma_tamaños_Y, tamaños_max_x[j], tamaños_max_y[i]);
                        } else {
                            label_salida_final[i][j].setBounds(suma_tamaños_X, suma_tamaños_Y, tamaños_max_x[j], tamaños_max_y[i]);
                        }

                        label_salida_final[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                        label_salida_final[i][j].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
                        label_salida_final[i][j].setForeground(Color.WHITE);
                        if (i == 0 && j > 0 || j == 0 && i > 0) {
                            label_salida_final[i][j].setForeground(Color.CYAN);
                        }

                        suma_tamaños_X += tamaños_max_x[j];

                    }
                    if (i > 0) {
                        suma_tamaños_Y += tamaños_max_y[i];
                    }
                }

                texto_out_final.setForeground(COLOR1);
                texto_out_final.setText("<html>Producto minimo: <font color='#3BFF00'>" + numeros[1][nmatrices].get(numeros[1][nmatrices].size() - 1) + "</font> - <font color='yellow'>" + cadenas[1][nmatrices].get(cadenas[1][nmatrices].size() - 1) + "</font><html>");

                scroll_Tabla.setViewportView(panel_salida_matriz);
                scroll_Tabla.setVisible(true);
                panel_salida_matriz.setPreferredSize(new Dimension((suma_tamaños_X) + 25, suma_tamaños_Y + 25));
            } else {
                texto_out_final.setForeground(Color.red);
                texto_out_final.setText("Dimensiones invalidas");
                scroll_Tabla.setVisible(false);
                JOptionPane.showMessageDialog(null, "Dimensiones invalidas");
            }
        }///////////////////////BOTON PROCESAR///////////////////
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == field_num_matricez) {
            if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                boton_generar.doClick();
            }
            if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
                System.exit(0);
            }
        }
        if (e.getSource() == panel_dimensiones || e.getSource() == panel_num_matricez || e.getSource() == panel_salida_matriz) {
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
