package jpuppeteer.cdp.client.constant.performance;

/**
*/
public enum SetTimeDomainRequestTimeDomain implements jpuppeteer.cdp.client.CDPEnum {

    TIMETICKS("timeTicks"),
    THREADTICKS("threadTicks"),
    ;

    private String value;

    SetTimeDomainRequestTimeDomain(String value) {
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

    public static SetTimeDomainRequestTimeDomain findByValue(String value) {
        for(SetTimeDomainRequestTimeDomain val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}