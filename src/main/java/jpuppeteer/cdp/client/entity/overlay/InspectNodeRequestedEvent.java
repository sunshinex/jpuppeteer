package jpuppeteer.cdp.client.entity.overlay;

/**
* Fired when the node should be inspected. This happens after call to `setInspectMode` or when user manually inspects an element.
* experimental
*/
public class InspectNodeRequestedEvent {

    /**
    * Id of the node to inspect.
    */
    public final Integer backendNodeId;

    public InspectNodeRequestedEvent(Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

}