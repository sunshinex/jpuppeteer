package jpuppeteer.cdp.client.entity.input;

/**
*/
public class SetIgnoreInputEventsRequest {

    /**
    * Ignores input events processing when set to true.
    */
    public final Boolean ignore;

    public SetIgnoreInputEventsRequest(Boolean ignore) {
        this.ignore = ignore;
    }

}