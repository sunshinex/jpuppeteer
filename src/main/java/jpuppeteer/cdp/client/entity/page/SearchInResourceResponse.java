package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SearchInResourceResponse {

    /**
    * List of search matches.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.debugger.SearchMatch> result;

    public void setResult (java.util.List<jpuppeteer.cdp.client.entity.debugger.SearchMatch> result) {
        this.result = result;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.debugger.SearchMatch> getResult() {
        return this.result;
    }

    public SearchInResourceResponse(java.util.List<jpuppeteer.cdp.client.entity.debugger.SearchMatch> result) {
        this.result = result;
    }

    public SearchInResourceResponse() {
    }

}