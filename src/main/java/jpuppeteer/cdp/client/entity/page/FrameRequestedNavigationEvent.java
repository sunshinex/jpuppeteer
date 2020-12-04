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
    public final String reason;

    /**
    * The destination URL for the requested navigation.
    */
    public final String url;

    public FrameRequestedNavigationEvent(String frameId, String reason, String url) {
        this.frameId = frameId;
        this.reason = reason;
        this.url = url;
    }

}