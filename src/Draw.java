//Klassen ritar ut spelplanen och GameObjects i spelplanen

import com.googlecode.lanterna.terminal.Terminal;

public class Draw {
    public static void drawBoardAndGameObjects(Terminal terminal, Player player, Monster monster, char[][] array) {
        drawBoard(terminal, array);
        drawGameObject(terminal, player, monster);
    }

    public static void drawBoard(Terminal terminal, char[][] array) {

        terminal.clearScreen();

        terminal.applyForegroundColor(Terminal.Color.CYAN);
        for (int i = 0; i <= Board.BOARD_HEIGHT; i++) {
            terminal.moveCursor(0,i);
            terminal.putCharacter('|');
            terminal.moveCursor(Board.BOARD_WIDTH+1,i);
            terminal.putCharacter('|');
        }
        for (int i = 1; i < Board.BOARD_WIDTH; i++){
            terminal.moveCursor(i,0);
            terminal.putCharacter('-');
            terminal.moveCursor(i,Board.BOARD_HEIGHT+1);
            terminal.putCharacter('-');
        }

        for (int i = 1; i < Board.BOARD_WIDTH +1; i++) {
            for (int j = 1; j < Board.BOARD_HEIGHT +1; j++) {
                terminal.moveCursor(i,j);
                terminal.putCharacter(array[i][j]);
            }
        }

    }

    public static void drawGameObject(Terminal terminal, Player player, Monster monster) {

        terminal.applyForegroundColor(Terminal.Color.RED);
        terminal.moveCursor(player.x, player.y);
        terminal.putCharacter('P');
        terminal.moveCursor(monster.x, monster.y);
        terminal.putCharacter('M');
        terminal.moveCursor(0,0);

    }
}