package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class CancelDownloadRequest {

    /**
    * Global unique identifier of the download.
    */
    public final String guid;

    /**
    * BrowserContext to perform the action in. When omitted, default browser context is used.
    */
    public final String browserContextId;

    public CancelDownloadRequest(String guid, String browserContextId) {
        this.guid = guid;
        this.browserContextId = browserContextId;
    }

    public CancelDownloadRequest(String guid) {
        this.guid = guid;
        this.browserContextId = null;
    }

}