package jpuppeteer.cdp.client.entity.page;

/**
* Per-script compilation cache parameters for `Page.produceCompilationCache`
*/
public class CompilationCacheParams {

    /**
    * The URL of the script to produce a compilation cache entry for.
    */
    public final String url;

    /**
    * A hint to the backend whether eager compilation is recommended. (the actual compilation mode used is upon backend discretion).
    */
    public final Boolean eager;

    public CompilationCacheParams(String url, Boolean eager) {
        this.url = url;
        this.eager = eager;
    }

    public CompilationCacheParams(String url) {
        this.url = url;
        this.eager = null;
    }

}