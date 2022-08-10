package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class ClearTrustTokensResponse {

    /**
    * True if any tokens were deleted, false otherwise.
    */
    private Boolean didDeleteTokens;

    public void setDidDeleteTokens (Boolean didDeleteTokens) {
        this.didDeleteTokens = didDeleteTokens;
    }

    public Boolean getDidDeleteTokens() {
        return this.didDeleteTokens;
    }

    public ClearTrustTokensResponse(Boolean didDeleteTokens) {
        this.didDeleteTokens = didDeleteTokens;
    }

    public ClearTrustTokensResponse() {
    }

}