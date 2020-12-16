package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class GetRuntimeCallStatsResponse {

    /**
    * Collected counter information.
    */
    public final java.util.List<CounterInfo> result;

    public GetRuntimeCallStatsResponse(java.util.List<CounterInfo> result) {
        this.result = result;
    }

}