package jpuppeteer.cdp.client.constant.headlessexperimental;

/**
* experimental
*/
public enum ScreenshotParamsFormat implements jpuppeteer.cdp.client.CDPEnum {

    JPEG("jpeg"),
    PNG("png"),
    ;

    private String value;

    ScreenshotParamsFormat(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ScreenshotParamsFormat findByValue(String value) {
        for(ScreenshotParamsFormat val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}