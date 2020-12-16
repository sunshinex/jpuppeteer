package jpuppeteer.cdp.client.entity.profiler;

/**
* Type profile data collected during runtime for a JavaScript script.
*/
public class ScriptTypeProfile {

    /**
    * JavaScript script id.
    */
    public final String scriptId;

    /**
    * JavaScript script name or url.
    */
    public final String url;

    /**
    * Type profile entries for parameters and return values of the functions in the script.
    */
    public final java.util.List<TypeProfileEntry> entries;

    public ScriptTypeProfile(String scriptId, String url, java.util.List<TypeProfileEntry> entries) {
        this.scriptId = scriptId;
        this.url = url;
        this.entries = entries;
    }

}