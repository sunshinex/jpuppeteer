package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class StopResponse {

    /**
    * Recorded profile.
    */
    public final Profile profile;

    public StopResponse(Profile profile) {
        this.profile = profile;
    }

}