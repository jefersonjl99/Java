/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Graphics;

/**
 *
 * @author juanc
 */
public class Dibuja {
    
     public static int nodoCompleto(NodoDibujo nodo){
       NodoDibujo p = nodo;
       if(p==null){
           return 0;
       }else{
           if(p.hijoIzquierda != null && p.hijoDerecha != null){
               return nodoCompleto(p.hijoIzquierda) + nodoCompleto(p.hijoDerecha)+1;
           }else{
               return nodoCompleto(p.hijoIzquierda) + nodoCompleto(p.hijoDerecha);
           }
       }
   }
     
     public void DibujaArbol(Graphics g, int x, int y, NodoDibujo nodo){
       NodoDibujo padre = nodo;
       //nodoCompleto(padre);
       if(padre==null){
           System.out.println("nodo vacio");
       }else{
           int extra = nodoCompleto(padre)*15;

 
           g.drawString(Integer.toString(padre.clave), x, y);
           if(padre.hijoIzquierda != null){
               g.drawLine(x-3, y+3, x-19-extra, y+27);
           }if(padre.hijoDerecha != null){
               g.drawLine(x+10, y-3, x+27+extra, y+27);
           }
           DibujaArbol(g, x-30-extra, y+30, padre.hijoIzquierda);
           DibujaArbol(g, x+30+extra, y+30, padre.hijoDerecha);
           
       }
 
    }
}
