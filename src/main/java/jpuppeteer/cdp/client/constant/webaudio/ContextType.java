package jpuppeteer.cdp.client.constant.webaudio;

/**
* Enum of BaseAudioContext types
* experimental
*/
public enum ContextType implements jpuppeteer.cdp.client.CDPEnum {

    REALTIME("realtime"),
    OFFLINE("offline"),
    ;

    private String value;

    ContextType(String value) {
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

    public static ContextType findByValue(String value) {
        for(ContextType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}