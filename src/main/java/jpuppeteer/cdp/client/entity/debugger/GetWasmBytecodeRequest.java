package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetWasmBytecodeRequest {

    /**
    * Id of the Wasm script to get source for.
    */
    private String scriptId;

    public void setScriptId (String scriptId) {
        this.scriptId = scriptId;
    }

    public String getScriptId() {
        return this.scriptId;
    }

    public GetWasmBytecodeRequest(String scriptId) {
        this.scriptId = scriptId;
    }

    public GetWasmBytecodeRequest() {
    }

}