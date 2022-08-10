package jpuppeteer.cdp.client.constant.emulation;

/**
*/
public enum ScreenOrientationType implements jpuppeteer.cdp.client.CDPEnum {

    PORTRAITPRIMARY("portraitPrimary"),
    PORTRAITSECONDARY("portraitSecondary"),
    LANDSCAPEPRIMARY("landscapePrimary"),
    LANDSCAPESECONDARY("landscapeSecondary"),
    ;

    private String value;

    ScreenOrientationType(String value) {
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

    public static ScreenOrientationType findByValue(String value) {
        for(ScreenOrientationType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}