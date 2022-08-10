package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum HeavyAdReason implements jpuppeteer.cdp.client.CDPEnum {

    NETWORKTOTALLIMIT("NetworkTotalLimit"),
    CPUTOTALLIMIT("CpuTotalLimit"),
    CPUPEAKLIMIT("CpuPeakLimit"),
    ;

    private String value;

    HeavyAdReason(String value) {
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

    public static HeavyAdReason findByValue(String value) {
        for(HeavyAdReason val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}