//Klassen ritar ut spelplanen och GameObjects i spelplanen

import com.googlecode.lanterna.terminal.Terminal;

public class DrawBoard {
    public static void draw(Player player, Monster monster) {

        Main.terminal.clearScreen();

        Main.terminal.applyForegroundColor(Terminal.Color.CYAN);
        for (int i = 0; i <= Board.BOARD_HEIGHT; i++) {
            Main.terminal.moveCursor(0,i);
            Main.terminal.putCharacter('|');
            Main.terminal.moveCursor(Board.BOARD_WIDTH,i);
            Main.terminal.putCharacter('|');
        }
        for (int i = 1; i < Board.BOARD_WIDTH; i++){
            Main.terminal.moveCursor(i,0);
            Main.terminal.putCharacter('-');
            Main.terminal.moveCursor(i,Board.BOARD_HEIGHT);
            Main.terminal.putCharacter('-');
        }

        Main.terminal.applyForegroundColor(Terminal.Color.RED);
        Main.terminal.moveCursor(player.x, player.y);
        Main.terminal.putCharacter('P');
        Main.terminal.moveCursor(monster.x, monster.y);
        Main.terminal.putCharacter('M');
        Main.terminal.moveCursor(0,0);
    }
}