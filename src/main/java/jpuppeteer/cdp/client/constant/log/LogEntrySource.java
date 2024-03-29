package jpuppeteer.cdp.client.constant.log;

/**
*/
public enum LogEntrySource implements jpuppeteer.cdp.client.CDPEnum {

    XML("xml"),
    JAVASCRIPT("javascript"),
    NETWORK("network"),
    STORAGE("storage"),
    APPCACHE("appcache"),
    RENDERING("rendering"),
    SECURITY("security"),
    DEPRECATION("deprecation"),
    WORKER("worker"),
    VIOLATION("violation"),
    INTERVENTION("intervention"),
    RECOMMENDATION("recommendation"),
    OTHER("other"),
    ;

    private String value;

    LogEntrySource(String value) {
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

    public static LogEntrySource findByValue(String value) {
        for(LogEntrySource val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}