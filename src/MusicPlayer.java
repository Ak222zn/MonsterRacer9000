import java.net.*;
import java.applet.*;

public class MusicPlayer {

    public static void musicPlayer() {
        try {
            String filnamn = "Music\\Metallica_Blackened.mp3";
            URL u = new URL(filnamn);
            AudioClip a = Applet.newAudioClip(u);
            a.play();
            Thread.sleep(80000);
        }
        catch (java.net.MalformedURLException e) {
            System.err.println(e.getStackTrace());
        }
        catch (InterruptedException e) {
            System.err.println(e.getStackTrace());
        }
    }
}