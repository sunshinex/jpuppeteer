package jpuppeteer.cdp.client.entity.memory;

/**
* experimental
*/
public class GetAllTimeSamplingProfileResponse {

    /**
    */
    private jpuppeteer.cdp.client.entity.memory.SamplingProfile profile;

    public void setProfile (jpuppeteer.cdp.client.entity.memory.SamplingProfile profile) {
        this.profile = profile;
    }

    public jpuppeteer.cdp.client.entity.memory.SamplingProfile getProfile() {
        return this.profile;
    }

    public GetAllTimeSamplingProfileResponse(jpuppeteer.cdp.client.entity.memory.SamplingProfile profile) {
        this.profile = profile;
    }

    public GetAllTimeSamplingProfileResponse() {
    }

}