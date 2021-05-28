package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class EnableRequest {

    /**
    * The maximum size in bytes of collected scripts (not referenced by other heap objects) the debugger can hold. Puts no limit if paramter is omitted.
    */
    public final java.math.BigDecimal maxScriptsCacheSize;

    public EnableRequest(java.math.BigDecimal maxScriptsCacheSize) {
        this.maxScriptsCacheSize = maxScriptsCacheSize;
    }

    public EnableRequest() {
        this.maxScriptsCacheSize = null;
    }

}