//Klassen innehåller regler för hur Gameobjects rör sig

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class Movement {

    public static void moveGameObject(Terminal terminal, Player player, Monster monster)throws InterruptedException {

        movePlayer(terminal, player);
        moveMonster(player, monster);

    }

    public static void movePlayer(Terminal terminal, Player player) throws InterruptedException {
        Key key;
        do {
            Thread.sleep(5);
            key = terminal.readInput();
        }
        while (key == null);

        switch (key.getKind()) {
            case ArrowDown:
                if (player.y < Board.BOARD_HEIGHT)
                    player.y++;
                break;
            case ArrowUp:
                if (player.y > 1)
                    player.y--;
                break;
            case ArrowLeft:
                if (player.x > 1)
                    player.x--;
                break;
            case ArrowRight:
                if (player.x < Board.BOARD_WIDTH)
                    player.x++;
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