import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class NonOverLappingGame {
    Random random = new Random();
    private ArrayList<Circles> circles = new ArrayList<>();
    private int width = 600;
    private int height = 600;


    public void generateWindow(){

        StdDraw.setCanvasSize(width,height);
        StdDraw.setScale(-1,1);
    }
    public void generateCircle(int number){
        int countOfCircles = 0;
        while(countOfCircles < number) {
            double xCoord = random.nextDouble() * (1 + 1) - 1;
            double yCoord = random.nextDouble() * (1 + 1) - 1;
            double radius = random.nextDouble() * (0.2 - 0.01) + 0.01;
            if (circles.size() == 0) {
                if ((!isOverFloweX(xCoord, radius) && (!isOverFlowY(yCoord, radius)))) {
                    circles.add(new Circles(xCoord, yCoord, radius));
                    countOfCircles++;
                }
            }
            if (circles.size() != 0) {
                if ((!isOverFloweX(xCoord, radius)) && (!isOverFlowY(yCoord, radius)) && (!isOverLapped(xCoord, yCoord, radius, circles))) {
                    circles.add(new Circles(xCoord, yCoord, radius));
                    countOfCircles++;
                }
            }
        }
    }

    public double findDistance(double xCoord1,double yCoord1, double xCoord2, double yCoord2){
        double xDistance = Math.pow(xCoord1-xCoord2,2);
        double yDistance = Math.pow(yCoord1-yCoord2,2);
        return Math.sqrt(xDistance+yDistance);
    }

    public boolean isOverFloweX(double xCoord, double radius){
        if (Math.abs(xCoord)+radius > 1){
            return true;
        }
        return false;
    }

    public boolean isOverFlowY(double yCoord, double radius){
        if (Math.abs(yCoord)+radius > 1){
            return true;
        }
        return false;
    }

    public boolean isOverLapped(double xCoord, double yCoord, double radius, ArrayList<Circles> array){
        for (Circles circle : circles){
            if (findDistance(xCoord,yCoord,circle.getxCoord(),circle.getyCoord()) < (circle.getRadius()+radius)){
                return true;
            }
        }
        return false;
    }

    public void drawCircles(){
        StdDraw.setPenColor(Color.BLUE);
        for (Circles circle : circles){
            StdDraw.filledCircle(circle.getxCoord(),circle.getyCoord(),circle.getRadius());
        }
    }

}