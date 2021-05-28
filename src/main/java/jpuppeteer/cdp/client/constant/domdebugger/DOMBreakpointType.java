package jpuppeteer.cdp.client.constant.domdebugger;

/**
* DOM breakpoint type.
*/
public enum DOMBreakpointType implements jpuppeteer.cdp.client.CDPEnum {

    SUBTREE_MODIFIED("subtree-modified"),
    ATTRIBUTE_MODIFIED("attribute-modified"),
    NODE_REMOVED("node-removed"),
    ;

    private String value;

    DOMBreakpointType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static DOMBreakpointType findByValue(String value) {
        for(DOMBreakpointType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}