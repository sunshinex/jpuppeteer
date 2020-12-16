package jpuppeteer.cdp.client.entity.page;

/**
*/
public class SetLifecycleEventsEnabledRequest {

    /**
    * If true, starts emitting lifecycle events.
    */
    public final Boolean enabled;

    public SetLifecycleEventsEnabledRequest(Boolean enabled) {
        this.enabled = enabled;
    }

}