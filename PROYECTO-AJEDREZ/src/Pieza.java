public class Pieza {
    private String color; // "Blanco" o "Negro"
    private String tipo;  // "Peón", "Torre", "Caballo", "Alfil", "Reina", "Rey"
    private boolean viva; // true si está en el tablero, false si fue capturada

    // Método constructor para crear una nueva pieza
    public Pieza(String color, String tipo) {
        this.color = color;
        this.tipo = tipo;
        this.viva = true; // Toda pieza empieza viva al iniciar la partida
    }

    // Métodos para obtener y modificar los datos (Getters y Setters)
    public String getColor() {
        return color;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isViva() {
        return viva;
    }

    public void setViva(boolean viva) {
        this.viva = viva;
    }

    // Este método nos servirá para imprimir la pieza fácilmente en la consola
    @Override
    public String toString() {
        return tipo + " " + color;
    }
}
