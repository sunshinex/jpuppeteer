package jpuppeteer.cdp.client.entity.layertree;

/**
* Rectangle where scrolling happens on the main thread.
* experimental
*/
public class ScrollRect {

    /**
    * Rectangle itself.
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect rect;

    /**
    * Reason for rectangle to force scrolling on the main thread
    */
    public final jpuppeteer.cdp.client.constant.layertree.ScrollRectType type;

    public ScrollRect(jpuppeteer.cdp.client.entity.dom.Rect rect, jpuppeteer.cdp.client.constant.layertree.ScrollRectType type) {
        this.rect = rect;
        this.type = type;
    }

}