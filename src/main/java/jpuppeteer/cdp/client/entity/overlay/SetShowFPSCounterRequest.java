package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowFPSCounterRequest {

    /**
    * True for showing the FPS counter
    */
    public final Boolean show;

    public SetShowFPSCounterRequest(Boolean show) {
        this.show = show;
    }

}