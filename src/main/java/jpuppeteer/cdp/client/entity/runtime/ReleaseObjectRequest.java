package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class ReleaseObjectRequest {

    /**
    * Identifier of the object to release.
    */
    public final String objectId;

    public ReleaseObjectRequest(String objectId) {
        this.objectId = objectId;
    }

}