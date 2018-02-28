//Klassen innehåller regler för hur Gameobjects rör sig

import com.googlecode.lanterna.input.Key;

public class Movement {
    public static void moveGameObject(Player player, Monster monster) throws InterruptedException {
        Key key;
        do {
            Thread.sleep(5);
            key = Main.terminal.readInput();
        }
        while (key == null);

            switch (key.getKind()) {
                case ArrowDown:
                    player.y++;
                    break;
                case ArrowUp:
                    player.y--;
                    break;
                case ArrowLeft:
                    player.x--;
                    break;
                case ArrowRight:
                    player.x++;
                    break;
            }



    }
}