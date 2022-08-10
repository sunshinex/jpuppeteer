package jpuppeteer.cdp.client.constant.performance;

/**
*/
public enum EnableRequestTimeDomain implements jpuppeteer.cdp.client.CDPEnum {

    TIMETICKS("timeTicks"),
    THREADTICKS("threadTicks"),
    ;

    private String value;

    EnableRequestTimeDomain(String value) {
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

    public static EnableRequestTimeDomain findByValue(String value) {
        for(EnableRequestTimeDomain val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}