package jpuppeteer.cdp.client.entity.serviceworker;

/**
* experimental
*/
public class DeliverPushMessageRequest {

    /**
    */
    public final String origin;

    /**
    */
    public final String registrationId;

    /**
    */
    public final String data;

    public DeliverPushMessageRequest(String origin, String registrationId, String data) {
        this.origin = origin;
        this.registrationId = registrationId;
        this.data = data;
    }

}