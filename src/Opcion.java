public class Opcion {
    private String texto;
    private boolean buenoOMalo;

    public Opcion(String texto,boolean buenoOMalo){
        this.texto = texto;
        this.buenoOMalo = buenoOMalo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isBuenoOMalo() {
        return buenoOMalo;
    }

    public void setBuenoOMalo(boolean buenoOMalo) {
        this.buenoOMalo = buenoOMalo;
    }
}
