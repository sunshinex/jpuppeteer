package jpuppeteer.cdp.client.constant.console;

/**
*/
public enum ConsoleMessageSource implements jpuppeteer.cdp.client.CDPEnum {

    XML("xml"),
    JAVASCRIPT("javascript"),
    NETWORK("network"),
    CONSOLE_API("console-api"),
    STORAGE("storage"),
    APPCACHE("appcache"),
    RENDERING("rendering"),
    SECURITY("security"),
    OTHER("other"),
    DEPRECATION("deprecation"),
    WORKER("worker"),
    ;

    private String value;

    ConsoleMessageSource(String value) {
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

    public static ConsoleMessageSource findByValue(String value) {
        for(ConsoleMessageSource val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}