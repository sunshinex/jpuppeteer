package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class GetSearchResultsRequest {

    /**
    * Unique search session identifier.
    */
    private String searchId;

    /**
    * Start index of the search result to be returned.
    */
    private Integer fromIndex;

    /**
    * End index of the search result to be returned.
    */
    private Integer toIndex;

    public void setSearchId (String searchId) {
        this.searchId = searchId;
    }

    public String getSearchId() {
        return this.searchId;
    }

    public void setFromIndex (Integer fromIndex) {
        this.fromIndex = fromIndex;
    }

    public Integer getFromIndex() {
        return this.fromIndex;
    }

    public void setToIndex (Integer toIndex) {
        this.toIndex = toIndex;
    }

    public Integer getToIndex() {
        return this.toIndex;
    }

    public GetSearchResultsRequest(String searchId, Integer fromIndex, Integer toIndex) {
        this.searchId = searchId;
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }

    public GetSearchResultsRequest() {
    }

}