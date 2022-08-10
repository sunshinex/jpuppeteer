package jpuppeteer.cdp.client.constant.webauthn;

/**
* experimental
*/
public enum AuthenticatorProtocol implements jpuppeteer.cdp.client.CDPEnum {

    U2F("u2f"),
    CTAP2("ctap2"),
    ;

    private String value;

    AuthenticatorProtocol(String value) {
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

    public static AuthenticatorProtocol findByValue(String value) {
        for(AuthenticatorProtocol val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}