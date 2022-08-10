package jpuppeteer.cdp.client.entity.page;

/**
* Fired when a renderer-initiated navigation is requested. Navigation may still be cancelled after the event is issued.
*/
public class FrameRequestedNavigationEvent {

    /**
    * Id of the frame that is being navigated.
    */
    private String frameId;

    /**
    * The reason for the navigation.
    */
    private jpuppeteer.cdp.client.constant.page.ClientNavigationReason reason;

    /**
    * The destination URL for the requested navigation.
    */
    private String url;

    /**
    * The disposition for the navigation.
    */
    private jpuppeteer.cdp.client.constant.page.ClientNavigationDisposition disposition;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
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

    public void setDisposition (jpuppeteer.cdp.client.constant.page.ClientNavigationDisposition disposition) {
        this.disposition = disposition;
    }

    public jpuppeteer.cdp.client.constant.page.ClientNavigationDisposition getDisposition() {
        return this.disposition;
    }

    public FrameRequestedNavigationEvent(String frameId, jpuppeteer.cdp.client.constant.page.ClientNavigationReason reason, String url, jpuppeteer.cdp.client.constant.page.ClientNavigationDisposition disposition) {
        this.frameId = frameId;
        this.reason = reason;
        this.url = url;
        this.disposition = disposition;
    }

    public FrameRequestedNavigationEvent() {
    }

}