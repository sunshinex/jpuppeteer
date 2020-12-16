package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PerformSearchResponse {

    /**
    * Unique search session identifier.
    */
    public final String searchId;

    /**
    * Number of search results.
    */
    public final Integer resultCount;

    public PerformSearchResponse(String searchId, Integer resultCount) {
        this.searchId = searchId;
        this.resultCount = resultCount;
    }

}