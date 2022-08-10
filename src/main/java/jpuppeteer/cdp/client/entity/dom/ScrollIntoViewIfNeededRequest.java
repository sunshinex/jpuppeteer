package jpuppeteer.cdp.client.entity.dom;

/**
*/
public class ScrollIntoViewIfNeededRequest {

    /**
    * Identifier of the node.
    */
    private Integer nodeId;

    /**
    * Identifier of the backend node.
    */
    private Integer backendNodeId;

    /**
    * JavaScript object id of the node wrapper.
    */
    private String objectId;

    /**
    * The rect to be scrolled into view, relative to the node's border box, in CSS pixels. When omitted, center of the node will be used, similar to Element.scrollIntoView.
    */
    private jpuppeteer.cdp.client.entity.dom.Rect rect;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public void setObjectId (String objectId) {
        this.objectId = objectId;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public void setRect (jpuppeteer.cdp.client.entity.dom.Rect rect) {
        this.rect = rect;
    }

    public jpuppeteer.cdp.client.entity.dom.Rect getRect() {
        return this.rect;
    }

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