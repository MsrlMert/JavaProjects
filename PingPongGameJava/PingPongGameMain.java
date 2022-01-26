import java.awt.*;
import java.awt.event.KeyEvent;

public class PingPongGameMain {
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        StdDraw.setCanvasSize(width,height);

        StdDraw.setXscale(0,width);
        StdDraw.setYscale(0,height);

        StdDraw.clear(Color.black);
        StdDraw.enableDoubleBuffering();

        PingPongGame pingPongGame = new PingPongGame();
        pingPongGame.drawRakets();
        pingPongGame.drawBall();

        while (true){
            pingPongGame.moveRakets();
            pingPongGame.moveBall();
            pingPongGame.touchRakets();
            pingPongGame.drawRakets();

            pingPongGame.drawBall();
            pingPongGame.countGoal();
            pingPongGame.printScore();
            if (pingPongGame.player1GoalCount ==5 || pingPongGame.player2GoalCount == 5){
                pingPongGame.findWinner();
                StdDraw.show();
                break;
            }

            StdDraw.show();
            StdDraw.clear(StdDraw.BOOK_BLUE);
        }

    }
}
