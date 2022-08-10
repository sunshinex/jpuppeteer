package jpuppeteer.cdp.client.constant.overlay;

/**
* experimental
*/
public enum LineStylePattern implements jpuppeteer.cdp.client.CDPEnum {

    DASHED("dashed"),
    DOTTED("dotted"),
    ;

    private String value;

    LineStylePattern(String value) {
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

    public static LineStylePattern findByValue(String value) {
        for(LineStylePattern val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}