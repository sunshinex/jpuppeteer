package jpuppeteer.cdp.client.constant.network;

/**
* Whether the request complied with Certificate Transparency policy.
*/
public enum CertificateTransparencyCompliance implements jpuppeteer.cdp.client.CDPEnum {

    UNKNOWN("unknown"),
    NOT_COMPLIANT("not-compliant"),
    COMPLIANT("compliant"),
    ;

    private String value;

    CertificateTransparencyCompliance(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static CertificateTransparencyCompliance findByValue(String value) {
        for(CertificateTransparencyCompliance val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}