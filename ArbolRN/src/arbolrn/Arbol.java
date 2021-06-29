/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolrn;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Jeferson Jimenez
 */
public class Arbol {

    public Nodo raiz;//declarar nodo raiz
    private final Nodo NULL;
    public ArrayList<String> lista = new ArrayList<>();

    int altura, gordura;
    boolean completo;
    ArrayList arr = new ArrayList();
    int[] niveles;

    private static final Font FUENTE = new Font("TimesRoman", Font.BOLD, 14);

    private int fila;
    private Nodo existente;

    int altura(Nodo r) {
        if (r == null) {
            return 0;
        }
        return Math.max(altura(r.hijoIzquierdo), altura(r.hijoDerecho)) - 1;
    }

    public int retornarAltura(Nodo r) {
        altura = 0;
        retornarAltura(r, 1);
        return altura - 1;
    }

    private void retornarAltura(Nodo r, int nivel) {
        if (r != null) {
            retornarAltura(r.hijoIzquierdo, nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(r.hijoDerecho, nivel + 1);
        }
    }

    int gordura(Nodo r) {
        niveles = new int[altura];
        for (int i = 0; i < niveles.length; i++) {
            niveles[i] = nodoN(r, i);
        }
        for (int i = 0; i < niveles.length; i++) {
            if (gordura <= niveles[i]) {
                gordura = niveles[i];
            }
        }
        return gordura;
    }

    int nodoN(Nodo r, int n) {
        if (r != null) {
            if (n == 0) {
                return nodoN(r.hijoIzquierdo, n - 1) + nodoN(r.hijoDerecho, n - 1) + 1;
            } else {
                return nodoN(r.hijoIzquierdo, n - 1) + nodoN(r.hijoDerecho, n - 1);
            }
        }
        return 0;
    }

    public Nodo getExistente() {
        return existente;
    }

    public void setExistente(Nodo existente) {
        this.existente = existente;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    private void preOrden(Nodo node) {
        if (node != NULL) {
            System.out.print(node.clave + " ");
            preOrden(node.hijoIzquierdo);
            preOrden(node.hijoDerecho);
        }
    }

    private void inOrder(Nodo node) {
        if (node != NULL) {
            inOrder(node.hijoIzquierdo);
            System.out.print("(" + node.clave + ", " + node.nombre + ")");
            inOrder(node.hijoDerecho);
        }
    }

    ArrayList inOrden(Nodo r) {
        if (r != null) {
            inOrden(r.hijoIzquierdo);
            System.out.print("(" + r.clave + ", " + r.nombre + ")");
            lista.add(Integer.toString(r.clave));
            inOrden(r.hijoDerecho);
        }
        return lista;
    }

    void inorden(Nodo p, Graphics lienzo) {
        lienzo.setFont(FUENTE);
        lienzo.setColor(Color.WHITE);
        String color;
        if (p.color == 0) {
            color = "Rojo";
        } else {
            color = "Negro";
        }
        if (p != null) {
            if (p.clave != 0) {

                inorden(p.hijoIzquierdo, lienzo);
                lienzo.drawString("" + p.clave + " | " + p.nombre + " | " + color, 5, ++fila * 20);
                inorden(p.hijoDerecho, lienzo);
            }
        }
    }

    private void postOrden(Nodo node) {
        if (node != NULL) {
            postOrden(node.hijoIzquierdo);
            postOrden(node.hijoDerecho);
            System.out.print(node.clave + " ");
        }
    }

    //Recursividad
    //Operacion basica de los arboles
    //tipo nodo
    private Nodo buscarArbol(Nodo node, int key) {//al momento de buscar le damos el dato representado con la variable key, y la raiz

        if (node == NULL || key == node.clave) {//si node(raiz) es null se llena con null y se retorna null porque no hay nada, si node de clave es igual a key quiere decir que ya lo encontro y lo devuelve
            return node;//reotrno de node tipo nodo
        }

        if (key < node.clave) {//Si node de clave es mayor al dato buscado(key), 
            return buscarArbol(node.hijoIzquierdo, key);//recursividad, buscamos por la izquierda si es mayor, node de hijo izquierdo, buscar recibe un parametro a parte del nodo que es un dato(key)
        }
        return buscarArbol(node.hijoDerecho, key);//Si no es mayor es menor, entonces buscara por la izquierda
    }

    private void nuevoPadre(Nodo u, Nodo v) {//u nodo actual
        if (u.padre == null) {//si el padre del nodo actual(u) es null la raiz va ser v
            raiz = v;
        } else if (u == u.padre.hijoIzquierdo) {//Si nodo actual es igual al padre del hijo izquierdo
            u.padre.hijoIzquierdo = v;//v se carga con el padre del hijo izquierdo
        } else {
            u.padre.hijoDerecho = v;//v se carga con el padre del hijo derecho
        }
        v.padre = u.padre;//el padre del nodo actual y del nodo v es el mismo
    }

    private int buscar_nodo(Nodo nodo, int key) {

        Nodo z = NULL;//nodo actual
        while (nodo != NULL) {
            if (nodo.clave == key) {
                z = nodo;
            }
            if (nodo.clave <= key) {//navega por derecha y por izquierda hasta llegar al nodo encontrado
                nodo = nodo.hijoDerecho;
            } else {
                nodo = nodo.hijoIzquierdo;
            }
        }

        if (z == NULL) {
            System.out.println("La llave no existe");
            return 0;
        }
        existente = z;
        return 1;
    }

    private int eliminar(Nodo nodo, int key) {//key: valor a eliminar
        Nodo z = NULL;//nodo actual
        Nodo x;
        Nodo y;
        while (nodo != NULL) {
            if (nodo.clave == key) {
                z = nodo;
            }
            if (nodo.clave <= key) {//navega por derecha y por izquierda hasta llegar al nodo encontrado
                nodo = nodo.hijoDerecho;
            } else {
                nodo = nodo.hijoIzquierdo;
            }
        }

        if (z == NULL) {
            return 2;
        }

        y = z;
        //System.out.println("color"+y.color);
        int yColorOriginal = y.color;
        if (z.hijoIzquierdo == NULL) {//si el nodo que se quiere eliminar tiene hijo izquierdo
            x = z.hijoDerecho;//si hijo izquierdo no existe se guarda en x(temp) guarda el hijo derecho, no existe hijo izquierdo pero puede existir hijo derecho
            nuevoPadre(z, z.hijoDerecho);
        } else if (z.hijoDerecho == NULL) {//si el nodo que se quiere eliminar tiene hijo derecho
            x = z.hijoIzquierdo;//si hijo derecho no existe se guarda en x(temp) guarda el hijo izquierdo
            nuevoPadre(z, z.hijoIzquierdo);
        } else {
            //nodo con dos hijos, se busca el predecesor, valor maximo asubarbol izquierdo
            y = minimum(z.hijoDerecho);
            yColorOriginal = y.color;
            x = y.hijoDerecho;
            if (y.padre == z) {
                x.padre = y;
            } else {
                nuevoPadre(y, y.hijoDerecho);
                y.hijoDerecho = z.hijoDerecho;
                y.hijoDerecho.padre = y;
            }

            nuevoPadre(z, y);
            y.hijoIzquierdo = z.hijoIzquierdo;
            y.hijoIzquierdo.padre = y;
            y.color = z.color;
        }
        if (yColorOriginal == 0) {
            balanceoEl(x);
        }
        return 0;
    }

    // Balanceo del arbol despues de eliminar un nodo
    private void balanceoEl(Nodo x) {//Recibimos parametro de tipo Nodo
        Nodo s;
        while (x != raiz && x.color == 0) {
            if (x == x.padre.hijoIzquierdo) {
                s = x.padre.hijoDerecho;
                if (s.color == 1) {//1 NEGRO
                    s.color = 0;//o ROJO
                    x.padre.color = 1;
                    RotacionIzq(x.padre);
                    s = x.padre.hijoDerecho;
                }

                if (s.hijoIzquierdo.color == 0 && s.hijoDerecho.color == 0) {
                    s.color = 1;
                    x = x.padre;
                } else {
                    if (s.hijoDerecho.color == 0) {
                        s.hijoIzquierdo.color = 0;
                        s.color = 1;
                        RotacionDer(s);//Se le manda de paramtro s
                        s = x.padre.hijoDerecho;
                    }

                    s.color = x.padre.color;
                    x.padre.color = 0;
                    s.hijoDerecho.color = 0;
                    RotacionIzq(x.padre);
                    x = raiz;
                }
            } else {
                s = x.padre.hijoIzquierdo;
                if (s.color == 1) {
                    s.color = 0;
                    x.padre.color = 1;
                    RotacionDer(x.padre);
                    s = x.padre.hijoIzquierdo;
                }

                if (s.hijoDerecho.color == 0 && s.hijoDerecho.color == 0) {
                    s.color = 1;
                    x = x.padre;
                } else {
                    if (s.hijoIzquierdo.color == 0) {
                        s.hijoDerecho.color = 0;
                        s.color = 1;
                        RotacionIzq(s);
                        s = x.padre.hijoIzquierdo;
                    }

                    s.color = x.padre.color;
                    x.padre.color = 0;
                    s.hijoIzquierdo.color = 0;
                    RotacionDer(x.padre);
                    x = raiz;
                }
            }
        }
        x.color = 0;
    }

    // Balancea el nodo despues de una insercion 
    private void balanceoIn(Nodo k) {//Recibimos parametro de tipo Nodo
        Nodo u;
        while (k.padre.color == 1) {
            if (k.padre == k.padre.padre.hijoDerecho) {
                u = k.padre.padre.hijoIzquierdo;
                if (u.color == 1) {
                    u.color = 0;
                    k.padre.color = 0;
                    k.padre.padre.color = 1;
                    k = k.padre.padre;
                } else {
                    if (k == k.padre.hijoIzquierdo) {
                        k = k.padre;
                        RotacionDer(k);
                    }
                    k.padre.color = 0;
                    k.padre.padre.color = 1;
                    RotacionIzq(k.padre.padre);
                }
            } else {
                u = k.padre.padre.hijoDerecho;

                if (u.color == 1) {
                    u.color = 0;
                    k.padre.color = 0;
                    k.padre.padre.color = 1;
                    k = k.padre.padre;
                } else {
                    if (k == k.padre.hijoDerecho) {
                        k = k.padre;
                        RotacionIzq(k);
                    }
                    k.padre.color = 0;
                    k.padre.padre.color = 1;
                    RotacionDer(k.padre.padre);
                }
            }
            if (k == raiz) {
                break;
            }
        }
        raiz.color = 0;
    }

    private void imprimir(Nodo root, String indent, boolean last) {
        if (root != NULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = root.color == 1 ? "rojo" : "negro";
            System.out.println(root.clave + "(" + sColor + ")");
            imprimir(root.hijoIzquierdo, indent, false);
            imprimir(root.hijoDerecho, indent, true);
        }
    }

    public Arbol() {
        NULL = new Nodo();
        NULL.color = 0;
        NULL.hijoIzquierdo = null;
        NULL.hijoDerecho = null;
        raiz = NULL;
    }

    public void preorder() {
        preOrden(this.raiz);
    }

    public void inorder() {
        inOrder(this.raiz);
    }

    public void postorder() {
        postOrden(this.raiz);
    }

    private Nodo searchTree(int k) {
        return buscarArbol(this.raiz, k);
    }

    //buscar minimo
    private Nodo minimum(Nodo node) {//se recibe nodo
        while (node.hijoIzquierdo != NULL) {//node=actual
            node = node.hijoIzquierdo;//mientras exista hijo izquierdo se va accediendo iterativamente
        }
        return node;//cuando no existe hijo izquierdo estamos situados en el nodo que tiene el valor actual y se procede a retornarlo
    }

    //buscar maximo
    private Nodo maximum(Nodo node) {
        while (node.hijoDerecho != NULL) {
            node = node.hijoDerecho;//mientras exista hijo derecho se va accediendo iterativamente
        }
        return node;//cuando no existe hijo derecho estamos situados en el nodo que tiene el valor actual y se procede a retornarlo
    }

    public Nodo successor(Nodo x) {
        if (x.hijoDerecho != NULL) {
            return minimum(x.hijoDerecho);
        }

        Nodo y = x.padre;
        while (y != NULL && x == y.hijoDerecho) {
            x = y;
            y = y.padre;
        }
        return y;
    }

    public Nodo predecessor(Nodo x) {
        if (x.hijoIzquierdo != NULL) {
            return maximum(x.hijoIzquierdo);
        }

        Nodo y = x.padre;
        while (y != NULL && x == y.hijoIzquierdo) {
            x = y;
            y = y.padre;
        }

        return y;
    }

    //rotacion a la izquierda
    public void RotacionIzq(Nodo x) {//recibe un nodo de tipo Nodo que se llamara x
        Nodo y = x.hijoDerecho;//Puntero del tipo Nodo que se llamara y
        x.hijoDerecho = y.hijoIzquierdo;//tiene un hijo izquierdo y lo dejamos como hijo derecho de x - no perderlo
        if (y.hijoIzquierdo != NULL) {
            y.hijoIzquierdo.padre = x;
        }
        y.padre = x.padre;
        if (x.padre == null) {
            this.raiz = y;
        } else if (x == x.padre.hijoIzquierdo) {
            x.padre.hijoIzquierdo = y;
        } else {
            x.padre.hijoDerecho = y;
        }
        y.hijoIzquierdo = x;
        x.padre = y;
    }

    //rotacion a la derecha
    public void RotacionDer(Nodo x) {//x:nodo actual
        Nodo y = x.hijoIzquierdo;//x lo apuntamos hacia el hijo izquierdo
        x.hijoIzquierdo = y.hijoDerecho;//tiene un hijo derecho y lo dejamos como hijo izquierdo de x - no perderlo
        if (y.hijoDerecho != NULL) {
            //Se realiza la rotación
            y.hijoDerecho.padre = x;//el padre del hijo derecho de y va a ser igual a x
        }
        //actualizacion
        y.padre = x.padre;
        if (x.padre == null) {
            this.raiz = y;
        } else if (x == x.padre.hijoDerecho) {
            x.padre.hijoDerecho = y;
        } else {
            x.padre.hijoIzquierdo = y;
        }
        y.hijoDerecho = x;
        x.padre = y;
    }

    //metodo recursivo insertar
    public int insert(int key, String s) {//recibimos el dato
        Nodo nodo = new Nodo();//nodo
        nodo.padre = null;
        nodo.clave = key;
        nodo.nombre = s;
        nodo.hijoIzquierdo = NULL;
        nodo.hijoDerecho = NULL;
        nodo.color = 1;

        Nodo y = null;
        Nodo x = this.raiz;

        while (x != NULL) {
            y = x;
            if (nodo.clave < x.clave) {//si el valor que queremos es menor que el valor del nodo que estamos revisando visitamos su hijo izquierdo
                x = x.hijoIzquierdo;
            } else if (nodo.clave > x.clave) {//si es mayor hijo derecho
                x = x.hijoDerecho;
            } else {
                return 2;
            }
        }

        nodo.padre = y;
        if (y == null) {//no habia nodos
            raiz = nodo;//raiz es igual al nuevo nodo insertado
        } else if (nodo.clave < y.clave) {//
            y.hijoIzquierdo = nodo;
        } else {
            y.hijoDerecho = nodo;
        }
        //System.out.println("padre "+y.clave);
        System.out.println("nodo " + nodo.clave);
        if (nodo.padre == null) {
            nodo.color = 0;
            return 0;
        }

        if (nodo.padre.padre == null) {
            return 1;
        }

        balanceoIn(nodo);//luego de la inserción actualiza los nodos
        return 0;
    }

    private Nodo getRaiz() {
        return this.raiz;
    }

    public int getColor(Nodo nodo) {
        return nodo.color;
    }

    public int eliminarNodo(int data) {
        return eliminar(this.raiz, data);
    }

    public int buscarNodo(int data) {
        return buscar_nodo(this.raiz, data);
    }

    public void printTree() {
        imprimir(this.raiz, "", true);
    }

}
