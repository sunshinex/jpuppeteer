package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum SetWebLifecycleStateRequestState implements jpuppeteer.cdp.client.CDPEnum {

    FROZEN("frozen"),
    ACTIVE("active"),
    ;

    private String value;

    SetWebLifecycleStateRequestState(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static SetWebLifecycleStateRequestState findByValue(String value) {
        for(SetWebLifecycleStateRequestState val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}