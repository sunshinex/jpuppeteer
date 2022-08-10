package jpuppeteer.cdp.client.entity.headlessexperimental;

/**
* experimental
*/
public class BeginFrameRequest {

    /**
    * Timestamp of this BeginFrame in Renderer TimeTicks (milliseconds of uptime). If not set, the current time will be used.
    */
    private java.math.BigDecimal frameTimeTicks;

    /**
    * The interval between BeginFrames that is reported to the compositor, in milliseconds. Defaults to a 60 frames/second interval, i.e. about 16.666 milliseconds.
    */
    private java.math.BigDecimal interval;

    /**
    * Whether updates should not be committed and drawn onto the display. False by default. If true, only side effects of the BeginFrame will be run, such as layout and animations, but any visual updates may not be visible on the display or in screenshots.
    */
    private Boolean noDisplayUpdates;

    /**
    * If set, a screenshot of the frame will be captured and returned in the response. Otherwise, no screenshot will be captured. Note that capturing a screenshot can fail, for example, during renderer initialization. In such a case, no screenshot data will be returned.
    */
    private jpuppeteer.cdp.client.entity.headlessexperimental.ScreenshotParams screenshot;

    public void setFrameTimeTicks (java.math.BigDecimal frameTimeTicks) {
        this.frameTimeTicks = frameTimeTicks;
    }

    public java.math.BigDecimal getFrameTimeTicks() {
        return this.frameTimeTicks;
    }

    public void setInterval (java.math.BigDecimal interval) {
        this.interval = interval;
    }

    public java.math.BigDecimal getInterval() {
        return this.interval;
    }

    public void setNoDisplayUpdates (Boolean noDisplayUpdates) {
        this.noDisplayUpdates = noDisplayUpdates;
    }

    public Boolean getNoDisplayUpdates() {
        return this.noDisplayUpdates;
    }

    public void setScreenshot (jpuppeteer.cdp.client.entity.headlessexperimental.ScreenshotParams screenshot) {
        this.screenshot = screenshot;
    }

    public jpuppeteer.cdp.client.entity.headlessexperimental.ScreenshotParams getScreenshot() {
        return this.screenshot;
    }

    public BeginFrameRequest(java.math.BigDecimal frameTimeTicks, java.math.BigDecimal interval, Boolean noDisplayUpdates, jpuppeteer.cdp.client.entity.headlessexperimental.ScreenshotParams screenshot) {
        this.frameTimeTicks = frameTimeTicks;
        this.interval = interval;
        this.noDisplayUpdates = noDisplayUpdates;
        this.screenshot = screenshot;
    }

    public BeginFrameRequest() {
        this.frameTimeTicks = null;
        this.interval = null;
        this.noDisplayUpdates = null;
        this.screenshot = null;
    }

}