package jpuppeteer.cdp.client.constant.runtime;

/**
*/
public enum ObjectPreviewType implements jpuppeteer.cdp.client.CDPEnum {

    OBJECT("object"),
    FUNCTION("function"),
    UNDEFINED("undefined"),
    STRING("string"),
    NUMBER("number"),
    BOOLEAN("boolean"),
    SYMBOL("symbol"),
    BIGINT("bigint"),
    ;

    private String value;

    ObjectPreviewType(String value) {
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

    public static ObjectPreviewType findByValue(String value) {
        for(ObjectPreviewType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}