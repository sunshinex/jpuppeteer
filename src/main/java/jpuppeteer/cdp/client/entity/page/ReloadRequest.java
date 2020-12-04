package jpuppeteer.cdp.client.entity.page;

/**
*/
public class ReloadRequest {

    /**
    * If true, browser cache is ignored (as if the user pressed Shift+refresh).
    */
    public final Boolean ignoreCache;

    /**
    * If set, the script will be injected into all frames of the inspected page after reload. Argument will be ignored if reloading dataURL origin.
    */
    public final String scriptToEvaluateOnLoad;

    public ReloadRequest(Boolean ignoreCache, String scriptToEvaluateOnLoad) {
        this.ignoreCache = ignoreCache;
        this.scriptToEvaluateOnLoad = scriptToEvaluateOnLoad;
    }

    public ReloadRequest() {
        this.ignoreCache = null;
        this.scriptToEvaluateOnLoad = null;
    }

}