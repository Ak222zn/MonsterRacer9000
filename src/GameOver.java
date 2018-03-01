import com.googlecode.lanterna.terminal.Terminal;

public class GameOver {

    public static void isPlayerAlive (Terminal terminal,Player player, Monster monster) throws InterruptedException{
        if (player.x == monster.x && player.y == monster.y){
            String text = "Game Over";
            printString(terminal, text, Board.BOARD_WIDTH + 3, 5);
            // anropa metod som skriver ut eventuell poäng
            Thread.sleep(5000); // 1000 blir 1 sek
            System.exit(0);

        }

    }


    private static void printString(Terminal terminal, String s, int x, int y) {
        char[] characters = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            terminal.moveCursor(i + x, y);
            terminal.putCharacter(characters[i]);
        }
    }

}
