package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetHistogramsRequest {

    /**
    * Requested substring in name. Only histograms which have query as a substring in their name are extracted. An empty or absent query returns all histograms.
    */
    private String query;

    /**
    * If true, retrieve delta since last call.
    */
    private Boolean delta;

    public void setQuery (String query) {
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }

    public void setDelta (Boolean delta) {
        this.delta = delta;
    }

    public Boolean getDelta() {
        return this.delta;
    }

    public GetHistogramsRequest(String query, Boolean delta) {
        this.query = query;
        this.delta = delta;
    }

    public GetHistogramsRequest() {
        this.query = null;
        this.delta = null;
    }

}