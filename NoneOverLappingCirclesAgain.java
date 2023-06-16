import java.awt.*;
import java.util.Random;

public class NoneOverLappingCirclesAgain {
    static Random random = new Random();
    public static void main(String[] args) {
        int width = 600;
        int height = 600;
        StdDraw.setCanvasSize(width,height);

        StdDraw.setXscale(-1,1);
        StdDraw.setYscale(-1,1);
        int amount = 400;
        double[][] points = randomPoints(amount);
        drawCircles(points);


    }
    public static double[][] randomPoints(int amount){
        double[][] coordinates = new double[amount][3];
        for (int i = 0; i <amount ; i++) {
            boolean isAddable = true;
            double xCoord = random.nextDouble() * (1 + 1) - 1;
            double yCoord = random.nextDouble() * (1 + 1) - 1;
            double radius = random.nextDouble() * (0.2 - 0.01) + 0.01;

            for (int j = 0; j < i; j++) {
                if (findDistance(xCoord, yCoord, coordinates[j][0], coordinates[j][1]) < radius + coordinates[j][2]) {
                    isAddable = false;
                    break;
                }
            }

            if (isAddable && Math.abs(xCoord)+radius <= 1 && Math.abs(yCoord)+radius <=1){
                coordinates[i][0] = xCoord;
                coordinates[i][1] = yCoord;
                coordinates[i][2] = radius;
            }
        }
        return coordinates;
    }

    public static void drawCircles(double[][] points){
        StdDraw.setPenColor(Color.orange);
        for (int i = 0; i < points.length; i++) {
            if(i % 2 == 0){
                StdDraw.setPenColor(Color.cyan);
            }
            else{
                StdDraw.setPenColor(Color.orange);
            }
            StdDraw.filledCircle(points[i][0],points[i][1],points[i][2]);
        }
    }
    public static double findDistance(double point1X, double point1Y, double point2X, double point2Y){
        double xDistance = Math.pow(point1X-point2X,2);
        double yDistance = Math.pow(point1Y-point2Y,2);

        return Math.sqrt(xDistance+yDistance);
    }

}
