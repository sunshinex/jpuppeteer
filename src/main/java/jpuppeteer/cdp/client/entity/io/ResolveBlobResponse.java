package jpuppeteer.cdp.client.entity.io;

/**
*/
public class ResolveBlobResponse {

    /**
    * UUID of the specified Blob.
    */
    public final String uuid;

    public ResolveBlobResponse(String uuid) {
        this.uuid = uuid;
    }

}