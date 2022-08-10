package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class DeliverPushMessageRequest {

    /**
    */
    private String origin;

    /**
    */
    private String registrationId;

    /**
    */
    private String data;

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

    public void setData (String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public DeliverPushMessageRequest(String origin, String registrationId, String data) {
        this.origin = origin;
        this.registrationId = registrationId;
        this.data = data;
    }

    public DeliverPushMessageRequest() {
    }

}