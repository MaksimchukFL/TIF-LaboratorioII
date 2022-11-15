public class Nodo {
    /*
    Esta clase representará cada decisión en el juego. Contendrá un string dada por otra clase que contendrá a todos
    los strings que se imprimirían en pantalla.
    También tendrá un valor que corresponderá a la desición de cada nodo, que podrá ser una opción 1 o 2. Se inicializa en cero
     */
    public String texto;
    public Nodo opcion1;
    public Nodo opcion2;

    public Nodo(String texto) {
        this.texto = texto;
        this.opcion1=null;
        this.opcion2=null;
    }



    @Override
    public String toString() {
        return this.texto;
    }
}
