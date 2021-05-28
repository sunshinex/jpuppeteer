package jpuppeteer.cdp.client.constant.systeminfo;

/**
* Image format of a given image.
* experimental
*/
public enum ImageType implements jpuppeteer.cdp.client.CDPEnum {

    JPEG("jpeg"),
    WEBP("webp"),
    UNKNOWN("unknown"),
    ;

    private String value;

    ImageType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ImageType findByValue(String value) {
        for(ImageType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}