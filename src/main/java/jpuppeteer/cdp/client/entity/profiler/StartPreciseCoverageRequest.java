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

    public StartPreciseCoverageRequest(Boolean callCount, Boolean detailed) {
        this.callCount = callCount;
        this.detailed = detailed;
    }

    public StartPreciseCoverageRequest() {
        this.callCount = null;
        this.detailed = null;
    }

}