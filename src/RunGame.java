//Klassen innehåller loopen som håller spelet igång

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class RunGame {
    public void rungame() throws InterruptedException {
        Player player = new Player();
        Monster monster = new Monster();


        //kör spelet så länge villkoret uppfylls
        while (true) {

            Key key;
            do {
                Thread.sleep(5);
                key = Main.terminal.readInput();
            } while (key == null);

        }
    }
}