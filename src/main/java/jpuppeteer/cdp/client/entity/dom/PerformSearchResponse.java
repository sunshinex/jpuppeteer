package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class PerformSearchResponse {

    /**
    * Unique search session identifier.
    */
    private String searchId;

    /**
    * Number of search results.
    */
    private Integer resultCount;

    public void setSearchId (String searchId) {
        this.searchId = searchId;
    }

    public String getSearchId() {
        return this.searchId;
    }

    public void setResultCount (Integer resultCount) {
        this.resultCount = resultCount;
    }

    public Integer getResultCount() {
        return this.resultCount;
    }

    public PerformSearchResponse(String searchId, Integer resultCount) {
        this.searchId = searchId;
        this.resultCount = resultCount;
    }

    public PerformSearchResponse() {
    }

}