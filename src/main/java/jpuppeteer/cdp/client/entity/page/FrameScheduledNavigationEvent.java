package jpuppeteer.cdp.client.entity.page;

/**
* Fired when frame schedules a potential navigation.
*/
public class FrameScheduledNavigationEvent {

    /**
    * Id of the frame that has scheduled a navigation.
    */
    public final String frameId;

    /**
    * Delay (in seconds) until the navigation is scheduled to begin. The navigation is not guaranteed to start.
    */
    public final java.math.BigDecimal delay;

    /**
    * The reason for the navigation.
    */
    public final jpuppeteer.cdp.client.constant.page.FrameScheduledNavigationEventReason reason;

    /**
    * The destination URL for the scheduled navigation.
    */
    public final String url;

    public FrameScheduledNavigationEvent(String frameId, java.math.BigDecimal delay, jpuppeteer.cdp.client.constant.page.FrameScheduledNavigationEventReason reason, String url) {
        this.frameId = frameId;
        this.delay = delay;
        this.reason = reason;
        this.url = url;
    }

}