package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CaptureSnapshotResponse {

    /**
    * Serialized page data.
    */
    private String data;

    public void setData (String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public CaptureSnapshotResponse(String data) {
        this.data = data;
    }

    public CaptureSnapshotResponse() {
    }

}