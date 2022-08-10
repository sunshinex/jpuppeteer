package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class SetDownloadBehaviorRequest {

    /**
    * Whether to allow all or deny all download requests, or use default Chrome behavior if available (otherwise deny). |allowAndName| allows download and names files according to their dowmload guids.
    */
    private jpuppeteer.cdp.client.constant.browser.SetDownloadBehaviorRequestBehavior behavior;

    /**
    * BrowserContext to set download behavior. When omitted, default browser context is used.
    */
    private String browserContextId;

    /**
    * The default path to save downloaded files to. This is required if behavior is set to 'allow' or 'allowAndName'.
    */
    private String downloadPath;

    /**
    * Whether to emit download events (defaults to false).
    */
    private Boolean eventsEnabled;

    public void setBehavior (jpuppeteer.cdp.client.constant.browser.SetDownloadBehaviorRequestBehavior behavior) {
        this.behavior = behavior;
    }

    public jpuppeteer.cdp.client.constant.browser.SetDownloadBehaviorRequestBehavior getBehavior() {
        return this.behavior;
    }

    public void setBrowserContextId (String browserContextId) {
        this.browserContextId = browserContextId;
    }

    public String getBrowserContextId() {
        return this.browserContextId;
    }

    public void setDownloadPath (String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String getDownloadPath() {
        return this.downloadPath;
    }

    public void setEventsEnabled (Boolean eventsEnabled) {
        this.eventsEnabled = eventsEnabled;
    }

    public Boolean getEventsEnabled() {
        return this.eventsEnabled;
    }

    public SetDownloadBehaviorRequest(jpuppeteer.cdp.client.constant.browser.SetDownloadBehaviorRequestBehavior behavior, String browserContextId, String downloadPath, Boolean eventsEnabled) {
        this.behavior = behavior;
        this.browserContextId = browserContextId;
        this.downloadPath = downloadPath;
        this.eventsEnabled = eventsEnabled;
    }

    public SetDownloadBehaviorRequest(jpuppeteer.cdp.client.constant.browser.SetDownloadBehaviorRequestBehavior behavior) {
        this.behavior = behavior;
        this.browserContextId = null;
        this.downloadPath = null;
        this.eventsEnabled = null;
    }

    public SetDownloadBehaviorRequest() {
    }

}