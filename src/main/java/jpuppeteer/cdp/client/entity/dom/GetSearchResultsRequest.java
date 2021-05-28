package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetSearchResultsRequest {

    /**
    * Unique search session identifier.
    */
    public final String searchId;

    /**
    * Start index of the search result to be returned.
    */
    public final Integer fromIndex;

    /**
    * End index of the search result to be returned.
    */
    public final Integer toIndex;

    public GetSearchResultsRequest(String searchId, Integer fromIndex, Integer toIndex) {
        this.searchId = searchId;
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }

}