/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.vuelo;

import ubicacion.Ciudad;

/**
 *
 * @author Jeferson Jimenez
 */
public class Vuelo {

    private Ciudad destino;
    private String codigo;
    private String fecha;
    private String hora;
    private int[][] sillasOcupadas;
    private int porcentajeLibre;

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int[][] getSillasOcupadas() {
        return sillasOcupadas;
    }

    public void setSillasOcupadas(int[][] sillasOcupadas) {
        this.sillasOcupadas = sillasOcupadas;
    }

    public int getPorcentajeLibre() {
        return porcentajeLibre;
    }

    public void setPorcentajeLibre(int porcentajeLibre) {
        this.porcentajeLibre = porcentajeLibre;
    }

}
