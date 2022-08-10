package jpuppeteer.cdp.client.constant.debugger;

/**
*/
public enum ContinueToLocationRequestTargetCallFrames implements jpuppeteer.cdp.client.CDPEnum {

    ANY("any"),
    CURRENT("current"),
    ;

    private String value;

    ContinueToLocationRequestTargetCallFrames(String value) {
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

    public static ContinueToLocationRequestTargetCallFrames findByValue(String value) {
        for(ContinueToLocationRequestTargetCallFrames val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}