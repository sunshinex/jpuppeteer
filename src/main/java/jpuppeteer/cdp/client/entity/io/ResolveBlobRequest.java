package jpuppeteer.cdp.client.entity.io;

/**
*/
public class ResolveBlobRequest {

    /**
    * Object id of a Blob object wrapper.
    */
    public final String objectId;

    public ResolveBlobRequest(String objectId) {
        this.objectId = objectId;
    }

}