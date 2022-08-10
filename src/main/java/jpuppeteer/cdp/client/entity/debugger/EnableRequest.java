package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class EnableRequest {

    /**
    * The maximum size in bytes of collected scripts (not referenced by other heap objects) the debugger can hold. Puts no limit if paramter is omitted.
    */
    private java.math.BigDecimal maxScriptsCacheSize;

    public void setMaxScriptsCacheSize (java.math.BigDecimal maxScriptsCacheSize) {
        this.maxScriptsCacheSize = maxScriptsCacheSize;
    }

    public java.math.BigDecimal getMaxScriptsCacheSize() {
        return this.maxScriptsCacheSize;
    }

    public EnableRequest(java.math.BigDecimal maxScriptsCacheSize) {
        this.maxScriptsCacheSize = maxScriptsCacheSize;
    }

    public EnableRequest() {
        this.maxScriptsCacheSize = null;
    }

}