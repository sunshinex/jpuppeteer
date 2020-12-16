package jpuppeteer.cdp.client.constant.accessibility;

/**
* Enum of possible native property sources (as a subtype of a particular AXValueSourceType).
* experimental
*/
public enum AXValueNativeSourceType implements jpuppeteer.cdp.client.CDPEnum {

    FIGCAPTION("figcaption"),
    LABEL("label"),
    LABELFOR("labelfor"),
    LABELWRAPPED("labelwrapped"),
    LEGEND("legend"),
    TABLECAPTION("tablecaption"),
    TITLE("title"),
    OTHER("other"),
    ;

    private String value;

    AXValueNativeSourceType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static AXValueNativeSourceType findByValue(String value) {
        for(AXValueNativeSourceType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}