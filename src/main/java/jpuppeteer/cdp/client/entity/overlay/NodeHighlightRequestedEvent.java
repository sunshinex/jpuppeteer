package jpuppeteer.cdp.client.entity.overlay;

/**
* Fired when the node should be highlighted. This happens after call to `setInspectMode`.
* experimental
*/
public class NodeHighlightRequestedEvent {

    /**
    */
    private Integer nodeId;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public NodeHighlightRequestedEvent(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public NodeHighlightRequestedEvent() {
    }

}