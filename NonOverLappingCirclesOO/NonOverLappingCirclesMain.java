public class NonOverLappingCirclesMain{
    public static void main(String[] args) {
        NonOverLappingGame game = new NonOverLappingGame();
        game.generateWindow();

        game.generateCircle(500);
        game.drawCircles();
        StdDraw.save("sCircle.png");
    }
}