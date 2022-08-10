package jpuppeteer.cdp.client.entity.debugger;

/**
* Debug symbols available for a wasm script.
*/
public class DebugSymbols {

    /**
    * Type of the debug symbols.
    */
    private jpuppeteer.cdp.client.constant.debugger.DebugSymbolsType type;

    /**
    * URL of the external symbol source.
    */
    private String externalURL;

    public void setType (jpuppeteer.cdp.client.constant.debugger.DebugSymbolsType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.debugger.DebugSymbolsType getType() {
        return this.type;
    }

    public void setExternalURL (String externalURL) {
        this.externalURL = externalURL;
    }

    public String getExternalURL() {
        return this.externalURL;
    }

    public DebugSymbols(jpuppeteer.cdp.client.constant.debugger.DebugSymbolsType type, String externalURL) {
        this.type = type;
        this.externalURL = externalURL;
    }

    public DebugSymbols(jpuppeteer.cdp.client.constant.debugger.DebugSymbolsType type) {
        this.type = type;
        this.externalURL = null;
    }

    public DebugSymbols() {
    }

}