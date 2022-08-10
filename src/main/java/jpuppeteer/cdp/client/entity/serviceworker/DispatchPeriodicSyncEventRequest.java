package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class DispatchPeriodicSyncEventRequest {

    /**
    */
    private String origin;

    /**
    */
    private String registrationId;

    /**
    */
    private String tag;

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setRegistrationId (String registrationId) {
        this.registrationId = registrationId;
    }

    public String getRegistrationId() {
        return this.registrationId;
    }

    public void setTag (String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return this.tag;
    }

    public DispatchPeriodicSyncEventRequest(String origin, String registrationId, String tag) {
        this.origin = origin;
        this.registrationId = registrationId;
        this.tag = tag;
    }

    public DispatchPeriodicSyncEventRequest() {
    }

}