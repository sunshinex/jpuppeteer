package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowViewportSizeOnResizeRequest {

    /**
    * Whether to paint size or not.
    */
    public final Boolean show;

    public SetShowViewportSizeOnResizeRequest(Boolean show) {
        this.show = show;
    }

}