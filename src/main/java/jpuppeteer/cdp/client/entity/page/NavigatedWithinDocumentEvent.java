package jpuppeteer.cdp.client.entity.page;

/**
* Fired when same-document navigation happens, e.g. due to history API usage or anchor navigation.
*/
public class NavigatedWithinDocumentEvent {

    /**
    * Id of the frame.
    */
    public final String frameId;

    /**
    * Frame's new url.
    */
    public final String url;

    public NavigatedWithinDocumentEvent(String frameId, String url) {
        this.frameId = frameId;
        this.url = url;
    }

}