package jpuppeteer.cdp.client.constant.runtime;

/**
*/
public enum ConsoleAPICalledEventType implements jpuppeteer.cdp.client.CDPEnum {

    LOG("log"),
    DEBUG("debug"),
    INFO("info"),
    ERROR("error"),
    WARNING("warning"),
    DIR("dir"),
    DIRXML("dirxml"),
    TABLE("table"),
    TRACE("trace"),
    CLEAR("clear"),
    STARTGROUP("startGroup"),
    STARTGROUPCOLLAPSED("startGroupCollapsed"),
    ENDGROUP("endGroup"),
    ASSERT("assert"),
    PROFILE("profile"),
    PROFILEEND("profileEnd"),
    COUNT("count"),
    TIMEEND("timeEnd"),
    ;

    private String value;

    ConsoleAPICalledEventType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ConsoleAPICalledEventType findByValue(String value) {
        for(ConsoleAPICalledEventType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}