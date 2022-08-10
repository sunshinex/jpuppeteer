package jpuppeteer.cdp.client.entity.profiler;

/**
* Coverage data for a JavaScript script.
*/
public class ScriptCoverage {

    /**
    * JavaScript script id.
    */
    private String scriptId;

    /**
    * JavaScript script name or url.
    */
    private String url;

    /**
    * Functions contained in the script that has coverage data.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.FunctionCoverage> functions;

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setFunctions (java.util.List<jpuppeteer.cdp.client.entity.profiler.FunctionCoverage> functions) {
        this.functions = functions;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.FunctionCoverage> getFunctions() {
        return this.functions;
    }

    public ScriptCoverage(String scriptId, String url, java.util.List<jpuppeteer.cdp.client.entity.profiler.FunctionCoverage> functions) {
        this.scriptId = scriptId;
        this.url = url;
        this.functions = functions;
    }

    public ScriptCoverage() {
    }

}