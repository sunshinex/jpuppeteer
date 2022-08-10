package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame schedules a potential navigation.
*/
public class FrameScheduledNavigationEvent {

    /**
    * Id of the frame that has scheduled a navigation.
    */
    private String frameId;

    /**
    * Delay (in seconds) until the navigation is scheduled to begin. The navigation is not guaranteed to start.
    */
    private java.math.BigDecimal delay;

    /**
    * The reason for the navigation.
    */
    private jpuppeteer.cdp.client.constant.page.ClientNavigationReason reason;

    /**
    * The destination URL for the scheduled navigation.
    */
    private String url;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setDelay (java.math.BigDecimal delay) {
        this.delay = delay;
    }

    public java.math.BigDecimal getDelay() {
        return this.delay;
    }

    public void setReason (jpuppeteer.cdp.client.constant.page.ClientNavigationReason reason) {
        this.reason = reason;
    }

    public jpuppeteer.cdp.client.constant.page.ClientNavigationReason getReason() {
        return this.reason;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public FrameScheduledNavigationEvent(String frameId, java.math.BigDecimal delay, jpuppeteer.cdp.client.constant.page.ClientNavigationReason reason, String url) {
        this.frameId = frameId;
        this.delay = delay;
        this.reason = reason;
        this.url = url;
    }

    public FrameScheduledNavigationEvent() {
    }

}