package jpuppeteer.cdp.client.entity.applicationcache;

/**
* experimental
*/
public class ApplicationCacheStatusUpdatedEvent {

    /**
    * Identifier of the frame containing document whose application cache updated status.
    */
    public final String frameId;

    /**
    * Manifest URL.
    */
    public final String manifestURL;

    /**
    * Updated application cache status.
    */
    public final Integer status;

    public ApplicationCacheStatusUpdatedEvent(String frameId, String manifestURL, Integer status) {
        this.frameId = frameId;
        this.manifestURL = manifestURL;
        this.status = status;
    }

}