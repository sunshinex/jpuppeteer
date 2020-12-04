package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class DispatchPeriodicSyncEventRequest {

    /**
    */
    public final String origin;

    /**
    */
    public final String registrationId;

    /**
    */
    public final String tag;

    public DispatchPeriodicSyncEventRequest(String origin, String registrationId, String tag) {
        this.origin = origin;
        this.registrationId = registrationId;
        this.tag = tag;
    }

}