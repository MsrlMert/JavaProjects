import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BouncingBallsGame {
    private int width = 600;
    private int height = 600;
    Random random = new Random();
    ArrayList<BouncingBalls> bouncingBalls = new ArrayList<>();

    public void generateWindow(){
        StdDraw.setCanvasSize(width,height);
        StdDraw.setScale(-1,1);
    }
    public void generateBalls(){
        double xCoord = random.nextDouble() * (1+1)-1;
        double yCoord = random.nextDouble() * (1+1)-1;
        double Vx = random.nextDouble() *(0.01+0.01)-0.01;
        double Vy = random.nextDouble() *(0.01+0.01)-0.01;

        bouncingBalls.add(new BouncingBalls(xCoord,yCoord,Vx,Vy));
    }

    public void moveBalls(){
        StdDraw.setPenColor(Color.orange);
        for (BouncingBalls ball : bouncingBalls){
            if (Math.abs(ball.getyCoord()+ball.getVy()) > 1-ball.getRadius()){
                ball.setVy(-ball.getVy());
            }
            if (Math.abs(ball.getxCoord()+ball.getVx()) > 1-ball.getRadius()){
                ball.setVx(-ball.getVx());
            }

            ball.setxCoord(ball.getxCoord()+ball.getVx());
            ball.setyCoord(ball.getyCoord()+ball.getVy());
            StdDraw.filledCircle(ball.getxCoord(),ball.getyCoord(),ball.getRadius());

        }

    }
//    public void touchBorder(int index){
//        if (Math.abs(bouncingBalls.get(index).getyCoord()+bouncingBalls.get(index).getVy()) > 1-bouncingBalls.get(index).getRadius()){
//            bouncingBalls.get(index).setVy(-bouncingBalls.get(index).getVy());
//        }
//        if (Math.abs(bouncingBalls.get(index).getxCoord()+bouncingBalls.get(index).getVx()) > 1-bouncingBalls.get(index).getRadius()){
//            bouncingBalls.get(index).setVx(-bouncingBalls.get(index).getVx());
//        }
//        double xCoord = bouncingBalls.get(index).getxCoord() + bouncingBalls.get(index).getVx();
//        double yCoord = bouncingBalls.get(index).getyCoord() + bouncingBalls.get(index).getVy();
//
//    }


}
