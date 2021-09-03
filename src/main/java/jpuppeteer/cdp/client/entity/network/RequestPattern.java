package jpuppeteer.cdp.client.entity.network;

/**
* Request pattern for interception.
*/
public class RequestPattern {

    /**
    * Wildcards (`'*'` -> zero or more, `'?'` -> exactly one) are allowed. Escape character is backslash. Omitting is equivalent to `"*"`.
    */
    public final String urlPattern;

    /**
    * If set, only requests for matching resource types will be intercepted.
    */
    public final jpuppeteer.cdp.client.constant.network.ResourceType resourceType;

    /**
    * Stage at which to begin intercepting requests. Default is Request.
    */
    public final jpuppeteer.cdp.client.constant.network.InterceptionStage interceptionStage;

    public RequestPattern(String urlPattern, jpuppeteer.cdp.client.constant.network.ResourceType resourceType, jpuppeteer.cdp.client.constant.network.InterceptionStage interceptionStage) {
        this.urlPattern = urlPattern;
        this.resourceType = resourceType;
        this.interceptionStage = interceptionStage;
    }

    public RequestPattern() {
        this.urlPattern = null;
        this.resourceType = null;
        this.interceptionStage = null;
    }

}