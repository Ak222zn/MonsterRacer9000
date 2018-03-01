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
        File newfile = null;
        BufferedReader read2 = null;


        Player player = new Player();
        Monster monster = new Monster();

        char[][] levelArray = new char[30][30];

        while (true) {

            // läs in en ny bana

            try {
                file = new File("Levels\\LevelCollection.txt");
                read = new BufferedReader(new FileReader(file));
                String level = read.readLine();
                newfile = new File("Levels\\" + level);
                read2 = new BufferedReader(new FileReader(newfile));

                for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
                    char[] line = read2.readLine().toCharArray();
                    for (int j = 0; j < Board.BOARD_WIDTH; j++) {
                        levelArray[i][j] = line[j];
                    }
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            //kör bana tills det blir game over, vilket kontrolleras och hanteras i GameOver
            do {
                Draw.drawBoardAndGameObjects(terminal, player, monster, levelArray);
                Movement.moveGameObject(terminal, player, monster, levelArray);
            } while (GameOver.isPlayerAlive(terminal, player, monster));


            if (GameOver.continuePlaying(terminal))
                continue;
            else
                System.exit(0);
        }
    }

}