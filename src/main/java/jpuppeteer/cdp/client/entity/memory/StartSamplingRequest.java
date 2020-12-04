package jpuppeteer.cdp.client.entity.memory;

/**
* experimental
*/
public class StartSamplingRequest {

    /**
    * Average number of bytes between samples.
    */
    public final Integer samplingInterval;

    /**
    * Do not randomize intervals between samples.
    */
    public final Boolean suppressRandomness;

    public StartSamplingRequest(Integer samplingInterval, Boolean suppressRandomness) {
        this.samplingInterval = samplingInterval;
        this.suppressRandomness = suppressRandomness;
    }

    public StartSamplingRequest() {
        this.samplingInterval = null;
        this.suppressRandomness = null;
    }

}