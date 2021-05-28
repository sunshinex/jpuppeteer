package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SearchInContentRequest {

    /**
    * Id of the script to search in.
    */
    public final String scriptId;

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

    public SearchInContentRequest(String scriptId, String query, Boolean caseSensitive, Boolean isRegex) {
        this.scriptId = scriptId;
        this.query = query;
        this.caseSensitive = caseSensitive;
        this.isRegex = isRegex;
    }

    public SearchInContentRequest(String scriptId, String query) {
        this.scriptId = scriptId;
        this.query = query;
        this.caseSensitive = null;
        this.isRegex = null;
    }

}