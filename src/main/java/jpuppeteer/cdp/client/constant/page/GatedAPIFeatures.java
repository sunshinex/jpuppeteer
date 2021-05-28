package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum GatedAPIFeatures implements jpuppeteer.cdp.client.CDPEnum {

    SHAREDARRAYBUFFERS("SharedArrayBuffers"),
    SHAREDARRAYBUFFERSTRANSFERALLOWED("SharedArrayBuffersTransferAllowed"),
    PERFORMANCEMEASUREMEMORY("PerformanceMeasureMemory"),
    PERFORMANCEPROFILE("PerformanceProfile"),
    ;

    private String value;

    GatedAPIFeatures(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static GatedAPIFeatures findByValue(String value) {
        for(GatedAPIFeatures val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}