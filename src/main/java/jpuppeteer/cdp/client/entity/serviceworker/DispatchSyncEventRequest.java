package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class DispatchSyncEventRequest {

    /**
    */
    private String origin;

    /**
    */
    private String registrationId;

    /**
    */
    private String tag;

    /**
    */
    private Boolean lastChance;

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

    public void setLastChance (Boolean lastChance) {
        this.lastChance = lastChance;
    }

    public Boolean getLastChance() {
        return this.lastChance;
    }

    public DispatchSyncEventRequest(String origin, String registrationId, String tag, Boolean lastChance) {
        this.origin = origin;
        this.registrationId = registrationId;
        this.tag = tag;
        this.lastChance = lastChance;
    }

    public DispatchSyncEventRequest() {
    }

}