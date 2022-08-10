package jpuppeteer.cdp.client.entity.webaudio;

/**
* Fields in AudioContext that change in real-time.
* experimental
*/
public class ContextRealtimeData {

    /**
    * The current context time in second in BaseAudioContext.
    */
    private java.math.BigDecimal currentTime;

    /**
    * The time spent on rendering graph divided by render quantum duration, and multiplied by 100. 100 means the audio renderer reached the full capacity and glitch may occur.
    */
    private java.math.BigDecimal renderCapacity;

    /**
    * A running mean of callback interval.
    */
    private java.math.BigDecimal callbackIntervalMean;

    /**
    * A running variance of callback interval.
    */
    private java.math.BigDecimal callbackIntervalVariance;

    public void setCurrentTime (java.math.BigDecimal currentTime) {
        this.currentTime = currentTime;
    }

    public java.math.BigDecimal getCurrentTime() {
        return this.currentTime;
    }

    public void setRenderCapacity (java.math.BigDecimal renderCapacity) {
        this.renderCapacity = renderCapacity;
    }

    public java.math.BigDecimal getRenderCapacity() {
        return this.renderCapacity;
    }

    public void setCallbackIntervalMean (java.math.BigDecimal callbackIntervalMean) {
        this.callbackIntervalMean = callbackIntervalMean;
    }

    public java.math.BigDecimal getCallbackIntervalMean() {
        return this.callbackIntervalMean;
    }

    public void setCallbackIntervalVariance (java.math.BigDecimal callbackIntervalVariance) {
        this.callbackIntervalVariance = callbackIntervalVariance;
    }

    public java.math.BigDecimal getCallbackIntervalVariance() {
        return this.callbackIntervalVariance;
    }

    public ContextRealtimeData(java.math.BigDecimal currentTime, java.math.BigDecimal renderCapacity, java.math.BigDecimal callbackIntervalMean, java.math.BigDecimal callbackIntervalVariance) {
        this.currentTime = currentTime;
        this.renderCapacity = renderCapacity;
        this.callbackIntervalMean = callbackIntervalMean;
        this.callbackIntervalVariance = callbackIntervalVariance;
    }

    public ContextRealtimeData() {
    }

}