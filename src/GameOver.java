import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class GameOver {

    public static void isPlayerAlive (Terminal terminal,Player player, Monster monster) {
        if (player.x == monster.x && player.y == monster.y){
            String text = "Game Over";
            printString(terminal, text, Board.BOARD_WIDTH + 3, 5);
            // anropa metod som skriver ut eventuell poäng
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);

        }

    }

    public static boolean continuePlaying(Terminal terminal) {
        Key key;
        boolean answer = false;

        do {
            try {
                Thread.sleep(5);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            key = terminal.readInput();
        }
        while (key == null);

        switch (key.getCharacter()) {
            case 'y':
                answer = true;
                break;
            case 'n':
                answer = false;
                break;
        }
         return answer;
    }


    private static void printString(Terminal terminal, String s, int x, int y) {
        char[] characters = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            terminal.moveCursor(i + x, y);
            terminal.putCharacter(characters[i]);
        }
    }

}
