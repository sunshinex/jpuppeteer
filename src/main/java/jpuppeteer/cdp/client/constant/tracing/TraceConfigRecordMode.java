package jpuppeteer.cdp.client.constant.tracing;

/**
* experimental
*/
public enum TraceConfigRecordMode implements jpuppeteer.cdp.client.CDPEnum {

    RECORDUNTILFULL("recordUntilFull"),
    RECORDCONTINUOUSLY("recordContinuously"),
    RECORDASMUCHASPOSSIBLE("recordAsMuchAsPossible"),
    ECHOTOCONSOLE("echoToConsole"),
    ;

    private String value;

    TraceConfigRecordMode(String value) {
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

    public static TraceConfigRecordMode findByValue(String value) {
        for(TraceConfigRecordMode val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}