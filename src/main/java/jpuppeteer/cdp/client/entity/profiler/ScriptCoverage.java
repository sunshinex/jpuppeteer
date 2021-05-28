package jpuppeteer.cdp.client.entity.profiler;

/**
* Coverage data for a JavaScript script.
*/
public class ScriptCoverage {

    /**
    * JavaScript script id.
    */
    public final String scriptId;

    /**
    * JavaScript script name or url.
    */
    public final String url;

    /**
    * Functions contained in the script that has coverage data.
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.profiler.FunctionCoverage> functions;

    public ScriptCoverage(String scriptId, String url, java.util.List<jpuppeteer.cdp.client.entity.profiler.FunctionCoverage> functions) {
        this.scriptId = scriptId;
        this.url = url;
        this.functions = functions;
    }

}