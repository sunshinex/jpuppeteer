package jpuppeteer.cdp.client.constant.security;

/**
* The action to take when a certificate error occurs. continue will continue processing the request and cancel will cancel the request.
*/
public enum CertificateErrorAction implements jpuppeteer.cdp.client.CDPEnum {

    CONTINUE("continue"),
    CANCEL("cancel"),
    ;

    private String value;

    CertificateErrorAction(String value) {
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

    public static CertificateErrorAction findByValue(String value) {
        for(CertificateErrorAction val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}