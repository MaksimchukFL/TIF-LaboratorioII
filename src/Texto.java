public class Texto {
    /*
    Esta clase contendrá todos los strings que un nodo pueda contener y sus respectivos getters para poder operarlos con
    ocultamiento
     */

    private String raiz="Hola, soy la raiz, quiere obtener el final 1 o el final 2?\n1.Final 1  2.Final 2";
    private String final1="Este es el final 1!";
    private String final2="Este es el final 2! No selecciones el 1!";
    private String finaloculto="Este es el final oculto qe esta enlazado al final 2!";


    public String getRaiz() {
        return raiz;
    }

    public String getFinal1() {
        return final1;
    }

    public String getFinal2() {
        return final2;
    }

    public String getFinaloculto() {
        return finaloculto;
    }
}
