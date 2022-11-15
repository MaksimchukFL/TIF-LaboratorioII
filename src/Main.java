import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Texto texto=new Texto();
        Scanner s=new Scanner(System.in);
        Arbol arbol=new Arbol();
        Nodo raiz=new Nodo(texto.getRaiz());
        Nodo final1=new Nodo(texto.getFinal1());
        Nodo final2=new Nodo(texto.getFinal2());
        Nodo finaloculto=new Nodo(texto.getFinaloculto());


        arbol.iniciarHistoria(raiz);
        if (arbol.listaDesiciones[0]==1) arbol.enlazarOpcion1(raiz,final1);
        if (arbol.listaDesiciones[0]==2) arbol.enlazarOpcion2(raiz,final2);
        if (arbol.listaDesiciones[1]==1) arbol.enlazarOpcion1(final2,finaloculto);


    }
}
