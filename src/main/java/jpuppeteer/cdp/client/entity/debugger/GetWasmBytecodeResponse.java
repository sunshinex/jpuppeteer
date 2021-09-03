package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetWasmBytecodeResponse {

    /**
    * Script source. (Encoded as a base64 string when passed over JSON)
    */
    public final String bytecode;

    public GetWasmBytecodeResponse(String bytecode) {
        this.bytecode = bytecode;
    }

}