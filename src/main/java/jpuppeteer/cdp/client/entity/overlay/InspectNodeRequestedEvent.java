package jpuppeteer.cdp.client.entity.overlay;

/**
* Fired when the node should be inspected. This happens after call to `setInspectMode` or when user manually inspects an element.
* experimental
*/
public class InspectNodeRequestedEvent {

    /**
    * Id of the node to inspect.
    */
    private Integer backendNodeId;

    public void setBackendNodeId (Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public Integer getBackendNodeId() {
        return this.backendNodeId;
    }

    public InspectNodeRequestedEvent(Integer backendNodeId) {
        this.backendNodeId = backendNodeId;
    }

    public InspectNodeRequestedEvent() {
    }

}