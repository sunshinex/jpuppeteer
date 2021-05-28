package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class SetDownloadBehaviorRequest {

    /**
    * Whether to allow all or deny all download requests, or use default Chrome behavior if available (otherwise deny). |allowAndName| allows download and names files according to their dowmload guids.
    */
    public final jpuppeteer.cdp.client.constant.browser.SetDownloadBehaviorRequestBehavior behavior;

    /**
    * BrowserContext to set download behavior. When omitted, default browser context is used.
    */
    public final String browserContextId;

    /**
    * The default path to save downloaded files to. This is required if behavior is set to 'allow' or 'allowAndName'.
    */
    public final String downloadPath;

    /**
    * Whether to emit download events (defaults to false).
    */
    public final Boolean eventsEnabled;

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

}