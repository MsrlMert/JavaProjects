import java.awt.*;

public class Lab05Main {
    public static void main(String[] args) {
        BouncingBallsGame game = new BouncingBallsGame();
        int numberOfCircle = 5;
        game.generateWindow();
        for (int i = 0; i < numberOfCircle; i++) {
            game.generateBalls();
        }
        StdDraw.enableDoubleBuffering();
        while (true){
            game.moveBalls();
            StdDraw.show();
            StdDraw.clear(Color.white);
        }
    }
}
