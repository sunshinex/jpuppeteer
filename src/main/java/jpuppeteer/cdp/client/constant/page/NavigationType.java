package jpuppeteer.cdp.client.constant.page;

/**
* The type of a frameNavigated event.
*/
public enum NavigationType implements jpuppeteer.cdp.client.CDPEnum {

    NAVIGATION("Navigation"),
    BACKFORWARDCACHERESTORE("BackForwardCacheRestore"),
    ;

    private String value;

    NavigationType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static NavigationType findByValue(String value) {
        for(NavigationType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}