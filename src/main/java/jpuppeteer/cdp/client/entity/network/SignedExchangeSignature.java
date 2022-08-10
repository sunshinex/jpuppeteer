package jpuppeteer.cdp.client.entity.network;

/**
* Information about a signed exchange signature. https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#rfc.section.3.1
*/
public class SignedExchangeSignature {

    /**
    * Signed exchange signature label.
    */
    private String label;

    /**
    * The hex string of signed exchange signature.
    */
    private String signature;

    /**
    * Signed exchange signature integrity.
    */
    private String integrity;

    /**
    * Signed exchange signature cert Url.
    */
    private String certUrl;

    /**
    * The hex string of signed exchange signature cert sha256.
    */
    private String certSha256;

    /**
    * Signed exchange signature validity Url.
    */
    private String validityUrl;

    /**
    * Signed exchange signature date.
    */
    private Integer date;

    /**
    * Signed exchange signature expires.
    */
    private Integer expires;

    /**
    * The encoded certificates.
    */
    private java.util.List<String> certificates;

    public void setLabel (String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setSignature (String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setIntegrity (String integrity) {
        this.integrity = integrity;
    }

    public String getIntegrity() {
        return this.integrity;
    }

    public void setCertUrl (String certUrl) {
        this.certUrl = certUrl;
    }

    public String getCertUrl() {
        return this.certUrl;
    }

    public void setCertSha256 (String certSha256) {
        this.certSha256 = certSha256;
    }

    public String getCertSha256() {
        return this.certSha256;
    }

    public void setValidityUrl (String validityUrl) {
        this.validityUrl = validityUrl;
    }

    public String getValidityUrl() {
        return this.validityUrl;
    }

    public void setDate (Integer date) {
        this.date = date;
    }

    public Integer getDate() {
        return this.date;
    }

    public void setExpires (Integer expires) {
        this.expires = expires;
    }

    public Integer getExpires() {
        return this.expires;
    }

    public void setCertificates (java.util.List<String> certificates) {
        this.certificates = certificates;
    }

    public java.util.List<String> getCertificates() {
        return this.certificates;
    }

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

    public SignedExchangeSignature() {
    }

}