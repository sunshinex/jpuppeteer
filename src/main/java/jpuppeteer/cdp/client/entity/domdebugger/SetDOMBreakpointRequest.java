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
    public final jpuppeteer.cdp.client.constant.domdebugger.DOMBreakpointType type;

    public SetDOMBreakpointRequest(Integer nodeId, jpuppeteer.cdp.client.constant.domdebugger.DOMBreakpointType type) {
        this.nodeId = nodeId;
        this.type = type;
    }

}