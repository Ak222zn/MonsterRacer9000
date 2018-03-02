//Klassen ritar ut spelplanen och GameObjects i spelplanen

import com.googlecode.lanterna.terminal.Terminal;

public class Draw {
    public static void drawBoardAndGameObjects(Terminal terminal, Player player, Monster monster, char[][] array) {
        drawBoard(terminal, array);
        drawGameObject(terminal, player, monster);
    }

    public static void drawBoard(Terminal terminal, char[][] array) {

        terminal.clearScreen();

        for (int i = 0; i < Board.BOARD_WIDTH; i++) {
            for (int j = 0; j < Board.BOARD_HEIGHT; j++) {
                terminal.applyForegroundColor(Terminal.Color.BLUE);
                terminal.moveCursor(i,j);
                if (array[i][j] == 'E') {
                    terminal.applyForegroundColor(Terminal.Color.WHITE);
                }
                terminal.putCharacter(array[i][j]);
            }
        }

        terminal.applyForegroundColor(Terminal.Color.CYAN);
        String text1 = "P = player";
        GameOver.printString(terminal, text1, Board.BOARD_WIDTH + 5, 3);
        String text2 = "P + E = next level";
        GameOver.printString(terminal, text2, Board.BOARD_WIDTH + 5, 4);
        String text3 = "P + red thing = Game Over";
        GameOver.printString(terminal, text3, Board.BOARD_WIDTH + 5, 5);
        String text4 = "Good luck!";
        GameOver.printString(terminal,text4, Board.BOARD_WIDTH + 5, 7);

    }

    public static void drawGameObject(Terminal terminal, Player player, Monster monster) {

        terminal.applyForegroundColor(Terminal.Color.YELLOW);
        terminal.moveCursor(player.getX(), player.getY());
        terminal.putCharacter('P');
        terminal.applyForegroundColor(Terminal.Color.RED);
        terminal.moveCursor(monster.getX(), monster.getY());
        terminal.putCharacter('\u2588');
        terminal.moveCursor(0,0);

    }
}