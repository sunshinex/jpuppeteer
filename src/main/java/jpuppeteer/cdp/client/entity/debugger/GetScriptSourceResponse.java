package jpuppeteer.cdp.client.entity.debugger;

/**
*/
public class GetScriptSourceResponse {

    /**
    * Script source (empty in case of Wasm bytecode).
    */
    private String scriptSource;

    /**
    * Wasm bytecode. (Encoded as a base64 string when passed over JSON)
    */
    private String bytecode;

    public void setScriptSource (String scriptSource) {
        this.scriptSource = scriptSource;
    }

    public String getScriptSource() {
        return this.scriptSource;
    }

    public void setBytecode (String bytecode) {
        this.bytecode = bytecode;
    }

    public String getBytecode() {
        return this.bytecode;
    }

    public GetScriptSourceResponse(String scriptSource, String bytecode) {
        this.scriptSource = scriptSource;
        this.bytecode = bytecode;
    }

    public GetScriptSourceResponse(String scriptSource) {
        this.scriptSource = scriptSource;
        this.bytecode = null;
    }

    public GetScriptSourceResponse() {
    }

}