//Klassen håller reda på var den befinner sig på spelplanen

import java.util.Random;

public class Player extends GameObject {

    public Player() {
    }

    public void randomizeStartPosition(char[][] array){
        Random rand = new Random();
        int tempX, tempY;
        tempX = rand.nextInt(30);
        tempY = rand.nextInt(30);
        while (array[tempX][tempY] == 'x' || array[tempX][tempY] == 'E') {
            tempX = rand.nextInt(30);
            tempY = rand.nextInt(30);
        }
        this.setX(tempX);
        this.setY(tempY);
    }

}