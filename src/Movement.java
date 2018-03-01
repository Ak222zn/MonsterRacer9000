//Klassen innehåller regler för hur Gameobjects rör sig

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class Movement {

    public static void moveGameObject(Terminal terminal, Player player, Monster monster, char [][] array) {

        movePlayer(terminal, player, array);
        moveMonster(player, monster);

    }

    public static void movePlayer(Terminal terminal, Player player, char [][] array)  {
        Key key;
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

        switch (key.getKind()) {
            case ArrowDown:
                if (player.y < Board.BOARD_HEIGHT && (array[player.x][player.y + 1]) != 'x') {
                    if (array[player.x][player.y + 1] == 'E')
                        System.exit(0);
                    player.y++;
                }
                break;
            case ArrowUp:
                if (player.y > 0 && (array[player.x][player.y - 1]) != 'x') {
                    if (array[player.x][player.y - 1] == 'E')
                        System.exit(0);
                    player.y--;
                }
                break;
            case ArrowLeft:
                if (player.x > 0 && (array[player.x - 1][player.y]) != 'x') {
                    if (array[player.x - 1][player.y] == 'E')
                        System.exit(0);
                    player.x--;
                }
                break;
            case ArrowRight:
                if (player.x < Board.BOARD_WIDTH && (array[player.x + 1][player.y]) != 'x') {
                    if (array[player.x + 1][player.y] == 'E')
                        System.exit(0);
                    player.x++;
                }
                break;
        }
    }

    public static void moveMonster(Player player, Monster monster) {

        int deltaX = (player.x - monster.x);
        int deltaY = (player.y - monster.y);
        if (Math.abs(deltaX) <= Math.abs(deltaY)) {
            if (deltaY > 0) {
                monster.y++;
            } else if (deltaY < 0)
                monster.y--;
        } else if (Math.abs(deltaX) > Math.abs(deltaY)) {
            if (deltaX > 0) {
                monster.x++;
            } else if (deltaX < 0)
                monster.x--;
        }
    }
}