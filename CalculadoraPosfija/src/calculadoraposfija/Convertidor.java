/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraposfija;

/**
 *
 * @author Jeferson Jimenez
 */
import java.util.*;

public class Convertidor {

    private String ultimaConvertida;

    public Convertidor() {
        ultimaConvertida = "0";
    }

    public String convertir(String expresion) throws SintaxException {
        Stack PilaNumeros = new Stack();
        Stack PilaOperadores = new Stack();
        String polinomio = quitarEspacios(expresion.toLowerCase());
        String fragmento;
        int pos = 0, tamano;
        byte cont;
        final String funciones[] = {
            "1 2 3 4 5 6 7 8 9 0 ( ) x e + - * / ^ %",
            "pi",
            "ln(",
            "log( abs( sen( sin( cos( tan( sec( csc( cot( sgn(",
            "rnd() asen( asin( acos( atan( asec( acsc( acot( senh( sinh( cosh( tanh( sech( csch( coth( sqrt(",
            "round( asenh( acosh( atanh( asech( acsch( acoth("
        };
        //Todas las funciones que trabajan como paréntesis de apertura están aquí.
        final String parentesis = "( ln log abs sen sin cos tan sec csc cot sgn asen asin acos atan asec acsc acot senh sinh cosh tanh sech csch coth sqrt round asenh asinh acosh atanh asech acsch acoth";

        byte anterior = 0;

        try {
            while (pos < polinomio.length()) {
                tamano = 0;
                cont = 1;
                while (tamano == 0 && cont <= 6) {
                    if (pos + cont <= polinomio.length() && funciones[cont - 1].contains(polinomio.substring(pos, pos + cont))) {
                        tamano = cont;
                    }
                    cont++;
                }

                if (tamano == 0) {
                    ultimaConvertida = "0";
                    CalculadoraPosfija.salida.setText("Error en la expresión");
                    throw new SintaxException("Error en la expresión");
                } else if (tamano == 1) { //Si encontró algo de tamaño uno
                    if (esNumero(polinomio.substring(pos, pos + tamano))) {
                        if (anterior == 1 || anterior == 4) {
                            sacarOperadores(PilaNumeros, PilaOperadores, "*");
                        }
                        fragmento = "";
                        do {
                            fragmento += polinomio.charAt(pos);
                            pos++;
                        } while (pos < polinomio.length() && (esNumero(polinomio.substring(pos, pos + tamano)) || polinomio.charAt(pos) == '.' || polinomio.charAt(pos) == ','));
                        try {
                            Double.valueOf(fragmento);
                        } catch (NumberFormatException e) {
                            ultimaConvertida = "0";
                            CalculadoraPosfija.salida.setText("Número mal digitado");
                            throw new SintaxException("Número mal digitado");
                        }
                        PilaNumeros.push(fragmento);
                        anterior = 1;
                        pos--;
                    } else if (polinomio.charAt(pos) == 'x' || polinomio.charAt(pos) == 'e') { //Si es un número conocido
                        if (anterior == 1 || anterior == 4) {//si hay una multiplicación oculta
                            sacarOperadores(PilaNumeros, PilaOperadores, "*");
                        }
                        PilaNumeros.push(polinomio.substring(pos, pos + tamano));
                        anterior = 1;
                    } else if (polinomio.charAt(pos) == '+' || polinomio.charAt(pos) == '*' || polinomio.charAt(pos) == '/' || polinomio.charAt(pos) == '%') { //Si es suma, multiplicación o división
                        if (anterior == 0 || anterior == 2 || anterior == 3)//Hay error si antes de los operadores no hay nada, hay un paréntesis de apertura o un operador
                        {
                            CalculadoraPosfija.salida.setText("Error en la expresión");
                            throw new SintaxException("Error en la expresión");
                        }

                        sacarOperadores(PilaNumeros, PilaOperadores, polinomio.substring(pos, pos + tamano));
                        anterior = 2;
                    } else if (polinomio.charAt(pos) == '^') { //Si es una potencia
                        if (anterior == 0 || anterior == 2 || anterior == 3) //Hay error si antes de un apotencia no hay nada, hay un paréntesis de apertura o un operador
                        {
                            CalculadoraPosfija.salida.setText("Error en la expresión");
                            throw new SintaxException("Error en la expresión");
                        }

                        PilaOperadores.push("^");
                        anterior = 2;
                    } else if (polinomio.charAt(pos) == '-') { //Si es una resta
                        if (anterior == 0 || anterior == 2 || anterior == 3) {//si hay un menos unario
                            PilaNumeros.push("-1");
                            sacarOperadores(PilaNumeros, PilaOperadores, "*");
                        } else {//si el menos es binario
                            sacarOperadores(PilaNumeros, PilaOperadores, "-");
                        }
                        anterior = 2;
                    } else if (polinomio.charAt(pos) == '(') {
                        if (anterior == 1 || anterior == 4) { //si hay una multiplicación oculta
                            sacarOperadores(PilaNumeros, PilaOperadores, "*");
                        }
                        PilaOperadores.push("(");
                        anterior = 3;
                    } else if (polinomio.charAt(pos) == ')') {
                        if (anterior != 1 && anterior != 4) //Antes de un cierre de paréntesis sólo puede haber un número u otro cierre de paréntesis, sino hay un error
                        {
                            CalculadoraPosfija.salida.setText("Error en la expresión");
                            throw new SintaxException("Error en la expresión");
                        }

                        while (!PilaOperadores.empty() && !parentesis.contains((String) PilaOperadores.peek())) {
                            sacaOperador(PilaNumeros, PilaOperadores);
                        }
                        if (!((String) PilaOperadores.peek()).equals("(")) {
                            PilaNumeros.push((((String) PilaNumeros.pop()) + " " + ((String) PilaOperadores.pop())));
                        } else {
                            PilaOperadores.pop();
                        }
                        anterior = 4;
                    }
                } else if (tamano >= 2) { //Si lo encontrado es de tamaño dos o mayor (todas las funciones se manejan igual)
                    fragmento = polinomio.substring(pos, pos + tamano);
                    switch (fragmento) {
                        case "pi":
                            if (anterior == 1 || anterior == 4) {//si hay una multiplicación oculta
                                sacarOperadores(PilaNumeros, PilaOperadores, "*");
                            }
                            PilaNumeros.push(fragmento);
                            anterior = 1;
                            break;
                        case "rnd()":
                            if (anterior == 1 || anterior == 4) {//si hay una multiplicación oculta
                                sacarOperadores(PilaNumeros, PilaOperadores, "*");
                            }
                            PilaNumeros.push("rnd");
                            anterior = 1;
                            break;
                        default:
                            if (anterior == 1 || anterior == 4) { //si hay una multiplicación oculta
                                sacarOperadores(PilaNumeros, PilaOperadores, "*");
                            }
                            PilaOperadores.push(fragmento.substring(0, fragmento.length() - 1)); //Se guarda en la pila de funciones sin el paréntesis de apertura (en postfijo no se necesita)
                            anterior = 3;
                            break;
                    }
                }
                pos += tamano;
            }

            while (!PilaOperadores.empty()) { //Saca todos los operadores mientras la pila no esté vacía
                if (parentesis.contains((String) PilaOperadores.peek())) {
                    CalculadoraPosfija.salida.setText("Hay un paréntesis de más");
                    throw new SintaxException("Hay un paréntesis de más");
                }
                sacaOperador(PilaNumeros, PilaOperadores);
            }

        } catch (EmptyStackException e) { //Si en algún momento se intenta sacar de la pila y está vacía hay un error
            ultimaConvertida = "0";
            CalculadoraPosfija.salida.setText("Expresión mal digitada");
            throw new SintaxException("Expresión mal digitada");
        }

        ultimaConvertida = ((String) PilaNumeros.pop()); //Se obtiene el resultado final

        if (!PilaNumeros.empty()) { //Si la pila de números no quedó vacía hay un error
            ultimaConvertida = "0";
            CalculadoraPosfija.salida.setText("Error en la expresión");
            throw new SintaxException("Error en la expresión");
        }

        return ultimaConvertida; //Se devuelve el resultado evaluado
    }

