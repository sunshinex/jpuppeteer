package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetHistogramRequest {

    /**
    * Requested histogram name.
    */
    public final String name;

    /**
    * If true, retrieve delta since last call.
    */
    public final Boolean delta;

    public GetHistogramRequest(String name, Boolean delta) {
        this.name = name;
        this.delta = delta;
    }

    public GetHistogramRequest(String name) {
        this.name = name;
        this.delta = null;
    }

}