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
import static javafx.scene.paint.Color.color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author jefer
 */
public class Banco extends JFrame implements ActionListener {

    JLabel imagen = new JLabel();
    Color color = new Color(50, 93, 127);

    Font fuente = new Font("TimesRoman", Font.BOLD, 40);

    ArrayList<ArrayList<String>> usuarios = new ArrayList<>();
    ArrayList<String> usuario = new ArrayList<>();

    Leer leer = new Leer();

    int identificacion = 0;

    JMenuBar barra = new JMenuBar();
    JMenuItem cuentas1, cuentas2, cuentas3, consultas1, consultas2, operaciones1, operaciones2, operaciones3;

    JFDatos ventana2;

    JButton btn_mostrar_todos = new JButton("<html>Mostrar Datos<html>");

    MostrarDatos mostrarDatos = new MostrarDatos();

    JMenu menu_cuentas = new JMenu("Cuentas");
    JMenu menu_consultas = new JMenu("Consultas");
    JMenu menu_operaciones = new JMenu("Operaciones");

    JLabel respuesta = new JLabel("<html>Bienvenido a <p> su banco<html>");

    public static void main(String[] args) {
        //setDefaultLookAndFeelDecorated(true);
        Banco obj = new Banco();
        obj.setSize(565, 270);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }

    public Banco() {
        super("BANCO");
        Container N = getContentPane();
        N.setLayout(null);
        N.setBackground(color);

        setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Banco\\src\\imagenes\\76547eb46a08a204e09138ef687f061d-d--lar-s--mbolo-de-moneda-doodle-by-vexels.png").getImage());

        N.add(imagen);
        imagen.setBounds(370, 0, 200, 180);
        ImageIcon imag = new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\Banco\\src\\imagenes\\76547eb46a08a204e09138ef687f061d-d--lar-s--mbolo-de-moneda-doodle-by-vexels.png");
        Icon icon = new ImageIcon(imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icon);

        N.add(btn_mostrar_todos);
        N.add(respuesta);

        setJMenuBar(barra);
        barra.add(menu_cuentas);
        barra.add(menu_consultas);
        barra.add(menu_operaciones);
        barra.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn_mostrar_todos.setBounds(415, 185, 120, 20);
        btn_mostrar_todos.setBackground(Color.MAGENTA);
        btn_mostrar_todos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_mostrar_todos.addActionListener(this);

        respuesta.setBounds(40, 20, 400, 150);
        respuesta.setFont(fuente);
        respuesta.setForeground(Color.CYAN);

        cuentas1 = new JMenuItem("Ingresar Cuenta");
        cuentas2 = new JMenuItem("Retirar Cuenta");
        cuentas3 = new JMenuItem("Cambiar Datos");
        menu_cuentas.add(cuentas1);
        menu_cuentas.add(cuentas2);
        menu_cuentas.add(cuentas3);
        cuentas1.addActionListener(this);
        cuentas2.addActionListener(this);
        cuentas3.addActionListener(this);

        consultas1 = new JMenuItem("Saldo");
        consultas2 = new JMenuItem("Datos");
        menu_consultas.add(consultas1);
        menu_consultas.add(consultas2);
        consultas1.addActionListener(this);
        consultas2.addActionListener(this);

        operaciones1 = new JMenuItem("Cobrar Intereses");
        operaciones2 = new JMenuItem("Consignar");
        operaciones3 = new JMenuItem("Retirar");
        menu_operaciones.add(operaciones1);
        menu_operaciones.add(operaciones2);
        menu_operaciones.add(operaciones3);
        operaciones1.addActionListener(this);
        operaciones2.addActionListener(this);
        operaciones3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Mostrartodos
        if (e.getSource() == btn_mostrar_todos) {

            mostrarDatos.accion(usuarios, usuario, 4);

        }//Mostrartodos

        if (e.getSource() == cuentas1) {
            ventana2 = new JFDatos(0, identificacion);
            ventana2.setVisible(true);
        }
        if (e.getSource() == cuentas2) {
            ventana2 = new JFDatos(1, identificacion);
            ventana2.setVisible(true);
        }
        if (e.getSource() == cuentas3) {

            identificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del usuario a actualizar:"));
            leer.accion(usuarios, usuario, 4);

            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).get(0).equals(Integer.toString(identificacion))) {
                    ventana2 = new JFDatos(2, identificacion);
                    ventana2.setVisible(true);
                    break;
                } else if (i == usuarios.size() - 1) {
                    JOptionPane.showMessageDialog(null, "<html>El usuario <html>" + identificacion + "<p>no esta registrado");
                }
            }

        }
        if (e.getSource() == consultas1) {
            ventana2 = new JFDatos(3, identificacion);
            ventana2.setVisible(true);
        }
        if (e.getSource() == consultas2) {
            ventana2 = new JFDatos(4, identificacion);
            ventana2.setVisible(true);
        }
        if (e.getSource() == operaciones1) {
            ventana2 = new JFDatos(5, identificacion);
            ventana2.setVisible(true);
        }
        if (e.getSource() == operaciones2) {

            identificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del usuario a Consignar:"));
            leer.accion(usuarios, usuario, 4);

            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).get(0).equals(Integer.toString(identificacion))) {
                    ventana2 = new JFDatos(6, identificacion);
                    ventana2.setVisible(true);
                    break;
                } else if (i == usuarios.size() - 1) {
                    JOptionPane.showMessageDialog(null, "<html>El usuario <html>" + identificacion + "<p>no esta registrado");
                }
            }
        }
        if (e.getSource() == operaciones3) {

            identificacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el documento del usuario a Consignar:"));
            leer.accion(usuarios, usuario, 4);

            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).get(0).equals(Integer.toString(identificacion))) {
                    ventana2 = new JFDatos(7, identificacion);
                    ventana2.setVisible(true);
                    break;
                } else if (i == usuarios.size() - 1) {
                    JOptionPane.showMessageDialog(null, "<html>El usuario <html>" + identificacion + "<p>no esta registrado");
                }
            }
        }

    }

}
