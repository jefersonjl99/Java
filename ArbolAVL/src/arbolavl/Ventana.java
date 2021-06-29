/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolavl;

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
public class Ventana extends JFrame implements ActionListener, KeyListener {

    private static final ImagenFondo IMAGEN_FONDO = new ImagenFondo();
    public static final int ANCHO = 800, ALTO = 600;

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

    private Arbol arbol;
    private final Dibujar dibujar = new Dibujar();

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
        arbol = new Arbol();

        panel_datos = new JPanel();
        panel_datos.setBackground(COLOR);
        panel_datos.setForeground(COLOR1);
        panel_datos.setBounds(5, 5, ANCHO - 15, 90);
        panel_datos.setBorder(BORDE);
        panel_datos.setLayout(null);
        panel_datos.requestFocus();
        panel_datos.addKeyListener(this);

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

            panel_datos.add(botones_operacion[i]);
        }

        for (int i = 0; i < field_codigo.length; i++) {

            field_codigo[i] = new JTextField("" + (i + 1));

            field_codigo[i].setBounds(-80 + ((i + 1) * 110), 40, 100, 20);
            field_codigo[i].setBackground(COLOR1);
            field_codigo[i].setForeground(Color.BLACK);
            field_codigo[i].setBorder(BORDE);
            field_codigo[i].requestFocus();
            field_codigo[i].addKeyListener(this);
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
                        boton_procesar.doClick();
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
        field_codigo[0].requestFocus();

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
        panel_lista_innorden.requestFocus();
        panel_lista_innorden.addKeyListener(this);

        panel_dibujo_arbol = new JPanel();
        panel_dibujo_arbol.setBackground(COLOR);
        panel_dibujo_arbol.setForeground(COLOR1);
        panel_dibujo_arbol.setBounds(210, 100, ANCHO - 220, ALTO - 110);
        panel_dibujo_arbol.setVisible(false);
        panel_dibujo_arbol.setBorder(BORDE);
        panel_dibujo_arbol.setLayout(null);
        panel_dibujo_arbol.requestFocus();
        panel_dibujo_arbol.addKeyListener(this);

        scroll_dibujo_arbol.setBounds(210, 100, 500, 410);
        scroll_dibujo_arbol.setVisible(false);
        scroll_dibujo_arbol.setBorder(BORDE);
        scroll_dibujo_arbol.getHorizontalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_dibujo_arbol.getHorizontalScrollBar().setBackground(Color.BLACK);
        scroll_dibujo_arbol.getVerticalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_dibujo_arbol.getVerticalScrollBar().setBackground(Color.BLACK);

        add(panel_datos);
        add(panel_lista_innorden);
        add(panel_dibujo_arbol);
    }

////////////////////////////////////////////ACTION LISTENER///////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {

        /////////////////////////////BOTON AGREGAR//////////////////////////
        if (e.getSource() == botones_operacion[0]) {
            panel_lista_innorden.paint(panel_lista_innorden.getGraphics());
            panel_dibujo_arbol.paint(panel_dibujo_arbol.getGraphics());
            arbol.setFila(0);
            panel_dibujo_arbol.setVisible(true);

            int n = Integer.parseInt(field_codigo[0].getText());
            String s = JOptionPane.showInputDialog("Ingrese el nombre del estudiante a registrar:");
            if (arbol.insertar_nodo(n, s) == 2) {
                JOptionPane.showMessageDialog(null, "El codigo ya existe");
            }
            arbol.inorden(arbol.raiz, panel_lista_innorden.getGraphics());
            dibujar.DibujaArbol(panel_dibujo_arbol.getGraphics(), 0, 30, arbol.raiz, panel_dibujo_arbol);

        }/////////////////////////////BOTON AGREGAR//////////////////////////

        /////////////////////////////BOTON RETIRAR//////////////////////////
        if (e.getSource() == botones_operacion[1]) {

            panel_dibujo_arbol.paint(panel_dibujo_arbol.getGraphics());
            panel_lista_innorden.paint(panel_lista_innorden.getGraphics());
            arbol.setFila(0);

            int n = Integer.parseInt(field_codigo[0].getText());
            if (arbol.retirar_nodo(n) == 2) {
                JOptionPane.showMessageDialog(null, "El nodo a retirar no se encuentra en el arbol");
            }
            arbol.inorden(arbol.raiz, panel_lista_innorden.getGraphics());
            dibujar.DibujaArbol(panel_dibujo_arbol.getGraphics(), 0, 30, arbol.raiz, panel_dibujo_arbol);

        }/////////////////////////////BOTON RETIRAR//////////////////////////

        /////////////////////////////BOTON BUSCAR//////////////////////////
        if (e.getSource() == botones_operacion[2]) {

            int n = Integer.parseInt(field_codigo[0].getText());
            if (arbol.buscar_nodo(n) == 1) {
                JOptionPane.showMessageDialog(null, "El nombre del alumno es: " + arbol.getExistente().nombre);
            }
        }/////////////////////////////BOTON RETIRAR//////////////////////////

    }

