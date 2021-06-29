/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication29;

/**
 *
 * @author jefer
 */
/*COMPONENTES JTEXTFIELD Y JTEXTAREA CON EVENTOS:
*
* - AGREGAR LINEAS DESDE JTEXTFIELD A JTEXTAREA
* - LIMPIAR JTEXTAREA
* - SALIR DEL PROGRAMA
*
* (perez987 febrero 2019) */
// import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

// CLASE PRINCIPAL DEL PROGRAMA
public class JavaApplication29 extends JFrame {

    // variables a nivel de clase
    protected JTextField texto1;
    protected JTextArea texto2;
    protected JPanel p1, p2;
    protected JButton btPoner, btQuitar, btSalir;
    protected String texto1Inicio;
    protected Color B, F1, F2, F3;
    protected int orden;
    // constante para el salto de linea
    protected final static String newline = "\n";

    // METODO CONSTRUCTOR QUE CREA Y MUESTRA LA INTERFAZ
    public JavaApplication29() {

        /* la variable especial super refiere a la superclase de la clase actual,
		* la clase Campos_de_texto hereda de JFrame por ello
		* super es JFrame, se declara un JFrame con el constructor
		* que pasa como argumento un String para el titulo,
		* super ha de ir siempre en la primera linea del metodo */
        super("JTextArea");
        /* la linea anterior equivale a this.setTitle("JTextArea");
		* cualquiera de las dos sirve para mostrar el texto
		* en la barra de titulo de la ventana */

 /* la variable especial this se usa en metodos de instancia
		* para hacer referencia al objeto que contiene al metodo,
		* aqui equivale a JFrame */
        // accion por defecto al cerrar la ventana: salir del programa
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // paneles de disposicion
        p1 = new JPanel(new BorderLayout()); // panel principal
        p2 = new JPanel(new GridLayout(1, 3)); // panel para 3 botones en BorderLayout.SOUTH
        p1.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

        // campo de texto JTextField
        texto1 = new JTextField(40);
        texto1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12));
        texto1Inicio = "\"CopiarTexto\" copia una linea nueva. \"Limpiar texto\" borra todo.";
        texto1.setText(texto1Inicio);

        // campo de texto JTextArea
        texto2 = new JTextArea(17, 40);
        texto2.setEditable(false);
        texto2.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12));
        B = new Color(60, 60, 60);
        texto2.setBackground(B);
        F1 = new Color(240, 240, 240);
        texto2.setForeground(F1);
        JScrollPane pScroll = new JScrollPane(texto2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        btPoner = new JButton("Copiar texto");
        btQuitar = new JButton("Limpiar texto");
        btSalir = new JButton("Salir");

        // asociar los botones con instancias de las clases que definen las acciones
        btPoner.addActionListener(new ponerTexto());
        btQuitar.addActionListener(new limpiarTexto());
        btSalir.addActionListener(new cerrarVentana());

        /*colocar los componentes en los paneles;
		* para agregar un componente a un JFrame es preferible
		* frame.getContentPane().add(panel);
		* en lugar de
		* frame.add(panel);*/
        this.getContentPane().add(p1);
        p1.add(texto1, BorderLayout.NORTH);
        // agregar JScrollPane al panel principal en lugar de agregar directamente JTextArea
        // para implementar las barras de deslizamiento (scroll)
        p1.add(pScroll, BorderLayout.CENTER);
        p1.add(p2, BorderLayout.SOUTH);
        p2.add(btPoner);
        p2.add(btQuitar);
        p2.add(btSalir);

        // tooltips para algunos elementos de la interfaz grafica
        btPoner.setToolTipText("Copiar texto desde JTextField a JTextArea");
        btQuitar.setToolTipText("Limpiar de texto JTextArea");
        btSalir.setToolTipText("Salir de la aplicacion");

        // crear y mostrar la ventana centrada en la pantalla
        // this.setTitle("JTextArea");
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        //this.setLocation(200,200);
        this.setVisible(true);
    }

// METODO DE ENTRADA AL PROGRAMA
    public static void main(String[] args) {
        // Java look and feel
        JFrame.setDefaultLookAndFeelDecorated(true);
        // instancia de la clase principal
        new JavaApplication29();
    }

    // CLASE QUE AGREGA LINEAS DESDE JTEXTFIELD A TEXTAREA
    class ponerTexto implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            String texto = texto1.getText();
            /* 16 lineas como maximo, mostrando al principio el numero de linea
			* mostrar un cero antes del numero de linea hasta llegar a 10 */
            if (orden < 16) {
                if (orden < 9) {
                    texto2.append("0" + (orden + 1) + " - " + texto + newline);
                } else if (orden >= 9) {
                    texto2.append((orden + 1) + " - " + texto + newline);
                }
                // posicionarse siempre en la ultima linea de JTExtArea
                texto2.setCaretPosition(texto2.getDocument().getLength());
                orden++;
            } else {
                texto1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12));
                F2 = new Color(255, 0, 0);
                texto1.setForeground(F2);
                texto1.setText("Se alcanzaron las 16 lineas (MAX).");
            }
        }
    }

    // CLASE QUE LIMPIA TEXTAREA
    class limpiarTexto implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            texto1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12));
            F3 = new Color(0, 0, 0);
            texto1.setForeground(F3);
            texto1.setText(texto1Inicio);
            texto2.setText("");
            orden = 0;
        }
    }

    // CLASE QUE SALE DEL PROGRAMA
    class cerrarVentana implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            System.exit(0);
        }
    }

}
