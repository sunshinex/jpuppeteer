package jpuppeteer.cdp.client.constant.indexeddb;

/**
* experimental
*/
public enum KeyType implements jpuppeteer.cdp.client.CDPEnum {

    NUMBER("number"),
    STRING("string"),
    DATE("date"),
    ARRAY("array"),
    ;

    private String value;

    KeyType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static KeyType findByValue(String value) {
        for(KeyType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}