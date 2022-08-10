package jpuppeteer.cdp.client.constant.log;

/**
*/
public enum LogEntryLevel implements jpuppeteer.cdp.client.CDPEnum {

    VERBOSE("verbose"),
    INFO("info"),
    WARNING("warning"),
    ERROR("error"),
    ;

    private String value;

    LogEntryLevel(String value) {
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

    public static LogEntryLevel findByValue(String value) {
        for(LogEntryLevel val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}