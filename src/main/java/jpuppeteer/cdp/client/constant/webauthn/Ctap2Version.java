package jpuppeteer.cdp.client.constant.webauthn;

/**
* experimental
*/
public enum Ctap2Version implements jpuppeteer.cdp.client.CDPEnum {

    CTAP2_0("ctap2_0"),
    CTAP2_1("ctap2_1"),
    ;

    private String value;

    Ctap2Version(String value) {
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

    public static Ctap2Version findByValue(String value) {
        for(Ctap2Version val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}