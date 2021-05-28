package jpuppeteer.cdp.client.entity.overlay;

/**
* experimental
*/
public class SetShowScrollBottleneckRectsRequest {

    /**
    * True for showing scroll bottleneck rects
    */
    public final Boolean show;

    public SetShowScrollBottleneckRectsRequest(Boolean show) {
        this.show = show;
    }

}