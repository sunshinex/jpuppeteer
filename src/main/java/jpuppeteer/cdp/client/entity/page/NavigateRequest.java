package jpuppeteer.cdp.client.entity.page;

/**
*/
public class NavigateRequest {

    /**
    * URL to navigate the page to.
    */
    public final String url;

    /**
    * Referrer URL.
    */
    public final String referrer;

    /**
    * Intended transition type.
    */
    public final String transitionType;

    /**
    * Frame id to navigate, if not specified navigates the top frame.
    */
    public final String frameId;

    public NavigateRequest(String url, String referrer, String transitionType, String frameId) {
        this.url = url;
        this.referrer = referrer;
        this.transitionType = transitionType;
        this.frameId = frameId;
    }

    public NavigateRequest(String url) {
        this.url = url;
        this.referrer = null;
        this.transitionType = null;
        this.frameId = null;
    }

}