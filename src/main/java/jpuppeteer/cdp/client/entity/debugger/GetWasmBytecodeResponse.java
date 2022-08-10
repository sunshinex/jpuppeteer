package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetWasmBytecodeResponse {

    /**
    * Script source. (Encoded as a base64 string when passed over JSON)
    */
    private String bytecode;

    public void setBytecode (String bytecode) {
        this.bytecode = bytecode;
    }

    public String getBytecode() {
        return this.bytecode;
    }

    public GetWasmBytecodeResponse(String bytecode) {
        this.bytecode = bytecode;
    }

    public GetWasmBytecodeResponse() {
    }

}