package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetHistogramsRequest {

    /**
    * Requested substring in name. Only histograms which have query as a substring in their name are extracted. An empty or absent query returns all histograms.
    */
    public final String query;

    /**
    * If true, retrieve delta since last call.
    */
    public final Boolean delta;

    public GetHistogramsRequest(String query, Boolean delta) {
        this.query = query;
        this.delta = delta;
    }

    public GetHistogramsRequest() {
        this.query = null;
        this.delta = null;
    }

}