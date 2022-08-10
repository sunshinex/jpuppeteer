package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PerformSearchRequest {

    /**
    * Plain text or query selector or XPath search query.
    */
    private String query;

    /**
    * True to search in user agent shadow DOM.
    */
    private Boolean includeUserAgentShadowDOM;

    public void setQuery (String query) {
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }

    public void setIncludeUserAgentShadowDOM (Boolean includeUserAgentShadowDOM) {
        this.includeUserAgentShadowDOM = includeUserAgentShadowDOM;
    }

    public Boolean getIncludeUserAgentShadowDOM() {
        return this.includeUserAgentShadowDOM;
    }

    public PerformSearchRequest(String query, Boolean includeUserAgentShadowDOM) {
        this.query = query;
        this.includeUserAgentShadowDOM = includeUserAgentShadowDOM;
    }

    public PerformSearchRequest(String query) {
        this.query = query;
        this.includeUserAgentShadowDOM = null;
    }

    public PerformSearchRequest() {
    }

}