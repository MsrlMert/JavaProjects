import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    Random random = new Random();
    Snake snake = new Snake();
    Food food = new Food();
    static int count = 0;
    ArrayList<Tails> tails = new ArrayList<>();

    public void move(){
        if (snake.snakeDirection == KeyEvent.VK_UP){
            snake.snakeYCoord += 20;
            StdDraw.pause(80);
        }
        if (snake.snakeDirection == KeyEvent.VK_RIGHT){
            snake.snakeXCoord += 20;
            StdDraw.pause(80);
        }
        if (snake.snakeDirection == KeyEvent.VK_DOWN){
            snake.snakeYCoord -= 20;
            StdDraw.pause(80);
        }
        if (snake.snakeDirection == KeyEvent.VK_LEFT){
            snake.snakeXCoord -= 20;
            StdDraw.pause(80);
        }
    }
    public void goUp(){
        if (snake.snakeDirection != KeyEvent.VK_DOWN){
            snake.snakeDirection = KeyEvent.VK_UP;
        }
    }
    public void goRight(){
        if (snake.snakeDirection != KeyEvent.VK_LEFT){
            snake.snakeDirection = KeyEvent.VK_RIGHT;
        }
    }
    public void goDown(){
        if (snake.snakeDirection != KeyEvent.VK_UP){
            snake.snakeDirection = KeyEvent.VK_DOWN;
        }
    }
    public void goLeft(){
        if (snake.snakeDirection != KeyEvent.VK_RIGHT){
            snake.snakeDirection = KeyEvent.VK_LEFT;
        }
    }

    public void drawSnake(){
        StdDraw.filledRectangle(snake.snakeXCoord,snake.snakeYCoord,snake.rectHalfSize,snake.rectHalfSize);
        StdDraw.show();
    }
    public void drawFood(){
        StdDraw.setPenColor(Color.red);
        StdDraw.filledCircle(food.foodXCoord,food.foodYCoord,15);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.show();
    }
    public void changeFoodCoord(){
        food.foodXCoord = random.nextInt(580-10+1)+10;
        food.foodYCoord = random.nextInt(580-10+1)+10;
    }
    public boolean isGameOver(){
        if (snake.snakeXCoord+ snake.rectHalfSize+10 > 600 || snake.snakeYCoord+ snake.rectHalfSize+10>600 || snake.snakeXCoord- snake.rectHalfSize <= 0 || snake.snakeYCoord- snake.rectHalfSize < 0){
            return true;
        }
        return false;
    }
    public void eatFood(){
        if (count == 0 || (Math.abs(snake.snakeXCoord-food.foodXCoord) < 20 && Math.abs(snake.snakeYCoord-food.foodYCoord) < 20)){
            count ++;
            tails.add(new Tails(snake.snakeXCoord, snake.snakeYCoord, snake.rectHalfSize, snake.snakeDirection));
            changeFoodCoord();

        }
        for (int i = tails.size()-1; i>0 ; i--) {
            StdDraw.setPenColor(Color.orange);
            tails.set(i, tails.get(i-1));
            StdDraw.filledRectangle(tails.get(i).xCoord,tails.get(i).yCoord,tails.get(i).rectHalfSize,tails.get(i).rectHalfSize);
        }
        StdDraw.setPenColor(Color.black);
        if (tails.size() > 0){
            int xCoord = snake.snakeXCoord;
            int yCoord = snake.snakeYCoord;
            int rectHalfSize = snake.rectHalfSize;
            int direction = snake.snakeDirection;
            tails.set(0,new Tails(xCoord,yCoord,rectHalfSize,direction));
            StdDraw.filledRectangle(tails.get(0).xCoord,tails.get(0).yCoord,tails.get(0).rectHalfSize,tails.get(0).rectHalfSize);
        }
    }
    public boolean isCrashedBody(){

        for (int i = 1; i < tails.size(); i++) {
            if (snake.snakeXCoord == tails.get(i).xCoord && snake.snakeYCoord == tails.get(i).yCoord){
                 return true;
            }
        }
        return false;
    }
}
