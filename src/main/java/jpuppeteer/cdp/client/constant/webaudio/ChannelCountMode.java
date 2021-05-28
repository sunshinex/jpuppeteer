package jpuppeteer.cdp.client.constant.webaudio;

/**
* Enum of AudioNode::ChannelCountMode from the spec
* experimental
*/
public enum ChannelCountMode implements jpuppeteer.cdp.client.CDPEnum {

    CLAMPED_MAX("clamped-max"),
    EXPLICIT("explicit"),
    MAX("max"),
    ;

    private String value;

    ChannelCountMode(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ChannelCountMode findByValue(String value) {
        for(ChannelCountMode val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}