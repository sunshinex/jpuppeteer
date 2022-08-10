package jpuppeteer.cdp.client.entity.fetch;

/**
*/
public class RequestPattern {

    /**
    * Wildcards (`'*'` -> zero or more, `'?'` -> exactly one) are allowed. Escape character is backslash. Omitting is equivalent to `"*"`.
    */
    private String urlPattern;

    /**
    * If set, only requests for matching resource types will be intercepted.
    */
    private jpuppeteer.cdp.client.constant.network.ResourceType resourceType;

    /**
    * Stage at which to begin intercepting requests. Default is Request.
    */
    private jpuppeteer.cdp.client.constant.fetch.RequestStage requestStage;

    public void setUrlPattern (String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public String getUrlPattern() {
        return this.urlPattern;
    }

    public void setResourceType (jpuppeteer.cdp.client.constant.network.ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public jpuppeteer.cdp.client.constant.network.ResourceType getResourceType() {
        return this.resourceType;
    }

    public void setRequestStage (jpuppeteer.cdp.client.constant.fetch.RequestStage requestStage) {
        this.requestStage = requestStage;
    }

    public jpuppeteer.cdp.client.constant.fetch.RequestStage getRequestStage() {
        return this.requestStage;
    }

    public RequestPattern(String urlPattern, jpuppeteer.cdp.client.constant.network.ResourceType resourceType, jpuppeteer.cdp.client.constant.fetch.RequestStage requestStage) {
        this.urlPattern = urlPattern;
        this.resourceType = resourceType;
        this.requestStage = requestStage;
    }

    public RequestPattern() {
        this.urlPattern = null;
        this.resourceType = null;
        this.requestStage = null;
    }

}