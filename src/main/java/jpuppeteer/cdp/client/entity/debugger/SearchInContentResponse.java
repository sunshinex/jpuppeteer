package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SearchInContentResponse {

    /**
    * List of search matches.
    */
    public final java.util.List<SearchMatch> result;

    public SearchInContentResponse(java.util.List<SearchMatch> result) {
        this.result = result;
    }

}