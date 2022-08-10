package jpuppeteer.cdp.client.entity.cast;

/**
* experimental
*/
public class StartTabMirroringRequest {

    /**
    */
    private String sinkName;

    public void setSinkName (String sinkName) {
        this.sinkName = sinkName;
    }

    public String getSinkName() {
        return this.sinkName;
    }

    public StartTabMirroringRequest(String sinkName) {
        this.sinkName = sinkName;
    }

    public StartTabMirroringRequest() {
    }

}