package metodomontecarlo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jefer
 */
public class MetodoMontecarlo extends JFrame {

    int n=50000;
    
    Puntos punto = new Puntos();

    Puntos[] puntos = new Puntos[n];

    Color color = new Color(50, 93, 127);
    
    Font fuente = new Font("TimesRoman", Font.BOLD, 25);

    JButton btn_calcular = new JButton("Calcular");

    JTextField leer = new JTextField("2");

    JLabel respuesta = new JLabel("");
    JLabel respuesta1 = new JLabel("");
    JLabel texto = new JLabel("Digite el diametro del circulo: ");
    JLabel imagen = new JLabel();

    public static void main(String[] args) {
        MetodoMontecarlo obj = new MetodoMontecarlo();
        obj.setSize(500, 520);
        obj.setLocationRelativeTo(null);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setResizable(false);
        JFrame.setDefaultLookAndFeelDecorated(true);
    }

    public MetodoMontecarlo() {

        super("Metodo Montecarlo");
        Container m = getContentPane();
        m.setLayout(null);
        m.setBackground(color);

        setIconImage(new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\MetodoMontecarlo\\src\\imagenes\\43102.png").getImage());

        m.add(texto);
        m.add(btn_calcular);
        m.add(leer);
        m.add(respuesta);
        m.add(respuesta1);
        
        texto.setBounds(30, 60, 200, 20);
        leer.setBounds(200, 60, 100, 20);
        btn_calcular.setBounds(200, 100, 100, 20);
        respuesta.setBounds(240, 410, 200, 20);
        respuesta1.setBounds(20, 400, 200, 100);
        m.add(imagen);
        
        imagen.setBounds(320, 20, 150, 150);
        ImageIcon imag=new ImageIcon("C:\\Users\\jefer\\Documents\\NetBeansProjects\\MetodoMontecarlo\\src\\imagenes\\ba38e6111932855459eb091da1372849-icono-de-dados-de-juego-by-vexels.png");
        Icon icon = new ImageIcon(imag.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icon);
        btn_calcular.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ActionListener oir = (ActionEvent e) -> {
            if (e.getSource() == btn_calcular) {

                double diametro = Integer.parseInt(leer.getText());

                double radio=diametro/2;
                
                int  contadorAdentro = 0;

                Graphics g;
                g = getGraphics();
                
                g.setColor(color);
                g.fillRect(150, 200, 200, 200);
                
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(150, 200, 200, 200);
                g.drawOval(150, 200, 200, 200);

                for (int i = 0; i < n; i++) {
                    punto.generar_punto_aleatorio(diametro);

                    if (punto.esta_dentro(radio) == true) {
                        
                        g.setColor(Color.RED);
                        g.drawString(".", (int) ((punto.x * 100) / (radio)) + 149, (int) ((punto.y * 100) / (radio)) + 201);
                        contadorAdentro++;
                    } else {
                        
                        g.setColor(Color.BLUE);
                        g.drawString(".", (int) ((punto.x * 100) / (radio)) + 149, (int) ((punto.y * 100) / (radio)) + 201);
                    }
                    
                }
                double pi = (double) ((Math.pow(diametro, 2)*(double)contadorAdentro)/(Math.pow((radio), 2)*(double)n));
                
                System.out.println("Diametro: "+diametro);
                System.out.println("Adentro: "+contadorAdentro);
                System.out.println("Totales: "+n);
                System.out.println("π ~ "+pi);
                
                respuesta1.setText("<html>Para el circulo de diametro: <html>"+diametro+"<p>Se generaron "+n+" lanzamientos<p>De los cuales "+contadorAdentro+" cayeron dentro del circulo");
                
                respuesta.setForeground(Color.RED);
                respuesta.setFont(fuente);
                respuesta.setText("π ~ " + pi);
                
            }
        };
        btn_calcular.addActionListener(oir);

    }

}
