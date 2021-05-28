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
    public final jpuppeteer.cdp.client.constant.domdebugger.DOMBreakpointType type;

    public RemoveDOMBreakpointRequest(Integer nodeId, jpuppeteer.cdp.client.constant.domdebugger.DOMBreakpointType type) {
        this.nodeId = nodeId;
        this.type = type;
    }

}