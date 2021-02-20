package jpuppeteer.util.mouse.impl;

import jpuppeteer.util.mouse.DeviationProvider;
import jpuppeteer.util.mouse.DoublePoint;

public class DefaultDeviationProvider implements DeviationProvider {

    public static final int DEFAULT_SLOPE_DIVIDER = 10;
    private final double slopeDivider;

    public DefaultDeviationProvider(double slopeDivider) {
        this.slopeDivider = slopeDivider;
    }

    @Override
    public DoublePoint getDeviation(double totalDistanceInPixels, double completionFraction) {
        double deviationFunctionResult = (1 - Math.cos(completionFraction * Math.PI * 2)) / 2;

        double deviationX = totalDistanceInPixels / slopeDivider;
        double deviationY = totalDistanceInPixels / slopeDivider;

        return new DoublePoint(deviationFunctionResult * deviationX, deviationFunctionResult * deviationY);
    }

}
