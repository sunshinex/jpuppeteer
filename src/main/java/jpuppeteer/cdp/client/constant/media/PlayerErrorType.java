package jpuppeteer.cdp.client.constant.media;

/**
* experimental
*/
public enum PlayerErrorType implements jpuppeteer.cdp.client.CDPEnum {

    PIPELINE_ERROR("pipeline_error"),
    MEDIA_ERROR("media_error"),
    ;

    private String value;

    PlayerErrorType(String value) {
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

    public static PlayerErrorType findByValue(String value) {
        for(PlayerErrorType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}