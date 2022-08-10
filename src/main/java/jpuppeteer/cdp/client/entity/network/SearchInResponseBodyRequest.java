package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SearchInResponseBodyRequest {

    /**
    * Identifier of the network response to search.
    */
    private String requestId;

    /**
    * String to search for.
    */
    private String query;

    /**
    * If true, search is case sensitive.
    */
    private Boolean caseSensitive;

    /**
    * If true, treats string parameter as regex.
    */
    private Boolean isRegex;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setQuery (String query) {
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }

    public void setCaseSensitive (Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public Boolean getCaseSensitive() {
        return this.caseSensitive;
    }

    public void setIsRegex (Boolean isRegex) {
        this.isRegex = isRegex;
    }

    public Boolean getIsRegex() {
        return this.isRegex;
    }

    public SearchInResponseBodyRequest(String requestId, String query, Boolean caseSensitive, Boolean isRegex) {
        this.requestId = requestId;
        this.query = query;
        this.caseSensitive = caseSensitive;
        this.isRegex = isRegex;
    }

    public SearchInResponseBodyRequest(String requestId, String query) {
        this.requestId = requestId;
        this.query = query;
        this.caseSensitive = null;
        this.isRegex = null;
    }

    public SearchInResponseBodyRequest() {
    }

}