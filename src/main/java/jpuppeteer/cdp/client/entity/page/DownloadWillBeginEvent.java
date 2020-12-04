package jpuppeteer.cdp.client.entity.page;

/**
* Fired when page is about to start a download.
*/
public class DownloadWillBeginEvent {

    /**
    * Id of the frame that caused download to begin.
    */
    public final String frameId;

    /**
    * URL of the resource being downloaded.
    */
    public final String url;

    public DownloadWillBeginEvent(String frameId, String url) {
        this.frameId = frameId;
        this.url = url;
    }

}