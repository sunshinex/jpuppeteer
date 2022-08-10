package jpuppeteer.cdp.client.entity.webaudio;

/**
* Protocol object for BaseAudioContext
* experimental
*/
public class BaseAudioContext {

    /**
    */
    private String contextId;

    /**
    */
    private jpuppeteer.cdp.client.constant.webaudio.ContextType contextType;

    /**
    */
    private jpuppeteer.cdp.client.constant.webaudio.ContextState contextState;

    /**
    */
    private jpuppeteer.cdp.client.entity.webaudio.ContextRealtimeData realtimeData;

    /**
    * Platform-dependent callback buffer size.
    */
    private java.math.BigDecimal callbackBufferSize;

    /**
    * Number of output channels supported by audio hardware in use.
    */
    private java.math.BigDecimal maxOutputChannelCount;

    /**
    * Context sample rate.
    */
    private java.math.BigDecimal sampleRate;

    public void setContextId (String contextId) {
        this.contextId = contextId;
    }

    public String getContextId() {
        return this.contextId;
    }

    public void setContextType (jpuppeteer.cdp.client.constant.webaudio.ContextType contextType) {
        this.contextType = contextType;
    }

    public jpuppeteer.cdp.client.constant.webaudio.ContextType getContextType() {
        return this.contextType;
    }

    public void setContextState (jpuppeteer.cdp.client.constant.webaudio.ContextState contextState) {
        this.contextState = contextState;
    }

    public jpuppeteer.cdp.client.constant.webaudio.ContextState getContextState() {
        return this.contextState;
    }

    public void setRealtimeData (jpuppeteer.cdp.client.entity.webaudio.ContextRealtimeData realtimeData) {
        this.realtimeData = realtimeData;
    }

    public jpuppeteer.cdp.client.entity.webaudio.ContextRealtimeData getRealtimeData() {
        return this.realtimeData;
    }

    public void setCallbackBufferSize (java.math.BigDecimal callbackBufferSize) {
        this.callbackBufferSize = callbackBufferSize;
    }

    public java.math.BigDecimal getCallbackBufferSize() {
        return this.callbackBufferSize;
    }

    public void setMaxOutputChannelCount (java.math.BigDecimal maxOutputChannelCount) {
        this.maxOutputChannelCount = maxOutputChannelCount;
    }

    public java.math.BigDecimal getMaxOutputChannelCount() {
        return this.maxOutputChannelCount;
    }

    public void setSampleRate (java.math.BigDecimal sampleRate) {
        this.sampleRate = sampleRate;
    }

    public java.math.BigDecimal getSampleRate() {
        return this.sampleRate;
    }

    public BaseAudioContext(String contextId, jpuppeteer.cdp.client.constant.webaudio.ContextType contextType, jpuppeteer.cdp.client.constant.webaudio.ContextState contextState, jpuppeteer.cdp.client.entity.webaudio.ContextRealtimeData realtimeData, java.math.BigDecimal callbackBufferSize, java.math.BigDecimal maxOutputChannelCount, java.math.BigDecimal sampleRate) {
        this.contextId = contextId;
        this.contextType = contextType;
        this.contextState = contextState;
        this.realtimeData = realtimeData;
        this.callbackBufferSize = callbackBufferSize;
        this.maxOutputChannelCount = maxOutputChannelCount;
        this.sampleRate = sampleRate;
    }

    public BaseAudioContext(String contextId, jpuppeteer.cdp.client.constant.webaudio.ContextType contextType, jpuppeteer.cdp.client.constant.webaudio.ContextState contextState, java.math.BigDecimal callbackBufferSize, java.math.BigDecimal maxOutputChannelCount, java.math.BigDecimal sampleRate) {
        this.contextId = contextId;
        this.contextType = contextType;
        this.contextState = contextState;
        this.realtimeData = null;
        this.callbackBufferSize = callbackBufferSize;
        this.maxOutputChannelCount = maxOutputChannelCount;
        this.sampleRate = sampleRate;
    }

    public BaseAudioContext() {
    }

}