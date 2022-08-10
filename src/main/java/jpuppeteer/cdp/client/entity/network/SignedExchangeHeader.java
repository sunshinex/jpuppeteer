package jpuppeteer.cdp.client.entity.network;

/**
* Information about a signed exchange header. https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#cbor-representation
*/
public class SignedExchangeHeader {

    /**
    * Signed exchange request URL.
    */
    private String requestUrl;

    /**
    * Signed exchange response code.
    */
    private Integer responseCode;

    /**
    * Signed exchange response headers.
    */
    private java.util.Map<String, Object> responseHeaders;

    /**
    * Signed exchange response signature.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.network.SignedExchangeSignature> signatures;

    /**
    * Signed exchange header integrity hash in the form of "sha256-<base64-hash-value>".
    */
    private String headerIntegrity;

    public void setRequestUrl (String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public void setResponseCode (Integer responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseHeaders (java.util.Map<String, Object> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public java.util.Map<String, Object> getResponseHeaders() {
        return this.responseHeaders;
    }

    public void setSignatures (java.util.List<jpuppeteer.cdp.client.entity.network.SignedExchangeSignature> signatures) {
        this.signatures = signatures;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.network.SignedExchangeSignature> getSignatures() {
        return this.signatures;
    }

    public void setHeaderIntegrity (String headerIntegrity) {
        this.headerIntegrity = headerIntegrity;
    }

    public String getHeaderIntegrity() {
        return this.headerIntegrity;
    }

    public SignedExchangeHeader(String requestUrl, Integer responseCode, java.util.Map<String, Object> responseHeaders, java.util.List<jpuppeteer.cdp.client.entity.network.SignedExchangeSignature> signatures, String headerIntegrity) {
        this.requestUrl = requestUrl;
        this.responseCode = responseCode;
        this.responseHeaders = responseHeaders;
        this.signatures = signatures;
        this.headerIntegrity = headerIntegrity;
    }

    public SignedExchangeHeader() {
    }

}