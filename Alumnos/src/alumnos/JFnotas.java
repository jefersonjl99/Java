/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author jefer
 */
public class JFnotas extends JFrame {

    int h = 0, tmp;
    int[] a;
    
    

    JTextArea txt_respuesta = new JTextArea(50, 30);
    JScrollPane deslizador = new JScrollPane(txt_respuesta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    Grabar grabar = new Grabar();
    Leer leer = new Leer();
    CambiarDatos cambiarDatos = new CambiarDatos();
    ConsultarAlumno consultarAlumno = new ConsultarAlumno();
    MostrarFotos mostrarFotos = new MostrarFotos();

    JLabel imagen = new JLabel();
    JLabel datos = new JLabel();

    ImageIcon imag;
    Icon icon;

    JButton anterior = new JButton("<<");
    JButton siguiente = new JButton(">>");

    String newline = "\n", registro = "";

    Color color = new Color(50, 93, 127);

    public JFnotas(ArrayList<ArrayList<String>> estudiantes, ArrayList<String> estudiante, int n, int opcion) {
        
        setTitle("Notas");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusableWindowState(false);
        
        
        Container N = getContentPane();
        N.setLayout(null);
        N.setBackground(color);

        txt_respuesta.setBackground(Color.WHITE);
        txt_respuesta.setEditable(false);
        txt_respuesta.setForeground(Color.BLACK);

        switch (opcion) {
            case 0:

                setTitle(estudiante.get(1));
                setSize(220, 300);
                setLocationRelativeTo(null);
                setResizable(false);

                N.add(imagen);
                N.add(datos);

                datos.setBounds(10, 210, 100, 60);
                imagen.setBounds(5, 5, 200, 200);

                System.out.println(estudiante.get(3));
                imag = new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Alumnos\\src\\imagenes\\" + estudiante.get(3));
                icon = new ImageIcon(imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));

                imagen.setIcon(icon);
                datos.setText("<html>" + estudiante.get(1) + "<p>Codigo: <html>" + estudiante.get(0) + "<p>Edad: " + estudiante.get(2));

                break;

            case 1:

                N.add(deslizador);
                deslizador.setBounds(0, 0, 490, 470);

                for (int i = 0; i < estudiantes.size(); i++) {
                    registro = "";
                    for (int j = 0; j < n; j++) {
                        switch (j) {
                            case 0:
                                registro += "Codigo: " + estudiantes.get(i).get(j);
                                break;
                            case 1:
                                registro += "     Nombre: " + estudiantes.get(i).get(j);
                                break;
                            case 2:
                                registro += "    Edad: " + estudiantes.get(i).get(j);
                                break;
                            case 3:
                                registro += "    Foto: " + estudiantes.get(i).get(j);
                                break;
                            default:
                                break;
                        }

                    }
                    txt_respuesta.append(registro + newline);
                }

                break;

            case 2:

                a = new int[estudiantes.size()];
                int[] b = new int[estudiantes.size()];
                tmp = 0;

                for (int i = 0; i < estudiantes.size(); i++) {
                    a[i] = i;
                    b[i] = Integer.parseInt(estudiantes.get(i).get(2));
                }

                for (int i = 0; i < a.length; i++) {
                    System.out.println(a[i]);
                }
                System.out.println("");

                for (int i = 0; i < estudiantes.size(); i++) {
                    for (int j = i; j < estudiantes.size(); j++) {
                        if (b[i] < b[j]) {
                            tmp = a[i];
                            a[i] = a[j];
                            a[j] = tmp;
                            tmp = b[i];
                            b[i] = b[j];
                            b[j] = tmp;
                        }
                    }
                }

                for (int i = 0; i < a.length; i++) {
                    System.out.println(a[i]);
                }

                setTitle(estudiantes.get(a[0]).get(1));
                setSize(220, 350);
                setLocationRelativeTo(null);
                setResizable(false);

                N.add(imagen);
                N.add(datos);
                N.add(anterior);
                N.add(siguiente);

                anterior.setBounds(10, 280, 50, 20);
                siguiente.setBounds(150, 280, 50, 20);
                datos.setBounds(10, 210, 100, 60);
                imagen.setBounds(5, 5, 200, 200);

                if (h == 0) {
                    anterior.setEnabled(false);
                }

                imag = new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Alumnos\\src\\imagenes\\" + estudiantes.get(a[0]).get(3));
                icon = new ImageIcon(imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));

                imagen.setIcon(icon);
                datos.setText("<html>" + estudiantes.get(a[0]).get(1) + "<p>Codigo: <html>" + estudiantes.get(a[0]).get(0) + "<p>Edad: " + estudiantes.get(a[0]).get(2));

                //Acciones
                ActionListener oir = (ActionEvent e) -> {

                    if (e.getSource() == anterior) {

                        if (h <= estudiantes.size() - 1) {
                            siguiente.setEnabled(true);
                        }

                        if (h <= 1) {
                            anterior.setEnabled(false);
                            h--;
                        } else {
                            anterior.setEnabled(true);
                            h--;
                        }
                        setTitle(estudiantes.get(a[h]).get(1));
                        imag = new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Alumnos\\src\\imagenes\\" + estudiantes.get(a[h]).get(3));
                        icon = new ImageIcon(imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
                        imagen.setIcon(icon);
                        datos.setText("<html>" + estudiantes.get(a[h]).get(1) + "<p>Codigo: <html>" + estudiantes.get(a[h]).get(0) + "<p>Edad: " + estudiantes.get(a[h]).get(2));

                    }

                    if (e.getSource() == siguiente) {

                        if (h >= 0) {
                            anterior.setEnabled(true);
                        }

                        if (h < estudiantes.size() - 2) {
                            siguiente.setEnabled(true);
                            h++;

                        } else {
                            siguiente.setEnabled(false);

                            h++;
                        }

                        setTitle(estudiantes.get(a[h]).get(1));
                        imag = new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Alumnos\\src\\imagenes\\" + estudiantes.get(a[h]).get(3));
                        icon = new ImageIcon(imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
                        imagen.setIcon(icon);
                        datos.setText("<html>" + estudiantes.get(a[h]).get(1) + "<p>Codigo: <html>" + estudiantes.get(a[h]).get(0) + "<p>Edad: " + estudiantes.get(a[h]).get(2));

                    }

                };
                anterior.addActionListener(oir);
                siguiente.addActionListener(oir);

                break;

            default:
                break;
        }
    }

    JFnotas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
