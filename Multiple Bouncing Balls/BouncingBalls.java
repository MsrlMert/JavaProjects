public class BouncingBalls {
    private double xCoord;
    private double yCoord;
    private double Vx;
    private double Vy;
    private double radius = 0.03;

    public double getRadius() {
        return this.radius;
    }

    public BouncingBalls(double xCoord, double yCoord, double Vx, double Vy) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.Vx = Vx;
        this.Vy = Vy;
        radius = 0.03;
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

    public double getVx() {
        return this.Vx;
    }

    public void setVx(final double vx) {
        this.Vx = vx;
    }

    public double getVy() {
        return this.Vy;
    }

    public void setVy(final double vy) {
        this.Vy = vy;
    }
}
