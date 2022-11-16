import java.io.File;
import javax.sound.sampled.*;

public final class Music {
    public static void playMusic(String song) {
        String filename = song;

        int EXTERNAL_BUFFER_SIZE = 524288;

        File soundFile = new File(filename);

        if (!soundFile.exists()) {
            System.err.println("Wave file not found: " + filename);
            return;
        }

        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        AudioFormat format = audioInputStream.getFormat();

        SourceDataLine auline = null;


        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        try {
            auline = (SourceDataLine) AudioSystem.getLine(info);


            auline.open(format);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


        auline.start();

        int nBytesRead = 0;
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

        try {
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) {

                    auline.write(abData, 0, nBytesRead);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {

            auline.drain();

            auline.close();
        }
    }
}