package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class GetRuntimeCallStatsResponse {

    /**
    * Collected runtime call counter information.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.RuntimeCallCounterInfo> result;

    public void setResult (java.util.List<jpuppeteer.cdp.client.entity.profiler.RuntimeCallCounterInfo> result) {
        this.result = result;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.RuntimeCallCounterInfo> getResult() {
        return this.result;
    }

    public GetRuntimeCallStatsResponse(java.util.List<jpuppeteer.cdp.client.entity.profiler.RuntimeCallCounterInfo> result) {
        this.result = result;
    }

    public GetRuntimeCallStatsResponse() {
    }

}