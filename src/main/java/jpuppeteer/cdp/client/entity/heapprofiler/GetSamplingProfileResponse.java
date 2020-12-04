package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class GetSamplingProfileResponse {

    /**
    * Return the sampling profile being collected.
    */
    public final jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfile profile;

    public GetSamplingProfileResponse(jpuppeteer.cdp.client.entity.heapprofiler.SamplingHeapProfile profile) {
        this.profile = profile;
    }

}