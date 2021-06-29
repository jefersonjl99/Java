/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notas;

/**
 *
 * @author jefer
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class Notas extends JFrame {

    int n = 5, rta = 0, fila;
    double valida, promedio=0;
    String registro="";

    ArrayList<ArrayList<String>> estudiantes = new ArrayList<>();

    
    Archivo archivo = new Archivo();

    Color color = new Color(50, 93, 127);

    Font fuente = new Font("TimesRoman", Font.BOLD, 25);

    JButton btn_agregar = new JButton("<html>Agregar<p>Estudiante<html>");
    JButton btn_obtener = new JButton("<html>Obtener Notas<p>del Estudiante<html>");
    JButton btn_cambiar = new JButton("<html>Cambiar<p>Notas<html>");
    JButton btn_mostrar = new JButton("<html>Mostrar Notas<html>");

    JLabel[] tecxto_label = new JLabel[n];
    JTextField[] leer = new JTextField[n];

    JLabel respuesta = new JLabel("");

    JLabel imagen = new JLabel();

    public static void main(String[] args) {
        Notas obj = new Notas();
        obj.setSize(500, 230);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }

    public Notas() {

        super("Notas");
        Container N = getContentPane();
        N.setLayout(null);
        N.setBackground(color);

        setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Notas\\src\\imagenes\\172-1724735_send-us-mail-imagenes-de-chulos-de-calificacion.png").getImage());

        N.add(imagen);
        imagen.setBounds(380, 20, 100, 100);
        ImageIcon imag = new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Notas\\src\\imagenes\\172-1724735_send-us-mail-imagenes-de-chulos-de-calificacion.png");
        Icon icon = new ImageIcon(imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icon);

        N.add(btn_agregar);
        N.add(btn_obtener);
        N.add(btn_cambiar);
        N.add(btn_mostrar);
        N.add(respuesta);

        btn_agregar.setBounds(10, 80, 100, 35);
        btn_obtener.setBounds(115, 80, 125, 35);
        btn_cambiar.setBounds(245, 80, 75, 35);
        btn_mostrar.setBounds(348, 150, 100, 35);
        respuesta.setBounds(10, 150, 400, 30);
        respuesta.setFont(fuente);
        respuesta.setForeground(Color.CYAN);
        
        btn_agregar.setBackground(Color.CYAN);
        btn_obtener.setBackground(Color.CYAN);
        btn_cambiar.setBackground(Color.CYAN);
        btn_mostrar.setBackground(Color.MAGENTA);

        btn_agregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_obtener.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_cambiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_mostrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        for (int i = 0; i < n; i++) {

            tecxto_label[i] = new JLabel("");
            leer[i] = new JTextField();

            N.add(tecxto_label[i]);
            tecxto_label[i].setBackground(null);

            N.add(leer[i]);
            leer[i].setBackground(Color.yellow);

            switch (i) {
                case 0:
                    tecxto_label[i].setBounds((60 * (i)) + 10, 20, 50, 20);
                    tecxto_label[i].setText("Codigo");
                    leer[i].setBounds((60 * (i)) + 10, 40, 60, 20);
                    leer[i].setText("2020");
                    break;
                case 1:
                    tecxto_label[i].setBounds((60 * (i) + 20), 20, 50, 20);
                    tecxto_label[i].setText("Nombre");
                    leer[i].setBounds((60 * (i)) + 20, 40, 100, 20);
                    leer[i].setText("jeferson");
                    break;
                default:
                    tecxto_label[i].setBounds((60 * (i) + 70), 20, 50, 20);
                    tecxto_label[i].setText("Nota #" + (i - 1));
                    leer[i].setBounds((60 * (i)) + 70, 40, 50, 20);
                    leer[i].setText("" + i);
                    break;
            }
        }

        archivo.leer(estudiantes);
        
        ActionListener oir = (ActionEvent e) -> {

            //Agregar
            if (e.getSource() == btn_agregar) {

                rta=0;
                registro="";
                promedio=0;
                ArrayList<String> estudiante = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    estudiante.add(leer[i].getText());
                }

                

                for (int i = 2; i < 5; i++) {
                    promedio+=Double.parseDouble(leer[i].getText());
                    if (validar_nota(leer[i].getText())) {
                        respuesta.setText("Error en nota " + (i - 1));
                        rta = 1;
                    }
                }

                if (rta == 0 && !existe_estudiante(leer[0].getText())) {
                    respuesta.setText(estudiante.get(0)+" Añadido");
                    estudiante.add(""+(promedio/3));
                    estudiantes.add(estudiante);
                    archivo.Ingresar(estudiantes);
                }else if(existe_estudiante(leer[0].getText())){
                    respuesta.setText("El estudiante "+estudiante.get(0)+" ya existe");
                }
                   
                                
                for (int i = 0; i < estudiantes.size(); i++) {
                    for (int j = 0; j < estudiante.size(); j++) {
                        System.out.print(estudiantes.get(i).get(j) + " ");
                    }
                    System.out.println("");
                }
                
                
            }//agregar

            //leer
            if (e.getSource() == btn_obtener) {

                for (int i = 0; i < estudiantes.size(); i++) {
                    if (estudiantes.get(i).get(0).equals(leer[0].getText())) {
                        for (int j = 0; j < n; j++) {
                            leer[j].setText(estudiantes.get(i).get(j));
                        }
                        respuesta.setText("Cargado");
                        fila=i;
                        break;
                    }else{
                        respuesta.setText("El estudiante no existe");
                    }
                }
            }//leer

            //cambiar
            if (e.getSource() == btn_cambiar) {
                
                rta=0;
                registro="";
                promedio=0;
                ArrayList<String> estudiante = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    if (i < 2) {
                        estudiante.add(estudiantes.get(fila).get(i));
                    } else {
                        estudiante.add(leer[i].getText());
                    }
                }
                
                

                for (int i = 2; i < 5; i++) {
                    
                    promedio+=Double.parseDouble(leer[i].getText());
                    if (validar_nota(leer[i].getText())) {
                        respuesta.setText("Error en nota " + (i - 1));
                        rta = 1;
                    }
                }

                if (rta == 0 && existe_estudiante(leer[0].getText())) {
                    respuesta.setText(estudiante.get(0)+" actualizado");
                    estudiante.add(""+(promedio/3));
                    estudiantes.set(fila,estudiante);
                    archivo.Ingresar(estudiantes);
                }else if(!existe_estudiante(leer[0].getText())){
                    respuesta.setText("El estudiante "+estudiante.get(0)+" no esta registrado");
                }
                   
                                
                for (int i = 0; i < estudiantes.size(); i++) {
                    for (int j = 0; j < estudiante.size(); j++) {
                        System.out.print(estudiantes.get(i).get(j) + " ");
                    }
                    System.out.println("");
                }
                
                
            }
            
            if(e.getSource()==btn_mostrar){
                
                JFnotas ventana2 = new JFnotas(estudiantes);
                ventana2.setVisible(true);
                
            }

        };
        btn_agregar.addActionListener(oir);
        btn_obtener.addActionListener(oir);
        btn_cambiar.addActionListener(oir);
        btn_mostrar.addActionListener(oir);
    }

    boolean existe_estudiante(String h) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).get(0).equals(h)) {
                return true;
            }
        }
        return false;
    }

    boolean validar_nota(String h) {

        valida = Double.parseDouble(h);
        return valida < 0 || valida > 5;
    }
}
