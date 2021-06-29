/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosJuego;

import entrada.Teclado;
import graficos.OptimizadorRecursos;
import graficos.Recursos;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import math.Posicion;

/**
 *
 * @author Jeferson Jimenez
 */
public class Jugador extends ObjetoMovible {

    private BufferedImage texturaJugador = Recursos.jugador_down;

    private int animacion, recurso;
    double velocidadMOV;
    private double velocidadDiag;

    private boolean enMovimiento = false, corriendo;
    
    public Jugador(Posicion posicion, Posicion velocidad, BufferedImage textura) {
        super(posicion, velocidad, textura);
    }

    @Override
    public void actualizar() {
        velocidadMOV = 3;
        actualizarVelocidad(velocidadMOV);
        corriendo = enMovimiento = false;

        if (animacion < 3200) {
            animacion++;
        } else {
            animacion = 0;
        }

        if (!enMovimiento && Teclado.COMER) {

            cambiarRecurso(corriendo, 9);
            //System.out.println("tamo quieto");
            /*long cont = 2000000000;
            long tiempoAca = System.nanoTime();
            long Diferenciatiempo = 0;
            while (Diferenciatiempo <= cont) {
                long tiempoAlla = System.nanoTime();
                Diferenciatiempo = tiempoAlla - tiempoAca;
            }*/
        }

        if (Teclado.CORRER) {
            actualizarVelocidad((velocidadMOV * 2));
            corriendo = true;
        }
        if (!Teclado.UP && Teclado.DOWN && !Teclado.LEFT && !Teclado.RIGHT) {
            posicion.setY(posicion.getY() + velocidadMOV);
            enMovimiento = true;
            recurso = 0;
            cambiarRecurso(corriendo, recurso);
        }
        if (Teclado.UP && !Teclado.DOWN && !Teclado.LEFT && !Teclado.RIGHT) {
            posicion.setY(posicion.getY() - velocidadMOV);
            enMovimiento = true;
            recurso = 1;
            cambiarRecurso(corriendo, recurso);
        }
        if (!Teclado.UP && !Teclado.DOWN && Teclado.LEFT && !Teclado.RIGHT) {
            posicion.setX(posicion.getX() - velocidadMOV);
            enMovimiento = true;
            recurso = 2;
            cambiarRecurso(corriendo, recurso);
        }
        if (!Teclado.UP && !Teclado.DOWN && !Teclado.LEFT && Teclado.RIGHT) {
            posicion.setX(posicion.getX() + velocidadMOV);
            enMovimiento = true;
            recurso = 3;
            cambiarRecurso(corriendo, recurso);
        }
        if (Teclado.UP && !Teclado.DOWN && !Teclado.LEFT && Teclado.RIGHT) {
            posicion.setY(posicion.getY() - velocidadDiag);
            posicion.setX(posicion.getX() + velocidadDiag);
            enMovimiento = true;
            recurso = 4;
            cambiarRecurso(corriendo, recurso);
        }
        if (!Teclado.UP && Teclado.DOWN && !Teclado.LEFT && Teclado.RIGHT) {
            posicion.setY(posicion.getY() + velocidadDiag);
            posicion.setX(posicion.getX() + velocidadDiag);
            enMovimiento = true;
            recurso = 5;
            cambiarRecurso(corriendo, recurso);
        }
        if (Teclado.UP && !Teclado.DOWN && Teclado.LEFT && !Teclado.RIGHT) {
            posicion.setY(posicion.getY() - velocidadDiag);
            posicion.setX(posicion.getX() - velocidadDiag);
            enMovimiento = true;
            recurso = 6;
            cambiarRecurso(corriendo, recurso);
        }
        if (!Teclado.UP && Teclado.DOWN && Teclado.LEFT && !Teclado.RIGHT) {
            posicion.setY(posicion.getY() + velocidadDiag);
            posicion.setX(posicion.getX() - velocidadDiag);
            enMovimiento = true;
            recurso = 7;
            cambiarRecurso(corriendo, recurso);
        }
        if (!enMovimiento && !Teclado.COMER) {
            cambiarRecurso(corriendo, recurso);
        }
        if (Teclado.EXIT) {
//            new Teclado();
//            ventana.transferFocusBackward();
//            Teclado.EXIT = false;
//            teclado.actualizar();
//
//            int s = JOptionPane.showConfirmDialog(null, "Seguro desea salir?", "salir", JOptionPane.YES_NO_OPTION);
//            if (s == 0) {
            System.exit(0);
//            } else {
//            }

        }
//        if (Teclado.z) {
//            texturaJugador = (BufferedImage) recursos.cortarImagen(Recursos.jugador, 10, 3, 44, 49);
//        }
    }

