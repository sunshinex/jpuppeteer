package jpuppeteer.util.mouse.impl;

import io.netty.util.concurrent.Future;
import jpuppeteer.api.Page;
import jpuppeteer.constant.MouseDefinition;
import jpuppeteer.entity.Point;
import jpuppeteer.util.mouse.MouseInfoAccessor;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class DefaultMouseInfoAccessor implements MouseInfoAccessor {

    private static final AtomicReferenceFieldUpdater<DefaultMouseInfoAccessor, Point> MOUSE_POSITION_UPDATER
            = AtomicReferenceFieldUpdater.newUpdater(DefaultMouseInfoAccessor.class, Point.class, "mousePosition");

    private volatile Point mousePosition;

    public DefaultMouseInfoAccessor(Point mousePosition) {
        this.mousePosition = mousePosition;
    }

    @Override
    public boolean setMousePosition(int x, int y) {
        Point oldPosition = this.mousePosition;
        Point newPosition = new Point(x, y);
        return MOUSE_POSITION_UPDATER.compareAndSet(this, oldPosition, newPosition);
    }

    @Override
    public Point getMousePosition() {
        return mousePosition;
    }
}
