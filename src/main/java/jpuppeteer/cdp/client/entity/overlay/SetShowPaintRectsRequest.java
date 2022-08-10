package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowPaintRectsRequest {

    /**
    * True for showing paint rectangles
    */
    private Boolean result;

    public void setResult (Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return this.result;
    }

    public SetShowPaintRectsRequest(Boolean result) {
        this.result = result;
    }

    public SetShowPaintRectsRequest() {
    }

}