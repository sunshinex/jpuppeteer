package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowScrollBottleneckRectsRequest {

    /**
    * True for showing scroll bottleneck rects
    */
    private Boolean show;

    public void setShow (Boolean show) {
        this.show = show;
    }

    public Boolean getShow() {
        return this.show;
    }

    public SetShowScrollBottleneckRectsRequest(Boolean show) {
        this.show = show;
    }

    public SetShowScrollBottleneckRectsRequest() {
    }

}