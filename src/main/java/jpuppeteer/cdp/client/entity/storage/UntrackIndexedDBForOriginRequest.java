package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class UntrackIndexedDBForOriginRequest {

    /**
    * Security origin.
    */
    private String origin;

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public UntrackIndexedDBForOriginRequest(String origin) {
        this.origin = origin;
    }

    public UntrackIndexedDBForOriginRequest() {
    }

}