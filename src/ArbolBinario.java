public class ArbolBinario {

    private Nodo raiz;
    private Nodo actual;

    public ArbolBinario(){
        this.raiz = null;
    }

    public Nodo getRaiz(){
        return this.raiz;
    }

    public Nodo getActual() {
        return actual;
    }

    public void setActual(Nodo actual) {
        this.actual = actual;
    }

    public boolean vacio(){
        return this.raiz == null;
    }

    public void insertar(Nodo nuevo){

        if(vacio()){
            this.raiz = nuevo;
            this.actual = raiz;
        }else{

            Nodo temporal = raiz;

            while (temporal != null){

                nuevo.setPadre(temporal);

                if(nuevo.getLlave() >= temporal.getLlave()){
                    temporal = temporal.getHijoDerecha();
                }else{
                    temporal = temporal.getHijoIzquierda();
                }
            }

            if(nuevo.getLlave() < nuevo.getPadre().getLlave()){
                nuevo.getPadre().setHijoIzquierda(nuevo);
            }else{
                nuevo.getPadre().setHijoDerecha(nuevo);
            }
        }
    }

    public void avanzar(int opcion){

        Nodo temporal = actual;

        if(temporal.valorOpcion(opcion)){
            if(temporal.getHijoDerecha().isValor()){
                this.actual = temporal.getHijoDerecha();
            }else if(temporal.getHijoIzquierda().isValor()){
                this.actual = temporal.getHijoIzquierda();
            }
        }else if(!temporal.valorOpcion(opcion)){
            if(!temporal.getHijoIzquierda().isValor()){
                this.actual = temporal.getHijoIzquierda();
            }else if(!temporal.getHijoDerecha().isValor()){
                this.actual = temporal.getHijoDerecha();
            }
        }
    }

    public void volverARaiz(){
        setActual(raiz);
    }
}