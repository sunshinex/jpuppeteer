package jpuppeteer.util.mouse;

public class DoublePoint {

    public final static DoublePoint ZERO = new DoublePoint(0, 0);
    public final double x;
    public final double y;

    public DoublePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
