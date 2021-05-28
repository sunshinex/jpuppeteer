package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class GetCountersResponse {

    /**
    * Collected counters information.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.profiler.CounterInfo> result;

    public GetCountersResponse(java.util.List<jpuppeteer.cdp.client.entity.profiler.CounterInfo> result) {
        this.result = result;
    }

}