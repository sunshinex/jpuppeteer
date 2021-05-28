package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowPaintRectsRequest {

    /**
    * True for showing paint rectangles
    */
    public final Boolean result;

    public SetShowPaintRectsRequest(Boolean result) {
        this.result = result;
    }

}