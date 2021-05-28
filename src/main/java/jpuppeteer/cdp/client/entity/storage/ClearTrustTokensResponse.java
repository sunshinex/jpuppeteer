package jpuppeteer.cdp.client.entity.storage;

/**
* experimental
*/
public class ClearTrustTokensResponse {

    /**
    * True if any tokens were deleted, false otherwise.
    */
    public final Boolean didDeleteTokens;

    public ClearTrustTokensResponse(Boolean didDeleteTokens) {
        this.didDeleteTokens = didDeleteTokens;
    }

}