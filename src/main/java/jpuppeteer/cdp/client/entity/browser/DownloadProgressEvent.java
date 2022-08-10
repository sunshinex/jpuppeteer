package jpuppeteer.cdp.client.entity.browser;

/**
* Fired when download makes progress. Last call has |done| == true.
*/
public class DownloadProgressEvent {

    /**
    * Global unique identifier of the download.
    */
    private String guid;

    /**
    * Total expected bytes to download.
    */
    private java.math.BigDecimal totalBytes;

    /**
    * Total bytes received.
    */
    private java.math.BigDecimal receivedBytes;

    /**
    * Download status.
    */
    private jpuppeteer.cdp.client.constant.browser.DownloadProgressEventState state;

    public void setGuid (String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setTotalBytes (java.math.BigDecimal totalBytes) {
        this.totalBytes = totalBytes;
    }

    public java.math.BigDecimal getTotalBytes() {
        return this.totalBytes;
    }

    public void setReceivedBytes (java.math.BigDecimal receivedBytes) {
        this.receivedBytes = receivedBytes;
    }

    public java.math.BigDecimal getReceivedBytes() {
        return this.receivedBytes;
    }

    public void setState (jpuppeteer.cdp.client.constant.browser.DownloadProgressEventState state) {
        this.state = state;
    }

    public jpuppeteer.cdp.client.constant.browser.DownloadProgressEventState getState() {
        return this.state;
    }

    public DownloadProgressEvent(String guid, java.math.BigDecimal totalBytes, java.math.BigDecimal receivedBytes, jpuppeteer.cdp.client.constant.browser.DownloadProgressEventState state) {
        this.guid = guid;
        this.totalBytes = totalBytes;
        this.receivedBytes = receivedBytes;
        this.state = state;
    }

    public DownloadProgressEvent() {
    }

}