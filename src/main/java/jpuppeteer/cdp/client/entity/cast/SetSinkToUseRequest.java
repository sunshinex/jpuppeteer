package jpuppeteer.cdp.client.entity.cast;

/**
* experimental
*/
public class SetSinkToUseRequest {

    /**
    */
    private String sinkName;

    public void setSinkName (String sinkName) {
        this.sinkName = sinkName;
    }

    public String getSinkName() {
        return this.sinkName;
    }

    public SetSinkToUseRequest(String sinkName) {
        this.sinkName = sinkName;
    }

    public SetSinkToUseRequest() {
    }

}