package jpuppeteer.cdp.client.entity.dom;

/**
* Mirrors `DOMNodeRemoved` event.
*/
public class ChildNodeRemovedEvent {

    /**
    * Parent id.
    */
    public final Integer parentNodeId;

    /**
    * Id of the node that has been removed.
    */
    public final Integer nodeId;

    public ChildNodeRemovedEvent(Integer parentNodeId, Integer nodeId) {
        this.parentNodeId = parentNodeId;
        this.nodeId = nodeId;
    }

}