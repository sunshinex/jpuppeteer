package jpuppeteer.cdp.client.entity.dom;

/**
* Fired when `Container`'s child node count has changed.
*/
public class ChildNodeCountUpdatedEvent {

    /**
    * Id of the node that has changed.
    */
    public final Integer nodeId;

    /**
    * New node count.
    */
    public final Integer childNodeCount;

    public ChildNodeCountUpdatedEvent(Integer nodeId, Integer childNodeCount) {
        this.nodeId = nodeId;
        this.childNodeCount = childNodeCount;
    }

}