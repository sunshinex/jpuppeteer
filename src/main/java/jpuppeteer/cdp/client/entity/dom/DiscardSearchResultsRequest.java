package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class DiscardSearchResultsRequest {

    /**
    * Unique search session identifier.
    */
    private String searchId;

    public void setSearchId (String searchId) {
        this.searchId = searchId;
    }

    public String getSearchId() {
        return this.searchId;
    }

    public DiscardSearchResultsRequest(String searchId) {
        this.searchId = searchId;
    }

    public DiscardSearchResultsRequest() {
    }

}