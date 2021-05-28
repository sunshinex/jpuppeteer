package jpuppeteer.cdp.client.constant.runtime;

/**
*/
public enum PropertyPreviewType implements jpuppeteer.cdp.client.CDPEnum {

    OBJECT("object"),
    FUNCTION("function"),
    UNDEFINED("undefined"),
    STRING("string"),
    NUMBER("number"),
    BOOLEAN("boolean"),
    SYMBOL("symbol"),
    ACCESSOR("accessor"),
    BIGINT("bigint"),
    ;

    private String value;

    PropertyPreviewType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static PropertyPreviewType findByValue(String value) {
        for(PropertyPreviewType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}