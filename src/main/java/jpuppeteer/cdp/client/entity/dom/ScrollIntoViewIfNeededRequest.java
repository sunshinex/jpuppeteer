package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class ScrollIntoViewIfNeededRequest {

    /**
    * Identifier of the node.
    */
    public final Integer nodeId;

    /**
    * Identifier of the backend node.
    */
    public final Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper.
    */
    public final String objectId;

    /**
    * The rect to be scrolled into view, relative to the node's border box, in CSS pixels. When omitted, center of the node will be used, similar to Element.scrollIntoView.
    */
    public final jpuppeteer.cdp.client.entity.dom.Rect rect;

    public ScrollIntoViewIfNeededRequest(Integer nodeId, Integer backendNodeId, String objectId, jpuppeteer.cdp.client.entity.dom.Rect rect) {
        this.nodeId = nodeId;
        this.backendNodeId = backendNodeId;
        this.objectId = objectId;
        this.rect = rect;
    }

    public ScrollIntoViewIfNeededRequest() {
        this.nodeId = null;
        this.backendNodeId = null;
        this.objectId = null;
        this.rect = null;
    }

}