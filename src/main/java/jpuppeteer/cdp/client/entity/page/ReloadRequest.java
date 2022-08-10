package jpuppeteer.cdp.client.entity.page;

/**
*/
public class ReloadRequest {

    /**
    * If true, browser cache is ignored (as if the user pressed Shift+refresh).
    */
    private Boolean ignoreCache;

    /**
    * If set, the script will be injected into all frames of the inspected page after reload. Argument will be ignored if reloading dataURL origin.
    */
    private String scriptToEvaluateOnLoad;

    public void setIgnoreCache (Boolean ignoreCache) {
        this.ignoreCache = ignoreCache;
    }

    public Boolean getIgnoreCache() {
        return this.ignoreCache;
    }

    public void setScriptToEvaluateOnLoad (String scriptToEvaluateOnLoad) {
        this.scriptToEvaluateOnLoad = scriptToEvaluateOnLoad;
    }

    public String getScriptToEvaluateOnLoad() {
        return this.scriptToEvaluateOnLoad;
    }

    public ReloadRequest(Boolean ignoreCache, String scriptToEvaluateOnLoad) {
        this.ignoreCache = ignoreCache;
        this.scriptToEvaluateOnLoad = scriptToEvaluateOnLoad;
    }

    public ReloadRequest() {
        this.ignoreCache = null;
        this.scriptToEvaluateOnLoad = null;
    }

}