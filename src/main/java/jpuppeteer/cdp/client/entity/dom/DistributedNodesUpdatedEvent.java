package jpuppeteer.cdp.client.entity.dom;

/**
* Called when distribution is changed.
*/
public class DistributedNodesUpdatedEvent {

    /**
    * Insertion point where distributed nodes were updated.
    */
    private Integer insertionPointId;

    /**
    * Distributed nodes for given insertion point.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.dom.BackendNode> distributedNodes;

    public void setInsertionPointId (Integer insertionPointId) {
        this.insertionPointId = insertionPointId;
    }

    public Integer getInsertionPointId() {
        return this.insertionPointId;
    }

    public void setDistributedNodes (java.util.List<jpuppeteer.cdp.client.entity.dom.BackendNode> distributedNodes) {
        this.distributedNodes = distributedNodes;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.dom.BackendNode> getDistributedNodes() {
        return this.distributedNodes;
    }

    public DistributedNodesUpdatedEvent(Integer insertionPointId, java.util.List<jpuppeteer.cdp.client.entity.dom.BackendNode> distributedNodes) {
        this.insertionPointId = insertionPointId;
        this.distributedNodes = distributedNodes;
    }

    public DistributedNodesUpdatedEvent() {
    }

}