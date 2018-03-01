//Klassen innehåller regler för hur Gameobjects rör sig

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class Movement {

//    public static void moveGameObject(Terminal terminal, Player player, Monster monster, char[][] array) {
//
//        movePlayer(terminal, player, array);
//        moveMonster(player, monster, array);
//
//    }

    public static boolean movePlayer(Terminal terminal, Player player, char[][] array) {
        Key key;
        boolean nextlevel = false;
        do {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            key = terminal.readInput();
        }
        while (key == null);

        switch (key.getKind()) {
            case ArrowDown:
                if (player.y < Board.BOARD_HEIGHT && (array[player.x][player.y + 1]) != 'x') {
                    if (array[player.x][player.y + 1] == 'E')
                        nextlevel = true;
                    player.y++;
                }
                break;
            case ArrowUp:
                if (player.y > 0 && (array[player.x][player.y - 1]) != 'x') {
                    if (array[player.x][player.y - 1] == 'E')
                        nextlevel = true;
                    player.y--;
                }
                break;
            case ArrowLeft:
                if (player.x > 0 && (array[player.x - 1][player.y]) != 'x') {
                    if (array[player.x - 1][player.y] == 'E')
                        nextlevel = true;
                    player.x--;
                }
                break;
            case ArrowRight:
                if (player.x < Board.BOARD_WIDTH && (array[player.x + 1][player.y]) != 'x') {
                    if (array[player.x + 1][player.y] == 'E')
                        nextlevel = true;
                    player.x++;
                }
                break;
        }
        return nextlevel;
    }

    public static void moveMonster(Player player, Monster monster, char[][] array) {

        int deltaX = (player.x - monster.x);
        int deltaY = (player.y - monster.y);
        if (Math.abs(deltaX) <= Math.abs(deltaY)) {
            if (deltaY > 0) {
                if (array[monster.x][monster.y + 1] != 'x' && array[monster.x][monster.y + 1] != 'E')
                    monster.y++;
            } else if (deltaY < 0)
                if (array[monster.x][monster.y - 1] != 'x' && array[monster.x][monster.y - 1] != 'E')
                    monster.y--;
        } else if (Math.abs(deltaX) > Math.abs(deltaY)) {
            if (deltaX > 0) {
                if (array[monster.x + 1][monster.y] != 'x' && array[monster.x + 1][monster.y] != 'E')
                    monster.x++;
            } else if (deltaX < 0)
                if (array[monster.x - 1][monster.y] != 'x' && array[monster.x - 1][monster.y] != 'E')
                    monster.x--;
        }
    }
}