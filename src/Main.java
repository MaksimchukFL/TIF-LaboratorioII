public class Main {

    public static void main(String[] args) {
	// Aqui pruebo el funcionamiento del arbol.

        //Instanciado de objetos
        //Textos
        Texto texto=new Texto();

        //Arbol
        Arbol arbol=new Arbol();

        //Nodos
        Nodo raiz=new Nodo(texto.getRaiz());
        Nodo final1=new Nodo(texto.getFinal1());
        Nodo final2=new Nodo(texto.getFinal2());
        Nodo finaloculto=new Nodo(texto.getFinaloculto());

        /*
        Creo un arbol de caracteristicas:

                    raiz
                 op1/  \op2
               final1  final2
                       op1/
                       finaloculto
         */
        arbol.iniciarHistoria(raiz);
        if (arbol.listaDesiciones[0]==1) arbol.enlazarOpcion1(raiz,final1);
        if (arbol.listaDesiciones[0]==2) arbol.enlazarOpcion2(raiz,final2);
        if (arbol.listaDesiciones[1]==1) arbol.enlazarOpcion1(final2,finaloculto);

        //Funcionamiento del arreglo
        System.out.println("Estos son los valores que quedaron guardados en el arreglo:");
        for (int desicion: arbol.listaDesiciones
             ) {
            if (desicion!=0) System.out.print(desicion+" ");
        }


    }
}
