package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class TakePreciseCoverageResponse {

    /**
    * Coverage data for the current isolate.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result;

    public TakePreciseCoverageResponse(java.util.List<jpuppeteer.cdp.client.entity.profiler.ScriptCoverage> result) {
        this.result = result;
    }

}