public class Nodo {
    private  Object dato; // Variable para guardar los datos de la jugada o pieza
    private  Nodo siguiente; //Atributo para enlazar un nodo siguiente
    private  Nodo anterior;// Atributo para enlazar un nodo anterior

    // Método constructor para inicializar las variables

    public Nodo(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
}

    // Métodos get y set para los atributos
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

}