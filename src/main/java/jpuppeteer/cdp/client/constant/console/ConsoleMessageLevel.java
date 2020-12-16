package jpuppeteer.cdp.client.constant.console;

/**
*/
public enum ConsoleMessageLevel implements jpuppeteer.cdp.client.CDPEnum {

    LOG("log"),
    WARNING("warning"),
    ERROR("error"),
    DEBUG("debug"),
    INFO("info"),
    ;

    private String value;

    ConsoleMessageLevel(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ConsoleMessageLevel findByValue(String value) {
        for(ConsoleMessageLevel val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}