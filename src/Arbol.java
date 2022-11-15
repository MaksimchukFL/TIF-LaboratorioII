import java.util.ArrayList;
import java.util.Scanner;

public class Arbol {
    /*
    Esta clase manejará la historia y el desarrollo de la misma como arbol binario.
    No nos interesa la eliminación de nodos, ya que el juego no necesitaría esta dinámica
     */

    //Atributos
    private Nodo raiz;
    public int contadorDesiciones=0;
    public int listaDesiciones[];

    //Constructor
    public Arbol() {
        this.raiz = null;
        listaDesiciones=new int[100];
    }

    //Metodos
    //Al iniciar la historia, también imprimirá automáticamente la primer parte.
    //Dará una posibilidad de desición, su valor se almacenará en memoria en un arreglo para su consulta.

    //TODO: TRYCATCH! El ingreso de datos por teclado solo debería admitir los enteros 1 y 2, a si que se puede hacer una excepción propia que controle este error. Ya no lo hago porque me dio paja.
    public void iniciarHistoria(Nodo raiz){
    this.raiz=raiz;
    System.out.println(raiz.toString());
    int seleccion;
    Scanner entrada=new Scanner(System.in);
    seleccion=entrada.nextInt();
    listaDesiciones[0]=seleccion;
    contadorDesiciones+=1;
    }

    //Al enlazar nuevos nodos, también se imprimen automaticamente sus strings.

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
