public class ArbolBinario {
    private NodoArbol raiz; // Nodo principal que inicia el árbol

    // Constructor que inicializa el árbol vacío
    public ArbolBinario() {
        this.raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    // 1. Operación: Insertar
    public void insertar(int id, Object dato) {
        raiz = insertarRecursivo(raiz, id, dato);
    }

    private NodoArbol insertarRecursivo(NodoArbol actual, int id, Object dato) {
        if (actual == null) {
            return new NodoArbol(id, dato); // Crea el nodo si encuentra el espacio vacío
        }
        if (id < actual.getId()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), id, dato)); // Va a la izquierda si es menor
        } else if (id > actual.getId()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), id, dato)); // Va a la derecha si es mayor
        }
        return actual;
    }

    // 2. Operación: Buscar
    public boolean buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    private boolean buscarRecursivo(NodoArbol actual, int id) {
        if (actual == null) {
            return false;
        }
        if (id == actual.getId()) {
            return true; // Lo encontró
        }
        // Sigue buscando por la izquierda o por la derecha según el id
        return id < actual.getId() 
            ? buscarRecursivo(actual.getIzquierdo(), id) 
            : buscarRecursivo(actual.getDerecho(), id);
    }

    // 3. Operación: Eliminar
    public void eliminar(int id) {
        raiz = eliminarRecursivo(raiz, id);
    }

    private NodoArbol eliminarRecursivo(NodoArbol actual, int id) {
        if (actual == null) return null;

        if (id == actual.getId()) {
            // Caso 1: No tiene hijos (es una hoja)
            if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
                return null;
            }
            // Caso 2: Tiene solo un hijo
            if (actual.getDerecho() == null) {
                return actual.getIzquierdo();
            }
            if (actual.getIzquierdo() == null) {
                return actual.getDerecho();
            }
            // Caso 3: Tiene dos hijos. Buscamos el menor de los mayores para reemplazarlo.
            int idMenor = encontrarMenorId(actual.getDerecho());
            actual.setId(idMenor);
            actual.setDerecho(eliminarRecursivo(actual.getDerecho(), idMenor));
            return actual;
        } 
        
        if (id < actual.getId()) {
            actual.setIzquierdo(eliminarRecursivo(actual.getIzquierdo(), id));
            return actual;
        }
        
        actual.setDerecho(eliminarRecursivo(actual.getDerecho(), id));
        return actual;
    }

    private int encontrarMenorId(NodoArbol raiz) {
        return raiz.getIzquierdo() == null ? raiz.getId() : encontrarMenorId(raiz.getIzquierdo());
    }

    // 4. Recorrido: Preorden (Raíz, Izquierda, Derecha)
    public void preorden() {
        System.out.print("Preorden: ");
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getId() + " ");
            preordenRecursivo(nodo.getIzquierdo());
            preordenRecursivo(nodo.getDerecho());
        }
    }

    // 5. Recorrido: Inorden (Izquierda, Raíz, Derecha)
    public void inorden() {
        System.out.print("Inorden: ");
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(NodoArbol nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.getIzquierdo());
            System.out.print(nodo.getId() + " ");
            inordenRecursivo(nodo.getDerecho());
        }
    }

    // 6. Recorrido: Posorden (Izquierda, Derecha, Raíz)
    public void posorden() {
        System.out.print("Posorden: ");
        posordenRecursivo(raiz);
        System.out.println();
    }

    private void posordenRecursivo(NodoArbol nodo) {
        if (nodo != null) {
            posordenRecursivo(nodo.getIzquierdo());
            posordenRecursivo(nodo.getDerecho());
            System.out.print(nodo.getId() + " ");
        }
    }
}
