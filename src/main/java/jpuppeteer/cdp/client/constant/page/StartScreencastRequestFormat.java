package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum StartScreencastRequestFormat implements jpuppeteer.cdp.client.CDPEnum {

    JPEG("jpeg"),
    PNG("png"),
    ;

    private String value;

    StartScreencastRequestFormat(String value) {
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

    public static StartScreencastRequestFormat findByValue(String value) {
        for(StartScreencastRequestFormat val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}