package jpuppeteer.cdp.client.entity.webaudio;

/**
* Protocol object for AudioNode
* experimental
*/
public class AudioNode {

    /**
    */
    private String nodeId;

    /**
    */
    private String contextId;

    /**
    */
    private String nodeType;

    /**
    */
    private java.math.BigDecimal numberOfInputs;

    /**
    */
    private java.math.BigDecimal numberOfOutputs;

    /**
    */
    private java.math.BigDecimal channelCount;

    /**
    */
    private jpuppeteer.cdp.client.constant.webaudio.ChannelCountMode channelCountMode;

    /**
    */
    private jpuppeteer.cdp.client.constant.webaudio.ChannelInterpretation channelInterpretation;

    public void setNodeId (String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public void setContextId (String contextId) {
        this.contextId = contextId;
    }

    public String getContextId() {
        return this.contextId;
    }

    public void setNodeType (String nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeType() {
        return this.nodeType;
    }

    public void setNumberOfInputs (java.math.BigDecimal numberOfInputs) {
        this.numberOfInputs = numberOfInputs;
    }

    public java.math.BigDecimal getNumberOfInputs() {
        return this.numberOfInputs;
    }

    public void setNumberOfOutputs (java.math.BigDecimal numberOfOutputs) {
        this.numberOfOutputs = numberOfOutputs;
    }

    public java.math.BigDecimal getNumberOfOutputs() {
        return this.numberOfOutputs;
    }

    public void setChannelCount (java.math.BigDecimal channelCount) {
        this.channelCount = channelCount;
    }

    public java.math.BigDecimal getChannelCount() {
        return this.channelCount;
    }

    public void setChannelCountMode (jpuppeteer.cdp.client.constant.webaudio.ChannelCountMode channelCountMode) {
        this.channelCountMode = channelCountMode;
    }

    public jpuppeteer.cdp.client.constant.webaudio.ChannelCountMode getChannelCountMode() {
        return this.channelCountMode;
    }

    public void setChannelInterpretation (jpuppeteer.cdp.client.constant.webaudio.ChannelInterpretation channelInterpretation) {
        this.channelInterpretation = channelInterpretation;
    }

    public jpuppeteer.cdp.client.constant.webaudio.ChannelInterpretation getChannelInterpretation() {
        return this.channelInterpretation;
    }

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

    public AudioNode() {
    }

}