import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SnakeGameMain{
    public static void main(String[] args) {
        int width = 600;
        int height = 600;

        StdDraw.setCanvasSize(width,height);

        StdDraw.setXscale(0,width);
        StdDraw.setYscale(0,height);
        StdDraw.enableDoubleBuffering();
        Game game = new Game();
        Snake snake = new Snake();
        Food food = new Food();


        int count = 0;
        while (true){

            if (game.isGameOver() || game.isCrashedBody()){
                System.out.println("OYUN BİTTİ");
                break;
            }

            if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
                game.goUp();


            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)){
                game.goRight();

            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
                game.goDown();

            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
                game.goLeft();

            }
            game.move();
            game.drawSnake();
            game.eatFood();
//            game.drawTails();
            game.drawFood();

            StdDraw.show();
            StdDraw.clear(Color.lightGray);
        }
    }

}