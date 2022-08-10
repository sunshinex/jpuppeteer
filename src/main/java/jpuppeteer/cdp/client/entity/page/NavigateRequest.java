package jpuppeteer.cdp.client.entity.page;

/**
*/
public class NavigateRequest {

    /**
    * URL to navigate the page to.
    */
    private String url;

    /**
    * Referrer URL.
    */
    private String referrer;

    /**
    * Intended transition type.
    */
    private jpuppeteer.cdp.client.constant.page.TransitionType transitionType;

    /**
    * Frame id to navigate, if not specified navigates the top frame.
    */
    private String frameId;

    /**
    * Referrer-policy used for the navigation.
    */
    private jpuppeteer.cdp.client.constant.page.ReferrerPolicy referrerPolicy;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setReferrer (String referrer) {
        this.referrer = referrer;
    }

    public String getReferrer() {
        return this.referrer;
    }

    public void setTransitionType (jpuppeteer.cdp.client.constant.page.TransitionType transitionType) {
        this.transitionType = transitionType;
    }

    public jpuppeteer.cdp.client.constant.page.TransitionType getTransitionType() {
        return this.transitionType;
    }

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setReferrerPolicy (jpuppeteer.cdp.client.constant.page.ReferrerPolicy referrerPolicy) {
        this.referrerPolicy = referrerPolicy;
    }

    public jpuppeteer.cdp.client.constant.page.ReferrerPolicy getReferrerPolicy() {
        return this.referrerPolicy;
    }

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

    public NavigateRequest() {
    }

}