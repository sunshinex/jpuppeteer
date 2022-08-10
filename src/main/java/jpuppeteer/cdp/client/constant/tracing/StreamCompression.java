package jpuppeteer.cdp.client.constant.tracing;

/**
* Compression type to use for traces returned via streams.
* experimental
*/
public enum StreamCompression implements jpuppeteer.cdp.client.CDPEnum {

    NONE("none"),
    GZIP("gzip"),
    ;

    private String value;

    StreamCompression(String value) {
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

    public static StreamCompression findByValue(String value) {
        for(StreamCompression val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}