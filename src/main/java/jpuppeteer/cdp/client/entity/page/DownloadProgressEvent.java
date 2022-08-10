package jpuppeteer.cdp.client.entity.page;

/**
* Fired when download makes progress. Last call has |done| == true. Deprecated. Use Browser.downloadProgress instead.
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
    private jpuppeteer.cdp.client.constant.page.DownloadProgressEventState state;

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

    public void setState (jpuppeteer.cdp.client.constant.page.DownloadProgressEventState state) {
        this.state = state;
    }

    public jpuppeteer.cdp.client.constant.page.DownloadProgressEventState getState() {
        return this.state;
    }

    public DownloadProgressEvent(String guid, java.math.BigDecimal totalBytes, java.math.BigDecimal receivedBytes, jpuppeteer.cdp.client.constant.page.DownloadProgressEventState state) {
        this.guid = guid;
        this.totalBytes = totalBytes;
        this.receivedBytes = receivedBytes;
        this.state = state;
    }

    public DownloadProgressEvent() {
    }

}