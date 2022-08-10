package jpuppeteer.cdp.client.constant.browser;

/**
*/
public enum PermissionSetting implements jpuppeteer.cdp.client.CDPEnum {

    GRANTED("granted"),
    DENIED("denied"),
    PROMPT("prompt"),
    ;

    private String value;

    PermissionSetting(String value) {
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

    public static PermissionSetting findByValue(String value) {
        for(PermissionSetting val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}