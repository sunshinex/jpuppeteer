package jpuppeteer.cdp.client.entity.dom;

/**
* Fired when `Container`'s child node count has changed.
*/
public class ChildNodeCountUpdatedEvent {

    /**
    * Id of the node that has changed.
    */
    private Integer nodeId;

    /**
    * New node count.
    */
    private Integer childNodeCount;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setChildNodeCount (Integer childNodeCount) {
        this.childNodeCount = childNodeCount;
    }

    public Integer getChildNodeCount() {
        return this.childNodeCount;
    }

    public ChildNodeCountUpdatedEvent(Integer nodeId, Integer childNodeCount) {
        this.nodeId = nodeId;
        this.childNodeCount = childNodeCount;
    }

    public ChildNodeCountUpdatedEvent() {
    }

}