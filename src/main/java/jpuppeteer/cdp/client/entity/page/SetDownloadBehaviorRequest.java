package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetDownloadBehaviorRequest {

    /**
    * Whether to allow all or deny all download requests, or use default Chrome behavior if available (otherwise deny).
    */
    private jpuppeteer.cdp.client.constant.page.SetDownloadBehaviorRequestBehavior behavior;

    /**
    * The default path to save downloaded files to. This is required if behavior is set to 'allow'
    */
    private String downloadPath;

    public void setBehavior (jpuppeteer.cdp.client.constant.page.SetDownloadBehaviorRequestBehavior behavior) {
        this.behavior = behavior;
    }

    public jpuppeteer.cdp.client.constant.page.SetDownloadBehaviorRequestBehavior getBehavior() {
        return this.behavior;
    }

    public void setDownloadPath (String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String getDownloadPath() {
        return this.downloadPath;
    }

    public SetDownloadBehaviorRequest(jpuppeteer.cdp.client.constant.page.SetDownloadBehaviorRequestBehavior behavior, String downloadPath) {
        this.behavior = behavior;
        this.downloadPath = downloadPath;
    }

    public SetDownloadBehaviorRequest(jpuppeteer.cdp.client.constant.page.SetDownloadBehaviorRequestBehavior behavior) {
        this.behavior = behavior;
        this.downloadPath = null;
    }

    public SetDownloadBehaviorRequest() {
    }

}