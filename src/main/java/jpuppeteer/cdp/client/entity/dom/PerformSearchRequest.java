package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PerformSearchRequest {

    /**
    * Plain text or query selector or XPath search query.
    */
    public final String query;

    /**
    * True to search in user agent shadow DOM.
    */
    public final Boolean includeUserAgentShadowDOM;

    public PerformSearchRequest(String query, Boolean includeUserAgentShadowDOM) {
        this.query = query;
        this.includeUserAgentShadowDOM = includeUserAgentShadowDOM;
    }

    public PerformSearchRequest(String query) {
        this.query = query;
        this.includeUserAgentShadowDOM = null;
    }

}