package jpuppeteer.cdp.client.constant.debugger;

/**
*/
public enum BreakLocationType implements jpuppeteer.cdp.client.CDPEnum {

    DEBUGGERSTATEMENT("debuggerStatement"),
    CALL("call"),
    RETURN("return"),
    ;

    private String value;

    BreakLocationType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static BreakLocationType findByValue(String value) {
        for(BreakLocationType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}