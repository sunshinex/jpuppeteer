package jpuppeteer.cdp.client.constant.page;

/**
* Indicates whether the frame is a secure context and why it is the case.
*/
public enum SecureContextType implements jpuppeteer.cdp.client.CDPEnum {

    SECURE("Secure"),
    SECURELOCALHOST("SecureLocalhost"),
    INSECURESCHEME("InsecureScheme"),
    INSECUREANCESTOR("InsecureAncestor"),
    ;

    private String value;

    SecureContextType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static SecureContextType findByValue(String value) {
        for(SecureContextType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}