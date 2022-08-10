package jpuppeteer.cdp.client.entity.input;

/**
*/
public class SetIgnoreInputEventsRequest {

    /**
    * Ignores input events processing when set to true.
    */
    private Boolean ignore;

    public void setIgnore (Boolean ignore) {
        this.ignore = ignore;
    }

    public Boolean getIgnore() {
        return this.ignore;
    }

    public SetIgnoreInputEventsRequest(Boolean ignore) {
        this.ignore = ignore;
    }

    public SetIgnoreInputEventsRequest() {
    }

}