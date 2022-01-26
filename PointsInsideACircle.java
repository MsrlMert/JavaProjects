import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class PointsInsideACircle {
    static Random random ;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a radius between [1,10]: ");
        int radius = input.nextInt();
        while(radius > 10 || radius < 1 ){
            System.out.println("Please Enter a radius between [1,10]: ");
            radius = input.nextInt();
        }
        System.out.println("Enter amount of points: ");
        int amountPoints = input.nextInt();
        drawProject(0,0,radius,amountPoints,pointsInCircle(createPoints(amountPoints),0,0,radius));

    }
    public static double[][] createPoints(int numPoint){
        random = new Random();
        int i = 0;
        double[][] points = new double[numPoint][2];
        while(i < numPoint){
            double randomX = random.nextDouble() * (10+10)-10;
            double randomY = random.nextDouble() * (10+10)-10;
            points[i][0] = randomX;
            points[i][1] = randomY;
            i++;
         }
        return points;
    }


    public static double[][] pointsInCircle(double[][] pointsList,double centerX, double centerY, int radius){
        double[][] pointInCircle ;
        int amountOfInCircle =0;
        for(double[] pointXY : pointsList){
            if(findDistance(pointXY[0],centerX,pointXY[1],centerY) < radius) {
                amountOfInCircle++;

            }
        }
        System.out.println(amountOfInCircle);
        pointInCircle = new double[amountOfInCircle][2];
        amountOfInCircle = 0;
        for(double[] pointXY : pointsList){
            if(findDistance(pointXY[0],centerX,pointXY[1],centerY) < radius) {
                pointInCircle[amountOfInCircle][0] = pointXY[0];
                pointInCircle[amountOfInCircle][1] = pointXY[1];
                amountOfInCircle++;
            }
        }
        return pointInCircle;
    }
    public static double findDistance(double num1X, double num2X, double num1Y, double num2Y){
        double xDistance = Math.pow((num1X-num2X),2);
        double yDistance = Math.pow((num1Y-num2Y),2);
        return Math.sqrt(xDistance+yDistance);
    }
    public static void drawProject(int centerX, int centerY, int radius,int amountOfPoint, double[][] inCirclePoints){
        StdDraw.setCanvasSize(800,800);
        StdDraw.setXscale(-5,5);
        StdDraw.setYscale(-5,5);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.circle(centerX, centerY, radius);
        double[][] pointsList = createPoints(amountOfPoint);
        for(double[] point : pointsList){
            if(findDistance(point[0],0,point[1],0) < radius){
                StdDraw.setPenColor(Color.red);
                StdDraw.point(point[0],point[1]);
            }
            else {
                StdDraw.setPenColor(Color.black);
                StdDraw.point(point[0], point[1]);
            }
        }


        StdDraw.show();

    }
}
