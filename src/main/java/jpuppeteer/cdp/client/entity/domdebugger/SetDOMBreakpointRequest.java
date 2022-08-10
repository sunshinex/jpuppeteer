package jpuppeteer.cdp.client.entity.domdebugger;

/**
*/
public class SetDOMBreakpointRequest {

    /**
    * Identifier of the node to set breakpoint on.
    */
    private Integer nodeId;

    /**
    * Type of the operation to stop upon.
    */
    private jpuppeteer.cdp.client.constant.domdebugger.DOMBreakpointType type;

    public void setNodeId (Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setType (jpuppeteer.cdp.client.constant.domdebugger.DOMBreakpointType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.domdebugger.DOMBreakpointType getType() {
        return this.type;
    }

    public SetDOMBreakpointRequest(Integer nodeId, jpuppeteer.cdp.client.constant.domdebugger.DOMBreakpointType type) {
        this.nodeId = nodeId;
        this.type = type;
    }

    public SetDOMBreakpointRequest() {
    }

}