package jpuppeteer.cdp.client.entity.page;

/**
* Per-script compilation cache parameters for `Page.produceCompilationCache`
*/
public class CompilationCacheParams {

    /**
    * The URL of the script to produce a compilation cache entry for.
    */
    private String url;

    /**
    * A hint to the backend whether eager compilation is recommended. (the actual compilation mode used is upon backend discretion).
    */
    private Boolean eager;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setEager (Boolean eager) {
        this.eager = eager;
    }

    public Boolean getEager() {
        return this.eager;
    }

    public CompilationCacheParams(String url, Boolean eager) {
        this.url = url;
        this.eager = eager;
    }

    public CompilationCacheParams(String url) {
        this.url = url;
        this.eager = null;
    }

    public CompilationCacheParams() {
    }

}