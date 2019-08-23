package jpuppeteer.api.browser;

public class Viewport {

    private final int width;

    private final int height;

    private final int deviceScaleFactor;

    private final boolean isMobile;

    private final boolean hasTouch;

    private final boolean isLandscape;

    public Viewport(int width, int height, int deviceScaleFactor, boolean isMobile, boolean hasTouch, boolean isLandscape) {
        this.width = width;
        this.height = height;
        this.deviceScaleFactor = deviceScaleFactor;
        this.isMobile = isMobile;
        this.hasTouch = hasTouch;
        this.isLandscape = isLandscape;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDeviceScaleFactor() {
        return deviceScaleFactor;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public boolean isHasTouch() {
        return hasTouch;
    }

    public boolean isLandscape() {
        return isLandscape;
    }

}
