package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class ClearTrustTokensRequest {

    /**
    */
    public final String issuerOrigin;

    public ClearTrustTokensRequest(String issuerOrigin) {
        this.issuerOrigin = issuerOrigin;
    }

}