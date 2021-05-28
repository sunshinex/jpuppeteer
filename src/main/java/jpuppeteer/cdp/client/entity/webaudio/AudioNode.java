package jpuppeteer.cdp.client.entity.webaudio;

/**
* Protocol object for AudioNode
* experimental
*/
public class AudioNode {

    /**
    */
    public final String nodeId;

    /**
    */
    public final String contextId;

    /**
    */
    public final String nodeType;

    /**
    */
    public final java.math.BigDecimal numberOfInputs;

    /**
    */
    public final java.math.BigDecimal numberOfOutputs;

    /**
    */
    public final java.math.BigDecimal channelCount;

    /**
    */
    public final jpuppeteer.cdp.client.constant.webaudio.ChannelCountMode channelCountMode;

    /**
    */
    public final jpuppeteer.cdp.client.constant.webaudio.ChannelInterpretation channelInterpretation;

    public AudioNode(String nodeId, String contextId, String nodeType, java.math.BigDecimal numberOfInputs, java.math.BigDecimal numberOfOutputs, java.math.BigDecimal channelCount, jpuppeteer.cdp.client.constant.webaudio.ChannelCountMode channelCountMode, jpuppeteer.cdp.client.constant.webaudio.ChannelInterpretation channelInterpretation) {
        this.nodeId = nodeId;
        this.contextId = contextId;
        this.nodeType = nodeType;
        this.numberOfInputs = numberOfInputs;
        this.numberOfOutputs = numberOfOutputs;
        this.channelCount = channelCount;
        this.channelCountMode = channelCountMode;
        this.channelInterpretation = channelInterpretation;
    }

}