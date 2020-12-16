package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class StopSamplingResponse {

    /**
    * Recorded sampling heap profile.
    */
    public final SamplingHeapProfile profile;

    public StopSamplingResponse(SamplingHeapProfile profile) {
        this.profile = profile;
    }

}