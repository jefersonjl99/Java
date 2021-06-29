/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author jefer
 */
public class Ajedrez extends JFrame {
    /*
     * @param args the command line arguments
     */
    JButton boton_caballo_negro = new JButton("Pintar caballo N");
    JButton boton_reina_negro = new JButton("Pintar reina N");
    JButton boton_rey_negro = new JButton("Pintar rey N");
    JButton boton_rey_blanco = new JButton("Pintar rey B");
    JButton boton_analizar_jugada = new JButton("Analizar Jugada");

    JTextArea[] textoPosicionX = new JTextArea[12];
    JTextArea[] textoPosicionY = new JTextArea[12];

    JTextField inPosicionX = new JTextField();
    JTextField inPosicionY = new JTextField();

    JLabel[][] posicion = new JLabel[12][12];
    JLabel respuesta = new JLabel("");

    Font fuente = new Font("Arial", Font.BOLD, 20);

    Coordinates posicionCaballo = new Coordinates(0, 0);
    Coordinates posicionReina = new Coordinates(0, 0);
    Coordinates posicionRey = new Coordinates(0, 0);
    Coordinates posicionReyB = new Coordinates(0, 0);

    int x = 0, y = 0;

    int[][] matriz = new int[12][12];

    Piezas p = new Piezas();


    public static void main(String[] args) {
        // TODO code application logic here
        Ajedrez obj = new Ajedrez();
        obj.setSize(600, 640);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
    }


    public Ajedrez() {
        super("Ajedrez");


        p.inicializar();

        Container a = getContentPane();
        a.setLayout(null);
        a.setBackground(Color.LIGHT_GRAY);


        a.add(inPosicionX);
        a.add(inPosicionY);
        a.add(boton_caballo_negro);
        a.add(boton_reina_negro);
        a.add(boton_rey_negro);
        a.add(boton_rey_blanco);
        a.add(respuesta);
        a.add(boton_analizar_jugada);

        inPosicionX.setBounds(10, 510, 50, 20);
        inPosicionY.setBounds(10, 540, 50, 20);
        inPosicionX.setText("0");
        inPosicionY.setText("0");

        respuesta.setBounds(70, 525, 450, 20);
        respuesta.setForeground(Color.red);
        respuesta.setFont(fuente);

        boton_caballo_negro.setSize(boton_caballo_negro.getMinimumSize());
        boton_caballo_negro.setBounds(10, 570, boton_caballo_negro.getWidth(), 20);
        boton_caballo_negro.setBackground(Color.black);
        boton_caballo_negro.setForeground(Color.white);
        boton_caballo_negro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_reina_negro.setSize(boton_reina_negro.getMinimumSize());
        boton_reina_negro.setBounds(10 + boton_caballo_negro.getWidth(), 570, boton_reina_negro.getWidth(), 20);
        boton_reina_negro.setBackground(Color.black);
        boton_reina_negro.setForeground(Color.white);
        boton_reina_negro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_rey_negro.setSize(boton_rey_negro.getMinimumSize());
        boton_rey_negro.setBounds(10 + boton_caballo_negro.getWidth() + boton_reina_negro.getWidth(), 570, boton_rey_negro.getWidth(), 20);
        boton_rey_negro.setBackground(Color.black);
        boton_rey_negro.setForeground(Color.white);
        boton_rey_negro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_rey_blanco.setSize(boton_rey_blanco.getMinimumSize());
        boton_rey_blanco.setBounds(10 + boton_caballo_negro.getWidth() + boton_reina_negro.getWidth() + boton_rey_negro.getWidth(), 570, boton_rey_blanco.getWidth(), 20);
        boton_rey_blanco.setBackground(Color.white);
        boton_rey_blanco.setForeground(Color.black);
        boton_rey_blanco.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton_analizar_jugada.setSize(boton_analizar_jugada.getMinimumSize());
        boton_analizar_jugada.setBounds(10 + boton_caballo_negro.getWidth() + boton_reina_negro.getWidth() + boton_rey_negro.getWidth() + boton_rey_blanco.getWidth(), 570, boton_analizar_jugada.getWidth(), 20);
        boton_analizar_jugada.setBackground(Color.red);
        boton_analizar_jugada.setForeground(Color.white);
        boton_analizar_jugada.setCursor(new Cursor(Cursor.HAND_CURSOR));


        //Creacion e inicializacion de la Matriz LABBEL
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {

                posicion[i][j] = new JLabel("", SwingConstants.CENTER);

                a.add(posicion[i][j]);

                posicion[i][j].setBounds(50 * i, -50 + 50 * j, 50, 50);

                if (i < 8 && j < 8) {
                    textoPosicionX[j] = new JTextArea("" + (j + 1));
                    textoPosicionY[i] = new JTextArea("" + (i + 1));

                    a.add(textoPosicionX[j]);
                    a.add(textoPosicionY[i]);

                    textoPosicionX[j].setBounds(120 + 50 * j, 35, 10, 15);
                    textoPosicionY[i].setBounds(90, 70 + 50 * i, 10, 15);
                    textoPosicionX[j].setEditable(false);
                    textoPosicionX[j].setBackground(null);
                    textoPosicionX[j].setForeground(Color.BLACK);
                    textoPosicionY[i].setEditable(false);
                    textoPosicionY[i].setBackground(null);
                    textoPosicionY[i].setForeground(Color.BLACK);
                }
                posicion[i][j].setText(null);
                if (i == j || (i + 2) == j || (i + 4) == j || (i + 6) == j || (j + 2) == i || (j + 4) == i || (j + 6) == i) {
                    posicion[i][j].setBackground(Color.darkGray);
                    posicion[i][j].setOpaque(true);
                }
                if ((i + 1) == j || (i + 3) == j || (i + 5) == j || (i + 7) == j || (j + 1) == i || (j + 3) == i || (j + 5) == i || (j + 7) == i) {
                    posicion[i][j].setBackground(Color.white);
                    posicion[i][j].setOpaque(true);
                }
                if (i < 2 || j < 2 || i > 9 || j > 9) {
                    posicion[i][j].setVisible(false);
                    posicion[i][j].setOpaque(false);

                }
            }
        }//fin  Creacion e inicializacion de la Matriz LABBEL


