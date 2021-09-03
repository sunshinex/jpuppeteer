package jpuppeteer.cdp.client.constant.runtime;

/**
*/
public enum PropertyPreviewSubtype implements jpuppeteer.cdp.client.CDPEnum {

    ARRAY("array"),
    NULL("null"),
    NODE("node"),
    REGEXP("regexp"),
    DATE("date"),
    MAP("map"),
    SET("set"),
    WEAKMAP("weakmap"),
    WEAKSET("weakset"),
    ITERATOR("iterator"),
    GENERATOR("generator"),
    ERROR("error"),
    PROXY("proxy"),
    PROMISE("promise"),
    TYPEDARRAY("typedarray"),
    ARRAYBUFFER("arraybuffer"),
    DATAVIEW("dataview"),
    WEBASSEMBLYMEMORY("webassemblymemory"),
    WASMVALUE("wasmvalue"),
    ;

    private String value;

    PropertyPreviewSubtype(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static PropertyPreviewSubtype findByValue(String value) {
        for(PropertyPreviewSubtype val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}