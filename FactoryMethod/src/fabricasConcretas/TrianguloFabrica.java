/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricasConcretas;

import fabricaAbstracta.Triangulo;
import fabricaAbstracta.TrianguloCreador;
import triangulosConcretos.Equilatero;
import triangulosConcretos.Escaleno;
import triangulosConcretos.Isoceles;

/**
 *
 * @author Jeferson Jimenez
 */
public class TrianguloFabrica implements TrianguloCreador {

    @Override
    public Triangulo crearTriangulo(int ladoA, int ladoB, int ladoC) {
        if ((ladoA == ladoB) && (ladoA == ladoC)) {
            return new Equilatero(ladoA, ladoB, ladoC);
        } else if ((ladoA != ladoB) && (ladoA != ladoC) && (ladoB != ladoC)) {
            return new Escaleno(ladoA, ladoB, ladoC);
        } else {
            return new Isoceles(ladoA, ladoB, ladoC);
        }
    }

}
