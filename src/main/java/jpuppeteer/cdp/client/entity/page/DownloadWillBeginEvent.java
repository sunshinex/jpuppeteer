package jpuppeteer.cdp.client.entity.page;

/**
* Fired when page is about to start a download. Deprecated. Use Browser.downloadWillBegin instead.
*/
public class DownloadWillBeginEvent {

    /**
    * Id of the frame that caused download to begin.
    */
    private String frameId;

    /**
    * Global unique identifier of the download.
    */
    private String guid;

    /**
    * URL of the resource being downloaded.
    */
    private String url;

    /**
    * Suggested file name of the resource (the actual name of the file saved on disk may differ).
    */
    private String suggestedFilename;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setGuid (String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setSuggestedFilename (String suggestedFilename) {
        this.suggestedFilename = suggestedFilename;
    }

    public String getSuggestedFilename() {
        return this.suggestedFilename;
    }

    public DownloadWillBeginEvent(String frameId, String guid, String url, String suggestedFilename) {
        this.frameId = frameId;
        this.guid = guid;
        this.url = url;
        this.suggestedFilename = suggestedFilename;
    }

    public DownloadWillBeginEvent() {
    }

}