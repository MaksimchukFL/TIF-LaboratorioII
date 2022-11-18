import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Musica {
    public Long nowFrame;
    public Clip clip;
    public String ruta;
    public String estado;
    AudioInputStream audioStream;

    //Inicializa el clip y el stream
    public Musica(String nombreArchivo) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //Objeto Stream de entrada
        audioStream = AudioSystem.getAudioInputStream(new File("Music\\" + nombreArchivo).getAbsoluteFile());
        //Referencia al clip
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        ruta = "Music\\" + nombreArchivo;
    }

    private void reproducir()
    {
        //Pone el play el clip
        clip.start();
        estado = "reproduciendo";
    }

    private void pausar()
    {
        if (estado.equals("pausado")) {
            System.out.println("El audio estÃ¡ pausado");
            return;
        }
        this.nowFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        estado = "pausado";
    }

    private void resetearAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //Reinicializa el clip y el stream
        audioStream = AudioSystem.getAudioInputStream(new File(ruta).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioStream);
    }

    public static void reproducir(Musica s){
        try {
            s.reproducir();
        }catch (Exception e) {
            System.out.println("No se pudo reproducir el audio");
            e.printStackTrace();

        }
    }

    public static void reproducirEnLoop(Musica s){
        s.clip.loop(Clip.LOOP_CONTINUOUSLY);

        try {
            s.reproducir();
        }catch (Exception e) {
            System.out.println("Experienced an error while playing sound.");
            e.printStackTrace();

        }
    }

    public static void pausar(Musica s){
        try {
            s.pausar();
        }catch (Exception e) {
            System.out.println("Experienced an error while playing sound.");
            e.printStackTrace();

        }
    }

    public static void resetearAudio(Musica s){
        try {
            s.resetearAudioStream();
        }catch (Exception e) {
            System.out.println("Experienced an error while playing sound.");
            e.printStackTrace();

        }
    }
}