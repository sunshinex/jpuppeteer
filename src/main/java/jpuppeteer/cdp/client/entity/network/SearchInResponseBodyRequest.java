package jpuppeteer.cdp.client.entity.network;

/**
*/
public class SearchInResponseBodyRequest {

    /**
    * Identifier of the network response to search.
    */
    public final String requestId;

    /**
    * String to search for.
    */
    public final String query;

    /**
    * If true, search is case sensitive.
    */
    public final Boolean caseSensitive;

    /**
    * If true, treats string parameter as regex.
    */
    public final Boolean isRegex;

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

}