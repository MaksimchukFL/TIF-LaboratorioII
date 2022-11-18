import java.io.FileReader;

public class Lectura {
    public static String deFicheros(String nombreTxt){

        String historia = "";
        try {
            FileReader entrada = new FileReader("Historia\\" + nombreTxt + ".txt");
            int caracter = entrada.read();

            while (caracter != -1) {
                caracter = entrada.read();
                if(caracter != -1) {
                    char letra = (char) caracter;
                    historia += letra;
                }
            }
            entrada.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return historia;
    }
}
