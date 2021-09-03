package jpuppeteer.cdp.client.entity.browser;

/**
* Fired when page is about to start a download.
*/
public class DownloadWillBeginEvent {

    /**
    * Id of the frame that caused the download to begin.
    */
    public final String frameId;

    /**
    * Global unique identifier of the download.
    */
    public final String guid;

    /**
    * URL of the resource being downloaded.
    */
    public final String url;

    /**
    * Suggested file name of the resource (the actual name of the file saved on disk may differ).
    */
    public final String suggestedFilename;

    public DownloadWillBeginEvent(String frameId, String guid, String url, String suggestedFilename) {
        this.frameId = frameId;
        this.guid = guid;
        this.url = url;
        this.suggestedFilename = suggestedFilename;
    }

}