package jpuppeteer.cdp.client.entity.debugger;

/**
* Debug symbols available for a wasm script.
*/
public class DebugSymbols {

    /**
    * Type of the debug symbols.
    */
    public final jpuppeteer.cdp.client.constant.debugger.DebugSymbolsType type;

    /**
    * URL of the external symbol source.
    */
    public final String externalURL;

    public DebugSymbols(jpuppeteer.cdp.client.constant.debugger.DebugSymbolsType type, String externalURL) {
        this.type = type;
        this.externalURL = externalURL;
    }

    public DebugSymbols(jpuppeteer.cdp.client.constant.debugger.DebugSymbolsType type) {
        this.type = type;
        this.externalURL = null;
    }

}