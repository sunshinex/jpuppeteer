package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class StopSamplingResponse {

    /**
    * Recorded sampling heap profile.
    */
    public final jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfile profile;

    public StopSamplingResponse(jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfile profile) {
        this.profile = profile;
    }

}