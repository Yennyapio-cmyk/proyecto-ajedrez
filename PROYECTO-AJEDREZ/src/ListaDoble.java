public class ListaDoble {
    private Nodo inicio; // Apunta al primer elemento
    private Nodo fin;    // Apunta al último elemento para facilitar el recorrido hacia atrás
    private int tamano;

    // Método constructor
    public ListaDoble() {
        this.inicio = null;
        this.fin = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    // 1. Operación: Insertar al inicio
    public void insertarInicio(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo; // Si es el único, es inicio y fin al mismo tiempo
        } else {
            nuevo.setSiguiente(inicio); // El nuevo apunta hacia adelante al inicio actual
            inicio.setAnterior(nuevo);  // El inicio actual apunta hacia atrás al nuevo
            inicio = nuevo;             // Se actualiza el inicio
        }
        tamano++;
    }

    // 2. Operación: Insertar al final
    public void insertarFinal(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo); // El fin actual apunta hacia adelante al nuevo
            nuevo.setAnterior(fin);  // El nuevo apunta hacia atrás al fin actual
            fin = nuevo;             // Se actualiza el fin
        }
        tamano++;
    }

    // 3. Operación: Insertar en posición
    public void insertarPosicion(Object dato, int posicion) {
        if (posicion <= 0) {
            insertarInicio(dato);
        } else if (posicion >= tamano) {
            insertarFinal(dato);
        } else {
            Nodo nuevo = new Nodo(dato);
            Nodo aux = inicio;
            // Buscamos el nodo que está justo antes de la posición deseada
            for (int i = 0; i < posicion - 1; i++) {
                aux = aux.getSiguiente();
            }
            Nodo siguienteNodo = aux.getSiguiente();

            // Ajustamos los 4 enlaces (2 hacia adelante y 2 hacia atrás)
            nuevo.setSiguiente(siguienteNodo);
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            siguienteNodo.setAnterior(nuevo);
            tamano++;
        }
    }

    // 4. Operación: Eliminar[span_5](start_span)[span_5](end_span)
    public void eliminar(Object dato) {
        if (estaVacia()) return;

        Nodo aux = inicio;
        while (aux != null) {
            if (aux.getDato().equals(dato)) {
                if (aux == inicio) { // Si es el primer nodo
                    inicio = inicio.getSiguiente();
                    if (inicio != null) {
                        inicio.setAnterior(null);
                    } else {
                        fin = null; // Si era el único nodo en la lista
                    }
                } else if (aux == fin) { // Si es el último nodo
                    fin = fin.getAnterior();
                    fin.setSiguiente(null);
                } else { // Si está en el medio
                    aux.getAnterior().setSiguiente(aux.getSiguiente());
                    aux.getSiguiente().setAnterior(aux.getAnterior());
                }
                tamano--;
                return; // Terminamos de eliminar y salimos del método
            }
            aux = aux.getSiguiente(); // Avanzamos para seguir buscando
        }
    }

    // 5. Operación: Buscar[span_6](start_span)[span_6](end_span)
    public boolean buscar(Object dato) {
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.getDato().equals(dato)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    // 6. Operación: Recorrer (Hacia adelante)[span_7](start_span)[span_7](end_span)
    public void recorrerAdelante() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        Nodo aux = inicio;
        while (aux != null) {
            System.out.print(aux.getDato() + " <-> ");
            aux = aux.getSiguiente();
        }
        System.out.println("null");
    }

    // 7. Operación: Recorrer (Hacia atrás)[span_8](start_span)[span_8](end_span)
    public void recorrerAtras() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        Nodo aux = fin;
        while (aux != null) {
            System.out.print(aux.getDato() + " <-> ");
            aux = aux.getAnterior();
        }
        System.out.println("null");
    }

    // 8. Tamaño
    public int getTamano() {
        return tamano;
    }
}
