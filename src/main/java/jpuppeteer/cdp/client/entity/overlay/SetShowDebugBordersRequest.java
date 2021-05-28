package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowDebugBordersRequest {

    /**
    * True for showing debug borders
    */
    public final Boolean show;

    public SetShowDebugBordersRequest(Boolean show) {
        this.show = show;
    }

}