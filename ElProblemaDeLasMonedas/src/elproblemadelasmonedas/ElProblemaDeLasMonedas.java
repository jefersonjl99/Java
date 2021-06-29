/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elproblemadelasmonedas;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author jefer
 */
public class ElProblemaDeLasMonedas extends JFrame implements ActionListener {

    int valor_vueltas, num_monedas, valores[], matriz_cambio[][], tamaño_max_x = 0, tamaño_max_y = 0, tamaño_max_x1 = 0, tamaño_max_y1 = 0, suma_pesos = 0;
    String cantidad_monedas[][];
    String cadenaFinal;
    ArrayList<int[]> cantidad_valores = new ArrayList<>();
    ArrayList<Integer> arr = new ArrayList<>();

    Cambio cambio;

    Color color = new Color(51, 51, 55);
    Color color1 = new Color(1, 153, 194);
    Color color_bordes = new Color(54, 155, 140);

    Border borde;

    Font fuente = new Font("TimesRoman", Font.BOLD, 10);

    JPanel panel_peso_articulos = new JPanel();
    JPanel panel_pesos_precios;
    JPanel panel_salida_total;

    JScrollPane scroll_panel_precios_pesos = new JScrollPane(panel_pesos_precios, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollPane scroll_salida_total = new JScrollPane(panel_salida_total, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    JTextField field_in_num_monedas = new JTextField("2");
    JTextField field_in_valor_vueltas = new JTextField("4");
    JTextField[] field_in_valores_monedas;
    JLabel texto_in_num_monedas = new JLabel("Numero de Monedas:");
    JLabel texto_in_valor_vueltas = new JLabel("Valor a devolver:");
    JLabel texto_in_monedas;
    JLabel[][] texto_out;
    JLabel texto_out_final = new JLabel("Gran hijueputa");

    JButton boton_generar = new JButton("Generar Campos");
    JButton boton_procesar = new JButton("Procesar");
    JButton boton_llenar = new JButton("Lenar");

    // Mochila mochila = new Mochila();
    ImagenFondo imagenFondo = new ImagenFondo();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ElProblemaDeLasMonedas obj = new ElProblemaDeLasMonedas();
        obj.setSize(727, 550);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
    }

    public ElProblemaDeLasMonedas() {
        super("El Problema De Las Monedas");
        setContentPane(imagenFondo);
        getContentPane().setLayout(null);
        setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\ElProblemaDeLasMonedas\\src\\imagenes\\6fd36446b62aa9fc71a0b535d066438a-pila-de-monedas-de-d--lar-by-vexels.png").getImage());
        getRootPane().setBorder(BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.magenta, Color.BLUE));

        borde = BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE);

        panel_peso_articulos.setBackground(color);
        panel_peso_articulos.setForeground(color1);
        panel_peso_articulos.setBounds(5, 5, 200, 90);
        panel_peso_articulos.setBorder(borde);
        panel_peso_articulos.setLayout(null);

        texto_in_num_monedas.setBounds(5, 10, 150, 20);
        texto_in_num_monedas.setForeground(color1);
        texto_in_valor_vueltas.setBounds(5, 30, 150, 20);
        texto_in_valor_vueltas.setForeground(color1);

