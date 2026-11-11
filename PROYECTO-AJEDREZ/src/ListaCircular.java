public class ListaCircular {
    private Nodo cabecera; // Referencia al primer nodo de la listas
    private int tamano;

    // Método constructor
    public ListaCircular() {
        this.cabecera = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return cabecera == null;
    }

    // 1. Operación: Insertar al inicio
    public void insertarInicio(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            cabecera = nuevo; // Si está vacía, la cabecera es el nuevo nodo
            nuevo.setSiguiente(cabecera); // Se apunta a sí mismo para hacer el círculo
        } else {
            Nodo aux = cabecera;
            // Recorremos hasta llegar al último nodo (el que apunta a la cabecera)
            while (aux.getSiguiente() != cabecera) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo); // El último apunta al nuevo
            nuevo.setSiguiente(cabecera); // El nuevo apunta a la cabecera actual
            cabecera = nuevo; // El nuevo se convierte en la cabecera
        }
        tamano++;
    }

    // 2. Operación: Insertar al final
    public void insertarFinal(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            cabecera = nuevo;
            nuevo.setSiguiente(cabecera); // Se apunta a sí mismo
        } else {
            Nodo aux = cabecera;
            while (aux.getSiguiente() != cabecera) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo); // El último apunta al nuevo
            nuevo.setSiguiente(cabecera); // El nuevo apunta a la cabecera, cerrando el círculo
        }
        tamano++;
    }

    // 3. Operación: Insertar en una posición específica
    public void insertarPosicion(Object dato, int posicion) {
        if (posicion <= 0) {
            insertarInicio(dato);
        } else if (posicion >= tamano) {
            insertarFinal(dato);
        } else {
            Nodo nuevo = new Nodo(dato);
            Nodo aux = cabecera;
            for (int i = 0; i < posicion - 1; i++) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
            tamano++;
        }
    }

    // 4. Operación: Eliminar
    public void eliminar(Object dato) {
        if (estaVacia()) return;

        Nodo aux = cabecera;
        Nodo anterior = null;
        boolean encontrado = false;

        // Buscamos el nodo a eliminar 
        do {
            if (aux.getDato().equals(dato)) {
                encontrado = true;
                break;
            }
            anterior = aux;
            aux = aux.getSiguiente();
        } while (aux != cabecera);

        if (encontrado) {
            if (aux == cabecera && aux.getSiguiente() == cabecera) {
                cabecera = null; // Si es el único nodo en la lista
            } else if (aux == cabecera) {
                // Si vamos a borrar el primero, debemos actualizar el último para que apunte al nuevo primero
                Nodo ultimo = cabecera;
                while (ultimo.getSiguiente() != cabecera) {
                    ultimo = ultimo.getSiguiente();
                }
                cabecera = cabecera.getSiguiente();
                ultimo.setSiguiente(cabecera);
            } } else if (anterior != null) {
    anterior.setSiguiente(aux.getSiguiente());
        }
            tamano--;
        }

    // 5. Operación: Buscar
    public boolean buscar(Object dato) {
        if (estaVacia()) return false;
        Nodo aux = cabecera;
        do {
            if (aux.getDato().equals(dato)) return true; // Retorna true si lo encuentra
            aux = aux.getSiguiente(); // Avanza al siguiente
        } while (aux != cabecera); // Se detiene cuando da la vuelta completa
        return false;
    }

    // 6. Operación: Recorrer
    public void recorrer() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        Nodo aux = cabecera;
        do {
            System.out.print(aux.getDato() + " -> ");
            aux = aux.getSiguiente();
        } while (aux != cabecera); // Recorre hasta volver a la cabecera
        System.out.println("(Ciclo vuelve a iniciar)");
    }
    public int getTamano() {
    return tamano;
}

}
