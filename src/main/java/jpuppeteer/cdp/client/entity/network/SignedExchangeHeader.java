package jpuppeteer.cdp.client.entity.network;

/**
* Information about a signed exchange header. https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#cbor-representation
*/
public class SignedExchangeHeader {

    /**
    * Signed exchange request URL.
    */
    public final String requestUrl;

    /**
    * Signed exchange response code.
    */
    public final Integer responseCode;

    /**
    * Signed exchange response headers.
    */
    public final java.util.Map<String, Object> responseHeaders;

    /**
    * Signed exchange response signature.
    */
    public final java.util.List<SignedExchangeSignature> signatures;

    /**
    * Signed exchange header integrity hash in the form of "sha256-<base64-hash-value>".
    */
    public final String headerIntegrity;

    public SignedExchangeHeader(String requestUrl, Integer responseCode, java.util.Map<String, Object> responseHeaders, java.util.List<SignedExchangeSignature> signatures, String headerIntegrity) {
        this.requestUrl = requestUrl;
        this.responseCode = responseCode;
        this.responseHeaders = responseHeaders;
        this.signatures = signatures;
        this.headerIntegrity = headerIntegrity;
    }

}