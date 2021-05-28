package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class UntrackIndexedDBForOriginRequest {

    /**
    * Security origin.
    */
    public final String origin;

    public UntrackIndexedDBForOriginRequest(String origin) {
        this.origin = origin;
    }

}