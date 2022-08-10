package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class SetDeviceMetricsOverrideRequest {

    /**
    * Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override.
    */
    private Integer width;

    /**
    * Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override.
    */
    private Integer height;

    /**
    * Overriding device scale factor value. 0 disables the override.
    */
    private java.math.BigDecimal deviceScaleFactor;

    /**
    * Whether to emulate mobile device. This includes viewport meta tag, overlay scrollbars, text autosizing and more.
    */
    private Boolean mobile;

    /**
    * Scale to apply to resulting view image.
    */
    private java.math.BigDecimal scale;

    /**
    * Overriding screen width value in pixels (minimum 0, maximum 10000000).
    */
    private Integer screenWidth;

    /**
    * Overriding screen height value in pixels (minimum 0, maximum 10000000).
    */
    private Integer screenHeight;

    /**
    * Overriding view X position on screen in pixels (minimum 0, maximum 10000000).
    */
    private Integer positionX;

    /**
    * Overriding view Y position on screen in pixels (minimum 0, maximum 10000000).
    */
    private Integer positionY;

    /**
    * Do not set visible view size, rely upon explicit setVisibleSize call.
    */
    private Boolean dontSetVisibleSize;

    /**
    * Screen orientation override.
    */
    private jpuppeteer.cdp.client.entity.emulation.ScreenOrientation screenOrientation;

    /**
    * If set, the visible area of the page will be overridden to this viewport. This viewport change is not observed by the page, e.g. viewport-relative elements do not change positions.
    */
    private jpuppeteer.cdp.client.entity.page.Viewport viewport;

    /**
    * If set, the display feature of a multi-segment screen. If not set, multi-segment support is turned-off.
    */
    private jpuppeteer.cdp.client.entity.emulation.DisplayFeature displayFeature;

    public void setWidth (Integer width) {
        this.width = width;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setHeight (Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setDeviceScaleFactor (java.math.BigDecimal deviceScaleFactor) {
        this.deviceScaleFactor = deviceScaleFactor;
    }

    public java.math.BigDecimal getDeviceScaleFactor() {
        return this.deviceScaleFactor;
    }

    public void setMobile (Boolean mobile) {
        this.mobile = mobile;
    }

    public Boolean getMobile() {
        return this.mobile;
    }

    public void setScale (java.math.BigDecimal scale) {
        this.scale = scale;
    }

    public java.math.BigDecimal getScale() {
        return this.scale;
    }

    public void setScreenWidth (Integer screenWidth) {
        this.screenWidth = screenWidth;
    }

    public Integer getScreenWidth() {
        return this.screenWidth;
    }

    public void setScreenHeight (Integer screenHeight) {
        this.screenHeight = screenHeight;
    }

    public Integer getScreenHeight() {
        return this.screenHeight;
    }

    public void setPositionX (Integer positionX) {
        this.positionX = positionX;
    }

    public Integer getPositionX() {
        return this.positionX;
    }

    public void setPositionY (Integer positionY) {
        this.positionY = positionY;
    }

    public Integer getPositionY() {
        return this.positionY;
    }

    public void setDontSetVisibleSize (Boolean dontSetVisibleSize) {
        this.dontSetVisibleSize = dontSetVisibleSize;
    }

    public Boolean getDontSetVisibleSize() {
        return this.dontSetVisibleSize;
    }

    public void setScreenOrientation (jpuppeteer.cdp.client.entity.emulation.ScreenOrientation screenOrientation) {
        this.screenOrientation = screenOrientation;
    }

    public jpuppeteer.cdp.client.entity.emulation.ScreenOrientation getScreenOrientation() {
        return this.screenOrientation;
    }

    public void setViewport (jpuppeteer.cdp.client.entity.page.Viewport viewport) {
        this.viewport = viewport;
    }

    public jpuppeteer.cdp.client.entity.page.Viewport getViewport() {
        return this.viewport;
    }

    public void setDisplayFeature (jpuppeteer.cdp.client.entity.emulation.DisplayFeature displayFeature) {
        this.displayFeature = displayFeature;
    }

    public jpuppeteer.cdp.client.entity.emulation.DisplayFeature getDisplayFeature() {
        return this.displayFeature;
    }

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

    public SetDeviceMetricsOverrideRequest() {
    }

}