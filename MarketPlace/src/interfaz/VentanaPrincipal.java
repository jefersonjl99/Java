/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

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
public class VentanaPrincipal extends JFrame implements ActionListener, KeyListener {

    private static final ImagenFondo IMAGEN_FONDO = new ImagenFondo();
    public static final int ANCHO = 720, ALTO = 520;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final Color COLOR = new Color(51, 51, 55);
    private static final Color COLOR1 = new Color(1, 153, 194);

    private static final Border BORDE = BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE);
    ;

    private static final Font FUENTE = new Font("TimesRoman", Font.BOLD, 10);

    private static JPanel panel_num_matricez;
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

    private final JButton boton_usuario = new JButton("Usuario");
    private final JButton boton_admin = new JButton("Admin");
    private final JButton boton_encargado = new JButton("Encargado");

    private JButton[] botones_acciones;

    public VentanaPrincipal() {
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setTitle("MARKETPLACE");
        setIconImage(new ImageIcon(VentanaPrincipal.class.getResource("/recursos/1.jpg")).getImage());
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

        boton_usuario.setBounds(ANCHO / 2 - 50, ALTO / 2 - 30, 100, 20);
        boton_usuario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_usuario.setForeground(COLOR1);
        boton_usuario.setBackground(COLOR);
        boton_usuario.setBorder(BORDE);
        boton_usuario.addActionListener(this);
        boton_usuario.addKeyListener(this);
        boton_usuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                boton_usuario.setBackground((COLOR1));
                boton_usuario.setForeground((COLOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton_usuario.setBackground((COLOR));
                boton_usuario.setForeground((COLOR1));
            }
        });

        boton_admin.setBounds(ANCHO / 2 - 50, ALTO / 2 - 5, 100, 20);
        boton_admin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_admin.setForeground(COLOR1);
        boton_admin.setBackground(COLOR);
        boton_admin.setBorder(BORDE);
        boton_admin.addActionListener(this);
        boton_admin.addKeyListener(this);
        boton_admin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                boton_admin.setBackground((COLOR1));
                boton_admin.setForeground((COLOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton_admin.setBackground((COLOR));
                boton_admin.setForeground((COLOR1));
            }
        });

        boton_encargado.setBounds(ANCHO / 2 - 50, ALTO / 2 + 20, 100, 20);
        boton_encargado.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_encargado.setForeground(COLOR1);
        boton_encargado.setBackground(COLOR);
        boton_encargado.setBorder(BORDE);
        boton_encargado.addActionListener(this);
        boton_encargado.addKeyListener(this);
        boton_encargado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                boton_encargado.setBackground((COLOR1));
                boton_encargado.setForeground((COLOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton_encargado.setBackground((COLOR));
                boton_encargado.setForeground((COLOR1));
            }
        });
        add(boton_admin);
        add(boton_usuario);
        add(boton_encargado);

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
        
        boton_admin.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ////////////////////BOTON ADMIN//////////////////////////////////
        if (e.getSource() == boton_admin) {

            panel_num_matricez = new JPanel();
            add(panel_num_matricez);
            panel_num_matricez.requestFocus();
            panel_num_matricez.setBackground(COLOR);
            panel_num_matricez.setForeground(COLOR1);
            panel_num_matricez.setBounds(5, 5, 200, 90);
            panel_num_matricez.setBorder(BORDE);
            panel_num_matricez.setLayout(null);

            botones_acciones = new JButton[3];
            for (int i = 0; i < botones_acciones.length; i++) {
                botones_acciones[i] = new JButton();

                botones_acciones[i].setBounds(25, -25 + ((i + 1) * 30), 150, 20);
                botones_acciones[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                botones_acciones[i].setForeground(COLOR1);
                botones_acciones[i].setBackground(COLOR);
                botones_acciones[i].setBorder(BORDE);
                botones_acciones[i].addActionListener(this);
                botones_acciones[i].addKeyListener(this);
                botones_acciones[i].addMouseListener(new MouseAdapter() {
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

                switch (i) {
                    case 0:
                        botones_acciones[i].setText("Agregar Ciudad");
                        break;
                    case 1:
                        botones_acciones[i].setText("Eliminar Ciudad");
                        break;
                    case 2:
                        botones_acciones[i].setText("Agregar Vuelo");
                        break;
                    default:
                        break;
                }

                panel_num_matricez.add(botones_acciones[i]);
            botones_acciones[0].requestFocus();

            }

        }////////////////////BOTON ADMIN//////////////////////////////////

        ////////////////////BOTON USUARIO//////////////////////////////////
        if (e.getSource() == boton_usuario) {

            panel_num_matricez = new JPanel();
            add(panel_num_matricez);
            panel_num_matricez.requestFocus();
            panel_num_matricez.setBackground(COLOR);
            panel_num_matricez.setForeground(COLOR1);
            panel_num_matricez.setBounds(5, 5, 200, 90);
            panel_num_matricez.setBorder(BORDE);
            panel_num_matricez.setLayout(null);

            botones_acciones = new JButton[3];
            for (int i = 0; i < botones_acciones.length; i++) {
                botones_acciones[i] = new JButton();

                botones_acciones[i].setBounds(25, -25 + ((i + 1) * 30), 150, 20);
                botones_acciones[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                botones_acciones[i].setForeground(COLOR1);
                botones_acciones[i].setBackground(COLOR);
                botones_acciones[i].setBorder(BORDE);
                botones_acciones[i].addActionListener(this);
                botones_acciones[i].addKeyListener(this);
                botones_acciones[i].addMouseListener(new MouseAdapter() {
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

                switch (i) {
                    case 0:
                        botones_acciones[i].setText("Registrar Usuario");
                        break;
                    case 1:
                        botones_acciones[i].setText("Eliminar Usuario");
                        break;
                    case 2:
                        botones_acciones[i].setText("Hacer Reserva");
                        break;
                    default:
                        break;
                }

                panel_num_matricez.add(botones_acciones[i]);
            botones_acciones[0].requestFocus();

            }

        }////////////////////BOTON USUARIO//////////////////////////////////

        ////////////////////BOTON ENCARGADO//////////////////////////////////
        if (e.getSource() == boton_encargado) {

            panel_num_matricez = new JPanel();
            add(panel_num_matricez);
            panel_num_matricez.requestFocus();
            panel_num_matricez.setBackground(COLOR);
            panel_num_matricez.setForeground(COLOR1);
            panel_num_matricez.setBounds(5, 5, 200, 90);
            panel_num_matricez.setBorder(BORDE);
            panel_num_matricez.setLayout(null);

            botones_acciones = new JButton[1];
            botones_acciones[0] = new JButton();

            botones_acciones[0].setBounds(25, -25 + (2 * 30), 150, 20);
            botones_acciones[0].setCursor(new Cursor(Cursor.HAND_CURSOR));
            botones_acciones[0].setForeground(COLOR1);
            botones_acciones[0].setBackground(COLOR);
            botones_acciones[0].setBorder(BORDE);
            botones_acciones[0].addActionListener(this);
            botones_acciones[0].addKeyListener(this);
            botones_acciones[0].setText("Generar Archivo");
            botones_acciones[0].addMouseListener(new MouseAdapter() {
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
            panel_num_matricez.add(botones_acciones[0]);
            botones_acciones[0].requestFocus();

        }////////////////////BOTON ENCARGADO//////////////////////////////////

        ////////////////////BOTON ENCARGADO//////////////////////////////////
        if (e.getSource() == botones_acciones[0]) {
            remove(panel_num_matricez);
            revalidate();
            repaint();
            int cc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cedula del Cliente"));
        }////////////////////BOTON ENCARGADO//////////////////////////////////


        
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        if (e.getSource() == field_num_matricez) {
//            if (KeyEvent.VK_ENTER == e.getKeyCode()) {
//                boton_generar.doClick();
//            }
//            if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
//                System.exit(0);
//            }
//        }
        if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
            System.exit(0);
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
            imagen = ImageIO.read(ImagenFondo.class.getResource("/recursos/1.jpg"));
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
