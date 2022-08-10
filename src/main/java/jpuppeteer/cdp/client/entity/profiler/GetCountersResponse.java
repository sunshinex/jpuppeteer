package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class GetCountersResponse {

    /**
    * Collected counters information.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.CounterInfo> result;

    public void setResult (java.util.List<jpuppeteer.cdp.client.entity.profiler.CounterInfo> result) {
        this.result = result;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.CounterInfo> getResult() {
        return this.result;
    }

    public GetCountersResponse(java.util.List<jpuppeteer.cdp.client.entity.profiler.CounterInfo> result) {
        this.result = result;
    }

    public GetCountersResponse() {
    }

}