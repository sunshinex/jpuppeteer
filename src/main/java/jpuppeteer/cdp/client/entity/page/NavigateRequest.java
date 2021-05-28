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
    public final jpuppeteer.cdp.client.constant.page.TransitionType transitionType;

    /**
    * Frame id to navigate, if not specified navigates the top frame.
    */
    public final String frameId;

    /**
    * Referrer-policy used for the navigation.
    */
    public final jpuppeteer.cdp.client.constant.page.ReferrerPolicy referrerPolicy;

    public NavigateRequest(String url, String referrer, jpuppeteer.cdp.client.constant.page.TransitionType transitionType, String frameId, jpuppeteer.cdp.client.constant.page.ReferrerPolicy referrerPolicy) {
        this.url = url;
        this.referrer = referrer;
        this.transitionType = transitionType;
        this.frameId = frameId;
        this.referrerPolicy = referrerPolicy;
    }

    public NavigateRequest(String url) {
        this.url = url;
        this.referrer = null;
        this.transitionType = null;
        this.frameId = null;
        this.referrerPolicy = null;
    }

}