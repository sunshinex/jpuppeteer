package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class GetTrustTokensResponse {

    /**
    */
    private java.util.List<jpuppeteer.cdp.client.entity.storage.TrustTokens> tokens;

    public void setTokens (java.util.List<jpuppeteer.cdp.client.entity.storage.TrustTokens> tokens) {
        this.tokens = tokens;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.storage.TrustTokens> getTokens() {
        return this.tokens;
    }

    public GetTrustTokensResponse(java.util.List<jpuppeteer.cdp.client.entity.storage.TrustTokens> tokens) {
        this.tokens = tokens;
    }

    public GetTrustTokensResponse() {
    }

}