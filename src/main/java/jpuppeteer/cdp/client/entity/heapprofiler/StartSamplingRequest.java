package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class StartSamplingRequest {

    /**
    * Average sample interval in bytes. Poisson distribution is used for the intervals. The default value is 32768 bytes.
    */
    public final java.math.BigDecimal samplingInterval;

    public StartSamplingRequest(java.math.BigDecimal samplingInterval) {
        this.samplingInterval = samplingInterval;
    }

    public StartSamplingRequest() {
        this.samplingInterval = null;
    }

}