    public double resolver(String expresionParseada, double x) throws ArithmeticException {
        Stack pilaEvaluar = new Stack();
        double a, b;
        StringTokenizer tokens = new StringTokenizer(expresionParseada); //La expresión partida en tokens
        String tokenActual; //El token que se procesa actualmente

        try {
            while (tokens.hasMoreTokens()) {
                tokenActual = tokens.nextToken();
                switch (tokenActual) {
                    case "e":
                        //Si es el número e
                        pilaEvaluar.push(Math.E);
                        break;
                    case "pi":
                        //Si es el número pi
                        pilaEvaluar.push(Math.PI);
                        break;
                    case "x":
                        //Si es una x se introduce el valor a evaluar por el usuario
                        pilaEvaluar.push(x);
                        break;
                    case "+":
                        //Si es una suma se sacan dos números y se suman
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(a + b);
                        break;
                    case "-":
                        //Si es resta se sacan dos valores y se restan (así con todos los operadores)
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(a - b);
                        break;
                    case "*":
                        //Multiplicación
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(a * b);
                        break;
                    case "/":
                        //División
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        if (b == 0) {
                             return Double.NaN;
                        } else {
                            pilaEvaluar.push(a / b);
                        }
                        break;
                    case "^":
                        //Potencia
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.pow(a, b));
                        break;
                    case "%":
                        //Resto de la división entera
                        b = ((Double) pilaEvaluar.pop());
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(a % b);
                        break;
                    case "ln":
                        //Si es logaritmo natural sólo se saca un valor de la pila y se evalúa
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log(a));
                        break;
                    case "log":
                        //Logaritmo en base 10
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log(a) / Math.log(10));
                        break;
                    case "abs":
                        //Valor absoluto
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.abs(a));
                        break;
                    case "rnd":
                        //Un número a random simplemente se mete en la pila de números
                        pilaEvaluar.push(Math.random());
                        break;
                    case "sen":
                    case "sin":
                        //Seno
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.sin(a));
                        break;
                    case "cos":
                        //Coseno
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.cos(a));
                        break;
                    case "tan":
                        //Tangente
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.tan(a));
                        break;
                    case "sec":
                        //Secante
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(1 / Math.cos(a));
                        break;
                    case "csc":
                        //Cosecante
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(1 / Math.sin(a));
                        break;
                    case "cot":
                        //Cotangente
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(1 / Math.tan(a));
                        break;
                    case "sgn":
                        //Signo
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(hallarSigno(a));
                        break;
                    case "asen":
                    case "asin":
                        //Arcoseno
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.asin(a));
                        break;
                    case "acos":
                        //Arcocoseno
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.acos(a));
                        break;
                    case "atan":
                        //Arcotangente
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.atan(a));
                        break;
                    case "asec":
                        //Arcosecante
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.acos(1 / a));
                        break;
                    case "acsc":
                        //Arcocosecante
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.asin(1 / a));
                        break;
                    case "acot":
                        //Arcocotangente
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.atan(1 / a));
                        break;
                    case "senh":
                    case "sinh":
                        //Seno hiperbólico
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push((Math.exp(a) - Math.exp(-a)) / 2);
                        break;
                    case "cosh":
                        //Coseno hiperbólico
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push((Math.exp(a) + Math.exp(-a)) / 2);
                        break;
                    case "tanh":
                        //tangente hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push((Math.exp(a) - Math.exp(-a)) / (Math.exp(a) + Math.exp(-a)));
                        break;
                    case "sech":
                        //Secante hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(2 / (Math.exp(a) + Math.exp(-a)));
                        break;
                    case "csch":
                        //Cosecante hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(2 / (Math.exp(a) - Math.exp(-a)));
                        break;
                    case "coth":
                        //Cotangente hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push((Math.exp(a) + Math.exp(-a)) / (Math.exp(a) - Math.exp(-a)));
                        break;
                    case "asenh":
                    case "asinh":
                        //Arcoseno hiperbólico
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log(a + Math.sqrt(a * a + 1)));
                        break;
                    case "acosh":
                        //Arcocoseno hiperbólico
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log(a + Math.sqrt(a * a - 1)));
                        break;
                    case "atanh":
                        //Arcotangente hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log((1 + a) / (1 - a)) / 2);
                        break;
                    case "asech":
                        //Arcosecante hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log((Math.sqrt(1 - a * a) + 1) / a));
                        break;
                    case "acsch":
                        //Arcocosecante hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log((hallarSigno(a) * Math.sqrt(a * a + 1) + 1) / a));
                        break;
                    case "acoth":
                        //Arcocotangente hiperbólica
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.log((a + 1) / (a - 1)) / 2);
                        break;
                    case "sqrt":
                        //Raíz cuadrada
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(Math.sqrt(a));
                        break;
                    case "round":
                        //Redondear
                        a = ((Double) pilaEvaluar.pop());
                        pilaEvaluar.push(new Double(Long.toString(Math.round(a))));
                        break;
                    default:
                        //si es otra cosa tiene que ser un número, simplemente se mete en la pila
                        pilaEvaluar.push(Double.valueOf(tokenActual));
                        break;
                }
            }
        } catch (EmptyStackException e) {
            throw new ArithmeticException("Expresión mal convertida");
        } catch (NumberFormatException e) {
            throw new ArithmeticException("Expresión mal digitada");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Valor no real en la expresión");
        }

        a = ((Double) pilaEvaluar.pop());

        if (!pilaEvaluar.empty()) {
            throw new ArithmeticException("Expresión mal digitada");
        }

        return a;
    }

    public double resolver(double x) throws ArithmeticException {
        try {
            return Convertidor.this.resolver(ultimaConvertida, x);
        } catch (ArithmeticException e) {
            throw e;
        }
    }

    private void sacaOperador(Stack Numeros, Stack operadores) throws EmptyStackException {
        String operador, a, b;
        final String operadoresBinarios = "+ - * / ^ %";

        try {
            operador = (String) operadores.pop();

            if (operadoresBinarios.contains(operador)) {
                b = (String) Numeros.pop();
                a = (String) Numeros.pop();
                Numeros.push((a + " " + b + " " + operador));
            } else {
                a = (String) Numeros.pop();
                Numeros.push((a + " " + operador));
            }
        } catch (EmptyStackException e) {
            throw e;
        }
    }

    private void sacarOperadores(Stack PilaNumeros, Stack PilaOperadores, String operador) {
        final String parentesis = "( ln log abs sen sin cos tan sec csc cot sgn asen asin acos atan asec acsc acot senh sinh cosh tanh sech csch coth sqrt round asenh asinh acosh atanh asech acsch acoth";

        while (!PilaOperadores.empty() && !parentesis.contains((String) PilaOperadores.peek()) && ((String) PilaOperadores.peek()).length() == 1 && prioridad(((String) PilaOperadores.peek()).charAt(0)) >= prioridad(operador.charAt(0))) {
            sacaOperador(PilaNumeros, PilaOperadores);
        }
        PilaOperadores.push(operador);//Al final mete el nuevo operador luego de sacar todo lo que tenía que sacar.
    }

    private int prioridad(char s) {
        switch (s) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
            case '%':
                return 1;
            case '^':
                return 2;
            default:
                break;
        }

        return -1;
    }

    private boolean esNumero(String s) {
        return s.compareTo("0") >= 0 && s.compareTo("9") <= 0;
    }

    //Quita los espacios del String
    private String quitarEspacios(String polinomio) {
        String sinEspacios = "";

        for (int i = 0; i < polinomio.length(); i++) {
            if (polinomio.charAt(i) != ' ') {
                sinEspacios += polinomio.charAt(i);
            }
        }

        return sinEspacios;
    }

    private double hallarSigno(double a) {
        if (a < 0) {
            return -1;
        } else if (a > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private class SintaxException extends ArithmeticException {

        public SintaxException() {
            super("Error de sintaxis en el polinomio");
            CalculadoraPosfija.salida.setText("Error de sintaxis en el polinomio");
        }

        public SintaxException(String e) {
            super(e);
        }
    }
}
