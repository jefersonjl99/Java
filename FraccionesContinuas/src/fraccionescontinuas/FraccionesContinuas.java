/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraccionescontinuas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class FraccionesContinuas extends JFrame {

    /**
     * @param args the command line arguments
     */
    int numerador, denominador, i;
    int[] cocientes = new int[32];

    Composicion obj_composicion = new Composicion();

    JTextField inNumerador = new JTextField("197");
    JTextField inDenominador = new JTextField("29");

    JTextArea txt_respuesta = new JTextArea(50, 30);
    JScrollPane deslizador = new JScrollPane(txt_respuesta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JLabel txt_divisor = new JLabel("_______");

    Color color = new Color(50, 93, 127);
    Color color1 = new Color(41, 53, 59);
    
    String newline = "\n";

    JButton btn_hacerArreglo = new JButton("Calcular Arreglo");
    JButton btn_mostrar = new JButton("Mostrar Igualdad");
    JButton btn_calcular = new JButton("Calcular mediente el Arreglo");

    JLabel lb_resultado = new JLabel("<html>ome gonoreea<p> home<html>");

    public static void main(String[] args) {
        // TODO code application logic here
        FraccionesContinuas obj = new FraccionesContinuas();
        obj.setSize(500, 540);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }

    public FraccionesContinuas() {
        super("Fracciones Continuas");
        Container f = getContentPane();
        f.setLayout(null);
        f.setBackground(color);

        f.add(inNumerador);
        f.add(inDenominador);
        f.add(txt_divisor);
        f.add(btn_hacerArreglo);
        f.add(btn_mostrar);
        f.add(btn_calcular);
        f.add(lb_resultado);
        f.add(deslizador);

        inNumerador.setBounds(50, 25, 50, 20);
        inDenominador.setBounds(50, 55, 50, 20);
        txt_divisor.setBounds(50, 37, 50, 15);
        btn_hacerArreglo.setBounds(120, 20, 200, 20);
        btn_mostrar.setBounds(120, 40, 200, 20);
        btn_calcular.setBounds(120, 60, 200, 20);
        
        btn_hacerArreglo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_mostrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_calcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        deslizador.setBounds(50, 100, 400, 400);
        txt_divisor.setBackground(null);
        
        txt_respuesta.setEditable(false);
        txt_respuesta.setBackground(color1);
        txt_respuesta.setForeground(Color.WHITE);

        ActionListener oir = (ActionEvent e) -> {
            //Hacer el arreglo de cocientes
            if (e.getSource() == btn_hacerArreglo) {
                txt_respuesta.setText("");
                
                
                numerador = Integer.parseInt(inNumerador.getText());
                denominador = Integer.parseInt(inDenominador.getText());

                obj_composicion.enviar(numerador, denominador);
                i = obj_composicion.fracciones.calcular_arreglo(cocientes);

                txt_respuesta.append("   Cocientes: ");
                for (int j = 0; j < i; j++) {
                    System.out.print(cocientes[j]);
                    txt_respuesta.append(""+cocientes[j]);
                    if(j<i-1){
                        System.out.print(", ");
                        txt_respuesta.append(", ");
                    }
                }txt_respuesta.append(newline);System.out.println("");
            }//Hacer el arreglo de cocientes

            //Mostrar el arreglo
            if (e.getSource() == btn_mostrar) {

                txt_respuesta.setText("");
                
                numerador = Integer.parseInt(inNumerador.getText());
                denominador = Integer.parseInt(inDenominador.getText());

                obj_composicion.enviar(numerador, denominador);
                i = obj_composicion.fracciones.calcular_arreglo(cocientes);
                
                
                txt_respuesta.append("  "+Integer.toString(numerador)+newline);
                txt_respuesta.append(" ------- = "+cocientes[0]+" + 1"+newline);
                txt_respuesta.append("  "+Integer.toString(denominador)+"              ------"+newline); 
                for (int j = 1; j < i; j++) {
                    for(int k=0;k<j;k++){
                        if(k==0){
                            txt_respuesta.append("              ");
                        }
                        txt_respuesta.append("       ");
                    }
                    txt_respuesta.append(cocientes[j]+" + 1" + newline);
                    if(j<i-1){
                        for(int k=0;k<j;k++){
                        if(k==0){
                            txt_respuesta.append("                    ");
                        }
                        txt_respuesta.append("       ");
                    }
                    txt_respuesta.append("--------"+newline);
                    }
                }

            }//Mostrar el arreglo

            //Calcula el cociente mediente el arreglo
            if (e.getSource() == btn_calcular) {

                txt_respuesta.setText("");
                
                numerador = Integer.parseInt(inNumerador.getText());
                denominador = Integer.parseInt(inDenominador.getText());

                obj_composicion.enviar(numerador, denominador);
                
                double salida=obj_composicion.fracciones.calcular_cociente(cocientes);
                
                System.out.println("Cociente: " +salida);
                
                txt_respuesta.append("  "+Integer.toString(numerador)+newline);
                txt_respuesta.append(" ------- = "+salida+newline);
                txt_respuesta.append("  "+Integer.toString(denominador));
            }//Calcula el cociente mediente el arreglo
        };
        btn_hacerArreglo.addActionListener(oir);
        btn_mostrar.addActionListener(oir);
        btn_calcular.addActionListener(oir);
    }
}

/*

if (orden < 9) {
                        texto2.append("0" + (orden + 1) + " - " + texto + newline);
                    } else if (orden >= 9) {
                        texto2.append((orden + 1) + " - " + texto + newline);
                    }
                    // posicionarse siempre en la ultima linea de JTExtArea
 */
