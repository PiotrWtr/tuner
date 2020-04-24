import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioHandler {

    public static Mixer mixer;
    public static Clip clip;
    public static AudioInputStream audioStream;
    public AudioHandler(){
        Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
        /*
        for (Mixer.Info info : mixInfos){
            System.out.println( info.getName() + " --- " + info.getDescription());
        }
        */
        mixer = AudioSystem.getMixer(mixInfos[4]);

        DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
        try {
            clip = (Clip) mixer.getLine(dataInfo);
        } catch (LineUnavailableException lue) {
            lue.printStackTrace();
        }

        try {
            URL soundURL = Main.class.getResource("/BassSample.wav");
            audioStream = AudioSystem.getAudioInputStream(soundURL);
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }public void play(){
        clip.setFramePosition(0);
        clip.start();
    }
}
