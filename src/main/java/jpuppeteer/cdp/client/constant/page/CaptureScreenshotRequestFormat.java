package jpuppeteer.cdp.client.constant.page;

/**
*/
public enum CaptureScreenshotRequestFormat implements jpuppeteer.cdp.client.CDPEnum {

    JPEG("jpeg"),
    PNG("png"),
    ;

    private String value;

    CaptureScreenshotRequestFormat(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static CaptureScreenshotRequestFormat findByValue(String value) {
        for(CaptureScreenshotRequestFormat val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}