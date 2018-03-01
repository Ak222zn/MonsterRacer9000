//Klassen innehåller loopen som håller spelet igång

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;

public class RunGame {
    public static void rungame() {
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);


        File file = null;
        BufferedReader read = null;
        char[][] levelArray = new char[21][21];
        try {
            file = new File("Levels\\LevelOne.txt");
            read = new BufferedReader(new FileReader(file));

            for (int i = 0; i < 21; i++) {
                char[] line = read.readLine().toCharArray();
                for (int j = 0; j < 21; j++) {
                    levelArray[i][j] = line[j];
                }
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }


        Player player = new Player();
        Monster monster = new Monster();


        while (true) {

            // läs in en ny bana


            //kör bana tills det blir game over, vilket kontrolleras och hanteras i GameOver
            while (true) {
                Draw.drawBoardAndGameObjects(terminal, player, monster, levelArray);
                Movement.moveGameObject(terminal, player, monster, levelArray);
                GameOver.isPlayerAlive(terminal, player, monster);
            }

//            if (GameOver.continuePlaying(terminal)) // true är fortsätta spela
//                continue;
//            else
//                System.exit(0);

        }
    }

}