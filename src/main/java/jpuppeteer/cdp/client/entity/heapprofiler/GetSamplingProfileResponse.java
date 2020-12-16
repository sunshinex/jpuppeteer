package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* experimental
*/
public class GetSamplingProfileResponse {

    /**
    * Return the sampling profile being collected.
    */
    public final SamplingHeapProfile profile;

    public GetSamplingProfileResponse(SamplingHeapProfile profile) {
        this.profile = profile;
    }

}