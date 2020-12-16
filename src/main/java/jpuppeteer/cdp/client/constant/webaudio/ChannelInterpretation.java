package jpuppeteer.cdp.client.constant.webaudio;

/**
* Enum of AudioNode::ChannelInterpretation from the spec
* experimental
*/
public enum ChannelInterpretation implements jpuppeteer.cdp.client.CDPEnum {

    DISCRETE("discrete"),
    SPEAKERS("speakers"),
    ;

    private String value;

    ChannelInterpretation(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public static ChannelInterpretation findByValue(String value) {
        for(ChannelInterpretation val : values()) {
            if (val.value.equals(value)) return val;
        }
        return null;
    }
}