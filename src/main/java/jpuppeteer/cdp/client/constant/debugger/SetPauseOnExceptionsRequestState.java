package jpuppeteer.cdp.client.constant.debugger;

/**
*/
public enum SetPauseOnExceptionsRequestState implements jpuppeteer.cdp.client.CDPEnum {

    NONE("none"),
    UNCAUGHT("uncaught"),
    ALL("all"),
    ;

    private String value;

    SetPauseOnExceptionsRequestState(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static SetPauseOnExceptionsRequestState findByValue(String value) {
        for(SetPauseOnExceptionsRequestState val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}