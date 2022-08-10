package jpuppeteer.cdp.client.entity.page;

/**
* Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
*/
public class NavigatedWithinDocumentEvent {

    /**
    * Id of the frame.
    */
    private String frameId;

    /**
    * Frame's new url.
    */
    private String url;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public NavigatedWithinDocumentEvent(String frameId, String url) {
        this.frameId = frameId;
        this.url = url;
    }

    public NavigatedWithinDocumentEvent() {
    }

}