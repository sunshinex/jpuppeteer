package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class RemoveDOMBreakpointRequest {

    /**
    * Identifier of the node to remove breakpoint from.
    */
    public final Integer nodeId;

    /**
    * Type of the breakpoint to remove.
    */
    public final String type;

    public RemoveDOMBreakpointRequest(Integer nodeId, String type) {
        this.nodeId = nodeId;
        this.type = type;
    }

}