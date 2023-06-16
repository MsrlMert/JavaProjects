import java.awt.*;

public class StdDraw_Filled_Circles {
    public static void main(String[] args){

        int canvasWidth = 600;
        int canvasHeight = 600;
        StdDraw.setCanvasSize(canvasWidth,canvasHeight);
        StdDraw.setXscale(0,1);
        StdDraw.setYscale(0,1);

        // set color of the 1st circle
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(0.6,0.55,0.3);

        Color myColor = new Color(1.0f,0.0f,0.0f);
        StdDraw.setPenColor(myColor);

        StdDraw.filledCircle(0.3,0.4,0.2);


    }
}
