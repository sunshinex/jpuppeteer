package jpuppeteer.cdp.client.constant.debugger;

/**
* Enum of possible script languages.
*/
public enum ScriptLanguage implements jpuppeteer.cdp.client.CDPEnum {

    JAVASCRIPT("JavaScript"),
    WEBASSEMBLY("WebAssembly"),
    ;

    private String value;

    ScriptLanguage(String value) {
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

    public static ScriptLanguage findByValue(String value) {
        for(ScriptLanguage val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}