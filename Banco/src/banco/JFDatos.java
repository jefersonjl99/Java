/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class JFDatos extends JFrame {

    int h = 0, tmp, n = 4, fila;
    int[] a;

    Agregar agregar = new Agregar();
    Borrar borrar = new Borrar();
    Grabar grabar = new Grabar();
    Leer leer = new Leer();
    CambiarDatos cambiarDatos = new CambiarDatos();

    JLabel[] texto_label = new JLabel[n];
    JTextField[] leer_txtfield = new JTextField[n];

    JButton btn_operacion = new JButton("");

    ArrayList<ArrayList<String>> usuarios = new ArrayList<>();
    ArrayList<String> usuario = new ArrayList<>();

    JTextArea txt_respuesta = new JTextArea(50, 30);
    JScrollPane deslizador = new JScrollPane(txt_respuesta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    JLabel imagen = new JLabel();
    JLabel datos = new JLabel();
    JLabel respuesta = new JLabel("");

    ActionListener oir;

    ImageIcon imag;
    Icon icon;

    JButton anterior = new JButton("<<");
    JButton siguiente = new JButton(">>");

    String newline = "\n", registro = "";

    Color color = new Color(50, 93, 127);

    Font fuente = new Font("TimesRoman", Font.BOLD, 25);

    public JFDatos(int opcion, int identificacion) {

        setTitle("Datos");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setResizable(false);

        Container N = getContentPane();
        N.setLayout(null);
        N.setBackground(color);

        btn_operacion.setText("");
        btn_operacion.setBounds(200, 80, 100, 20);
        btn_operacion.setCursor(new Cursor(Cursor.HAND_CURSOR));

        respuesta.setBounds(10, 120, 400, 90);
        respuesta.setFont(fuente);
        respuesta.setForeground(Color.CYAN);

        switch (opcion) {
            case 0:

                setTitle("Nueva Cuenta");

                N.add(btn_operacion);
                N.add(respuesta);

                leer.accion(usuarios, usuario, n);

                btn_operacion.setText("Ingresar");

                for (int i = 0; i < n; i++) {

                    texto_label[i] = new JLabel("");
                    leer_txtfield[i] = new JTextField();

                    N.add(texto_label[i]);
                    texto_label[i].setBackground(null);

                    N.add(leer_txtfield[i]);
                    leer_txtfield[i].setBackground(Color.yellow);
                    leer_txtfield[i].setBackground(Color.yellow);

                    switch (i) {
                        case 0:
                            texto_label[i].setBounds((60 * (i)) + 10, 20, 100, 20);
                            texto_label[i].setText("Identificación");
                            leer_txtfield[i].setBounds((60 * (i)) + 10, 40, 100, 20);
                            leer_txtfield[i].setText("2020");
                            break;
                        case 1:
                            texto_label[i].setBounds((100 * (i)) + 20, 20, 120, 20);
                            texto_label[i].setText("Nombre del habiente");
                            leer_txtfield[i].setBounds((100 * (i)) + 20, 40, 120, 20);
                            leer_txtfield[i].setText("jeferson");
                            break;
                        case 2:
                            texto_label[i].setBounds((100 * (i) + 50), 20, 80, 20);
                            texto_label[i].setText("Saldo Inicial");
                            leer_txtfield[i].setBounds((100 * (i)) + 50, 40, 80, 20);
                            leer_txtfield[i].setText("18");
                            break;
                        default:
                            texto_label[i].setBounds((100 * (i)) + 40, 20, 80, 20);
                            texto_label[i].setText("% interes");
                            leer_txtfield[i].setBounds((100 * (i)) + 40, 40, 80, 20);
                            leer_txtfield[i].setText("5");
                            break;
                    }
                }

                oir = (ActionEvent e) -> {
                    if (e.getSource() == btn_operacion) {
                        usuario = new ArrayList<>();

                        for (int i = 0; i < n; i++) {
                            usuario.add(leer_txtfield[i].getText());
                        }

                        if (!existe_usuario(leer_txtfield[0].getText())) {

                            respuesta.setText(usuario.get(0) + " Añadido");
                            agregar.accion(usuarios, usuario, n);
                            grabar.accion(usuarios, usuario, n);

                        } else if (existe_usuario(leer_txtfield[0].getText())) {

                            respuesta.setText("El Usuario " + usuario.get(0) + " ya existe");

                        }

                        //muestra el arraylist
                        System.out.println("");
                        for (int i = 0; i < usuarios.size(); i++) {
                            for (int j = 0; j < usuario.size(); j++) {
                                System.out.print(usuarios.get(i).get(j) + " ");
                            }
                            System.out.println("");
                        }
                    }
                };
                btn_operacion.addActionListener(oir);

                break;

            case 1:

                setTitle("Retirar Cuenta");

                N.add(btn_operacion);
                N.add(respuesta);

                leer.accion(usuarios, usuario, n);

                btn_operacion.setText("Retirar");

                texto_label[0] = new JLabel("");
                leer_txtfield[0] = new JTextField();

                N.add(texto_label[0]);
                texto_label[0].setBackground(null);

                N.add(leer_txtfield[0]);
                leer_txtfield[0].setBackground(Color.yellow);

                texto_label[0].setBounds(200, 20, 100, 20);
                texto_label[0].setText("Identificación");
                leer_txtfield[0].setBounds(200, 40, 100, 20);
                leer_txtfield[0].setText("0");

                oir = (ActionEvent e) -> {
                    usuario = new ArrayList<>();

                    if (existe_usuario(leer_txtfield[0].getText())) {

                        usuario.add(usuarios.get(fila).get(0));

                        respuesta.setText(usuario.get(0) + " eliminado");
                        borrar.accion(usuarios, usuario, fila);
                        grabar.accion(usuarios, usuario, n);

                    } else {

                        respuesta.setText("<html>El Usuario <html>" + leer_txtfield[0].getText() + "<p>no esta registrado");

                    }

                    //muestra el arraylist
                    System.out.println("");
                    for (int i = 0; i < usuarios.size(); i++) {
                        for (int j = 0; j < usuario.size(); j++) {
                            System.out.print(usuarios.get(i).get(j) + " ");
                        }
                        System.out.println("");
                    }
                };
                btn_operacion.addActionListener(oir);

                break;

            case 2:

                setTitle("Cambiar Cuenta");

                N.add(btn_operacion);
                N.add(respuesta);

                leer.accion(usuarios, usuario, n);
                existe_usuario(Integer.toString(identificacion));

                btn_operacion.setText("Cambiar");

                for (int i = 0; i < n; i++) {

                    texto_label[i] = new JLabel("");
                    leer_txtfield[i] = new JTextField();

                    N.add(texto_label[i]);
                    texto_label[i].setBackground(null);

                    N.add(leer_txtfield[i]);
                    leer_txtfield[i].setBackground(Color.yellow);

                    switch (i) {
                        case 0:

                            break;
                        case 1:
                            texto_label[i].setBounds((100 * (i)) + 20, 20, 120, 20);
                            texto_label[i].setText("Nombre del habiente");
                            leer_txtfield[i].setBounds((100 * (i)) + 20, 40, 120, 20);
                            break;
                        case 2:
                            texto_label[i].setBounds((100 * (i) + 50), 20, 80, 20);
                            texto_label[i].setText("Saldo");
                            leer_txtfield[i].setBounds((100 * (i)) + 50, 40, 80, 20);
                            break;
                        default:
                            texto_label[i].setBounds((100 * (i)) + 40, 20, 80, 20);
                            texto_label[i].setText("% interes");
                            leer_txtfield[i].setBounds((100 * (i)) + 40, 40, 80, 20);
                            break;
                    }
                }

                for (int j = 1; j < n; j++) {
                    leer_txtfield[j].setText(usuarios.get(fila).get(j));
                }
                respuesta.setText("Cargado");

                oir = (ActionEvent e) -> {
                    if (e.getSource() == btn_operacion) {
                        usuario = new ArrayList<>();

                        for (int i = 0; i < n; i++) {
                            if (i < 1) {
                                usuario.add(usuarios.get(fila).get(i));
                            } else {
                                usuario.add(leer_txtfield[i].getText());
                            }
                        }

                        respuesta.setText(usuario.get(0) + " actualizado");
                        cambiarDatos.accion(usuarios, usuario, n);
                        grabar.accion(usuarios, usuario, n);

                        //muestra el arraylist
                        System.out.println("");
                        for (int i = 0; i < usuarios.size(); i++) {
                            for (int j = 0; j < usuario.size(); j++) {
                                System.out.print(usuarios.get(i).get(j) + " ");
                            }
                            System.out.println("");
                        }
                    }
                };
                btn_operacion.addActionListener(oir);

                break;

            case 3:

                setTitle("Leer Saldo");

                N.add(btn_operacion);
                N.add(respuesta);

                leer.accion(usuarios, usuario, n);

                btn_operacion.setText("Consultar");

                texto_label[0] = new JLabel("");
                leer_txtfield[0] = new JTextField();

                N.add(texto_label[0]);
                texto_label[0].setBackground(null);

                N.add(leer_txtfield[0]);
                leer_txtfield[0].setBackground(Color.yellow);

                texto_label[0].setBounds(200, 20, 100, 20);
                texto_label[0].setText("Identificación");
                leer_txtfield[0].setBounds(200, 40, 100, 20);
                leer_txtfield[0].setText("0");

                oir = (ActionEvent e) -> {
                    usuario = new ArrayList<>();

                    if (existe_usuario(leer_txtfield[0].getText())) {

                        respuesta.setText("<html>El Saldo de <html>" + usuarios.get(fila).get(0) + "<p>es: " + usuarios.get(fila).get(2));

                    } else {

                        respuesta.setText("<html>El Usuario <html>" + leer_txtfield[0].getText() + "<p>no esta registrado");

                    }

                    //muestra el arraylist
                    System.out.println("");
                    for (int i = 0; i < usuarios.size(); i++) {
                        for (int j = 0; j < usuario.size(); j++) {
                            System.out.print(usuarios.get(i).get(j) + " ");
                        }
                        System.out.println("");
                    }
                };
                btn_operacion.addActionListener(oir);

                break;

            case 4:

                setTitle("Leer Datos");

                N.add(btn_operacion);
                N.add(respuesta);

                leer.accion(usuarios, usuario, n);

                btn_operacion.setText("Consultar");

                texto_label[0] = new JLabel("");
                leer_txtfield[0] = new JTextField();

                N.add(texto_label[0]);
                texto_label[0].setBackground(null);

                N.add(leer_txtfield[0]);
                leer_txtfield[0].setBackground(Color.yellow);

                texto_label[0].setBounds(200, 20, 100, 20);
                texto_label[0].setText("Identificación");
                leer_txtfield[0].setBounds(200, 40, 100, 20);
                leer_txtfield[0].setText("0");

                oir = (ActionEvent e) -> {
                    usuario = new ArrayList<>();

                    if (existe_usuario(leer_txtfield[0].getText())) {

                        respuesta.setText("<html>Nombre: " + usuarios.get(fila).get(1) + "<p>Saldo: <html>" + usuarios.get(fila).get(2) + "<p>Interes: " + usuarios.get(fila).get(3) + "%");

                    } else {

                        respuesta.setText("<html>El Usuario <html>" + leer_txtfield[0].getText() + "<p>no esta registrado");

                    }

                    //muestra el arraylist
                    System.out.println("");
                    for (int i = 0; i < usuarios.size(); i++) {
                        for (int j = 0; j < usuario.size(); j++) {
                            System.out.print(usuarios.get(i).get(j) + " ");
                        }
                        System.out.println("");
                    }
                };
                btn_operacion.addActionListener(oir);

                break;

            case 5:

                setTitle("Cobrar Intereses");

                N.add(btn_operacion);
                N.add(respuesta);

                leer.accion(usuarios, usuario, n);

                btn_operacion.setText("Cobrar");

                texto_label[0] = new JLabel("");
                leer_txtfield[0] = new JTextField();

                N.add(texto_label[0]);
                texto_label[0].setBackground(null);

                N.add(leer_txtfield[0]);
                leer_txtfield[0].setBackground(Color.yellow);

                texto_label[0].setBounds(200, 20, 100, 20);
                texto_label[0].setText("Identificación");
                leer_txtfield[0].setBounds(200, 40, 100, 20);
                leer_txtfield[0].setText("0");

                oir = (ActionEvent e) -> {
                    usuario = new ArrayList<>();

                    if (existe_usuario(leer_txtfield[0].getText())) {

                        for (int i = 0; i < n; i++) {
                            if (i != 2) {
                                usuario.add(usuarios.get(fila).get(i));
                            } else {
                                double saldo = Double.parseDouble(usuarios.get(fila).get(2));
                                double interes = Double.parseDouble(usuarios.get(fila).get(3));
                                saldo += (saldo * (interes / 100));
                                usuario.add(Double.toString(saldo));
                                System.out.println(saldo);
                            }
                        }

                        cambiarDatos.accion(usuarios, usuario, n);
                        grabar.accion(usuarios, usuario, n);
                        respuesta.setText("<html>Interes del " + usuarios.get(fila).get(3) + "% Cobrado...<p>Nuevo Saldo: <html>" + usuarios.get(fila).get(2));

                    } else {

                        respuesta.setText("<html>El Usuario <html>" + leer_txtfield[0].getText() + "<p>no esta registrado");

                    }

                    //muestra el arraylist
                    System.out.println("");
                    for (int i = 0; i < usuarios.size(); i++) {
                        for (int j = 0; j < usuario.size(); j++) {
                            System.out.print(usuarios.get(i).get(j) + " ");
                        }
                        System.out.println("");
                    }
                };
                btn_operacion.addActionListener(oir);

                break;

            case 6:

                setTitle("Consignación");

                N.add(btn_operacion);
                N.add(respuesta);

                leer.accion(usuarios, usuario, n);
                existe_usuario(Integer.toString(identificacion));

                btn_operacion.setText("Consignar");

                texto_label[0] = new JLabel("");
                leer_txtfield[0] = new JTextField();

                N.add(texto_label[0]);
                texto_label[0].setBackground(null);

                N.add(leer_txtfield[0]);
                leer_txtfield[0].setBackground(Color.yellow);

                texto_label[0].setBounds(200, 20, 120, 20);
                texto_label[0].setText("Saldo a Consignar:");
                leer_txtfield[0].setBounds(200, 40, 100, 20);
                leer_txtfield[0].setText("0");

                oir = (ActionEvent e) -> {
                    usuario = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        if (i != 2) {
                            usuario.add(usuarios.get(fila).get(i));
                        } else {
                            double saldo = Double.parseDouble(usuarios.get(fila).get(2));
                            saldo += Double.parseDouble(leer_txtfield[0].getText());
                            usuario.add(Double.toString(saldo));
                            System.out.println(saldo);
                        }
                    }

                    cambiarDatos.accion(usuarios, usuario, n);
                    grabar.accion(usuarios, usuario, n);
                    respuesta.setText("<html>Consignacion a: " + usuarios.get(fila).get(0) + " Realizada<p>Nuevo Saldo: <html>" + usuarios.get(fila).get(2));

                    //muestra el arraylist
                    System.out.println("");
                    for (int i = 0; i < usuarios.size(); i++) {
                        for (int j = 0; j < usuario.size(); j++) {
                            System.out.print(usuarios.get(i).get(j) + " ");
                        }
                        System.out.println("");
                    }
                };
                btn_operacion.addActionListener(oir);

                break;
            case 7:

                setTitle("Retiro");

                N.add(btn_operacion);
                N.add(respuesta);

                leer.accion(usuarios, usuario, n);
                existe_usuario(Integer.toString(identificacion));

                btn_operacion.setText("Retirar");

                texto_label[0] = new JLabel("");
                leer_txtfield[0] = new JTextField();

                N.add(texto_label[0]);
                texto_label[0].setBackground(null);

                N.add(leer_txtfield[0]);
                leer_txtfield[0].setBackground(Color.yellow);

                texto_label[0].setBounds(200, 20, 120, 20);
                texto_label[0].setText("Saldo a Retirar:");
                leer_txtfield[0].setBounds(200, 40, 100, 20);
                leer_txtfield[0].setText("0");

                oir = (ActionEvent e) -> {

                    usuario = new ArrayList<>();

                    if (Double.parseDouble(leer_txtfield[0].getText()) <= Double.parseDouble(usuarios.get(fila).get(2))) {
                        for (int i = 0; i < n; i++) {
                            if (i != 2) {
                                usuario.add(usuarios.get(fila).get(i));
                            } else {
                                double saldo = Double.parseDouble(usuarios.get(fila).get(2));
                                saldo -= Double.parseDouble(leer_txtfield[0].getText());
                                usuario.add(Double.toString(saldo));
                                System.out.println(saldo);
                            }
                        }

                        cambiarDatos.accion(usuarios, usuario, n);
                        grabar.accion(usuarios, usuario, n);
                        respuesta.setText("<html>Retiro a: " + usuarios.get(fila).get(0) + " Realizado<p>Nuevo Saldo: <html>" + usuarios.get(fila).get(2));

                    } else {

                        respuesta.setText("<html>Saldo de: " + usuarios.get(fila).get(0) + " Insuficiente<p>Saldo: <html>" + usuarios.get(fila).get(2));

                    }

                    //muestra el arraylist
                    System.out.println("");
                    for (int i = 0; i < usuarios.size(); i++) {
                        for (int j = 0; j < usuario.size(); j++) {
                            System.out.print(usuarios.get(i).get(j) + " ");
                        }
                        System.out.println("");
                    }
                };
                btn_operacion.addActionListener(oir);

                break;
            case 8:
                
                
                N.add(deslizador);
                deslizador.setBounds(0, 0, 490, 220);
                
                leer.accion(usuarios, usuario, n);

                for (int i = 0; i < usuarios.size(); i++) {
                    registro = "";
                    for (int j = 0; j < n; j++) {
                        switch (j) {
                            case 0:
                                registro += "Identificación: " + usuarios.get(i).get(j);
                                break;
                            case 1:
                                registro += "    Nombre: " + usuarios.get(i).get(j);
                                break;
                            case 2:
                                registro += "    Saldo: " + usuarios.get(i).get(j);
                                break;
                            case 3:
                                registro += "    Interes: " + usuarios.get(i).get(j) + "%";
                                break;
                            default:
                                break;
                        }

                    }
                    txt_respuesta.append(registro + newline);
                }

                break;

            default:
                break;
        }
    }

    //funcion eviste estudiante
    boolean existe_usuario(String h
    ) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).get(0).equals(h)) {
                fila = i;
                return true;
            }
        }
        return false;
    }

}
