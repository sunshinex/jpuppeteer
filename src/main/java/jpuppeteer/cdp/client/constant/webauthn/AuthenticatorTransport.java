package jpuppeteer.cdp.client.constant.webauthn;

/**
* experimental
*/
public enum AuthenticatorTransport implements jpuppeteer.cdp.client.CDPEnum {

    USB("usb"),
    NFC("nfc"),
    BLE("ble"),
    CABLE("cable"),
    INTERNAL("internal"),
    ;

    private String value;

    AuthenticatorTransport(String value) {
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

    public static AuthenticatorTransport findByValue(String value) {
        for(AuthenticatorTransport val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}