//Klassen ritar ut spelplanen och GameObjects i spelplanen

import com.googlecode.lanterna.terminal.Terminal;

public class Draw {
    public static void drawBoardAndGameObjects(Terminal terminal, Player player, Monster monster) {
        drawBoard(terminal);
        drawGameObject(terminal, player, monster);
    }

    public static void drawBoard(Terminal terminal) {

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
        for (int i = 6; i < 14; i++){
            terminal.moveCursor(6, i);
            terminal.putCharacter('|');
            terminal.moveCursor(14, i);
            terminal.putCharacter('|');
        }
        for (int i = 6; i < 14; i++){
            terminal.moveCursor(i, 6);
            terminal.putCharacter('-');
            terminal.moveCursor(i, 14);
            terminal.putCharacter('-');
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