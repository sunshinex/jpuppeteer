package jpuppeteer.cdp.client.entity.webaudio;

/**
* Fields in AudioContext that change in real-time.
* experimental
*/
public class ContextRealtimeData {

    /**
    * The current context time in second in BaseAudioContext.
    */
    public final java.math.BigDecimal currentTime;

    /**
    * The time spent on rendering graph divided by render quantum duration, and multiplied by 100. 100 means the audio renderer reached the full capacity and glitch may occur.
    */
    public final java.math.BigDecimal renderCapacity;

    /**
    * A running mean of callback interval.
    */
    public final java.math.BigDecimal callbackIntervalMean;

    /**
    * A running variance of callback interval.
    */
    public final java.math.BigDecimal callbackIntervalVariance;

    public ContextRealtimeData(java.math.BigDecimal currentTime, java.math.BigDecimal renderCapacity, java.math.BigDecimal callbackIntervalMean, java.math.BigDecimal callbackIntervalVariance) {
        this.currentTime = currentTime;
        this.renderCapacity = renderCapacity;
        this.callbackIntervalMean = callbackIntervalMean;
        this.callbackIntervalVariance = callbackIntervalVariance;
    }

}