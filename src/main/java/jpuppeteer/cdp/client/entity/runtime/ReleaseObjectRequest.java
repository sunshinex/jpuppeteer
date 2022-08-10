package jpuppeteer.cdp.client.entity.runtime;

/**
*/
public class ReleaseObjectRequest {

    /**
    * Identifier of the object to release.
    */
    private String objectId;

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public ReleaseObjectRequest(String objectId) {
        this.objectId = objectId;
    }

    public ReleaseObjectRequest() {
    }

}