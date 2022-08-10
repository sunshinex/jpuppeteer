package jpuppeteer.cdp.client.entity.memory;

/**
* experimental
*/
public class StartSamplingRequest {

    /**
    * Average number of bytes between samples.
    */
    private Integer samplingInterval;

    /**
    * Do not randomize intervals between samples.
    */
    private Boolean suppressRandomness;

    public void setSamplingInterval (Integer samplingInterval) {
        this.samplingInterval = samplingInterval;
    }

    public Integer getSamplingInterval() {
        return this.samplingInterval;
    }

    public void setSuppressRandomness (Boolean suppressRandomness) {
        this.suppressRandomness = suppressRandomness;
    }

    public Boolean getSuppressRandomness() {
        return this.suppressRandomness;
    }

    public StartSamplingRequest(Integer samplingInterval, Boolean suppressRandomness) {
        this.samplingInterval = samplingInterval;
        this.suppressRandomness = suppressRandomness;
    }

    public StartSamplingRequest() {
        this.samplingInterval = null;
        this.suppressRandomness = null;
    }

}