package jpuppeteer.cdp.client.entity.page;

/**
*/
public class CaptureSnapshotRequest {

    /**
    * Format (defaults to mhtml).
    */
    private jpuppeteer.cdp.client.constant.page.CaptureSnapshotRequestFormat format;

    public void setFormat (jpuppeteer.cdp.client.constant.page.CaptureSnapshotRequestFormat format) {
        this.format = format;
    }

    public jpuppeteer.cdp.client.constant.page.CaptureSnapshotRequestFormat getFormat() {
        return this.format;
    }

    public CaptureSnapshotRequest(jpuppeteer.cdp.client.constant.page.CaptureSnapshotRequestFormat format) {
        this.format = format;
    }

    public CaptureSnapshotRequest() {
        this.format = null;
    }

}