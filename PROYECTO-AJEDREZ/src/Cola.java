public class Cola {
    private Nodo inicio; // Referencia al primer elemento de la cola
    private Nodo fin;    // Referencia al último elemento de la cola
    private int tamano;

    // Método constructor para inicializar la cola vacías
    public Cola() {
        this.inicio = null;
        this.fin = null;
        this.tamano = 0;
    }

    // 1. Operación: está vacía
    // Devuelve verdadero si el inicio es null
    public boolean estaVacia() {
        return inicio == null;
    }

    // 2. Operación: encolar[span_8](start_span)[span_8](end_span)
    // Inserta un elemento al final de la cola[span_9](start_span)[span_9](end_span)
    public void encolar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            inicio = nuevo; // Si está vacía, inicio y fin apuntan al nuevo nodo
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo); // El último nodo actual apunta al nuevo[span_11](start_span)[span_11](end_span)
            fin = nuevo; // El fin se actualiza al nuevo nodo[span_12](start_span)[span_12](end_span)
        }
        tamano++;
    }

    // 3. Operación: desencolar
    // Extrae el elemento del frente (inicio) de la cola
    public Object desencolar() {
        if (!estaVacia()) {
            Object dato = inicio.getDato(); // Obtenemos el dato del inicio
            if (inicio == fin) {
                // Si solo hay un elemento, la cola queda vacía
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.getSiguiente(); // El inicio avanza al siguiente nodo
            }
            tamano--;
            return dato;
        } else {
            System.out.println("La cola está vacía.");
            return null;
        }
    }

    // 4. Operación: ver frente
    // Devuelve el elemento del inicio sin extraerlo
    public Object verFrente() {
        if (!estaVacia()) {
            return inicio.getDato();
        } else {
            System.out.println("La cola está vacía.");
            return null;
        }
    }

    // 5. Operación: tamaño
    // Devuelve la cantidad de elementos en la cola
    public int getTamano() {
        return tamano;
    }
}
