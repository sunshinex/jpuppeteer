package jpuppeteer.cdp.client.entity.target;

/**
*/
public class GetBrowserContextsResponse {

    /**
    * An array of browser context ids.
    */
    private java.util.List<String> browserContextIds;

    public void setBrowserContextIds (java.util.List<String> browserContextIds) {
        this.browserContextIds = browserContextIds;
    }

    public java.util.List<String> getBrowserContextIds() {
        return this.browserContextIds;
    }

    public GetBrowserContextsResponse(java.util.List<String> browserContextIds) {
        this.browserContextIds = browserContextIds;
    }

    public GetBrowserContextsResponse() {
    }

}