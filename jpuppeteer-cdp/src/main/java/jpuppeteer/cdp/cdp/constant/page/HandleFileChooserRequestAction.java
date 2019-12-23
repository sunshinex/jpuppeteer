package jpuppeteer.cdp.cdp.constant.page;

/**
*/
public enum HandleFileChooserRequestAction {

    ACCEPT("accept"),
    CANCEL("cancel"),
    FALLBACK("fallback"),
    ;

    private String value;

    HandleFileChooserRequestAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
}

    public static HandleFileChooserRequestAction findByValue(String value) {
        for(HandleFileChooserRequestAction val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}