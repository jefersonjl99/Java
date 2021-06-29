/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elproblemadelamochila;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.Border;

/**
 *
 * @author jefer
 */
public class ElProblemaDeLaMochila extends JFrame implements ActionListener {

    int num_articulos, peso_max, precios[], pesos[], salida[][], tamaño_max_x = 0, tamaño_max_y = 0, tamaño_max_x1 = 0, tamaño_max_y1 = 0, suma_pesos = 0;
    String[][] mtx;
    int[] contador;
    ArrayList<Integer> arr = new ArrayList<>();

    Color color = new Color(51, 51, 55);
    Color color1 = new Color(1, 153, 194);
    Color color_bordes = new Color(54, 155, 140);

    Border borde;

    Font fuente = new Font("TimesRoman", Font.BOLD, 10);

    JPanel panel_peso_articulos = new JPanel();
    JPanel panel_pesos_precios;
    JPanel panel_salida_total;
    JPanel panel_salida_final;

    JScrollPane scroll_panel_precios_pesos = new JScrollPane(panel_pesos_precios, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollPane scroll_salida_total = new JScrollPane(panel_salida_total, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JScrollPane scroll_salida_final = new JScrollPane(panel_salida_final, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JTextField field_in_peso_lim = new JTextField("2");
    JTextField field_in_num_articulos = new JTextField("4");
    JTextField[] field_in_pesos;
    JTextField[] field_in_precios;
    JLabel texto_in_peso_lim = new JLabel("Digite el peso limite:");
    JLabel texto_in_num_articulos = new JLabel("Digite el # de articulos: ");
    JLabel[] texto_in_pesos_precios;
    JLabel[][] texto_out;
    JLabel[][] texto_out1;

    JButton boton_generar = new JButton("Generar Campos");
    JButton boton_procesar = new JButton("Procesar");

    Mochila mochila = new Mochila();
    ImagenFondo imagenFondo = new ImagenFondo();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ElProblemaDeLaMochila obj = new ElProblemaDeLaMochila();
        obj.setSize(900, 550);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
    }

    public ElProblemaDeLaMochila() {
        super("ElProblemaDeLaMochila");
        setContentPane(imagenFondo);
        getContentPane().setLayout(null);
        setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\ElProblemaDeLaMochila\\src\\imagenes\\72f9c59cf2f33fadae72fcc61f8e691c-icono-de-mochila-camping-by-vexels.png").getImage());
        getRootPane().setBorder(BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.magenta, Color.BLUE));

        borde = BorderFactory.createSoftBevelBorder(1, Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.BLUE);

        panel_peso_articulos.setBackground(color);
        panel_peso_articulos.setForeground(color1);
        panel_peso_articulos.setBounds(5, 5, 200, 90);
        panel_peso_articulos.setBorder(borde);
        panel_peso_articulos.setLayout(null);

        texto_in_peso_lim.setBounds(5, 10, 150, 20);
        texto_in_peso_lim.setForeground(color1);
        texto_in_num_articulos.setBounds(5, 30, 150, 20);
        texto_in_num_articulos.setForeground(color1);

        field_in_peso_lim.setBounds(140, 10, 50, 20);
        field_in_peso_lim.setBackground(color1);
        field_in_peso_lim.setForeground(Color.BLACK);
        field_in_peso_lim.setBorder(borde);

        field_in_num_articulos.setBounds(140, 30, 50, 20);
        field_in_num_articulos.setBackground(color1);
        field_in_num_articulos.setForeground(Color.BLACK);
        field_in_num_articulos.setBorder(borde);

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

        boton_procesar.setBounds(5, 50, 100, 15);
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

        panel_peso_articulos.add(texto_in_peso_lim);
        panel_peso_articulos.add(texto_in_num_articulos);
        panel_peso_articulos.add(field_in_peso_lim);
        panel_peso_articulos.add(field_in_num_articulos);
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

        scroll_salida_final.setBounds(715, 5, 168, 505);
        scroll_salida_final.setVisible(false);
        scroll_salida_final.setBorder(borde);
        scroll_salida_final.getHorizontalScrollBar().setCursor(new Cursor(Cursor.HAND_CURSOR));
        scroll_salida_final.getHorizontalScrollBar().setBackground(Color.BLACK);

        add(scroll_panel_precios_pesos);
        add(scroll_salida_final);
        add(scroll_salida_total);
        add(panel_peso_articulos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton_generar) {

            panel_pesos_precios = new JPanel();
            scroll_panel_precios_pesos.setViewportView(panel_pesos_precios);
            scroll_panel_precios_pesos.setVisible(true);
            panel_pesos_precios.setLayout(null);
            panel_pesos_precios.setBackground(color);
            panel_pesos_precios.add(boton_procesar);

            panel_pesos_precios.setPreferredSize(new Dimension((Integer.parseInt(field_in_num_articulos.getText()) * 30) + 75, 90));

            texto_in_pesos_precios = new JLabel[2];
            field_in_pesos = new JTextField[Integer.parseInt(field_in_num_articulos.getText())];
            field_in_precios = new JTextField[Integer.parseInt(field_in_num_articulos.getText())];

            for (int x = 0; x < Integer.parseInt(field_in_num_articulos.getText()); x++) {
                field_in_pesos[x] = new JTextField();
                field_in_precios[x] = new JTextField();
                texto_in_pesos_precios[0] = new JLabel();
                texto_in_pesos_precios[1] = new JLabel();

                panel_pesos_precios.add(texto_in_pesos_precios[0]);
                panel_pesos_precios.add(texto_in_pesos_precios[1]);
                panel_pesos_precios.add(field_in_pesos[x]);
                panel_pesos_precios.add(field_in_precios[x]);

                field_in_pesos[x].setBounds(40 + (30 * (x + 1)), 5, 30, 20);
                field_in_precios[x].setBounds(40 + (30 * (x + 1)), 25, 30, 20);

                texto_in_pesos_precios[0].setBounds(5, -15 + (20 * (0 + 1)), 50, 20);
                texto_in_pesos_precios[1].setBounds(5, -15 + (20 * (1 + 1)), 50, 20);
                //texto[y].setFont(fuente);
                texto_in_pesos_precios[0].setForeground(color1);
                texto_in_pesos_precios[1].setForeground(color1);
                field_in_pesos[x].setText(Integer.toString(x + 1));
                field_in_pesos[x].setBackground(color1);
                field_in_pesos[x].setForeground(Color.BLACK);
                field_in_pesos[x].setBorder(borde);

                field_in_precios[x].setText(Integer.toString(x + 2));
                field_in_precios[x].setBackground(color1);
                field_in_precios[x].setForeground(Color.BLACK);
                field_in_precios[x].setBorder(borde);
            }

            texto_in_pesos_precios[0].setText("Pesos");
            texto_in_pesos_precios[1].setText("Precios");

        }

        if (e.getSource() == boton_procesar) {
            panel_salida_total = new JPanel();
            panel_salida_final = new JPanel();
            panel_salida_final.setBackground(color);
            panel_salida_final.setLayout(null);
            panel_salida_final.setBorder(borde);
            panel_salida_total.setBackground(color);
            panel_salida_total.setLayout(null);
            panel_salida_total.setBorder(borde);

            num_articulos = Integer.parseInt(field_in_num_articulos.getText());
            peso_max = Integer.parseInt(field_in_peso_lim.getText());

            salida = new int[num_articulos][peso_max + 1];

            pesos = new int[num_articulos];
            precios = new int[num_articulos];

            for (int i = 0; i < num_articulos; i++) {
                pesos[i] = Integer.parseInt(field_in_pesos[i].getText());
                precios[i] = Integer.parseInt(field_in_precios[i].getText());
            }

            int tmp;

            for (int i = 0; i < num_articulos; i++) {
                for (int j = i; j < num_articulos; j++) {
                    if (pesos[i] > pesos[j]) {
                        tmp = precios[i];
                        precios[i] = precios[j];
                        precios[j] = tmp;
                        tmp = pesos[i];
                        pesos[i] = pesos[j];
                        pesos[j] = tmp;
                    }
                }
            }

            for (int i = 0; i < num_articulos; i++) {
                for (int j = 0; j <= peso_max; j++) {
                    salida[i][j] = mochila.optimizarPeso(i, j, precios, pesos);
                }
            }

            GenerarMAtriz();

            texto_out = new JLabel[num_articulos + 1][peso_max + 4];
            for (int i = 0; i < num_articulos + 1; i++) {
                for (int j = 0; j < peso_max + 4; j++) {
                    texto_out[i][j] = new JLabel();

                    panel_salida_total.add(texto_out[i][j]);

                    if (i == 0 && j == 0) {
                        texto_out[i][j].setText("Articulo");
                    } else if (i == 0 && j == 1) {
                        texto_out[i][j].setText("Peso");
                    } else if (i == 0 && j == 2) {
                        texto_out[i][j].setText("Costo");
                    } else if (i == 0) {
                        texto_out[i][j].setText(Integer.toString(j - 3));
                    } else if (j == 0) {
                        texto_out[i][j].setText(Integer.toString(i));
                    } else if (j == 1) {
                        texto_out[i][j].setText(Integer.toString(pesos[i - 1]));
                    } else if (j == 2) {
                        texto_out[i][j].setText(Integer.toString(precios[i - 1]));
                    } else if (i > 0 && j > 2) {
                        texto_out[i][j].setText("<html>" + Integer.toString(salida[i - 1][j - 3]) + "<p><html>" + mtx[i][j - 3] + "");
                    }

                    if (tamaño_max_y < texto_out[i][j].getMinimumSize().getHeight()) {
                        tamaño_max_y = (int) texto_out[i][j].getMinimumSize().getHeight();
                    }
                    if (tamaño_max_x < texto_out[i][j].getMinimumSize().getWidth()) {
                        tamaño_max_x = (int) texto_out[i][j].getMinimumSize().getWidth();
                    }

                }
            }
            for (int i = 0; i < num_articulos + 1; i++) {
                for (int j = 0; j < peso_max + 4; j++) {
                    texto_out[i][j].setBounds(5 - tamaño_max_x + ((tamaño_max_x + 3) * (j + 1)), 5 - tamaño_max_y + (tamaño_max_y * (i + 1)), tamaño_max_x + 3, tamaño_max_y);
                    texto_out[i][j].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
                    texto_out[i][j].setForeground(Color.WHITE);
                    if (i == 0 && j > 2) {
                        texto_out[i][j].setForeground(Color.CYAN);
                    } else if (i > 0 && j == 1) {
                        texto_out[i][j].setForeground(Color.CYAN);
                    } else if (i > 0 && j == 2) {
                        texto_out[i][j].setForeground(Color.RED);
                    }
                }
            }

            texto_out1 = new JLabel[arr.size() + 1][3];
            for (int i = 0; i < arr.size() + 1; i++) {
                for (int j = 0; j < 3; j++) {
                    texto_out1[i][j] = new JLabel();

                    panel_salida_final.add(texto_out1[i][j]);

                    if (i == 0 && j == 0) {
                        texto_out1[i][j].setText("Articulo");
                    } else if (i == 0 && j == 1) {
                        texto_out1[i][j].setText("Peso");
                    } else if (i == 0 && j == 2) {
                        texto_out1[i][j].setText("Costo");
                    } else if (j == 0 && i < arr.size()) {
                        texto_out1[i][j].setText(Integer.toString(arr.get(i)));
                    } else if (j == 1 && i < arr.size()) {
                        texto_out1[i][j].setText(Integer.toString(pesos[arr.get(i) - 1]));
                    } else if (j == 2 && i < arr.size()) {
                        texto_out1[i][j].setText(Integer.toString(precios[arr.get(i) - 1]));
                    } else if (i == arr.size() && j == 1) {
                        texto_out1[i][j].setText(Integer.toString(suma_pesos));
                    } else if (i == arr.size() && j == 2) {
                        texto_out1[i][j].setText(Integer.toString(salida[num_articulos - 1][peso_max]));
                    }

                    if (tamaño_max_y1 < texto_out1[i][j].getMinimumSize().getHeight()) {
                        tamaño_max_y1 = (int) texto_out1[i][j].getMinimumSize().getHeight();
                    }
                    if (tamaño_max_x1 < texto_out1[i][j].getMinimumSize().getWidth()) {
                        tamaño_max_x1 = (int) texto_out1[i][j].getMinimumSize().getWidth();
                    }

                }
            }
            for (int i = 0; i < arr.size() + 1; i++) {
                for (int j = 0; j < 3; j++) {
                    texto_out1[i][j].setBounds(-tamaño_max_x1 + ((tamaño_max_x1 + 3) * (j + 1)), 5 - tamaño_max_y1 + (tamaño_max_y1 * (i + 1)), tamaño_max_x1 + 3, tamaño_max_y1);
                    texto_out1[i][j].setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
                    texto_out1[i][j].setForeground(Color.WHITE);
                    if (i == 0 && j > 2) {
                        texto_out1[i][j].setForeground(Color.CYAN);
                    } else if (i > 0 && j == 1) {
                        texto_out1[i][j].setForeground(Color.CYAN);
                    } else if (i > 0 && j == 2) {
                        texto_out1[i][j].setForeground(Color.RED);
                    }
                }
            }

            scroll_salida_final.setViewportView(panel_salida_final);
            scroll_salida_final.setVisible(true);
            panel_salida_final.setPreferredSize(new Dimension((3 * tamaño_max_x1), ((arr.size() + 1) * tamaño_max_y1) + 15));

            scroll_salida_total.setViewportView(panel_salida_total);
            scroll_salida_total.setVisible(true);
            panel_salida_total.setPreferredSize(new Dimension(((peso_max + 4) * (tamaño_max_x + 3)) + 20, ((num_articulos + 1) * tamaño_max_y) + 20));

        }
    }

    public void GenerarMAtriz() {
        int cP = num_articulos + 1;
        int cA = peso_max + 1;
        suma_pesos = 0;
        int[][] mal = new int[cP][cA];
        mtx = new String[cP][cA];
        int[] co = new int[cP - 1];
        contador = new int[cP - 1];
        String cad = "";
        char[] cadena = new char[0];
        arr.clear();

        for (int o = 0; o < cP - 1; o++) {
            co[o] = o + 1;
        }

        for (int i = 0; i < cP; i++) {

            for (int j = 0; j < cA; j++) {
                mtx[i][j] = "0:0";
            }
        }

        for (int i = 1; i < cP; i++) {
            for (int j = 1; j < cA; j++) {
                if (j - pesos[i - 1] >= 0) {
                    mal[i][j] = Math.max(mal[i - 1][j], mal[i - 1][j - pesos[i - 1]] + precios[i - 1]);
                    if (mal[i][j] == mal[i - 1][j]) {
                        mtx[i][j] = mtx[i - 1][j];
                        cadena = mtx[cP - 1][cA - 1].toCharArray();
                    } else {
                        cad = mtx[i - 1][j - pesos[i - 1]];
                        cad = cad + "+" + precios[i - 1] + ":" + co[i - 1];
                        mtx[i][j] = cad;
                        cadena = mtx[cP - 1][cA - 1].toCharArray();
                    }
                } else {
                    mal[i][j] = mal[i - 1][j];
                    mtx[i][j] = mtx[i - 1][j];
                    cadena = mtx[cP - 1][cA - 1].toCharArray();
                }
            }
        }

        for (int i = 2; i < cadena.length; i += 4) {
            arr.add(Integer.parseInt(Character.toString(cadena[i])));
        }

        for (int i = 0; i < arr.size(); i++) {
            suma_pesos += arr.get(i);
            System.out.print(arr.get(i));
        }
        System.out.println("");

    }

    ////////////////////////////////////////
    public int Minima_devolucion(int cantidad_devuelta, int[] monedas) {

        //Creamos la matriz de devoluciones
        int[][] matriz_cambio = new int[monedas.length + 1][cantidad_devuelta + 1];

        //Rellenamos la 1ª columna de ceros
        for (int i = 0; i < monedas.length; i++) {
            matriz_cambio[i][0] = 0;
        }

        //La 1ª fila menos la 1ª columna un número alto
        for (int j = 1; j <= cantidad_devuelta; j++) {
            matriz_cambio[0][j] = 999999;
        }

        for (int i = 1; i <= monedas.length; i++) {
            for (int j = 1; j <= cantidad_devuelta; j++) {
                if (monedas[i - 1] > j) {
                    //Si la moneda es superior a la cantidad a devolver
                    matriz_cambio[i][j] = matriz_cambio[i - 1][j];
                } else {
                    //Si la moneda no es superior a la cantidad a devolver

                    //Calcular cual es el mínimo de estas dos posiciones
                    int minimo = 0; //Guardaremos aquí el mínimo

                    if (matriz_cambio[i - 1][j] < matriz_cambio[i][j - monedas[i - 1]] + 1) {
                        minimo = matriz_cambio[i - 1][j];
                    } else {
                        minimo = matriz_cambio[i][j - monedas[i - 1]] + 1;
                    }
                    //Guardamos mínimo
                    matriz_cambio[i][j] = minimo;
                }
            }
        }

        return matriz_cambio[monedas.length][cantidad_devuelta];
    }
}

////////////////////////////////////////////////////////
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

