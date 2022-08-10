package jpuppeteer.cdp.client.entity.network;

/**
*/
public class CanEmulateNetworkConditionsResponse {

    /**
    * True if emulation of network conditions is supported.
    */
    private Boolean result;

    public void setResult (Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return this.result;
    }

    public CanEmulateNetworkConditionsResponse(Boolean result) {
        this.result = result;
    }

    public CanEmulateNetworkConditionsResponse() {
    }

}