package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class GetRuntimeCallStatsResponse {

    /**
    * Collected counter information.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.profiler.CounterInfo> result;

    public GetRuntimeCallStatsResponse(java.util.List<jpuppeteer.cdp.client.entity.profiler.CounterInfo> result) {
        this.result = result;
    }

}