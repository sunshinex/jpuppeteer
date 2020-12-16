package jpuppeteer.cdp.client.entity.emulation;

/**
*/
public class CanEmulateResponse {

    /**
    * True if emulation is supported.
    */
    public final Boolean result;

    public CanEmulateResponse(Boolean result) {
        this.result = result;
    }

}