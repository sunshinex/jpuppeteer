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
    public final String channelCountMode;

    /**
    */
    public final String channelInterpretation;

    public AudioNode(String nodeId, String contextId, String nodeType, java.math.BigDecimal numberOfInputs, java.math.BigDecimal numberOfOutputs, java.math.BigDecimal channelCount, String channelCountMode, String channelInterpretation) {
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