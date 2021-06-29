/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

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
public class Alumnos extends JFrame {

    int n = 4, fila;

    ArrayList<ArrayList<String>> estudiantes = new ArrayList<>();
    ArrayList<String> estudiante = new ArrayList<>();

    Agregar agregar = new Agregar();
    Borrar borrar = new Borrar();
    Grabar grabar = new Grabar();
    Leer leer = new Leer();
    CambiarDatos cambiarDatos = new CambiarDatos();
    ConsultarAlumno consultarAlumno = new ConsultarAlumno();
    MostrarDatos mostrarDatos = new MostrarDatos();
    MostrarFotos mostrarFotos = new MostrarFotos();

    Color color = new Color(50, 93, 127);

    Font fuente = new Font("TimesRoman", Font.BOLD, 25);

    JButton btn_agregar = new JButton("<html>Agregar<p>Estudiante<html>");
    JButton btn_obtener = new JButton("<html>Obtener Datos<p>del Estudiante<html>");
    JButton btn_cambiar = new JButton("<html>Cambiar<p>Datos<html>");
    JButton btn_borrar = new JButton("<html>Borrar<p>Datos<html>");
    JButton btn_mostrar = new JButton("<html>Mostrar Estudiante<html>");
    JButton btn_mostrar_todos = new JButton("<html>Mostrar Datos<html>");
    JButton btn_mostrar_fotos = new JButton("<html>Mostrar Fotos<html>");

    JLabel[] texto_label = new JLabel[n];
    JTextField[] leer_txtfield = new JTextField[n];

    JLabel respuesta = new JLabel("");

    JLabel imagen = new JLabel();

    public static void main(String[] args) {
        Alumnos obj = new Alumnos();
        obj.setSize(565, 270);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }

