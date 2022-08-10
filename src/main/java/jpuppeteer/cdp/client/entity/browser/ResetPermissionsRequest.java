package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class ResetPermissionsRequest {

    /**
    * BrowserContext to reset permissions. When omitted, default browser context is used.
    */
    private String browserContextId;

    public void setBrowserContextId (String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public String getBrowserContextId() {
        return this.browserContextId;
    }

    public ResetPermissionsRequest(String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public ResetPermissionsRequest() {
        this.browserContextId = null;
    }

}