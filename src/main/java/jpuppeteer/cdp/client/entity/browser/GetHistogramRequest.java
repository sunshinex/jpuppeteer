package jpuppeteer.cdp.client.entity.browser;

/**
*/
public class GetHistogramRequest {

    /**
    * Requested histogram name.
    */
    private String name;

    /**
    * If true, retrieve delta since last call.
    */
    private Boolean delta;

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDelta (Boolean delta) {
        this.delta = delta;
    }

    public Boolean getDelta() {
        return this.delta;
    }

    public GetHistogramRequest(String name, Boolean delta) {
        this.name = name;
        this.delta = delta;
    }

    public GetHistogramRequest(String name) {
        this.name = name;
        this.delta = null;
    }

    public GetHistogramRequest() {
    }

}