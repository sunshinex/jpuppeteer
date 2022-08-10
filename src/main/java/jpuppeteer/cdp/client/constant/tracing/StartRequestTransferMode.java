package jpuppeteer.cdp.client.constant.tracing;

/**
* experimental
*/
public enum StartRequestTransferMode implements jpuppeteer.cdp.client.CDPEnum {

    REPORTEVENTS("ReportEvents"),
    RETURNASSTREAM("ReturnAsStream"),
    ;

    private String value;

    StartRequestTransferMode(String value) {
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

    public static StartRequestTransferMode findByValue(String value) {
        for(StartRequestTransferMode val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}