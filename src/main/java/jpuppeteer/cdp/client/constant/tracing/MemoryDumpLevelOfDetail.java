package jpuppeteer.cdp.client.constant.tracing;

/**
* Details exposed when memory request explicitly declared. Keep consistent with memory_dump_request_args.h and memory_instrumentation.mojom
* experimental
*/
public enum MemoryDumpLevelOfDetail implements jpuppeteer.cdp.client.CDPEnum {

    BACKGROUND("background"),
    LIGHT("light"),
    DETAILED("detailed"),
    ;

    private String value;

    MemoryDumpLevelOfDetail(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static MemoryDumpLevelOfDetail findByValue(String value) {
        for(MemoryDumpLevelOfDetail val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}