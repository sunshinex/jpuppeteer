package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetDownloadBehaviorRequest {

    /**
    * Whether to allow all or deny all download requests, or use default Chrome behavior if available (otherwise deny).
    */
    public final String behavior;

    /**
    * The default path to save downloaded files to. This is requred if behavior is set to 'allow'
    */
    public final String downloadPath;

    public SetDownloadBehaviorRequest(String behavior, String downloadPath) {
        this.behavior = behavior;
        this.downloadPath = downloadPath;
    }

    public SetDownloadBehaviorRequest(String behavior) {
        this.behavior = behavior;
        this.downloadPath = null;
    }

}