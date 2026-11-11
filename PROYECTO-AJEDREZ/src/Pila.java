public class Pila {
    private Nodo inicio; // Nodo que controla la cima/tope de la pila
    private int tamano;  // Variable para llevar el control del tamaño

    // Método constructor para inicializar la pila vacía
    public Pila() {
        this.inicio = null;
        this.tamano = 0;
    }

    // 1. Operación: está vacía
    // Devuelve verdadero si el inicio es null
    public boolean estaVacia() {
        return inicio == null;
    }

    // 2. Operación: apilar[
    // Inserta un nuevo elemento en el tope de la pila
    public void apilar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            inicio = nuevo; // Si está vacía, el nuevo nodo es el inicio
        } else {
            nuevo.setSiguiente(inicio); // El nuevo nodo apunta al inicio actual
            inicio = nuevo; // El inicio ahora es el nuevo nodo
        }
        tamano++; // Aumentamos el tamaño de la pila
    }

    // 3. Operación: desapilar
    // Extrae y devuelve el elemento del tope de la pila
    public Object desapilar() {
        if (!estaVacia()) {
            Object dato = inicio.getDato(); // Obtenemos el dato del inicio
            inicio = inicio.getSiguiente(); // El nuevo inicio es el nodo siguiente
            tamano--; // Reducimos el tamaño
            return dato; // Retornamos el dato extraído
        } else {
            System.out.println("La pila está vacía.");
            return null;
        }
    }

    // 4. Operación: ver tope
    // Devuelve el elemento de la cima sin extraerlo
    public Object verTope() {
        if (!estaVacia()) {
            return inicio.getDato();
        } else {
            System.out.println("La pila está vacía.");
            return null;
        }
    }

    // 5. Operación: tamaño
    // Devuelve la cantidad de elementos en la pila
    public int getTamano() {
        return tamano;
    }
}

