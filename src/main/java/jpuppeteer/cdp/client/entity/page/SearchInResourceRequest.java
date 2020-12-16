package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SearchInResourceRequest {

    /**
    * Frame id for resource to search in.
    */
    public final String frameId;

    /**
    * URL of the resource to search in.
    */
    public final String url;

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

    public SearchInResourceRequest(String frameId, String url, String query, Boolean caseSensitive, Boolean isRegex) {
        this.frameId = frameId;
        this.url = url;
        this.query = query;
        this.caseSensitive = caseSensitive;
        this.isRegex = isRegex;
    }

    public SearchInResourceRequest(String frameId, String url, String query) {
        this.frameId = frameId;
        this.url = url;
        this.query = query;
        this.caseSensitive = null;
        this.isRegex = null;
    }

}