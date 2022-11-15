import java.util.ArrayList;
import java.util.Scanner;

public class Arbol {
    /*
    Esta clase manejará la historia y el desarrollo de la misma como arbol binario.
    No nos interesa la eliminación de nodos, ya que el juego no necesitaría esta dinámica
     */

    private Nodo raiz;
    public int contadorDesiciones=0;
    public int listaDesiciones[]=new int[100];

    public Arbol() {
        this.raiz = null;
    }

    //Metodos
    //Al iniciar la historia, también imprimirá automáticamente la primer parte.
    //Dará una posibilidad de desición, su valor se almacenará en memoria en un arreglo para su consulta.
    public void iniciarHistoria(Nodo raiz){
    this.raiz=raiz;
    System.out.println(raiz.toString());
    int seleccion;
    Scanner entrada=new Scanner(System.in);
    seleccion=entrada.nextInt();
    listaDesiciones[0]=seleccion;
    contadorDesiciones+=1;
    }

    public void enlazarOpcion1(Nodo nodoinicial, Nodo nodoagregado){
        nodoinicial.opcion1=nodoagregado;
        System.out.println(nodoagregado.toString());
        int seleccion;
        Scanner entrada=new Scanner(System.in);
        seleccion=entrada.nextInt();
        listaDesiciones[contadorDesiciones]=seleccion;
        contadorDesiciones+=1;
    }

    public void enlazarOpcion2(Nodo nodoinicial, Nodo nodoagregado){
        nodoinicial.opcion2=nodoagregado;
        System.out.println(nodoagregado.toString());
        int seleccion;
        Scanner entrada=new Scanner(System.in);
        seleccion=entrada.nextInt();
        listaDesiciones[contadorDesiciones]=seleccion;
        contadorDesiciones+=1;
    }


}
