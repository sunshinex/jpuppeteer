package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetScriptSourceResponse {

    /**
    * Script source (empty in case of Wasm bytecode).
    */
    public final String scriptSource;

    /**
    * Wasm bytecode.
    */
    public final String bytecode;

    public GetScriptSourceResponse(String scriptSource, String bytecode) {
        this.scriptSource = scriptSource;
        this.bytecode = bytecode;
    }

    public GetScriptSourceResponse(String scriptSource) {
        this.scriptSource = scriptSource;
        this.bytecode = null;
    }

}