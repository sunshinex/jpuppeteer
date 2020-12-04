package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class DispatchSyncEventRequest {

    /**
    */
    public final String origin;

    /**
    */
    public final String registrationId;

    /**
    */
    public final String tag;

    /**
    */
    public final Boolean lastChance;

    public DispatchSyncEventRequest(String origin, String registrationId, String tag, Boolean lastChance) {
        this.origin = origin;
        this.registrationId = registrationId;
        this.tag = tag;
        this.lastChance = lastChance;
    }

}