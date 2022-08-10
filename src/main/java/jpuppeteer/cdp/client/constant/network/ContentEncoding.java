package jpuppeteer.cdp.client.constant.network;

/**
* List of content encodings supported by the backend.
*/
public enum ContentEncoding implements jpuppeteer.cdp.client.CDPEnum {

    DEFLATE("deflate"),
    GZIP("gzip"),
    BR("br"),
    ;

    private String value;

    ContentEncoding(String value) {
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

    public static ContentEncoding findByValue(String value) {
        for(ContentEncoding val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}