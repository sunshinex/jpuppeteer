package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class CanEmulateResponse {

    /**
    * True if emulation is supported.
    */
    private Boolean result;

    public void setResult (Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return this.result;
    }

    public CanEmulateResponse(Boolean result) {
        this.result = result;
    }

    public CanEmulateResponse() {
    }

}