//    public void mostrarMatriz(JScrollPane scroll_pane, Arbol A) {
//
//        int columnas = A.obtenerTamañoMatriz()[1] - 1;
//        JPanel panel = new JPanel() {
//
//            @Override
//            public void paintComponent(Graphics g) {
//                super.paintComponent(g);
//
//                g.setColor(Color.magenta);
//                if (columnas > -1) {
//                    drawArrow(g, 50, 45, 70, 45);
//                }
//                for (int i = 0; i < columnas; i++) {
//                    drawArrow(g, (i + 1) * 70 + 50, 45, (i + 2) * 70, 45);
//                }
//                int i, j = 0;
//                for (NodoColumna x = A.getCabeza(); x != null; x = x.getSiguienteElemento()) {
//                    i = 0;
//                    for (NodoFila y = x.getElementoAbajo(); y != null; y = y.getSiguienteElemento()) {
//                        drawArrow(g, 25 + ((j + 1) * 70), ((i + 1) * 70), 25 + ((j + 1) * 70), 20 + ((i + 1) * 70));
//                        i++;
//                    }
//                    j++;
//                }
//
//            }
//
//            public void drawArrow(Graphics g, int x0, int y0, int x1, int y1) {
//
//                g.setColor(Color.MAGENTA);
//                double alfa = Math.atan2(y1 - y0, x1 - x0);
//                g.drawLine(x0, y0, x1, y1);
//                int k = 5;
//                int xa = (int) (x1 - k * Math.cos(alfa + 1));
//                int ya = (int) (y1 - k * Math.sin(alfa + 1));
//                // Se dibuja un extremo de la dirección de la flecha.
//                g.drawLine(xa, ya, x1, y1);
//                xa = (int) (x1 - k * Math.cos(alfa - 1));
//                ya = (int) (y1 - k * Math.sin(alfa - 1));
//                // Se dibuja el otro extremo de la dirección de la flecha.
//                g.drawLine(xa, ya, x1, y1);
//            }
//        };
//        panel.setBackground(COLOR);
//        panel.setLayout(null);
//        panel.setBorder(BORDE);
//        panel.requestFocus();
//        panel.addKeyListener(this);
//
//        label_nombre_matriz = new JLabel("" + A.getNombre());
//        label_nombre_matriz.setForeground(Color.YELLOW);
//        label_nombre_matriz.setFont(FUENTE);
//        label_nombre_matriz.setBounds(5, 5, (int) label_nombre_matriz.getMinimumSize().getWidth(), 20);
//
//        panel.add(label_nombre_matriz);
//
////        field_dimensiones[0].requestFocus();
//        label_salida_final = new JLabel[(A.obtenerTamañoMatriz()[0] + 1)][A.obtenerTamañoMatriz()[1]];
//        label_salida_final_apunt = new JLabel[A.obtenerTamañoMatriz()[1] + 1];
//
//        label_salida_final_apunt[A.obtenerTamañoMatriz()[1]] = new JLabel();
//        panel.add(label_salida_final_apunt[A.obtenerTamañoMatriz()[1]]);
//
//        label_salida_final_apunt[A.obtenerTamañoMatriz()[1]].setBounds(40, 33, 10, 25);
//        label_salida_final_apunt[A.obtenerTamañoMatriz()[1]].setForeground(Color.MAGENTA);
//        label_salida_final_apunt[A.obtenerTamañoMatriz()[1]].setText("·");
//        label_salida_final_apunt[A.obtenerTamañoMatriz()[1]].setVerticalAlignment(SwingConstants.CENTER);
//        label_salida_final_apunt[A.obtenerTamañoMatriz()[1]].setHorizontalAlignment(SwingConstants.CENTER);
//        label_salida_final_apunt[A.obtenerTamañoMatriz()[1]].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
//
//        int i, j = 0;
//        for (NodoColumna x = A.getCabeza(); x != null; x = x.getSiguienteElemento()) {
//
//            i = 0;
//
//            label_salida_final[i][j] = new JLabel();
//            label_salida_final_apunt[j] = new JLabel();
//
//            panel.add(label_salida_final[i][j]);
//            panel.add(label_salida_final_apunt[j]);
//
//            label_salida_final[i][j].setBounds((j + 1) * 70, (i + 1) * 20, 50, 50);
//            label_salida_final[i][j].setVerticalAlignment(SwingConstants.CENTER);
//            label_salida_final[i][j].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
//            label_salida_final[i][j].setForeground(Color.WHITE);
//            label_salida_final[i][j].setText("<html><div style='text-align: center;'>" + x.getColumna() + "</div>" + "<p><font color='#DD09DD'>_______</font></p><html>");
//
//            label_salida_final_apunt[j].setBounds(40 + (j + 1) * 70, 20, 10, 50);
//            label_salida_final_apunt[j].setForeground(Color.MAGENTA);
//            label_salida_final_apunt[j].setText("·");
//            label_salida_final_apunt[j].setVerticalAlignment(SwingConstants.CENTER);
//            label_salida_final_apunt[j].setHorizontalAlignment(SwingConstants.CENTER);
//            label_salida_final_apunt[j].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
//
//            for (NodoFila y = x.getElementoAbajo(); y != null; y = y.getSiguienteElemento()) {
//
//                label_salida_final[i][j] = new JLabel();
//
//                panel.add(label_salida_final[i][j]);
//
//                label_salida_final[i][j].setBounds((j + 1) * 70, 20 + (i + 1) * 70, 50, 50);
//                label_salida_final[i][j].setVerticalAlignment(SwingConstants.CENTER);
//                label_salida_final[i][j].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
//                label_salida_final[i][j].setForeground(Color.WHITE);
//
//                label_salida_final[i][j].setText("<html><div style='text-align: center;'>" + y.getFila() + " | " + y.getValor() + "</div><p><font color='#DD09DD'>_______</font><html>");
//
//                i++;
//            }
//            j++;
//        }
//
//        panel.setPreferredSize(new Dimension(((A.obtenerTamañoMatriz()[1] + 1) * 70) - 10, ((A.obtenerTamañoMatriz()[0] + 1) * 70) + 20));
//        scroll_pane.setViewportView(panel);
//        scroll_pane.setVisible(true);
//
//    }
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
