import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class GameOver {

    public static boolean isPlayerAlive(Terminal terminal, Player player, Monster monster) {
        if (player.getX() == monster.getX() && player.getY() == monster.getY()) {
            terminal.applyForegroundColor(Terminal.Color.RED);
            String text = "Game Over";
            printString(terminal, text, Board.BOARD_WIDTH + 5, 13);
            return false;
        } else
            return true;

    }

    public static boolean continuePlaying(Terminal terminal) {
        Key key;
        boolean answer = false;
        boolean notYorN = true;
        while (notYorN) {

            terminal.applyForegroundColor(Terminal.Color.GREEN);
            printString(terminal, "Continue playing? y/n", Board.BOARD_WIDTH + 5, 15);
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
