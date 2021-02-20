package jpuppeteer.util.mouse;

public class MathUtil {

    public static int roundTowards(double value, int target) {
        if (target > value) {
            return (int) Math.ceil(value);
        } else {
            return (int) Math.floor(value);
        }
    }
}