        ActionListener oir = (ActionEvent e) ->
        {


            //BOTON CABALLO NEGRO
            if (e.getSource() == boton_caballo_negro) {
                //Obtine las coordenadas ingresadas
                x = Integer.parseInt(inPosicionX.getText()) + 1;
                y = Integer.parseInt(inPosicionY.getText()) + 1;


                //Si las coordenadas existen
                if (x >= 2 && y >= 2 && x < 10 && y < 10) {

                    //Analiza si ya esta la ficha y la borra
                    matriz = p.obtener_fichas();
                    for (int i = 0; i < 12; i++) {
                        for (int j = 0; j < 12; j++) {
                            if (matriz[i][j] == 14) {
                                posicion[i][j].setIcon(null);
                            }
                        }
                    }

                    //Cambia el icono en la posicion digitada
                    ImageIcon imagen = new ImageIcon("C:\\Users\\jefer\\OneDrive\\Imágenes\\caballoB.png");
                    Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(posicion[x][y].getWidth(), posicion[x][y].getHeight(), Image.SCALE_DEFAULT));
                    posicion[x][y].setIcon(icon);
                    posicionCaballo.x = x;
                    posicionCaballo.y = y;
                    p.m_caballo_negro(posicionCaballo);
                } else {
                    respuesta.setText("Coordenadas invalidas");
                }
            }//Fin botn Caballo


