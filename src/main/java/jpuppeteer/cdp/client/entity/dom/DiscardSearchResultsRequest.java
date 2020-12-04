package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class DiscardSearchResultsRequest {

    /**
    * Unique search session identifier.
    */
    public final String searchId;

    public DiscardSearchResultsRequest(String searchId) {
        this.searchId = searchId;
    }

}