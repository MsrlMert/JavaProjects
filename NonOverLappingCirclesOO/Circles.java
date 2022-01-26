public class Circles {
    private double xCoord;
    private double yCoord;
    private double radius;

    public Circles(final double xCoord, final double yCoord, final double radius) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.radius = radius;
    }

    public double getxCoord() {
        return this.xCoord;
    }

    public void setxCoord(final double xCoord) {
        this.xCoord = xCoord;
    }

    public double getyCoord() {
        return this.yCoord;
    }

    public void setyCoord(final double yCoord) {
        this.yCoord = yCoord;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(final double radius) {
        this.radius = radius;
    }
}