    @Override
    public void dibujar(Graphics g) {
        g.drawImage(texturaJugador, (int) posicion.getX(), (int) posicion.getY(), null);
    }

    @Override
    public Posicion getPosicion() {
        return posicion.getPosicion();
    }

    @Override
    public void cambiarRecurso(boolean corriendo, int numGrafico) {
        int resto = animacion % 60;
        if (corriendo) {
            switch (numGrafico) {
                case 0:
                    if (enMovimiento) {
                        if (resto > 5 && resto <= 10) {
                            texturaJugador = Recursos.jugador_corriendo_down0;
                        } else if (resto > 10 && resto <= 15) {
                            texturaJugador = Recursos.jugador_corriendo_down1;
                        } else if (resto > 15 && resto <= 20) {
                            texturaJugador = Recursos.jugador_corriendo_down2;
                        } else if (resto > 20 && resto <= 25) {
                            texturaJugador = Recursos.jugador_corriendo_down3;
                        } else if (resto > 25 && resto <= 30) {
                            texturaJugador = Recursos.jugador_corriendo_down4;
                        } else if (resto > 30 && resto <= 35) {
                            texturaJugador = Recursos.jugador_corriendo_down5;
                        } else if (resto > 35 && resto <= 40) {
                            texturaJugador = Recursos.jugador_corriendo_down0;
                        } else if (resto > 40 && resto <= 45) {
                            texturaJugador = Recursos.jugador_corriendo_down1;
                        } else if (resto > 45 && resto <= 50) {
                            texturaJugador = Recursos.jugador_corriendo_down2;
                        } else if (resto > 50 && resto <= 55) {
                            texturaJugador = Recursos.jugador_corriendo_down3;
                        } else if (resto > 55) {
                            texturaJugador = Recursos.jugador_corriendo_down4;
                        } else {
                            texturaJugador = Recursos.jugador_corriendo_down5;
                        }
                    } else {
                        texturaJugador = Recursos.jugador_down;
                    }
                    break;
                case 1:
                    if (enMovimiento) {
                        if (resto > 5 && resto <= 10) {
                            texturaJugador = Recursos.jugador_corriendo_up0;
                        } else if (resto > 10 && resto <= 15) {
                            texturaJugador = Recursos.jugador_corriendo_up1;
                        } else if (resto > 15 && resto <= 20) {
                            texturaJugador = Recursos.jugador_corriendo_up2;
                        } else if (resto > 20 && resto <= 25) {
                            texturaJugador = Recursos.jugador_corriendo_up3;
                        } else if (resto > 25 && resto <= 30) {
                            texturaJugador = Recursos.jugador_corriendo_up4;
                        } else if (resto > 30 && resto <= 35) {
                            texturaJugador = Recursos.jugador_corriendo_up5;
                        } else if (resto > 35 && resto <= 40) {
                            texturaJugador = Recursos.jugador_corriendo_up0;
                        } else if (resto > 40 && resto <= 45) {
                            texturaJugador = Recursos.jugador_corriendo_up1;
                        } else if (resto > 45 && resto <= 50) {
                            texturaJugador = Recursos.jugador_corriendo_up2;
                        } else if (resto > 50 && resto <= 55) {
                            texturaJugador = Recursos.jugador_corriendo_up3;
                        } else if (resto > 55) {
                            texturaJugador = Recursos.jugador_corriendo_up4;
                        } else {
                            texturaJugador = Recursos.jugador_corriendo_up5;
                        }
                    } else {
                        texturaJugador = Recursos.jugador_up;
                    }
                    break;
                case 2:
                    cambiarRecurso(corriendo, 3);
                    texturaJugador = OptimizadorRecursos.rotarSprite(texturaJugador);
                    texturaJugador = OptimizadorRecursos.voltearSprite(texturaJugador);
                    break;
                case 3:
                    if (enMovimiento) {
                        if (resto > 5 && resto <= 10) {
                            texturaJugador = Recursos.jugador_corriendo_right0;
                        } else if (resto > 10 && resto <= 15) {
                            texturaJugador = Recursos.jugador_corriendo_right1;
                        } else if (resto > 15 && resto <= 20) {
                            texturaJugador = Recursos.jugador_corriendo_right2;
                        } else if (resto > 20 && resto <= 25) {
                            texturaJugador = Recursos.jugador_corriendo_right3;
                        } else if (resto > 25 && resto <= 30) {
                            texturaJugador = Recursos.jugador_corriendo_right4;
                        } else if (resto > 30 && resto <= 35) {
                            texturaJugador = Recursos.jugador_corriendo_right5;
                        } else if (resto > 35 && resto <= 40) {
                            texturaJugador = Recursos.jugador_corriendo_right0;
                        } else if (resto > 40 && resto <= 45) {
                            texturaJugador = Recursos.jugador_corriendo_right1;
                        } else if (resto > 45 && resto <= 50) {
                            texturaJugador = Recursos.jugador_corriendo_right2;
                        } else if (resto > 50 && resto <= 55) {
                            texturaJugador = Recursos.jugador_corriendo_right3;
                        } else if (resto > 55) {
                            texturaJugador = Recursos.jugador_corriendo_right4;
                        } else {
                            texturaJugador = Recursos.jugador_corriendo_right5;
                        }
                    } else {

                        texturaJugador = Recursos.jugador_right;
                    }
                    break;
                case 4:
                    if (enMovimiento) {
                        if (resto > 5 && resto <= 10) {
                            texturaJugador = Recursos.jugador_corriendo_diag_up0;
                        } else if (resto > 10 && resto <= 15) {
                            texturaJugador = Recursos.jugador_corriendo_diag_up1;
                        } else if (resto > 15 && resto <= 20) {
                            texturaJugador = Recursos.jugador_corriendo_diag_up2;
                        } else if (resto > 20 && resto <= 25) {
                            texturaJugador = Recursos.jugador_corriendo_diag_up3;
                        } else if (resto > 25 && resto <= 30) {
                            texturaJugador = Recursos.jugador_corriendo_diag_up4;
                        } else if (resto > 30 && resto <= 35) {
                            texturaJugador = Recursos.jugador_corriendo_diag_up5;
                        } else if (resto > 35 && resto <= 40) {
                            texturaJugador = Recursos.jugador_corriendo_diag_up0;
                        } else if (resto > 40 && resto <= 45) {
                            texturaJugador = Recursos.jugador_corriendo_diag_up1;
                        } else if (resto > 45 && resto <= 50) {
                            texturaJugador = Recursos.jugador_corriendo_diag_up2;
                        } else if (resto > 50 && resto <= 55) {
                            texturaJugador = Recursos.jugador_corriendo_diag_up3;
                        } else if (resto > 55) {
                            texturaJugador = Recursos.jugador_corriendo_diag_up4;
                        } else {
                            texturaJugador = Recursos.jugador_corriendo_diag_up5;
                        }
                    } else {
                        texturaJugador = Recursos.jugador_diag_up;
                    }
                    break;
                case 5:
                    if (enMovimiento) {
                        if (resto > 0 && resto <= 5) {
                            texturaJugador = Recursos.jugador_corriendo_diag_down0;
                        } else if (resto > 5 && resto <= 10) {
                            texturaJugador = Recursos.jugador_corriendo_diag_down1;
                        } else if (resto > 10 && resto <= 15) {
                            texturaJugador = Recursos.jugador_corriendo_diag_down2;
                        } else if (resto > 15 && resto <= 20) {
                            texturaJugador = Recursos.jugador_corriendo_diag_down3;
                        } else if (resto > 20 && resto <= 25) {
                            texturaJugador = Recursos.jugador_corriendo_diag_down4;
                        } else if (resto > 25 && resto <= 30) {
                            texturaJugador = Recursos.jugador_corriendo_diag_down5;
                        } else if (resto > 30 && resto <= 35) {
                            texturaJugador = Recursos.jugador_corriendo_diag_down0;
                        } else if (resto > 35 && resto <= 40) {
                            texturaJugador = Recursos.jugador_corriendo_diag_down1;
                        } else if (resto > 40 && resto <= 45) {
                            texturaJugador = Recursos.jugador_corriendo_diag_down2;
                        } else if (resto > 45 && resto <= 50) {
                            texturaJugador = Recursos.jugador_corriendo_diag_down3;
                        } else if (resto > 50 && resto <= 55) {
                            texturaJugador = Recursos.jugador_corriendo_diag_down4;
                        } else {
                            texturaJugador = Recursos.jugador_corriendo_diag_down5;
                        }
                    } else {
                        texturaJugador = Recursos.jugador_diag_down;
                    }
                    break;
                case 6:
                    cambiarRecurso(corriendo, 4);
                    texturaJugador = OptimizadorRecursos.rotarSprite(texturaJugador);
                    texturaJugador = OptimizadorRecursos.voltearSprite(texturaJugador);
                    break;
                case 7:
                    cambiarRecurso(corriendo, 5);
                    texturaJugador = OptimizadorRecursos.rotarSprite(texturaJugador);
                    texturaJugador = OptimizadorRecursos.voltearSprite(texturaJugador);
                    break;
                default:
                    texturaJugador = Recursos.jugador_down;
                    break;
            }
        } else {
            switch (numGrafico) {
                case 0:
                    if (enMovimiento) {
                        if (resto > 5 && resto <= 10) {
                            texturaJugador = Recursos.jugador_down0;
                        } else if (resto > 10 && resto <= 15) {
                            texturaJugador = Recursos.jugador_down1;
                        } else if (resto > 15 && resto <= 20) {
                            texturaJugador = Recursos.jugador_down2;
                        } else if (resto > 20 && resto <= 25) {
                            texturaJugador = Recursos.jugador_down3;
                        } else if (resto > 25 && resto <= 30) {
                            texturaJugador = Recursos.jugador_down4;
                        } else if (resto > 30 && resto <= 35) {
                            texturaJugador = Recursos.jugador_down5;
                        } else if (resto > 35 && resto <= 40) {
                            texturaJugador = Recursos.jugador_down0;
                        } else if (resto > 40 && resto <= 45) {
                            texturaJugador = Recursos.jugador_down1;
                        } else if (resto > 45 && resto <= 50) {
                            texturaJugador = Recursos.jugador_down2;
                        } else if (resto > 50 && resto <= 55) {
                            texturaJugador = Recursos.jugador_down3;
                        } else if (resto > 55) {
                            texturaJugador = Recursos.jugador_down4;
                        } else {
                            texturaJugador = Recursos.jugador_down5;
                        }
                    } else {
                        texturaJugador = Recursos.jugador_down;
                    }
                    break;
                case 1:
                    if (enMovimiento) {
                        if (resto > 5 && resto <= 10) {
                            texturaJugador = Recursos.jugador_up0;
                        } else if (resto > 10 && resto <= 15) {
                            texturaJugador = Recursos.jugador_up1;
                        } else if (resto > 15 && resto <= 20) {
                            texturaJugador = Recursos.jugador_up2;
                        } else if (resto > 20 && resto <= 25) {
                            texturaJugador = Recursos.jugador_up3;
                        } else if (resto > 25 && resto <= 30) {
                            texturaJugador = Recursos.jugador_up4;
                        } else if (resto > 30 && resto <= 35) {
                            texturaJugador = Recursos.jugador_up5;
                        } else if (resto > 35 && resto <= 40) {
                            texturaJugador = Recursos.jugador_up0;
                        } else if (resto > 40 && resto <= 45) {
                            texturaJugador = Recursos.jugador_up1;
                        } else if (resto > 45 && resto <= 50) {
                            texturaJugador = Recursos.jugador_up2;
                        } else if (resto > 50 && resto <= 55) {
                            texturaJugador = Recursos.jugador_up3;
                        } else if (resto > 55) {
                            texturaJugador = Recursos.jugador_up4;
                        } else {
                            texturaJugador = Recursos.jugador_up5;
                        }
                    } else {
                        texturaJugador = Recursos.jugador_up;
                    }
                    break;
                case 2:
                    cambiarRecurso(corriendo, 3);
                    texturaJugador = OptimizadorRecursos.rotarSprite(texturaJugador);
                    texturaJugador = OptimizadorRecursos.voltearSprite(texturaJugador);
                    break;
                case 3:
                    if (enMovimiento) {
                        if (resto > 5 && resto <= 10) {
                            texturaJugador = Recursos.jugador_right0;
                        } else if (resto > 10 && resto <= 15) {
                            texturaJugador = Recursos.jugador_right1;
                        } else if (resto > 15 && resto <= 20) {
                            texturaJugador = Recursos.jugador_right2;
                        } else if (resto > 20 && resto <= 25) {
                            texturaJugador = Recursos.jugador_right3;
                        } else if (resto > 25 && resto <= 30) {
                            texturaJugador = Recursos.jugador_right4;
                        } else if (resto > 30 && resto <= 35) {
                            texturaJugador = Recursos.jugador_right5;
                        } else if (resto > 35 && resto <= 40) {
                            texturaJugador = Recursos.jugador_right0;
                        } else if (resto > 40 && resto <= 45) {
                            texturaJugador = Recursos.jugador_right1;
                        } else if (resto > 45 && resto <= 50) {
                            texturaJugador = Recursos.jugador_right2;
                        } else if (resto > 50 && resto <= 55) {
                            texturaJugador = Recursos.jugador_right3;
                        } else if (resto > 55) {
                            texturaJugador = Recursos.jugador_right4;
                        } else {
                            texturaJugador = Recursos.jugador_right5;
                        }
                    } else {

                        texturaJugador = Recursos.jugador_right;
                    }
                    break;
                case 4:
                    if (enMovimiento) {
                        if (resto > 5 && resto <= 10) {
                            texturaJugador = Recursos.jugador_diag_up0;
                        } else if (resto > 10 && resto <= 15) {
                            texturaJugador = Recursos.jugador_diag_up1;
                        } else if (resto > 15 && resto <= 20) {
                            texturaJugador = Recursos.jugador_diag_up2;
                        } else if (resto > 20 && resto <= 25) {
                            texturaJugador = Recursos.jugador_diag_up3;
                        } else if (resto > 25 && resto <= 30) {
                            texturaJugador = Recursos.jugador_diag_up4;
                        } else if (resto > 30 && resto <= 35) {
                            texturaJugador = Recursos.jugador_diag_up5;
                        } else if (resto > 35 && resto <= 40) {
                            texturaJugador = Recursos.jugador_diag_up0;
                        } else if (resto > 40 && resto <= 45) {
                            texturaJugador = Recursos.jugador_diag_up1;
                        } else if (resto > 45 && resto <= 50) {
                            texturaJugador = Recursos.jugador_diag_up2;
                        } else if (resto > 50 && resto <= 55) {
                            texturaJugador = Recursos.jugador_diag_up3;
                        } else if (resto > 55) {
                            texturaJugador = Recursos.jugador_diag_up4;
                        } else {
                            texturaJugador = Recursos.jugador_diag_up5;
                        }
                    } else {
                        texturaJugador = Recursos.jugador_diag_up;
                    }
                    break;
                case 5:
                    if (enMovimiento) {
                        if (resto > 5 && resto <= 10) {
                            texturaJugador = Recursos.jugador_diag_down0;
                        } else if (resto > 10 && resto <= 15) {
                            texturaJugador = Recursos.jugador_diag_down1;
                        } else if (resto > 15 && resto <= 20) {
                            texturaJugador = Recursos.jugador_diag_down2;
                        } else if (resto > 20 && resto <= 25) {
                            texturaJugador = Recursos.jugador_diag_down3;
                        } else if (resto > 25 && resto <= 30) {
                            texturaJugador = Recursos.jugador_diag_down4;
                        } else if (resto > 30 && resto <= 35) {
                            texturaJugador = Recursos.jugador_diag_down5;
                        } else if (resto > 35 && resto <= 40) {
                            texturaJugador = Recursos.jugador_diag_down0;
                        } else if (resto > 40 && resto <= 45) {
                            texturaJugador = Recursos.jugador_diag_down1;
                        } else if (resto > 45 && resto <= 50) {
                            texturaJugador = Recursos.jugador_diag_down2;
                        } else if (resto > 50 && resto <= 55) {
                            texturaJugador = Recursos.jugador_diag_down3;
                        } else if (resto > 55) {
                            texturaJugador = Recursos.jugador_diag_down4;
                        } else {
                            texturaJugador = Recursos.jugador_diag_down5;
                        }
                    } else {
                        texturaJugador = Recursos.jugador_diag_down;
                    }
                    break;
                case 6:
                    cambiarRecurso(corriendo, 4);
                    texturaJugador = OptimizadorRecursos.rotarSprite(texturaJugador);
                    texturaJugador = OptimizadorRecursos.voltearSprite(texturaJugador);
                    break;
                case 7:
                    cambiarRecurso(corriendo, 5);
                    texturaJugador = OptimizadorRecursos.rotarSprite(texturaJugador);
                    texturaJugador = OptimizadorRecursos.voltearSprite(texturaJugador);
                    break;
                default:
                    if (!enMovimiento) {
                        if (resto > 10 && resto <= 20) {
                            texturaJugador = Recursos.jugador_static;
                        } else if (resto > 20 && resto <= 30) {
                            texturaJugador = Recursos.jugador_static0;
                        } else if (resto > 30 && resto <= 40) {
                            texturaJugador = Recursos.jugador_static1;
                        } else if (resto > 40 && resto <= 50) {
                            texturaJugador = Recursos.jugador_static2;
                        } else if (resto > 50 && resto <= 60) {
                            texturaJugador = Recursos.jugador_static;
                        } else if (resto > 60) {
                            texturaJugador = Recursos.jugador_static0;
                        }
                    }
                    break;
            }
        }
    }

    private void actualizarVelocidad(double velocidad) {
        velocidadMOV = velocidad;
        velocidadDiag = velocidadMOV * Math.cos(Math.PI / 4);
    }
}
