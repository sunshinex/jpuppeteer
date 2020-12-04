package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CaptureSnapshotRequest {

    /**
    * Format (defaults to mhtml).
    */
    public final String format;

    public CaptureSnapshotRequest(String format) {
        this.format = format;
    }

    public CaptureSnapshotRequest() {
        this.format = null;
    }

}