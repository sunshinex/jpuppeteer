package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class StartPreciseCoverageRequest {

    /**
    * Collect accurate call counts beyond simple 'covered' or 'not covered'.
    */
    public final Boolean callCount;

    /**
    * Collect block-based coverage.
    */
    public final Boolean detailed;

    /**
    * Allow the backend to send updates on its own initiative
    */
    public final Boolean allowTriggeredUpdates;

    public StartPreciseCoverageRequest(Boolean callCount, Boolean detailed, Boolean allowTriggeredUpdates) {
        this.callCount = callCount;
        this.detailed = detailed;
        this.allowTriggeredUpdates = allowTriggeredUpdates;
    }

    public StartPreciseCoverageRequest() {
        this.callCount = null;
        this.detailed = null;
        this.allowTriggeredUpdates = null;
    }

}