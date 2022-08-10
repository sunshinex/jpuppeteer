package jpuppeteer.cdp.client.entity.dom;

/**
* Mirrors `DOMNodeInserted` event.
*/
public class ChildNodeInsertedEvent {

    /**
    * Id of the node that has changed.
    */
    private Integer parentNodeId;

    /**
    * If of the previous siblint.
    */
    private Integer previousNodeId;

    /**
    * Inserted node data.
    */
    private jpuppeteer.cdp.client.entity.dom.Node node;

    public void setParentNodeId (Integer parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public Integer getParentNodeId() {
        return this.parentNodeId;
    }

    public void setPreviousNodeId (Integer previousNodeId) {
        this.previousNodeId = previousNodeId;
    }

    public Integer getPreviousNodeId() {
        return this.previousNodeId;
    }

    public void setNode (jpuppeteer.cdp.client.entity.dom.Node node) {
        this.node = node;
    }

    public jpuppeteer.cdp.client.entity.dom.Node getNode() {
        return this.node;
    }

    public ChildNodeInsertedEvent(Integer parentNodeId, Integer previousNodeId, jpuppeteer.cdp.client.entity.dom.Node node) {
        this.parentNodeId = parentNodeId;
        this.previousNodeId = previousNodeId;
        this.node = node;
    }

    public ChildNodeInsertedEvent() {
    }

}