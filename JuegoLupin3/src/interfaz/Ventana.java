package interfaz;

import entrada.Teclado;
import estado.EstadoDelJuego;
import graficos.Recursos;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import math.Posicion;
import objetosJuego.Jugador;
import objetosJuego.ObjetoJuego;

public class Ventana extends JFrame implements Runnable {

    public static final int ANCHO = 800, ALTO = 600;
    private Canvas canvas;
    private Thread hilo;
    private boolean corriendo = false;

    private BufferStrategy bs;
    private Graphics g;

    private static int FPS = 0;
    private static int APS = 0;

    private double posX, posY;

    public final ImageIcon icono = new ImageIcon(Ventana.class.getResource("/recursos/icono.png"));

    private EstadoDelJuego estadoDelJuego;
    private Teclado teclado;
    private Posicion posicion;
    private ObjetoJuego objetoJuego;
    private Jugador jugador;

    public Ventana() {
        setTitle("Lupin 3\t                                                                        W,A,S,D,⇑");
        setUndecorated(true);
        setSize(ANCHO, ALTO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(icono.getImage());
        inicializarComponentes();
        requestFocus();
    }

    private void inicializarComponentes() {
        canvas = new Canvas();
        teclado = new Teclado();

        canvas.setPreferredSize(new Dimension(ANCHO, ALTO));
        canvas.setMaximumSize(new Dimension(ANCHO, ALTO));
        canvas.setMinimumSize(new Dimension(ANCHO, ALTO));
        canvas.setFocusable(true);

        add(canvas);
        canvas.addKeyListener(teclado);
    }

    public void iniciarHilo() {
        hilo = new Thread(this);
        hilo.start();
        corriendo = true;
    }

    private void inicializar() {
        new Recursos().inicializar();
        estadoDelJuego = new EstadoDelJuego();
    }

    private void actualizar() {
        if (isFocused()) {
            teclado.actualizar();
            estadoDelJuego.actualizar();
            posX = estadoDelJuego.obtenerPosicion().getX();
            posY = estadoDelJuego.obtenerPosicion().getY();
        }
    }

    @Override
    public void run() {

        int actualizacionesAcumuladas = 0;
        int framesAcumulados = 0;

        final int NS_POR_SEGUNDO = 1000000000;
        final int APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();

        double tiempoTranscurrido;
        double delta = 0;

        inicializar();

        while (corriendo) {
            final long inicioBucle = System.nanoTime();

            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;

            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

            if (delta >= 1) {
                actualizar();
                actualizacionesAcumuladas++;
                delta--;
            }

            dibujar();

            framesAcumulados++;
            
            if (System.nanoTime() - referenciaContador >= NS_POR_SEGUNDO) {

                APS = actualizacionesAcumuladas;
                FPS = framesAcumulados;

                actualizacionesAcumuladas = 0;
                framesAcumulados = 0;
                referenciaContador = System.nanoTime();
            }

        }

        detener();
    }

    private void dibujar() {
        bs = canvas.getBufferStrategy();

        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        //-----------------------
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, ANCHO, ALTO);

        estadoDelJuego.dibujar(g);

        g.setColor(Color.WHITE);
        g.drawString("FPS: " + FPS, 20, 20);
        g.drawString("APS: " + APS, 20, 30);
        g.drawString("X: " + (double) Math.round(posX * 100d) / 100d, 20, 40);
        g.drawString("Y: " + (double) Math.round(posY * 100d) / 100d, 20, 50);
        //---------------------
        g.dispose();
        bs.show();
    }

    private void detener() {
        try {
            hilo.join();
            corriendo = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
