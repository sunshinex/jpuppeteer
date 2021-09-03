package jpuppeteer.cdp.client.entity.page;

/**
* Fired for failed bfcache history navigations if BackForwardCache feature is enabled. Do not assume any ordering with the Page.frameNavigated event. This event is fired only for main-frame history navigation where the document changes (non-same-document navigations), when bfcache navigation fails.
*/
public class BackForwardCacheNotUsedEvent {

    /**
    * The loader id for the associated navgation.
    */
    public final String loaderId;

    /**
    * The frame id of the associated frame.
    */
    public final String frameId;

    public BackForwardCacheNotUsedEvent(String loaderId, String frameId) {
        this.loaderId = loaderId;
        this.frameId = frameId;
    }

}