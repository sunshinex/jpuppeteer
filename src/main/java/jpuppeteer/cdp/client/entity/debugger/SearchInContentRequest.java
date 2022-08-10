package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class SearchInContentRequest {

    /**
    * Id of the script to search in.
    */
    private String scriptId;

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

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
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

    public SearchInContentRequest() {
    }

}