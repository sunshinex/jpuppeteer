package jpuppeteer.cdp.client.entity.io;

/**
*/
public class ResolveBlobRequest {

    /**
    * Object id of a Blob object wrapper.
    */
    private String objectId;

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public ResolveBlobRequest(String objectId) {
        this.objectId = objectId;
    }

    public ResolveBlobRequest() {
    }

}