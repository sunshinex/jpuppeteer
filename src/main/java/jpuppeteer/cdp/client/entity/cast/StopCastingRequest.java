package jpuppeteer.cdp.client.entity.cast;

/**
* experimental
*/
public class StopCastingRequest {

    /**
    */
    private String sinkName;

    public void setSinkName (String sinkName) {
        this.sinkName = sinkName;
    }

    public String getSinkName() {
        return this.sinkName;
    }

    public StopCastingRequest(String sinkName) {
        this.sinkName = sinkName;
    }

    public StopCastingRequest() {
    }

}