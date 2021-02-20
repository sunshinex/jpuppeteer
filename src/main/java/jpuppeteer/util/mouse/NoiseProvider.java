package jpuppeteer.util.mouse;

import java.util.Random;

public interface NoiseProvider {

    DoublePoint getNoise(Random random, double xStepSize, double yStepSize);

}
