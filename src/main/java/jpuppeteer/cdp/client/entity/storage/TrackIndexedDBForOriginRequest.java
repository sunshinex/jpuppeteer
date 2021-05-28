package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class TrackIndexedDBForOriginRequest {

    /**
    * Security origin.
    */
    public final String origin;

    public TrackIndexedDBForOriginRequest(String origin) {
        this.origin = origin;
    }

}