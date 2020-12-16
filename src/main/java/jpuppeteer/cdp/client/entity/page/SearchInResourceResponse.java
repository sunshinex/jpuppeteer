package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SearchInResourceResponse {

    /**
    * List of search matches.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.debugger.SearchMatch> result;

    public SearchInResourceResponse(java.util.List<jpuppeteer.cdp.client.entity.debugger.SearchMatch> result) {
        this.result = result;
    }

}