    public Alumnos() {

        super("Alumnos");
        Container N = getContentPane();
        N.setLayout(null);
        N.setBackground(color);

        setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Notas\\src\\imagenes\\172-1724735_send-us-mail-imagenes-de-chulos-de-calificacion.png").getImage());

        N.add(imagen);
        imagen.setBounds(435, 20, 100, 100);
        ImageIcon imag = new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Notas\\src\\imagenes\\172-1724735_send-us-mail-imagenes-de-chulos-de-calificacion.png");
        Icon icon = new ImageIcon(imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icon);

        N.add(btn_agregar);
        N.add(btn_obtener);
        N.add(btn_cambiar);
        N.add(btn_borrar);
        N.add(btn_mostrar);
        N.add(btn_mostrar_todos);
        N.add(btn_mostrar_fotos);
        N.add(respuesta);

        btn_agregar.setBounds(10, 80, 100, 35);
        btn_obtener.setBounds(115, 80, 125, 35);
        btn_cambiar.setBounds(245, 80, 75, 35);
        btn_borrar.setBounds(325, 80, 75, 35);
        btn_mostrar.setBounds(415, 145, 100, 35);
        btn_mostrar_todos.setBounds(415, 185, 120, 20);
        btn_mostrar_fotos.setBounds(415, 210, 120, 20);
        respuesta.setBounds(10, 150, 400, 60);
        respuesta.setFont(fuente);
        respuesta.setForeground(Color.CYAN);

        btn_agregar.setBackground(Color.CYAN);
        btn_obtener.setBackground(Color.CYAN);
        btn_cambiar.setBackground(Color.CYAN);
        btn_borrar.setBackground(Color.CYAN);
        btn_mostrar.setBackground(Color.CYAN);
        btn_mostrar_todos.setBackground(Color.MAGENTA);
        btn_mostrar_fotos.setBackground(Color.MAGENTA);

        btn_agregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_obtener.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_cambiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_borrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_mostrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_mostrar_todos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_mostrar_fotos.setCursor(new Cursor(Cursor.HAND_CURSOR));

        for (int i = 0; i < n; i++) {

            texto_label[i] = new JLabel("");
            leer_txtfield[i] = new JTextField();

            N.add(texto_label[i]);
            texto_label[i].setBackground(null);

            N.add(leer_txtfield[i]);
            leer_txtfield[i].setBackground(Color.yellow);

            switch (i) {
                case 0:
                    texto_label[i].setBounds((60 * (i)) + 10, 20, 50, 20);
                    texto_label[i].setText("Codigo");
                    leer_txtfield[i].setBounds((60 * (i)) + 10, 40, 60, 20);
                    leer_txtfield[i].setText("2020");
                    break;
                case 1:
                    texto_label[i].setBounds((60 * (i) + 20), 20, 50, 20);
                    texto_label[i].setText("Nombre");
                    leer_txtfield[i].setBounds((60 * (i)) + 20, 40, 100, 20);
                    leer_txtfield[i].setText("jeferson");
                    break;
                case 2:
                    texto_label[i].setBounds((60 * (i) + 70), 20, 50, 20);
                    texto_label[i].setText("Edad");
                    leer_txtfield[i].setBounds((60 * (i)) + 70, 40, 50, 20);
                    leer_txtfield[i].setText("18");
                    break;
                default:
                    texto_label[i].setBounds((60 * (i) + 70), 20, 100, 20);
                    texto_label[i].setText("Nombre Foto");
                    leer_txtfield[i].setBounds((60 * (i)) + 70, 40, 110, 20);
                    leer_txtfield[i].setText("jeferson.jpg");
                    break;
            }
        }

        leer.accion(estudiantes, estudiante, n);

        //Acciones
        ActionListener oir = (ActionEvent e) -> {

            //Agregar
            if (e.getSource() == btn_agregar) {

                estudiante = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    estudiante.add(leer_txtfield[i].getText());
                }

                if (!existe_estudiante(leer_txtfield[0].getText())) {

                    respuesta.setText(estudiante.get(0) + " Añadido");
                    agregar.accion(estudiantes, estudiante, n);
                    grabar.accion(estudiantes, estudiante, n);

                } else if (existe_estudiante(leer_txtfield[0].getText())) {

                    respuesta.setText("El estudiante " + estudiante.get(0) + " ya existe");

                }

                //muestra el arraylist
                System.out.println("");
                for (int i = 0; i < estudiantes.size(); i++) {
                    for (int j = 0; j < estudiante.size(); j++) {
                        System.out.print(estudiantes.get(i).get(j) + " ");
                    }
                    System.out.println("");
                }

            }//agregar

            //leer
            if (e.getSource() == btn_obtener) {

                if (existe_estudiante(leer_txtfield[0].getText())) {

                    //carga el array en el txtfield segun el codigo
                    for (int j = 0; j < n; j++) {
                        leer_txtfield[j].setText(estudiantes.get(fila).get(j));
                    }
                    respuesta.setText("Cargado");
                    
                } else {

                    respuesta.setText("<html>El estudiante <html>" + leer_txtfield[0].getText() + "<p>no esta registrado");

                }

                //muestra el arraylist
                System.out.println("");
                for (int i = 0; i < estudiantes.size(); i++) {
                    for (int j = 0; j < estudiante.size(); j++) {
                        System.out.print(estudiantes.get(i).get(j) + " ");
                    }
                    System.out.println("");
                }

            }//leer

            //cambiar
            if (e.getSource() == btn_cambiar) {

                estudiante = new ArrayList<>();

                if (existe_estudiante(leer_txtfield[0].getText())) {

                    for (int i = 0; i < n; i++) {
                        if (i < 2) {
                            estudiante.add(estudiantes.get(fila).get(i));
                        } else {
                            estudiante.add(leer_txtfield[i].getText());
                        }
                    }

                    respuesta.setText(estudiante.get(0) + " actualizado");
                    cambiarDatos.accion(estudiantes, estudiante, n);
                    grabar.accion(estudiantes, estudiante, n);

                } else {

                    respuesta.setText("<html>El estudiante <html>" + leer_txtfield[0].getText() + "<p>no esta registrado");

                }

                //muestra el arraylist
                System.out.println("");
                for (int i = 0; i < estudiantes.size(); i++) {
                    for (int j = 0; j < estudiante.size(); j++) {
                        System.out.print(estudiantes.get(i).get(j) + " ");
                    }
                    System.out.println("");
                }

            }//cambiar

            //borrar
            if (e.getSource() == btn_borrar) {

                estudiante = new ArrayList<>();

                if (existe_estudiante(leer_txtfield[0].getText())) {

                    for (int i = 0; i < n; i++) {
                        if (i < 2) {
                            estudiante.add(estudiantes.get(fila).get(i));
                        } else {
                            estudiante.add(leer_txtfield[i].getText());
                        }
                    }

                    respuesta.setText(estudiante.get(0) + " eliminado");
                    borrar.accion(estudiantes, estudiante, fila);
                    grabar.accion(estudiantes, estudiante, n);

                } else {

                    respuesta.setText("<html>El estudiante <html>" + leer_txtfield[0].getText() + "<p>no esta registrado");

                }

                //muestra el arraylist
                System.out.println("");
                for (int i = 0; i < estudiantes.size(); i++) {
                    for (int j = 0; j < estudiante.size(); j++) {
                        System.out.print(estudiantes.get(i).get(j) + " ");
                    }
                    System.out.println("");
                }

            }//borrar

            //mostrar estudiante
            if (e.getSource() == btn_mostrar) {
                
                estudiante = new ArrayList<>();

                estudiante.add(leer_txtfield[0].getText());
                System.out.println("");
                System.out.println(estudiante);

                if (existe_estudiante(leer_txtfield[0].getText())) {
                    consultarAlumno.accion(estudiantes, estudiante, n);
                } else if (!existe_estudiante(leer_txtfield[0].getText())) {
                    respuesta.setText("El estudiante " + estudiante.get(0) + " no esta registrado");
                }

            }//mostrar estudiante

            //Mostrartodos
            if (e.getSource() == btn_mostrar_todos) {

                mostrarDatos.accion(estudiantes, estudiante, n);

            }//Mostrartodos

            //mostrarfotos
            if (e.getSource() == btn_mostrar_fotos) {

                mostrarFotos.accion(estudiantes, estudiante, n);

            }//mostrarfotos

        };
        btn_agregar.addActionListener(oir);
        btn_obtener.addActionListener(oir);
        btn_cambiar.addActionListener(oir);
        btn_borrar.addActionListener(oir);
        btn_mostrar.addActionListener(oir);
        btn_mostrar_todos.addActionListener(oir);
        btn_mostrar_fotos.addActionListener(oir);

    }

    //funcion eviste estudiante
    boolean existe_estudiante(String h) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).get(0).equals(h)) {
                fila = i;
                return true;
            }
        }
        return false;
    }
}
