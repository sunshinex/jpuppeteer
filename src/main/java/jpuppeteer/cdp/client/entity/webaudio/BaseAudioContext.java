package jpuppeteer.cdp.client.entity.webaudio;

/**
* Protocol object for BaseAudioContext
* experimental
*/
public class BaseAudioContext {

    /**
    */
    public final String contextId;

    /**
    */
    public final jpuppeteer.cdp.client.constant.webaudio.ContextType contextType;

    /**
    */
    public final jpuppeteer.cdp.client.constant.webaudio.ContextState contextState;

    /**
    */
    public final ContextRealtimeData realtimeData;

    /**
    * Platform-dependent callback buffer size.
    */
    public final java.math.BigDecimal callbackBufferSize;

    /**
    * Number of output channels supported by audio hardware in use.
    */
    public final java.math.BigDecimal maxOutputChannelCount;

    /**
    * Context sample rate.
    */
    public final java.math.BigDecimal sampleRate;

    public BaseAudioContext(String contextId, jpuppeteer.cdp.client.constant.webaudio.ContextType contextType, jpuppeteer.cdp.client.constant.webaudio.ContextState contextState, ContextRealtimeData realtimeData, java.math.BigDecimal callbackBufferSize, java.math.BigDecimal maxOutputChannelCount, java.math.BigDecimal sampleRate) {
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

}