package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetLifecycleEventsEnabledRequest {

    /**
    * If true, starts emitting lifecycle events.
    */
    private Boolean enabled;

    public void setEnabled (Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public SetLifecycleEventsEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
    }

    public SetLifecycleEventsEnabledRequest() {
    }

}