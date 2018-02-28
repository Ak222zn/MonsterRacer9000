//Klassen innehåller loopen som håller spelet igång

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

public class RunGame {
    public void rungame() throws InterruptedException {
        Player player = new Player();
        Monster monster = new Monster();


        //kör spelet så länge villkoret uppfylls
        while (true) {
            DrawBoard.draw(player,monster);

            Movement.moveGameObject(player,monster);
            if (isPlayerAlive(player, monster)){
                continue;
            } else
                System.exit(0);

        }
    }

    public boolean isPlayerAlive (Player player, Monster monster){
        if (player.x == monster.x && player.y == monster.y){
            return false;
        }
        return true;
    }
}