package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class StopResponse {

    /**
    * Recorded profile.
    */
    private jpuppeteer.cdp.client.entity.profiler.Profile profile;

    public void setProfile (jpuppeteer.cdp.client.entity.profiler.Profile profile) {
        this.profile = profile;
    }

    public jpuppeteer.cdp.client.entity.profiler.Profile getProfile() {
        return this.profile;
    }

    public StopResponse(jpuppeteer.cdp.client.entity.profiler.Profile profile) {
        this.profile = profile;
    }

    public StopResponse() {
    }

}