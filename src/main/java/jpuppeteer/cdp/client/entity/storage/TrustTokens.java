package jpuppeteer.cdp.client.entity.storage;

/**
* Pair of issuer origin and number of available (signed, but not used) Trust Tokens from that issuer.
* experimental
*/
public class TrustTokens {

    /**
    */
    private String issuerOrigin;

    /**
    */
    private java.math.BigDecimal count;

    public void setIssuerOrigin (String issuerOrigin) {
        this.issuerOrigin = issuerOrigin;
    }

    public String getIssuerOrigin() {
        return this.issuerOrigin;
    }

    public void setCount (java.math.BigDecimal count) {
        this.count = count;
    }

    public java.math.BigDecimal getCount() {
        return this.count;
    }

    public TrustTokens(String issuerOrigin, java.math.BigDecimal count) {
        this.issuerOrigin = issuerOrigin;
        this.count = count;
    }

    public TrustTokens() {
    }

}