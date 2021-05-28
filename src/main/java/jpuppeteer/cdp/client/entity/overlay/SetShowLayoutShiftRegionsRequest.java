package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowLayoutShiftRegionsRequest {

    /**
    * True for showing layout shift regions
    */
    public final Boolean result;

    public SetShowLayoutShiftRegionsRequest(Boolean result) {
        this.result = result;
    }

}