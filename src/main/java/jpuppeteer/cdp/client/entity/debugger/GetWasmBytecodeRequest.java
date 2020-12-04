package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetWasmBytecodeRequest {

    /**
    * Id of the Wasm script to get source for.
    */
    public final String scriptId;

    public GetWasmBytecodeRequest(String scriptId) {
        this.scriptId = scriptId;
    }

}