package jpuppeteer.cdp.client.constant.overlay;

/**
* experimental
*/
public enum ContrastAlgorithm implements jpuppeteer.cdp.client.CDPEnum {

    AA("aa"),
    AAA("aaa"),
    APCA("apca"),
    ;

    private String value;

    ContrastAlgorithm(String value) {
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

    public static ContrastAlgorithm findByValue(String value) {
        for(ContrastAlgorithm val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}