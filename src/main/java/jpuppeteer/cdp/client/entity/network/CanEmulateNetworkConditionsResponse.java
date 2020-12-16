package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CanEmulateNetworkConditionsResponse {

    /**
    * True if emulation of network conditions is supported.
    */
    public final Boolean result;

    public CanEmulateNetworkConditionsResponse(Boolean result) {
        this.result = result;
    }

}