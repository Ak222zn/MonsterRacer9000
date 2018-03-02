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
                if (player.getY() < Board.BOARD_HEIGHT && (array[player.getX()][player.getY() + 1]) != 'x') {
                    if (array[player.getX()][player.getY() + 1] == 'E')
                        nextlevel = true;
                    player.setY(player.getY() + 1);
                }
                break;
            case ArrowUp:
                if (player.getY() > 0 && (array[player.getX()][player.getY() - 1]) != 'x') {
                    if (array[player.getX()][player.getY() - 1] == 'E')
                        nextlevel = true;
                    player.setY(player.getY() - 1);
                }
                break;
            case ArrowLeft:
                if (player.getX() > 0 && (array[player.getX() - 1][player.getY()]) != 'x') {
                    if (array[player.getX() - 1][player.getY()] == 'E')
                        nextlevel = true;
                    player.setX(player.getX() - 1);
                }
                break;
            case ArrowRight:
                if (player.getX() < Board.BOARD_WIDTH && (array[player.getX() + 1][player.getY()]) != 'x') {
                    if (array[player.getX() + 1][player.getY()] == 'E')
                        nextlevel = true;
                    player.setX(player.getX() + 1);
                }
                break;
        }
        return nextlevel;
    }

    public static void moveMonster(Player player, Monster monster, char[][] array) {

        int deltaX = (player.getX() - monster.getX());
        int deltaY = (player.getY() - monster.getY());
        if (Math.abs(deltaX) <= Math.abs(deltaY)) {
            if (deltaY > 0) {
                if (array[monster.getX()][monster.getY() + 1] != 'x' && array[monster.getX()][monster.getY() + 1] != 'E')
                    monster.setY(monster.getY() + 1);
            } else if (deltaY < 0)
                if (array[monster.getX()][monster.getY() - 1] != 'x' && array[monster.getX()][monster.getY() - 1] != 'E')
                    monster.setY(monster.getY() - 1);
        } else if (Math.abs(deltaX) > Math.abs(deltaY)) {
            if (deltaX > 0) {
                if (array[monster.getX() + 1][monster.getY()] != 'x' && array[monster.getX() + 1][monster.getY()] != 'E')
                    monster.setX(monster.getX() + 1);
            } else if (deltaX < 0)
                if (array[monster.getX() - 1][monster.getY()] != 'x' && array[monster.getX() - 1][monster.getY()] != 'E')
                    monster.setX(monster.getX() - 1);
        }
    }
}