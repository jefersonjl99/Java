/*
 * Copyright <2021> <JEFERSON JIMENEZ>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining 
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fabrica;

/**
 *
 * @author jorge malaver
 */
import monedas.*;
//import Almacenes.Jumbo;
import abstracto.Comun;

public class Fabrica {

    protected int seleccion;

    public Fabrica(int sel) {//constructor 
        seleccion = sel;
    }

    public Comun crear_selecion() { //
        switch (seleccion) {
            case 1:
                // Si el string ingresado es igual a 1 devuelve una instancia de la clase Dolar
                return new Dolar();
            case 2:
                // Si el string ingresado es igual a 2 devuelve una instancia de la clase Euro
                return new Euro();
            case 3:
                // Si el string ingresado es igual a 3 devuelve una instancia de la clase Libra
                return new Libra();
            case 4:
                // Si el string ingresado es igual a 4 devuelve una instancia de la clase Rublo
                return new Rublo();
            case 5:
                // Si el string ingresado es igual a 5 devuelve una instancia de la clase Yen
                return new Yen();
            case 6:
                // Si el string ingresado es igual a 1 devuelve una instancia de la clase Yuan
                return new Yuan();
            default:
                return null;// Si el string ingresado es igual a diferente a los mecionados, retorna null}
        }
    }

}
