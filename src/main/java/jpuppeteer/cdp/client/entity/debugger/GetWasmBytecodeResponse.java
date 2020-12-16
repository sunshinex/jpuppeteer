package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetWasmBytecodeResponse {

    /**
    * Script source.
    */
    public final String bytecode;

    public GetWasmBytecodeResponse(String bytecode) {
        this.bytecode = bytecode;
    }

}