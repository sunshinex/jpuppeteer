package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowLayoutShiftRegionsRequest {

    /**
    * True for showing layout shift regions
    */
    private Boolean result;

    public void setResult (Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return this.result;
    }

    public SetShowLayoutShiftRegionsRequest(Boolean result) {
        this.result = result;
    }

    public SetShowLayoutShiftRegionsRequest() {
    }

}