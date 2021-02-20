package jpuppeteer.util.mouse;

public interface DeviationProvider {

    DoublePoint getDeviation(double totalDistanceInPixels, double completionFraction);

}
