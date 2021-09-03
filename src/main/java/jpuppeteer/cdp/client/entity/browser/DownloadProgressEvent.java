package jpuppeteer.cdp.client.entity.browser;

/**
* Fired when download makes progress. Last call has |done| == true.
*/
public class DownloadProgressEvent {

    /**
    * Global unique identifier of the download.
    */
    public final String guid;

    /**
    * Total expected bytes to download.
    */
    public final java.math.BigDecimal totalBytes;

    /**
    * Total bytes received.
    */
    public final java.math.BigDecimal receivedBytes;

    /**
    * Download status.
    */
    public final jpuppeteer.cdp.client.constant.browser.DownloadProgressEventState state;

    public DownloadProgressEvent(String guid, java.math.BigDecimal totalBytes, java.math.BigDecimal receivedBytes, jpuppeteer.cdp.client.constant.browser.DownloadProgressEventState state) {
        this.guid = guid;
        this.totalBytes = totalBytes;
        this.receivedBytes = receivedBytes;
        this.state = state;
    }

}