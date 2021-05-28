package jpuppeteer.cdp.client.entity.page;

/**
* Fired when download makes progress. Last call has |done| == true. Deprecated. Use Browser.downloadProgress instead.
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
    public final jpuppeteer.cdp.client.constant.page.DownloadProgressEventState state;

    public DownloadProgressEvent(String guid, java.math.BigDecimal totalBytes, java.math.BigDecimal receivedBytes, jpuppeteer.cdp.client.constant.page.DownloadProgressEventState state) {
        this.guid = guid;
        this.totalBytes = totalBytes;
        this.receivedBytes = receivedBytes;
        this.state = state;
    }

}