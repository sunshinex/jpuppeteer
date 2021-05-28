package jpuppeteer.cdp.client.constant.debugger;

/**
*/
public enum DebugSymbolsType implements jpuppeteer.cdp.client.CDPEnum {

    NONE("None"),
    SOURCEMAP("SourceMap"),
    EMBEDDEDDWARF("EmbeddedDWARF"),
    EXTERNALDWARF("ExternalDWARF"),
    ;

    private String value;

    DebugSymbolsType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static DebugSymbolsType findByValue(String value) {
        for(DebugSymbolsType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}