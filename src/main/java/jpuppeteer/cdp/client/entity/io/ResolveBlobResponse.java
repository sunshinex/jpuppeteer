package jpuppeteer.cdp.client.entity.io;

/**
*/
public class ResolveBlobResponse {

    /**
    * UUID of the specified Blob.
    */
    private String uuid;

    public void setUuid (String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public ResolveBlobResponse(String uuid) {
        this.uuid = uuid;
    }

    public ResolveBlobResponse() {
    }

}