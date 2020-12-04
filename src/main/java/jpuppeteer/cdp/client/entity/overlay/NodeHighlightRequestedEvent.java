package jpuppeteer.cdp.client.entity.overlay;

/**
* Fired when the node should be highlighted. This happens after call to `setInspectMode`.
* experimental
*/
public class NodeHighlightRequestedEvent {

    /**
    */
    public final Integer nodeId;

    public NodeHighlightRequestedEvent(Integer nodeId) {
        this.nodeId = nodeId;
    }

}