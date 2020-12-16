package jpuppeteer.cdp.client.entity.profiler;

/**
*/
public class GetBestEffortCoverageResponse {

    /**
    * Coverage data for the current isolate.
    */
    public final java.util.List<ScriptCoverage> result;

    public GetBestEffortCoverageResponse(java.util.List<ScriptCoverage> result) {
        this.result = result;
    }

}