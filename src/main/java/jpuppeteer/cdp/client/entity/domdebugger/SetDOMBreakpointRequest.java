package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class SetDOMBreakpointRequest {

    /**
    * Identifier of the node to set breakpoint on.
    */
    public final Integer nodeId;

    /**
    * Type of the operation to stop upon.
    */
    public final String type;

    public SetDOMBreakpointRequest(Integer nodeId, String type) {
        this.nodeId = nodeId;
        this.type = type;
    }

}