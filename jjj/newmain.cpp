#include <iostream>
#include <stdlib.h>
#include <cstdlib>
using namespace std;

struct nodo_cliente {
    int cc;
    string nombre;
    struct nodo_cliente *sgte;
};

struct nodo_prestamo {
    int codigo; //codigo del prestamo
    int valor; // valor del prestamo
    int plazo; //plazo en meses del prestamo
    nodo_cliente *cliente;
    int sucursal;
    struct nodo_prestamo *sgte; //siguiente prestamo en la lista
};

bool buscarPrestamo(struct nodo_prestamo *lista, int codigo) {
    struct nodo_prestamo *q = lista;

    while (q != NULL) {//mientras el nodo actual no sea nulo avanza hasta encontrar el nodo con el valor ingresado
        if (q->codigo == codigo) {//
            return true; //si lo encuentra retorna verdadero
        }
        q = q->sgte;
    }
    return false; //si no lo encuentra retorna falso
}

struct nodo_cliente *buscarCliente(struct nodo_cliente *lista, int cc) {
    struct nodo_cliente *q = lista;

    while (q != NULL) {//mientras el nodo actual no sea nulo avanza hasta encontrar el nodo con el valor ingresado
        if (q->cc == cc) {
            return q; //si lo encuentra retorna el nodo que tiene el mismo numero de cedula
        }
        q = q->sgte;
    }
    return NULL; // si no lo encuentra retorna nulo
}

struct nodo_cliente *insertarCliente(struct nodo_cliente * &clientes, int cc) {//inserta clientes en una lista con su cedula

    if (buscarCliente(clientes, cc) != NULL) { //Si ya esta registrado el cliente retorna este mismo

        cout << "\n CLIENTE EXISTENTE";
        return buscarCliente(clientes, cc);

    } else {//Si no esta registrado lo agrega en el lugar correspondiente y lo devuelve

        struct nodo_cliente *nuevo_cliente;
        string nombre;
        nuevo_cliente = new(struct nodo_cliente);

        cout << "\n INGRESE EL NOMBRE DEL CLIENTE: ";
        cin>>nombre;

        nuevo_cliente->cc = cc;
        nuevo_cliente->nombre = nombre;
        nuevo_cliente->sgte = NULL;

        if (clientes == NULL) {// si la lista es nula agrega el nuevo cliente en la cabeza
            clientes = nuevo_cliente;
        } else {//si no, recorre la lista hasta encontrar uno mayor a el teniendo en cuenta el anterior y el siguiente y lo mete en medio de los dos
            if (cc < clientes->cc) {
                nuevo_cliente->sgte = clientes;
                clientes = nuevo_cliente;
            } else {
                struct nodo_cliente *reco = clientes;
                struct nodo_cliente *atras = clientes;
                while (cc >= reco->cc && reco->sgte != NULL) {
                    atras = reco;
                    reco = reco->sgte;
                }
                if (cc >= reco->cc) {
                    reco->sgte = nuevo_cliente;
                } else {
                    nuevo_cliente->sgte = reco;
                    atras->sgte = nuevo_cliente;
                }
            }
        }

        cout << "\n CLIENTE AGREGADO";
        return nuevo_cliente;
    }
}

void insertarPrestamo(struct nodo_prestamo * &prestamos, struct nodo_cliente * &clientes, int codigo) {

    if (buscarPrestamo(prestamos, codigo)) {
        cout << "\nEL PRESTAMO #" << codigo << " YA EXISTE, POR FAVOR INTENTE NUEVAMENTE...";
    } else {
        struct nodo_prestamo *recorrido, *nuevo_prestamo = new(struct nodo_prestamo);
        int valor, plazo, cc, sucursal;
        do {
            cout << "\n DIGITE EL VALOR DEL PRESTAMO: $";
            cin>>valor;
            if (valor <= 0) {
                cout << "\n INGRESE UN VALOR VALIDO!";
            }
        } while (valor <= 0);
        do {
            cout << "\n DIGITE EL PLAZO (EN MESES) DEL PRESTAMO: ";
            cin>>plazo;
            if (plazo <= 0) {
                cout << "\n INGRESE UN PLAZO VALIDO!";
            }
        } while (plazo <= 0);
        do {
            cout << "\n DIGITE EL CODIGO DE LA SUCURSAL: ";
            cin>>sucursal;
            if (sucursal <= 0) {
                cout << "\n INGRESE UNA SUCURSAL VALIDA!";
            }
        } while (sucursal <= 0);
        do {
            cout << "\n DIGITE LA CEDULA DEL CLIENTE: ";
            cin>>cc;
            if (cc <= 0) {
                cout << "\n INGRESE UNA CEDULA VALIDA!";
            }
        } while (cc <= 0);
        struct nodo_cliente *cliente_actual = insertarCliente(clientes, cc);

        nuevo_prestamo->codigo = codigo;
        nuevo_prestamo->valor = valor;
        nuevo_prestamo->plazo = plazo;
        nuevo_prestamo->sucursal = sucursal;
        nuevo_prestamo->cliente = cliente_actual;
        nuevo_prestamo->sgte = NULL;

        if (prestamos == NULL) {
            prestamos = nuevo_prestamo;
        } else {
            recorrido = prestamos;
            while (recorrido->sgte != NULL) {
                recorrido = recorrido->sgte;
            }
            recorrido->sgte = nuevo_prestamo;
        }

        cout << "\n PRESTAMO #" << codigo << " AGREGADO EXITOSAMENTE.";
    }
}

