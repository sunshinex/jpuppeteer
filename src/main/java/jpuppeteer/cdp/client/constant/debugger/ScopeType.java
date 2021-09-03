package jpuppeteer.cdp.client.constant.debugger;

/**
*/
public enum ScopeType implements jpuppeteer.cdp.client.CDPEnum {

    GLOBAL("global"),
    LOCAL("local"),
    WITH("with"),
    CLOSURE("closure"),
    CATCH("catch"),
    BLOCK("block"),
    SCRIPT("script"),
    EVAL("eval"),
    MODULE("module"),
    WASM_EXPRESSION_STACK("wasm-expression-stack"),
    ;

    private String value;

    ScopeType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ScopeType findByValue(String value) {
        for(ScopeType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}