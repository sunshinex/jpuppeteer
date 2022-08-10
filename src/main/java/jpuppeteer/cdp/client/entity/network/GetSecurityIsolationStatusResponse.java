package jpuppeteer.cdp.client.entity.network;

/**
*/
public class GetSecurityIsolationStatusResponse {

    /**
    */
    private jpuppeteer.cdp.client.entity.network.SecurityIsolationStatus status;

    public void setStatus (jpuppeteer.cdp.client.entity.network.SecurityIsolationStatus status) {
        this.status = status;
    }

    public jpuppeteer.cdp.client.entity.network.SecurityIsolationStatus getStatus() {
        return this.status;
    }

    public GetSecurityIsolationStatusResponse(jpuppeteer.cdp.client.entity.network.SecurityIsolationStatus status) {
        this.status = status;
    }

    public GetSecurityIsolationStatusResponse() {
    }

}