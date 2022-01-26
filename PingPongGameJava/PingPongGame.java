import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class PingPongGame {
    Raket raket1 = new Raket(20,300);
    Raket raket2 = new Raket(780,300);
    PingPongBall ball = new PingPongBall(400,300);
    int player1GoalCount = 0;
    int player2GoalCount = 0;
    Random random = new Random();

    public void drawRakets(){
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(raket1.xCoord,raket1.yCoord,10,50);
        StdDraw.filledRectangle(raket2.xCoord,raket2.yCoord,10,50);
        StdDraw.setPenColor(Color.orange);
    }
    public void drawBall(){
        StdDraw.filledCircle(ball.xCoord,ball.yCoord,10);

    }
    public void moveRakets(){
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)){
            int y = raket1.yCoord;
            y += 20;
            raket1.yCoord = y;
            StdDraw.pause(40);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_S)){
            int y = raket1.yCoord;
            y -= 20;
            raket1.yCoord = y;
            StdDraw.pause(40);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)){
            raket2.yCoord += 20;
            StdDraw.pause(40);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)){
            raket2.yCoord -= 20;
            StdDraw.pause(40);
        }
    }
    public void moveBall(){
        double x = ball.xCoord;
        double  y = ball.yCoord;
        if (y +ball.Vy > 600 -10 || y+ ball.Vy < 0){
            ball.Vy = -ball.Vy;

        }
        ball.xCoord = ball.xCoord + ball.Vx;
        ball.yCoord = ball.yCoord + ball.Vy;
    }

    public void countGoal(){
        double x = ball.xCoord;
        double y = ball.yCoord;
        if (x+ ball.Vx > 800-10){
            player1GoalCount++;
            resetGame();
        }
        if (x+ ball.Vx < 0){
            player2GoalCount++;
            resetGame();
        }
    }

    public void resetGame(){
        int[] list = {-1,1};
        ball.xCoord = 400;
        ball.yCoord = 300;
        StdDraw.filledCircle(ball.xCoord,ball.yCoord,10);
        ball.Vx = ball.Vx * list[random.nextInt(2)];
        ball.Vy = ball.Vy * list[random.nextInt(2)];
    }
    public void touchRakets(){
        if ((ball.xCoord < 790 && ball.xCoord > 770) && (Math.abs(ball.yCoord-raket2.yCoord)<100)){
            ball.Vx = -ball.Vx;


        }
        if ((ball.xCoord < 30 && ball.xCoord > 10) && (Math.abs(raket1.yCoord- ball.yCoord) < 100)){
            ball.Vx = -ball.Vx;
        }
        ball.xCoord = ball.xCoord+ball.Vx;
        ball.yCoord = ball.yCoord+ball.Vy;
    }
    public void findWinner(){
        if (player1GoalCount == 5){
            System.out.println("Winner is first Player");
            StdDraw.text(400,300,"Player 1 Is Winner");
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.text(390,560,String.valueOf(player1GoalCount));

        }
        if (player2GoalCount == 5 ){
            System.out.println("Winner is second Player");
            StdDraw.text(400,300,"Player 2 Is Winner");
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.text(410,560,String.valueOf(player2GoalCount));

        }
    }
    public void printScore(){
        StdDraw.setPenColor(Color.RED);

        StdDraw.text(390,560,String.valueOf(player1GoalCount));
        StdDraw.text(410,560,String.valueOf(player2GoalCount));

    }
}
