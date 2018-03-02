//Klassen håller reda på var den befinner sig på spelplanen

import java.util.Random;

public class Monster extends GameObject {

    public Monster() {
        this.setX(13);
        this.setX(13);

    }

    public void randomizeStartPosition(Player player, char[][] array){
        Random rand = new Random();
        int tempX, tempY;
        tempX = rand.nextInt(30);
        tempY = rand.nextInt(30);
        while (array[tempX][tempY] == 'x' || array[tempX][tempY] == 'E' || (tempX == player.getX() && tempY == player.getY())) {
            tempX = rand.nextInt(30);
            tempY = rand.nextInt(30);
        }
        this.setX(tempX);
        this.setY(tempY);
    }
}