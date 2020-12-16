package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CaptureSnapshotRequest {

    /**
    * Format (defaults to mhtml).
    */
    public final jpuppeteer.cdp.client.constant.page.CaptureSnapshotRequestFormat format;

    public CaptureSnapshotRequest(jpuppeteer.cdp.client.constant.page.CaptureSnapshotRequestFormat format) {
        this.format = format;
    }

    public CaptureSnapshotRequest() {
        this.format = null;
    }

}