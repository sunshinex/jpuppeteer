package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class ClearTrustTokensRequest {

    /**
    */
    private String issuerOrigin;

    public void setIssuerOrigin (String issuerOrigin) {
        this.issuerOrigin = issuerOrigin;
    }

    public String getIssuerOrigin() {
        return this.issuerOrigin;
    }

    public ClearTrustTokensRequest(String issuerOrigin) {
        this.issuerOrigin = issuerOrigin;
    }

    public ClearTrustTokensRequest() {
    }

}