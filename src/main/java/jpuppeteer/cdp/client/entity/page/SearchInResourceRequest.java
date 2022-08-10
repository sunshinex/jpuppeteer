package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SearchInResourceRequest {

    /**
    * Frame id for resource to search in.
    */
    private String frameId;

    /**
    * URL of the resource to search in.
    */
    private String url;

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

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
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

    public SearchInResourceRequest() {
    }

}