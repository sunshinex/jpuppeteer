package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class CancelDownloadRequest {

    /**
    * Global unique identifier of the download.
    */
    private String guid;

    /**
    * BrowserContext to perform the action in. When omitted, default browser context is used.
    */
    private String browserContextId;

    public void setGuid (String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return this.guid;
    }

    public void setBrowserContextId (String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public String getBrowserContextId() {
        return this.browserContextId;
    }

    public CancelDownloadRequest(String guid, String browserContextId) {
        this.guid = guid;
        this.browserContextId = browserContextId;
    }

    public CancelDownloadRequest(String guid) {
        this.guid = guid;
        this.browserContextId = null;
    }

    public CancelDownloadRequest() {
    }

}