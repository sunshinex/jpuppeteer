package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class GetBestEffortCoverageResponse {

    /**
    * Coverage data for the current isolate.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result;

    public void setResult (java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result) {
        this.result = result;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> getResult() {
        return this.result;
    }

    public GetBestEffortCoverageResponse(java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result) {
        this.result = result;
    }

    public GetBestEffortCoverageResponse() {
    }

}