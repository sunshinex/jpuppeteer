package jpuppeteer.cdp.client.entity.memory;

/**
* experimental
*/
public class GetBrowserSamplingProfileResponse {

    /**
    */
    private jpuppeteer.cdp.client.entity.memory.SamplingProfile profile;

    public void setProfile (jpuppeteer.cdp.client.entity.memory.SamplingProfile profile) {
        this.profile = profile;
    }

    public jpuppeteer.cdp.client.entity.memory.SamplingProfile getProfile() {
        return this.profile;
    }

    public GetBrowserSamplingProfileResponse(jpuppeteer.cdp.client.entity.memory.SamplingProfile profile) {
        this.profile = profile;
    }

    public GetBrowserSamplingProfileResponse() {
    }

}