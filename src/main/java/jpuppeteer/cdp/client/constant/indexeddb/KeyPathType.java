package jpuppeteer.cdp.client.constant.indexeddb;

/**
* experimental
*/
public enum KeyPathType implements jpuppeteer.cdp.client.CDPEnum {

    NULL("null"),
    STRING("string"),
    ARRAY("array"),
    ;

    private String value;

    KeyPathType(String value) {
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

    public static KeyPathType findByValue(String value) {
        for(KeyPathType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}