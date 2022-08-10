package jpuppeteer.cdp.client.entity.layertree;

/**
* Rectangle where scrolling happens on the main thread.
* experimental
*/
public class ScrollRect {

    /**
    * Rectangle itself.
    */
    private jpuppeteer.cdp.client.entity.dom.Rect rect;

    /**
    * Reason for rectangle to force scrolling on the main thread
    */
    private jpuppeteer.cdp.client.constant.layertree.ScrollRectType type;

    public void setRect (jpuppeteer.cdp.client.entity.dom.Rect rect) {
        this.rect = rect;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getRect() {
        return this.rect;
    }

    public void setType (jpuppeteer.cdp.client.constant.layertree.ScrollRectType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.layertree.ScrollRectType getType() {
        return this.type;
    }

    public ScrollRect(jpuppeteer.cdp.client.entity.dom.Rect rect, jpuppeteer.cdp.client.constant.layertree.ScrollRectType type) {
        this.rect = rect;
        this.type = type;
    }

    public ScrollRect() {
    }

}