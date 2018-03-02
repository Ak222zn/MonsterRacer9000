//Klassen innehåller loopen som håller spelet igång

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class RunGame {
    public static void rungame() {
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);

        Scanner scanNewLevel = null;

        Player player = new Player();
        Monster monster = new Monster();

        char[][] levelArray = new char[30][30];

        int level = 1;
        for (level = 1; level <= 5; level++) {
            File newfile = new File("Levels\\Board" + level + ".txt");
            try {
                scanNewLevel = new Scanner(new FileReader(newfile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // läs in en ny bana
            for (int i = 0; i < Board.BOARD_HEIGHT; i++) {
                char[] line = scanNewLevel.nextLine().toCharArray();
                for (int j = 0; j < Board.BOARD_WIDTH; j++) {
                    levelArray[i][j] = line[j];
                }
            }

            player.randomizeStartPosition(levelArray);
            monster.randomizeStartPosition(player, levelArray);

            //kör bana tills det blir game over, vilket kontrolleras och hanteras i GameOver
            do {
                Draw.drawBoardAndGameObjects(terminal, player, monster, levelArray);
                if (Movement.movePlayer(terminal, player, levelArray))
                    break;
                Movement.moveMonster(player, monster, levelArray);
            } while (GameOver.isPlayerAlive(terminal, player, monster));

            if (GameOver.isPlayerAlive(terminal, player, monster) && level == 5) {
                terminal.applyForegroundColor(Terminal.Color.GREEN);
                String text2 = "Congratulations! You won!";
                GameOver.printString(terminal, text2, Board.BOARD_WIDTH + 5, 2);
                if (GameOver.continuePlaying(terminal)) {
                    level = 0;
                    continue;
                } else {
                    System.exit(0);
                }
            } else if (GameOver.isPlayerAlive(terminal, player, monster)) {
                continue;
            } else if (GameOver.continuePlaying(terminal)) {
                level = 0;
                continue;
            } else
                System.exit(0);
        }
    }
}
