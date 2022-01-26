public class StdDraw_Points {
    public static void main(String[] args){

        int canvasWidth = 600;
        int canvasHeight = 600;
        StdDraw.setCanvasSize(canvasWidth,canvasHeight);

        StdDraw.setXscale(0,1);
        StdDraw.setYscale(0,1);

        StdDraw.clear(StdDraw.WHITE);

        double x0 = 0.1, y0 = 0.7;
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.setPenRadius(0.02);
        StdDraw.point(x0,y0);

        double x1 = 0.6;
        double y1 = 0.3;

        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.setPenRadius(0.04);
        StdDraw.point(x1,y1);




    }
}
