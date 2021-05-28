package jpuppeteer.cdp.client.constant.media;

/**
* experimental
*/
public enum PlayerMessageLevel implements jpuppeteer.cdp.client.CDPEnum {

    ERROR("error"),
    WARNING("warning"),
    INFO("info"),
    DEBUG("debug"),
    ;

    private String value;

    PlayerMessageLevel(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static PlayerMessageLevel findByValue(String value) {
        for(PlayerMessageLevel val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}