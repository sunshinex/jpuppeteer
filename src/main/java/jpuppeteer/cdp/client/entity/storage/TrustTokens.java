package jpuppeteer.cdp.client.entity.storage;

/**
* Pair of issuer origin and number of available (signed, but not used) Trust Tokens from that issuer.
* experimental
*/
public class TrustTokens {

    /**
    */
    public final String issuerOrigin;

    /**
    */
    public final java.math.BigDecimal count;

    public TrustTokens(String issuerOrigin, java.math.BigDecimal count) {
        this.issuerOrigin = issuerOrigin;
        this.count = count;
    }

}