        field_in_num_monedas.setBounds(140, 10, 50, 20);
        field_in_num_monedas.setBackground(color1);
        field_in_num_monedas.setForeground(Color.BLACK);
        field_in_num_monedas.setBorder(borde);
        field_in_num_monedas.addKeyListener(new KeyAdapter() {
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
        field_in_num_monedas.addFocusListener(new FocusListener() {
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

        field_in_valor_vueltas.setBounds(140, 30, 50, 20);
        field_in_valor_vueltas.setBackground(color1);
        field_in_valor_vueltas.setForeground(Color.BLACK);
        field_in_valor_vueltas.setBorder(borde);
        field_in_valor_vueltas.addKeyListener(new KeyAdapter() {
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
        field_in_valor_vueltas.addFocusListener(new FocusListener() {
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

        boton_generar.setBounds(25, 60, 150, 20);
        boton_generar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_generar.setForeground(color1);
        boton_generar.setBackground(color);
        boton_generar.setBorder(borde);
        boton_generar.addActionListener(this);
        boton_generar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                boton_generar.setBackground((color1));
                boton_generar.setForeground((color));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton_generar.setBackground((color));
                boton_generar.setForeground((color1));
            }
        });

        boton_procesar.setBounds(5, 40, 100, 15);
        boton_procesar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_procesar.setForeground(color1);
        boton_procesar.setBackground(color);
        boton_procesar.setBorder(borde);
        boton_procesar.addActionListener(this);
        boton_procesar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                boton_procesar.setBackground((color1));
                boton_procesar.setForeground((color));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton_procesar.setBackground((color));
                boton_procesar.setForeground((color1));
            }
        });

        boton_llenar.setBounds(110, 40, 100, 15);
        boton_llenar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_llenar.setForeground(color1);
        boton_llenar.setBackground(color);
        boton_llenar.setBorder(borde);
        boton_llenar.addActionListener(this);
        boton_llenar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                boton_llenar.setBackground((color1));
                boton_llenar.setForeground((color));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton_llenar.setBackground((color));
                boton_llenar.setForeground((color1));
            }
        });

        panel_peso_articulos.add(texto_in_num_monedas);
        panel_peso_articulos.add(texto_in_valor_vueltas);
        panel_peso_articulos.add(field_in_num_monedas);
        panel_peso_articulos.add(field_in_valor_vueltas);
        panel_peso_articulos.add(boton_generar);

        scroll_panel_precios_pesos.setBounds(210, 5, 500, 90);
        scroll_panel_precios_pesos.setVisible(false);
        scroll_panel_precios_pesos.setBorder(borde);
        scroll_panel_precios_pesos.getHorizontalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_panel_precios_pesos.getHorizontalScrollBar().setBackground(Color.BLACK);

        scroll_salida_total.setBounds(5, 100, 705, 410);
        scroll_salida_total.setVisible(false);
        scroll_salida_total.setBorder(borde);
        scroll_salida_total.getHorizontalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_salida_total.getHorizontalScrollBar().setBackground(Color.BLACK);

        add(scroll_panel_precios_pesos);
        add(scroll_salida_total);
        add(panel_peso_articulos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //////////////////////////////////BOTON GENERAR///////////////////////
        if (e.getSource() == boton_generar) {

            panel_pesos_precios = new JPanel();
            scroll_panel_precios_pesos.setViewportView(panel_pesos_precios);
            scroll_panel_precios_pesos.setVisible(true);
            panel_pesos_precios.setLayout(null);
            panel_pesos_precios.setBackground(color);
            panel_pesos_precios.add(boton_procesar);
            panel_pesos_precios.add(boton_llenar);

            panel_pesos_precios.setPreferredSize(new Dimension((Integer.parseInt(field_in_num_monedas.getText()) * 30) + 115, 90));

            texto_in_monedas = new JLabel();
            field_in_valores_monedas = new JTextField[Integer.parseInt(field_in_num_monedas.getText())];

            for (int x = 0; x < Integer.parseInt(field_in_num_monedas.getText()); x++) {
                field_in_valores_monedas[x] = new JTextField();

                panel_pesos_precios.add(field_in_valores_monedas[x]);

                field_in_valores_monedas[x].setBounds(80 + (30 * (x + 1)), 5, 30, 20);

                field_in_valores_monedas[x].setText(Integer.toString(x + 1));
                field_in_valores_monedas[x].setBackground(color1);
                field_in_valores_monedas[x].setForeground(Color.BLACK);
                field_in_valores_monedas[x].setBorder(borde);
                field_in_valores_monedas[x].addKeyListener(new KeyAdapter() {
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
                field_in_valores_monedas[x].addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        Object o = e.getSource();
                        if (o instanceof JTextField) {
                            JTextField field_in_valores_monedas = (JTextField) o;
                            field_in_valores_monedas.setSelectionStart(0);
                            field_in_valores_monedas.setSelectionEnd(field_in_valores_monedas.getText().length());
                            field_in_valores_monedas.setBackground(Color.BLACK);
                            field_in_valores_monedas.setForeground(color1);
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        Object o = e.getSource();
                        if (o instanceof JTextField) {
                            JTextField field_in_valores_monedas = (JTextField) o;
                            field_in_valores_monedas.setBackground(color1);
                            field_in_valores_monedas.setForeground(Color.BLACK);
                        }
                    }
                });
            }
            panel_pesos_precios.add(texto_in_monedas);
            texto_in_monedas.setBounds(5, -15 + (20 * (0 + 1)), 110, 20);
            //texto[y].setFont(fuente);
            texto_in_monedas.setForeground(color1);
            texto_in_monedas.setText("Denominaciones:");

        }////////BOTON GENERAR

        //////////////////BOTON PROCESAR////////////////
        if (e.getSource() == boton_procesar) {
            panel_salida_total = new JPanel();
            panel_salida_total.setBackground(color);
            panel_salida_total.setLayout(null);
            panel_salida_total.setBorder(borde);
            texto_out_final.setText("");
            panel_pesos_precios.add(texto_out_final);

            valor_vueltas = Integer.parseInt(field_in_valor_vueltas.getText());
            num_monedas = Integer.parseInt(field_in_num_monedas.getText());

            valores = new int[num_monedas];

            for (int i = 0; i < num_monedas; i++) {
                try {
                    valores[i] = Integer.parseInt(field_in_valores_monedas[i].getText());
                } catch (NumberFormatException excepcion) {
                    texto_out_final.setText("VALORES INVALIDOS!!!");
                }
            }

            int tmp;

            for (int i = 0; i < num_monedas; i++) {
                for (int j = i; j < num_monedas; j++) {
                    if (valores[i] > valores[j]) {
                        tmp = valores[i];
                        valores[i] = valores[j];
                        valores[j] = tmp;
                    }
                }
            }

            cantidad_valores.clear();
            cambio = new Cambio(valor_vueltas, valores);
            matriz_cambio = cambio.getMatrizCambio();
            cantidad_valores = cambio.getVectorSeleccion();
            cantidad_monedas = new String[num_monedas][valor_vueltas];

            for (int i = 0; i < num_monedas; i++) {
                for (int j = 0; j < valor_vueltas; j++) {
                    cantidad_monedas[i][j] = "0:0";
                }
            }

            int h = 0;
            for (int i = 0; i < num_monedas; i++) {
                for (int j = 0; j < valor_vueltas; j++) {
                    String cadena = "";
                    cadenaFinal = "";
                    for (int k = 0; k < num_monedas; k++) {
                        if (cantidad_valores.get(h)[k] != 0) {
                            cadena += (cantidad_valores.get(h)[k] + ":" + valores[k] + "+");
                            cadenaFinal += (cantidad_valores.get(h)[k] + " de " + valores[k] + " y ");
                        }
                    }
                    cadenaFinal = cadenaFinal.substring(0, cadenaFinal.length() - 2);
                    cadena = cadena.substring(0, cadena.length() - 1);
                    cantidad_monedas[i][j] = cadena;
                    h++;
                }
            }

            texto_out_final.setBounds(215, 40, 200, 15);
            texto_out_final.setForeground(color1);

            if (matriz_cambio[num_monedas][valor_vueltas] == 999999) {
                texto_out_final.setText("No se puede dar el cambio");
                scroll_salida_total.setVisible(false);
                update(this.getGraphics());
            } else {
                texto_out_final.setText(cadenaFinal);
                texto_out = new JLabel[num_monedas + 2][valor_vueltas + 2];
                for (int i = 0; i < num_monedas + 2; i++) {
                    for (int j = 0; j < valor_vueltas + 2; j++) {
                        texto_out[i][j] = new JLabel();

                        panel_salida_total.add(texto_out[i][j]);

                        if (i == 0 && j == 0) {
                            texto_out[i][j].setText("Valores");
                        } else if (i == 0) {
                            texto_out[i][j].setText(Integer.toString(j - 1));
                        } else if (j == 0 && i > 1) {
                            texto_out[i][j].setText("<html><div style='text-align: center;'><font color='red'>" + Integer.toString(valores[i - 2]) + "</font></div></html>");
                        } else if (i == 1 && j > 0) {
                            texto_out[i][j].setText("∞");
                        } else if (j == 1 && i > 0) {
                            //texto_out[i][j].setText("<html>0<p>0:0<html>");
                            texto_out[i][j].setText("0");
                        } else if (j > 1 && i > 1) {
                            if (matriz_cambio[i - 1][j - 1] == 999999) {
                                texto_out[i][j].setText("∞");
                            } else {
                                texto_out[i][j].setText("<html><div style='text-align: center;'>" + Integer.toString(matriz_cambio[i - 1][j - 1]) + "</div><p><font color='yellow'>" + cantidad_monedas[i - 2][j - 2] + "</font></p></html>");
                            }
                        }

                        if (tamaño_max_y < texto_out[i][j].getMinimumSize().getHeight()) {
                            tamaño_max_y = (int) texto_out[i][j].getMinimumSize().getHeight();
                        }
                        if (tamaño_max_x < texto_out[i][j].getMinimumSize().getWidth()) {
                            tamaño_max_x = (int) texto_out[i][j].getMinimumSize().getWidth();
                        }

                    }
                }
                for (int i = 0; i < num_monedas + 2; i++) {
                    for (int j = 0; j < valor_vueltas + 2; j++) {
                        texto_out[i][j].setBounds(5 - tamaño_max_x + ((tamaño_max_x + 2) * (j + 1)), 5 - tamaño_max_y + (tamaño_max_y * (i + 1)), tamaño_max_x + 3, tamaño_max_y);
                        texto_out[i][j].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
                        texto_out[i][j].setForeground(Color.WHITE);
                        texto_out[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                        if (i == 0 && j > 0) {
                            texto_out[i][j].setForeground(Color.CYAN);
                        }
                    }
                }
                scroll_salida_total.setViewportView(panel_salida_total);
                scroll_salida_total.setVisible(true);
                panel_salida_total.setPreferredSize(new Dimension((((valor_vueltas + 2) * (tamaño_max_x + 2)) + 15), ((num_monedas + 2) * (tamaño_max_y)) + 10));
            }
        }//Botno Procesar}

        /////////////////////////////////BOTON LLENAR///////////////////////
        if (e.getSource() == boton_llenar) {
            for (int x = 0; x < Integer.parseInt(field_in_num_monedas.getText()); x++) {
                field_in_valores_monedas[x].setText(Integer.toString((int) (Math.random() * (9)) + 1));
            }
        }/////////BOTON LLENAR
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

