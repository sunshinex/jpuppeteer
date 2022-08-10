package jpuppeteer.cdp.client.entity.dom;

/**
* Mirrors `DOMNodeRemoved` event.
*/
public class ChildNodeRemovedEvent {

    /**
    * Parent id.
    */
    private Integer parentNodeId;

    /**
    * Id of the node that has been removed.
    */
    private Integer nodeId;

    public void setParentNodeId (Integer parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public Integer getParentNodeId() {
        return this.parentNodeId;
    }

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public ChildNodeRemovedEvent(Integer parentNodeId, Integer nodeId) {
        this.parentNodeId = parentNodeId;
        this.nodeId = nodeId;
    }

    public ChildNodeRemovedEvent() {
    }

}