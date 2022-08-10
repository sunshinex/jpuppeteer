package jpuppeteer.cdp.client.entity.page;

/**
*/
public class ProduceCompilationCacheRequest {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.page.CompilationCacheParams> scripts;

    public void setScripts (java.util.List<jpuppeteer.cdp.client.entity.page.CompilationCacheParams> scripts) {
        this.scripts = scripts;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.page.CompilationCacheParams> getScripts() {
        return this.scripts;
    }

    public ProduceCompilationCacheRequest(java.util.List<jpuppeteer.cdp.client.entity.page.CompilationCacheParams> scripts) {
        this.scripts = scripts;
    }

    public ProduceCompilationCacheRequest() {
    }

}