package jpuppeteer.cdp.client.entity.dom;

/**
* Called when distrubution is changed.
*/
public class DistributedNodesUpdatedEvent {

    /**
    * Insertion point where distrubuted nodes were updated.
    */
    public final Integer insertionPointId;

    /**
    * Distributed nodes for given insertion point.
    */
    public final java.util.List<BackendNode> distributedNodes;

    public DistributedNodesUpdatedEvent(Integer insertionPointId, java.util.List<BackendNode> distributedNodes) {
        this.insertionPointId = insertionPointId;
        this.distributedNodes = distributedNodes;
    }

}