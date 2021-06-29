/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerprograma;

class sumardosnumeros{
  double x,y;
  double respuesta;
  sumardosnumeros(double x, double y){
    this.x=x;
    this.y=y;
  }
  void sumar(){
    respuesta = x+y;
  }
  double mostrar() {
    return respuesta;
  }
}