package jpuppeteer.cdp.client.constant.browser;

/**
* Browser command ids used by executeBrowserCommand.
*/
public enum BrowserCommandId implements jpuppeteer.cdp.client.CDPEnum {

    OPENTABSEARCH("openTabSearch"),
    CLOSETABSEARCH("closeTabSearch"),
    ;

    private String value;

    BrowserCommandId(String value) {
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

    public static BrowserCommandId findByValue(String value) {
        for(BrowserCommandId val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}