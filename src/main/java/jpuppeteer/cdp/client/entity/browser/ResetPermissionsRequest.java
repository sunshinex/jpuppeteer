package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class ResetPermissionsRequest {

    /**
    * BrowserContext to reset permissions. When omitted, default browser context is used.
    */
    public final String browserContextId;

    public ResetPermissionsRequest(String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public ResetPermissionsRequest() {
        this.browserContextId = null;
    }

}