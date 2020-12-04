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
    public final String contextType;

    /**
    */
    public final String contextState;

    /**
    */
    public final jpuppeteer.cdp.client.entity.webaudio.ContextRealtimeData realtimeData;

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

    public BaseAudioContext(String contextId, String contextType, String contextState, jpuppeteer.cdp.client.entity.webaudio.ContextRealtimeData realtimeData, java.math.BigDecimal callbackBufferSize, java.math.BigDecimal maxOutputChannelCount, java.math.BigDecimal sampleRate) {
        this.contextId = contextId;
        this.contextType = contextType;
        this.contextState = contextState;
        this.realtimeData = realtimeData;
        this.callbackBufferSize = callbackBufferSize;
        this.maxOutputChannelCount = maxOutputChannelCount;
        this.sampleRate = sampleRate;
    }

    public BaseAudioContext(String contextId, String contextType, String contextState, java.math.BigDecimal callbackBufferSize, java.math.BigDecimal maxOutputChannelCount, java.math.BigDecimal sampleRate) {
        this.contextId = contextId;
        this.contextType = contextType;
        this.contextState = contextState;
        this.realtimeData = null;
        this.callbackBufferSize = callbackBufferSize;
        this.maxOutputChannelCount = maxOutputChannelCount;
        this.sampleRate = sampleRate;
    }

}