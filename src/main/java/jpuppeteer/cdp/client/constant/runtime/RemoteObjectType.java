package jpuppeteer.cdp.client.constant.runtime;

/**
*/
public enum RemoteObjectType implements jpuppeteer.cdp.client.CDPEnum {

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

    RemoteObjectType(String value) {
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

    public static RemoteObjectType findByValue(String value) {
        for(RemoteObjectType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}