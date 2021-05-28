package jpuppeteer.cdp.client.constant.log;

/**
*/
public enum ViolationSettingName implements jpuppeteer.cdp.client.CDPEnum {

    LONGTASK("longTask"),
    LONGLAYOUT("longLayout"),
    BLOCKEDEVENT("blockedEvent"),
    BLOCKEDPARSER("blockedParser"),
    DISCOURAGEDAPIUSE("discouragedAPIUse"),
    HANDLER("handler"),
    RECURRINGHANDLER("recurringHandler"),
    ;

    private String value;

    ViolationSettingName(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ViolationSettingName findByValue(String value) {
        for(ViolationSettingName val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}