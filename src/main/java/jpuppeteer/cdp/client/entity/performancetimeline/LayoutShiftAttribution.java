package jpuppeteer.cdp.client.entity.performancetimeline;

/**
* experimental
*/
public class LayoutShiftAttribution {

    /**
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect previousRect;

    /**
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect currentRect;

    /**
    */
    public final Integer nodeId;

    public LayoutShiftAttribution(jpuppeteer.cdp.client.entity.dom.Rect previousRect, jpuppeteer.cdp.client.entity.dom.Rect currentRect, Integer nodeId) {
        this.previousRect = previousRect;
        this.currentRect = currentRect;
        this.nodeId = nodeId;
    }

    public LayoutShiftAttribution(jpuppeteer.cdp.client.entity.dom.Rect previousRect, jpuppeteer.cdp.client.entity.dom.Rect currentRect) {
        this.previousRect = previousRect;
        this.currentRect = currentRect;
        this.nodeId = null;
    }

}