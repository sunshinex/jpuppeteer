package jpuppeteer.cdp.client.entity.performancetimeline;

/**
* experimental
*/
public class LayoutShiftAttribution {

    /**
    */
    private jpuppeteer.cdp.client.entity.dom.Rect previousRect;

    /**
    */
    private jpuppeteer.cdp.client.entity.dom.Rect currentRect;

    /**
    */
    private Integer nodeId;

    public void setPreviousRect (jpuppeteer.cdp.client.entity.dom.Rect previousRect) {
        this.previousRect = previousRect;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getPreviousRect() {
        return this.previousRect;
    }

    public void setCurrentRect (jpuppeteer.cdp.client.entity.dom.Rect currentRect) {
        this.currentRect = currentRect;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getCurrentRect() {
        return this.currentRect;
    }

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

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

    public LayoutShiftAttribution() {
    }

}