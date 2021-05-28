package jpuppeteer.cdp.client.entity.page;

/**
* Fired when a renderer-initiated navigation is requested. Navigation may still be cancelled after the event is issued.
*/
public class FrameRequestedNavigationEvent {

    /**
    * Id of the frame that is being navigated.
    */
    public final String frameId;

    /**
    * The reason for the navigation.
    */
    public final jpuppeteer.cdp.client.constant.page.ClientNavigationReason reason;

    /**
    * The destination URL for the requested navigation.
    */
    public final String url;

    /**
    * The disposition for the navigation.
    */
    public final jpuppeteer.cdp.client.constant.page.ClientNavigationDisposition disposition;

    public FrameRequestedNavigationEvent(String frameId, jpuppeteer.cdp.client.constant.page.ClientNavigationReason reason, String url, jpuppeteer.cdp.client.constant.page.ClientNavigationDisposition disposition) {
        this.frameId = frameId;
        this.reason = reason;
        this.url = url;
        this.disposition = disposition;
    }

}