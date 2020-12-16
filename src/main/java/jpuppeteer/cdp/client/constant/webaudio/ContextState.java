package jpuppeteer.cdp.client.constant.webaudio;

/**
* Enum of AudioContextState from the spec
* experimental
*/
public enum ContextState implements jpuppeteer.cdp.client.CDPEnum {

    SUSPENDED("suspended"),
    RUNNING("running"),
    CLOSED("closed"),
    ;

    private String value;

    ContextState(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ContextState findByValue(String value) {
        for(ContextState val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}