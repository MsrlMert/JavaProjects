import java.awt.event.KeyEvent;
import java.util.Set;

public class GettingKeyboardInput {
    public static void main(String[] args) {

        int width = 600;
        int height = 600;
        StdDraw.setCanvasSize(width,height);

        StdDraw.setXscale(0,width);
        StdDraw.setYscale(0,height);
        StdDraw.enableDoubleBuffering();

        int x = 250;
        int y = 250;
        int rectHalfSize = 20;

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledRectangle(x,y,rectHalfSize,rectHalfSize);
        StdDraw.show();

        int keyboardPauseDuration = 100;

        while(true) {
            if (StdDraw.isKeyPressed((KeyEvent.VK_LEFT))) {
                StdDraw.pause(keyboardPauseDuration);
                x = x - 2 * rectHalfSize;
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
                // move right
                StdDraw.pause(keyboardPauseDuration);
                x = x + (2 * rectHalfSize);
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
                StdDraw.pause(keyboardPauseDuration);
                y = y + (2 * rectHalfSize);
            }
            if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
                StdDraw.pause(keyboardPauseDuration);
                y = y - (2 * rectHalfSize);
            }

            StdDraw.clear();
            StdDraw.filledRectangle(x, y, rectHalfSize, rectHalfSize);
            StdDraw.show();
        }
    }
}