void reportarClientes(struct nodo_cliente * lista) {
    int i = 0;
    if (lista != NULL) {

        while (lista != NULL) {
            cout << ' ' << i + 1 << ") CC #" << lista->cc << " " << lista->nombre << endl;
            lista = lista->sgte;
            i++;
        }
    } else {
        cout << "\n NO SE ENCUENTRAN CLIENTES REGISTRADOS.";
    }
}

void reportarPrestamos(struct nodo_prestamo * lista, int sucursal) {
    int i = 0;
    int j = 0;
    if (lista != NULL) {
        while (lista != NULL) {
            if (lista->sucursal == sucursal) {
                cout << ' ' << i + 1 << ") PRESTAMO #" << lista->codigo << " CC #" << lista->cliente->cc << "  " << lista->cliente->nombre << endl;
                j++;
            }
            lista = lista->sgte;
            i++;
        }
        if (j == 0) {
            cout << "\n NO SE ENCUENTRAN PRESTAMOS REGISTRADOS PARA LA SUCURSAL " << sucursal << ".";
        }
    } else {
        cout << "\n NO SE ENCUENTRAN PRESTAMOS REGISTRADOS.";
    }
}

void eliminarPrestamo(struct nodo_prestamo * &prestamos, int codigo, int cc) {

    if (buscarPrestamo(prestamos, codigo)) {

        struct nodo_prestamo * p, *ant;
        p = prestamos;

        if (prestamos != NULL) {
            while (p != NULL) {
                if (p->codigo == codigo) {
                    if (p->cliente->cc == cc) {

                        if (p == prestamos) {
                            prestamos = prestamos->sgte;
                        } else {
                            ant->sgte = p->sgte;
                        }
                        delete(p);
                        cout << "\n PRESTAMO #" << codigo << " ELIMINADO EXITOSAMENTE!";
                        return;
                        
                    }else{
                        cout << "\nEL PRESTAMO #" << codigo << " NO ESTA ASIGNADO AL CLIENTE CON CC #"<<cc;
                    }
                }
                ant = p;
                p = p->sgte;
            }
        }

    } else {
        cout << "\nEL PRESTAMO #" << codigo << " NO SE ENCUENTRA REGISTRADO";
    }
}

void menu1() {
    cout << "\n\t\tLISTA ENLAZADA SIMPLE\n\n";
    cout << " 1. REGISTRAR PRESTAMO                " << endl;
    cout << " 2. MOSTRAR PRESTAMOS                 " << endl;
    cout << " 3. CANCELAR PRESTAMO                 " << endl;
    cout << " 4. MOSTRAR CLIENTES                  " << endl;
    cout << " 5. SALIR                             " << endl;

    cout << "\n INGRESE OPCION: ";
}

/*                        Funcion Principal
---------------------------------------------------------------------*/

int main() {
    struct nodo_prestamo * prestamos = NULL;
    struct nodo_cliente * clientes = NULL;
    int opcion; // opcion del menu
    int codigo; // elemenento a ingresar
    int cc; //cedula de ciudadania
    string nombre_cliente;

    system("color 0b");

    do {
        menu1();
        cin>> opcion;

        switch (opcion) {
            case 1:

                cout << "\n CODIGO PRESTAMO A INSERTAR: ";
                cin>> codigo;
                insertarPrestamo(prestamos, clientes, codigo);
                break;


            case 2:

                cout << "\n NUMERO DE SUCURSAL A CONSULTAR: ";
                cin>> codigo;
                reportarPrestamos(prestamos, codigo);
                break;


            case 3:
                cout << "\n CEDULA DEL ACREEDOR: ";
                cin>> cc;
                if (buscarCliente(clientes, cc) != NULL) {

                    cout << "\n CODIGO DE PRESTAMO A ELIMINAR: ";
                    cin>> codigo;
                    eliminarPrestamo(prestamos, codigo, cc);

                } else {
                    cout << "\n EL CLIENTE CON NUMERO DE CEDULA " << cc << " NO SE ENCUENTRA REGISTRADO.";
                }
                break;

            case 4:
                cout << "\n\t CLIENTES REGISTRADOS: " << endl;
                reportarClientes(clientes);
                break;

            default:
                cout << "\n OPCION INCORRECTA...";
                break;
        }

        cout << endl << endl;
        system("PAUSE");
        system("CLS");

    } while (opcion != 5);


    system("pause");
    return 0;
}