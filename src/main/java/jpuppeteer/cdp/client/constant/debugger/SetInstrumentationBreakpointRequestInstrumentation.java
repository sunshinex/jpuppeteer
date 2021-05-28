package jpuppeteer.cdp.client.constant.debugger;

/**
*/
public enum SetInstrumentationBreakpointRequestInstrumentation implements jpuppeteer.cdp.client.CDPEnum {

    BEFORESCRIPTEXECUTION("beforeScriptExecution"),
    BEFORESCRIPTWITHSOURCEMAPEXECUTION("beforeScriptWithSourceMapExecution"),
    ;

    private String value;

    SetInstrumentationBreakpointRequestInstrumentation(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static SetInstrumentationBreakpointRequestInstrumentation findByValue(String value) {
        for(SetInstrumentationBreakpointRequestInstrumentation val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}