package jpuppeteer.cdp.client.constant.audits;

/**
* experimental
*/
public enum GetEncodedResponseRequestEncoding implements jpuppeteer.cdp.client.CDPEnum {

    WEBP("webp"),
    JPEG("jpeg"),
    PNG("png"),
    ;

    private String value;

    GetEncodedResponseRequestEncoding(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static GetEncodedResponseRequestEncoding findByValue(String value) {
        for(GetEncodedResponseRequestEncoding val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}