            //BOTON REINA NEGRA
            else if (e.getSource() == boton_reina_negro) {
                //Obtine las coordenadas ingresadas
                x = Integer.parseInt(inPosicionX.getText()) + 1;
                y = Integer.parseInt(inPosicionY.getText()) + 1;


                //Si las coordenadas existen
                if (x >= 2 && y >= 2 && x < 10 && y < 10) {

                    //Analiza si ya esta la ficha y la borra
                    matriz = p.obtener_fichas();
                    for (int i = 0; i < 12; i++) {
                        for (int j = 0; j < 12; j++) {
                            if (matriz[i][j] == 12) {
                                posicion[i][j].setIcon(null);
                            }
                        }
                    }

                    //Cambia el icono en la posicion digitada
                    ImageIcon imagen = new ImageIcon("C:\\Users\\jefer\\OneDrive\\Imágenes\\reinaB.png");
                    Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(posicion[x][y].getWidth(), posicion[x][y].getHeight(), Image.SCALE_DEFAULT));
                    posicion[x][y].setIcon(icon);
                    posicionReina.x = x;
                    posicionReina.y = y;
                    p.m_reina_negra(posicionReina);
                } else {
                    respuesta.setText("Coordenadas invalidas");
                }
            }//FIN BOTON REINA NEGRA


            //BOTON REY NEGRO
            else if (e.getSource() == boton_rey_negro) {
                //Obtine las coordenadas ingresadas
                x = Integer.parseInt(inPosicionX.getText()) + 1;
                y = Integer.parseInt(inPosicionY.getText()) + 1;


                //Si las coordenadas existen
                if (x >= 2 && y >= 2 && x < 10 && y < 10) {

                    //Analiza si ya esta la ficha y la borra
                    matriz = p.obtener_fichas();
                    for (int i = 0; i < 12; i++) {
                        for (int j = 0; j < 12; j++) {
                            if (matriz[i][j] == 11) {
                                posicion[i][j].setIcon(null);
                            }
                        }
                    }

                    //Cambia el icono en la posicion digitada
                    ImageIcon imagen = new ImageIcon("C:\\Users\\jefer\\OneDrive\\Imágenes\\reyB.png");
                    Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(posicion[x][y].getWidth(), posicion[x][y].getHeight(), Image.SCALE_DEFAULT));
                    posicion[x][y].setIcon(icon);
                    posicionRey.x = x;
                    posicionRey.y = y;
                    p.m_rey_negro(posicionRey);
                } else {
                    respuesta.setText("Coordenadas invalidas");
                }
            }//FIN BOTON REY NEGRO


            //BOTON REY BLANCO
            else if (e.getSource() == boton_rey_blanco) {
                //Obtine las coordenadas ingresadas
                x = Integer.parseInt(inPosicionX.getText()) + 1;
                y = Integer.parseInt(inPosicionY.getText()) + 1;

                //Si las coordenadas existen
                if (x >= 2 && y >= 2 && x < 10 && y < 10) {

                    //Analiza si ya esta la ficha y la borra
                    matriz = p.obtener_fichas();
                    for (int i = 0; i < 12; i++) {
                        for (int j = 0; j < 12; j++) {
                            if (matriz[i][j] == 21) {
                                posicion[i][j].setIcon(null);
                            }
                        }
                    }

                    //Cambia el icono en la posicion digitada
                    ImageIcon imagen = new ImageIcon("C:\\Users\\jefer\\OneDrive\\Imágenes\\reyW.png");
                    Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(posicion[x][y].getWidth(), posicion[x][y].getHeight(), Image.SCALE_DEFAULT));
                    posicion[x][y].setIcon(icon);
                    posicionReyB.x = x;
                    posicionReyB.y = y;
                    p.m_rey_blanco(posicionReyB);
                } else {
                    respuesta.setText("Coordenadas invalidas");
                }
            }//FIN BOTON REY BLANCO


            //BOTON ANALIZAR JUGADA
            else if (e.getSource() == boton_analizar_jugada) {


                p.m_imprima();
                p.obtener_fichas();
                respuesta.setText("" + p.estado_rey_blanco(posicionReyB));


            }//FIN BOTON ANALIZAR JUGADA

        };//FIN ACCTION EVENT

        boton_caballo_negro.addActionListener(oir);
        boton_reina_negro.addActionListener(oir);
        boton_rey_negro.addActionListener(oir);
        boton_rey_blanco.addActionListener(oir);
        boton_analizar_jugada.addActionListener(oir);

    }//FIN CONSTRUCTOR

}//FIN CLASE
