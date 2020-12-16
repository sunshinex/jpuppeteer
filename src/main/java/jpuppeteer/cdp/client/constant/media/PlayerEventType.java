package jpuppeteer.cdp.client.constant.media;

/**
* Break out events into different types
* experimental
*/
public enum PlayerEventType implements jpuppeteer.cdp.client.CDPEnum {

    PLAYBACKEVENT("playbackEvent"),
    SYSTEMEVENT("systemEvent"),
    MESSAGEEVENT("messageEvent"),
    ;

    private String value;

    PlayerEventType(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static PlayerEventType findByValue(String value) {
        for(PlayerEventType val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}