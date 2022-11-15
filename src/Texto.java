public class Texto {
    /*
    La idea de esta clase es pegar acá todos los Strings que se van a imprimir por pantalla y sus respectivos getters.
     */

    private String raiz="Hola, soy la raiz, quiere obtener el final 1 o el final 2?\n1.Final 1\n2.Final 2";
    private String final1="Este es el final 1!";
    private String final2="Este es el final 2! No selecciones el 1!";
    private String finaloculto="Este es el final oculto que esta enlazado al final 2!";


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
