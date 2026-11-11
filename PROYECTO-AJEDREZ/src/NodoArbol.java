public class NodoArbol {
    private int id; // Identificador numérico para ordenar el árbol (ej. número de partida)
    private Object dato; // La información que queremos guardar
    private NodoArbol izquierdo; // Apuntador al hijo izquierdo
    private NodoArbol derecho;   // Apuntador al hijo derecho

    // Método constructor
    public NodoArbol(int id, Object dato) {
        this.id = id;
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Métodos get y set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
}
