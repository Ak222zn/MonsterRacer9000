//Klassen innehåller loopen som håller spelet igång

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;

public class RunGame {
    public static void rungame() throws InterruptedException, FileNotFoundException, Exception {
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);


        File file = new File("LevelOne.txt");
        BufferedReader read = new BufferedReader(new FileReader(file));

        Player player = new Player();
        Monster monster = new Monster();

        String filestring;
        while ((filestring = read.readLine()) != null) {
            System.out.println(filestring);
        }


        while (true) {

            //kör spelet tills det blir game over, vilket kontrolleras och hanteras i GameOver
            while (true) {
                Draw.drawBoardAndGameObjects(terminal, player, monster);
                Movement.moveGameObject(terminal, player, monster);
                GameOver.isPlayerAlive(terminal, player, monster);
            }
        }
    }

}