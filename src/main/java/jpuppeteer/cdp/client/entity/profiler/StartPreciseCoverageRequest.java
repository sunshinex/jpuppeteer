package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class StartPreciseCoverageRequest {

    /**
    * Collect accurate call counts beyond simple 'covered' or 'not covered'.
    */
    private Boolean callCount;

    /**
    * Collect block-based coverage.
    */
    private Boolean detailed;

    /**
    * Allow the backend to send updates on its own initiative
    */
    private Boolean allowTriggeredUpdates;

    public void setCallCount (Boolean callCount) {
        this.callCount = callCount;
    }

    public Boolean getCallCount() {
        return this.callCount;
    }

    public void setDetailed (Boolean detailed) {
        this.detailed = detailed;
    }

    public Boolean getDetailed() {
        return this.detailed;
    }

    public void setAllowTriggeredUpdates (Boolean allowTriggeredUpdates) {
        this.allowTriggeredUpdates = allowTriggeredUpdates;
    }

    public Boolean getAllowTriggeredUpdates() {
        return this.allowTriggeredUpdates;
    }

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