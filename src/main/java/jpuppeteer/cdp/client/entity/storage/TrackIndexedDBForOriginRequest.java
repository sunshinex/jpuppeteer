package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class TrackIndexedDBForOriginRequest {

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

    public TrackIndexedDBForOriginRequest(String origin) {
        this.origin = origin;
    }

    public TrackIndexedDBForOriginRequest() {
    }

}