import java.awt.*;

public class StdDraw_Circle {
    public static void main(String[] args){
        // X Y scale parameters
        int canvasWidth = 400;
        int canvasHeight = 400;

        // Canvas
        StdDraw.setCanvasSize(canvasWidth,canvasHeight);
        StdDraw.setXscale(0,1);
        StdDraw.setYscale(0,1);

        // Circle Paramaters : center coordinates, radius, thickness and color

        double circleCenterX = 0.5;
        double circleCenterY = 0.5;
        double circleRadius = 0.45;
        double circleBorderThickness = 0.024;
        Color circleColor = StdDraw.CYAN;

        // Draw Circle
        StdDraw.setPenColor(circleColor);
        StdDraw.setPenRadius(circleBorderThickness);
//        StdDraw.circle(circleCenterX,circleCenterY,circleRadius);
        StdDraw.filledCircle(circleCenterX,circleCenterY,circleRadius);

        // save drawing to an image file

        // StdDraw.save("outputFigure.png");

    }
}
