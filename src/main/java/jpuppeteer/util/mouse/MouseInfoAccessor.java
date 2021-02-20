package jpuppeteer.util.mouse;

import jpuppeteer.entity.Point;

public interface MouseInfoAccessor {

    boolean setMousePosition(int x, int y);

    Point getMousePosition();

}
