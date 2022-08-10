package jpuppeteer.cdp.client.constant.page;

/**
* Javascript dialog type.
*/
public enum DialogType implements jpuppeteer.cdp.client.CDPEnum {

    ALERT("alert"),
    CONFIRM("confirm"),
    PROMPT("prompt"),
    BEFOREUNLOAD("beforeunload"),
    ;

    private String value;

    DialogType(String value) {
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

    public static DialogType findByValue(String value) {
        for(DialogType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}