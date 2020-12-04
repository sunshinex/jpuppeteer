package jpuppeteer.cdp.client.entity.network;

/**
* Information about a signed exchange signature. https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#rfc.section.3.1
*/
public class SignedExchangeSignature {

    /**
    * Signed exchange signature label.
    */
    public final String label;

    /**
    * The hex string of signed exchange signature.
    */
    public final String signature;

    /**
    * Signed exchange signature integrity.
    */
    public final String integrity;

    /**
    * Signed exchange signature cert Url.
    */
    public final String certUrl;

    /**
    * The hex string of signed exchange signature cert sha256.
    */
    public final String certSha256;

    /**
    * Signed exchange signature validity Url.
    */
    public final String validityUrl;

    /**
    * Signed exchange signature date.
    */
    public final Integer date;

    /**
    * Signed exchange signature expires.
    */
    public final Integer expires;

    /**
    * The encoded certificates.
    */
    public final java.util.List<String> certificates;

    public SignedExchangeSignature(String label, String signature, String integrity, String certUrl, String certSha256, String validityUrl, Integer date, Integer expires, java.util.List<String> certificates) {
        this.label = label;
        this.signature = signature;
        this.integrity = integrity;
        this.certUrl = certUrl;
        this.certSha256 = certSha256;
        this.validityUrl = validityUrl;
        this.date = date;
        this.expires = expires;
        this.certificates = certificates;
    }

    public SignedExchangeSignature(String label, String signature, String integrity, String validityUrl, Integer date, Integer expires) {
        this.label = label;
        this.signature = signature;
        this.integrity = integrity;
        this.certUrl = null;
        this.certSha256 = null;
        this.validityUrl = validityUrl;
        this.date = date;
        this.expires = expires;
        this.certificates = null;
    }

}