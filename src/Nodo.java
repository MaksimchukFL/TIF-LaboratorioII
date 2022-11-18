public class Nodo {

    private Nodo padre;
    private Nodo hijoDerecha; //Siempre debe ser mayor o igual que la llave
    private Nodo hijoIzquierda; //Siempre debe ser menor que la llave

    private int llave;
    private String historia;
    private Opcion[] opciones;
    private boolean valor;


    public Nodo(int llave,String historia,Opcion[] opciones,boolean valor){
        this.padre = null;
        this.hijoDerecha = null;
        this.hijoIzquierda = null;
        this.llave = llave;
        this.historia = historia;
        this.opciones = opciones;
        this.valor = valor;
    }

    public Nodo(int llave,String historia,boolean valor){
        this.padre = null;
        this.hijoDerecha = null;
        this.hijoIzquierda = null;
        this.llave = llave;
        this.historia = historia;
        this.opciones = null;
        this.valor = valor;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Nodo getHijoDerecha() {
        return hijoDerecha;
    }

    public void setHijoDerecha(Nodo hijoDerecha) {
        this.hijoDerecha = hijoDerecha;
    }

    public Nodo getHijoIzquierda() {
        return hijoIzquierda;
    }

    public void setHijoIzquierda(Nodo hijoIzquierda) {
        this.hijoIzquierda = hijoIzquierda;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Opcion[] getOpciones() {
        return opciones;
    }

    public void setOpciones(Opcion[] opciones) {
        this.opciones = opciones;
    }

    public boolean valorOpcion(int opcion){
        return opciones[opcion-1].isBuenoOMalo();
    }

    public boolean isValor() {
        return valor;
    }

    public String lasOpcionesToString(){

        int i=1;
        String lasOpciones = "";

        for(Opcion opcion:opciones){
            lasOpciones += i + "- " + opcion.getTexto() + "\n";
            i++;
        }

        return lasOpciones;
    }
}
