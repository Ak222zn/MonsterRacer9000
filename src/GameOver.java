import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class GameOver {

    public static boolean isPlayerAlive(Terminal terminal, Player player, Monster monster) {
        if (player.getX() == monster.getX() && player.getY() == monster.getY()) {
            String text = "Game Over";
            printString(terminal, text, Board.BOARD_WIDTH + 3, 5);
            return false;
        } else
            return true;

    }

    public static boolean continuePlaying(Terminal terminal) {
        Key key;
        boolean answer = false;
        boolean notYorN = true;
        while (notYorN) {

            printString(terminal, "Continue playing? y/n", 35, 20);
            do {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                key = terminal.readInput();
            }
            while (key == null);

            switch (key.getCharacter()) {
                case 'y':
                    answer = true;
                    notYorN = false;
                    break;
                case 'n':
                    answer = false;
                    notYorN = false;
                    break;
            }
        }
        return answer;
    }




    public static void printString(Terminal terminal, String s, int x, int y) {
        char[] characters = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            terminal.moveCursor(i + x, y);
            terminal.putCharacter(characters[i]);
        }
    }

}
