package jpuppeteer.cdp.client.entity.profiler;

/**
* Type profile data collected during runtime for a JavaScript script.
*/
public class ScriptTypeProfile {

    /**
    * JavaScript script id.
    */
    private String scriptId;

    /**
    * JavaScript script name or url.
    */
    private String url;

    /**
    * Type profile entries for parameters and return values of the functions in the script.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.profiler.TypeProfileEntry> entries;

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

    public void setEntries (java.util.List<jpuppeteer.cdp.client.entity.profiler.TypeProfileEntry> entries) {
        this.entries = entries;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.profiler.TypeProfileEntry> getEntries() {
        return this.entries;
    }

    public ScriptTypeProfile(String scriptId, String url, java.util.List<jpuppeteer.cdp.client.entity.profiler.TypeProfileEntry> entries) {
        this.scriptId = scriptId;
        this.url = url;
        this.entries = entries;
    }

    public ScriptTypeProfile() {
    }

}