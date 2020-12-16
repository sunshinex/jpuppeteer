package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class TakePreciseCoverageResponse {

    /**
    * Coverage data for the current isolate.
    */
    public final java.util.List<ScriptCoverage> result;

    public TakePreciseCoverageResponse(java.util.List<ScriptCoverage> result) {
        this.result = result;
    }

}