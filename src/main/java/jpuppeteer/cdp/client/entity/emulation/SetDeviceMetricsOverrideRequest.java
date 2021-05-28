package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetDeviceMetricsOverrideRequest {

    /**
    * Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override.
    */
    public final Integer width;

    /**
    * Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override.
    */
    public final Integer height;

    /**
    * Overriding device scale factor value. 0 disables the override.
    */
    public final java.math.BigDecimal deviceScaleFactor;

    /**
    * Whether to emulate mobile device. This includes viewport meta tag, overlay scrollbars, text autosizing and more.
    */
    public final Boolean mobile;

    /**
    * Scale to apply to resulting view image.
    */
    public final java.math.BigDecimal scale;

    /**
    * Overriding screen width value in pixels (minimum 0, maximum 10000000).
    */
    public final Integer screenWidth;

    /**
    * Overriding screen height value in pixels (minimum 0, maximum 10000000).
    */
    public final Integer screenHeight;

    /**
    * Overriding view X position on screen in pixels (minimum 0, maximum 10000000).
    */
    public final Integer positionX;

    /**
    * Overriding view Y position on screen in pixels (minimum 0, maximum 10000000).
    */
    public final Integer positionY;

    /**
    * Do not set visible view size, rely upon explicit setVisibleSize call.
    */
    public final Boolean dontSetVisibleSize;

    /**
    * Screen orientation override.
    */
    public final jpuppeteer.cdp.client.entity.emulation.ScreenOrientation screenOrientation;

    /**
    * If set, the visible area of the page will be overridden to this viewport. This viewport change is not observed by the page, e.g. viewport-relative elements do not change positions.
    */
    public final jpuppeteer.cdp.client.entity.page.Viewport viewport;

    /**
    * If set, the display feature of a multi-segment screen. If not set, multi-segment support is turned-off.
    */
    public final jpuppeteer.cdp.client.entity.emulation.DisplayFeature displayFeature;

    public SetDeviceMetricsOverrideRequest(Integer width, Integer height, java.math.BigDecimal deviceScaleFactor, Boolean mobile, java.math.BigDecimal scale, Integer screenWidth, Integer screenHeight, Integer positionX, Integer positionY, Boolean dontSetVisibleSize, jpuppeteer.cdp.client.entity.emulation.ScreenOrientation screenOrientation, jpuppeteer.cdp.client.entity.page.Viewport viewport, jpuppeteer.cdp.client.entity.emulation.DisplayFeature displayFeature) {
        this.width = width;
        this.height = height;
        this.deviceScaleFactor = deviceScaleFactor;
        this.mobile = mobile;
        this.scale = scale;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.positionX = positionX;
        this.positionY = positionY;
        this.dontSetVisibleSize = dontSetVisibleSize;
        this.screenOrientation = screenOrientation;
        this.viewport = viewport;
        this.displayFeature = displayFeature;
    }

    public SetDeviceMetricsOverrideRequest(Integer width, Integer height, java.math.BigDecimal deviceScaleFactor, Boolean mobile) {
        this.width = width;
        this.height = height;
        this.deviceScaleFactor = deviceScaleFactor;
        this.mobile = mobile;
        this.scale = null;
        this.screenWidth = null;
        this.screenHeight = null;
        this.positionX = null;
        this.positionY = null;
        this.dontSetVisibleSize = null;
        this.screenOrientation = null;
        this.viewport = null;
        this.displayFeature = null;
    }

}