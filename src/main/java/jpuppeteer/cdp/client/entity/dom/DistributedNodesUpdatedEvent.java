package jpuppeteer.cdp.client.entity.dom;

/**
* Called when distribution is changed.
*/
public class DistributedNodesUpdatedEvent {

    /**
    * Insertion point where distributed nodes were updated.
    */
    public final Integer insertionPointId;

    /**
    * Distributed nodes for given insertion point.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.dom.BackendNode> distributedNodes;

    public DistributedNodesUpdatedEvent(Integer insertionPointId, java.util.List<jpuppeteer.cdp.client.entity.dom.BackendNode> distributedNodes) {
        this.insertionPointId = insertionPointId;
        this.distributedNodes = distributedNodes;
    }

}