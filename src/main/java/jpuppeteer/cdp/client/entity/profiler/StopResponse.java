package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class StopResponse {

    /**
    * Recorded profile.
    */
    public final jpuppeteer.cdp.client.entity.profiler.Profile profile;

    public StopResponse(jpuppeteer.cdp.client.entity.profiler.Profile profile) {
        this.profile = profile;
    }

}