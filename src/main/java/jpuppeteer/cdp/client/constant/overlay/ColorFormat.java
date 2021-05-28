package jpuppeteer.cdp.client.constant.overlay;

/**
* experimental
*/
public enum ColorFormat implements jpuppeteer.cdp.client.CDPEnum {

    RGB("rgb"),
    HSL("hsl"),
    HEX("hex"),
    ;

    private String value;

    ColorFormat(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ColorFormat findByValue(String value) {
        for(ColorFormat val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}