package jpuppeteer.cdp.client.constant.tracing;

/**
* Data format of a trace. Can be either the legacy JSON format or the protocol buffer format. Note that the JSON format will be deprecated soon.
* experimental
*/
public enum StreamFormat implements jpuppeteer.cdp.client.CDPEnum {

    JSON("json"),
    PROTO("proto"),
    ;

    private String value;

    StreamFormat(String value) {
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

    public static StreamFormat findByValue(String value) {
        for(StreamFormat val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}