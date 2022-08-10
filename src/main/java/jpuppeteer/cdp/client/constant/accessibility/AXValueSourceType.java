package jpuppeteer.cdp.client.constant.accessibility;

/**
* Enum of possible property sources.
* experimental
*/
public enum AXValueSourceType implements jpuppeteer.cdp.client.CDPEnum {

    ATTRIBUTE("attribute"),
    IMPLICIT("implicit"),
    STYLE("style"),
    CONTENTS("contents"),
    PLACEHOLDER("placeholder"),
    RELATEDELEMENT("relatedElement"),
    ;

    private String value;

    AXValueSourceType(String value) {
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

    public static AXValueSourceType findByValue(String value) {
        for(AXValueSourceType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}