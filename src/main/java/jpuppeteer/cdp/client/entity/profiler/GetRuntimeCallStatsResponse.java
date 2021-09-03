package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class GetRuntimeCallStatsResponse {

    /**
    * Collected runtime call counter information.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.profiler.RuntimeCallCounterInfo> result;

    public GetRuntimeCallStatsResponse(java.util.List<jpuppeteer.cdp.client.entity.profiler.RuntimeCallCounterInfo> result) {
        this.result = result;
    }

}