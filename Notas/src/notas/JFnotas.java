/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notas;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author jefer
 */
public class JFnotas extends JFrame {

    JTextArea txt_respuesta = new JTextArea(50, 30);
    JScrollPane deslizador = new JScrollPane(txt_respuesta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    Archivo archivo = new Archivo();

    String newline = "\n", registro = "";

    Color color = new Color(50, 93, 127);

    public JFnotas(ArrayList<ArrayList<String>> l) {

        setTitle("Notas");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);

        Container N = getContentPane();
        N.setLayout(null);
        N.setBackground(color);
        N.add(deslizador);
        deslizador.setBounds(0, 0, 490, 470);
        txt_respuesta.setBackground(Color.WHITE);
        txt_respuesta.setEditable(false);
        txt_respuesta.setForeground(Color.BLACK);

        archivo.leer(l);

        for (int i = 0; i < l.size(); i++) {
            registro = "";
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    registro += "Codigo: " + l.get(i).get(j) + ",";
                } else if (j == 1) {
                    registro += "     Nombre: " + l.get(i).get(j) + ",";
                } else if (j > 1 && j < 5) {
                    registro += "    Nota#" + (j - 1) + ": " + l.get(i).get(j);
                } else if (j == 5) {

                    registro += "    Promedio= " + l.get(i).get(j);
                }

            }
            txt_respuesta.append(registro + newline);
        }

    }

}
