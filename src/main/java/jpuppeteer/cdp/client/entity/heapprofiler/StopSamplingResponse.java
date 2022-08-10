package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class StopSamplingResponse {

    /**
    * Recorded sampling heap profile.
    */
    private jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfile profile;

    public void setProfile (jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfile profile) {
        this.profile = profile;
    }

    public jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfile getProfile() {
        return this.profile;
    }

    public StopSamplingResponse(jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfile profile) {
        this.profile = profile;
    }

    public StopSamplingResponse() {
    }

}