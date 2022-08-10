package jpuppeteer.cdp.client.entity.security;

/**
* Details about the security state of the page certificate.
*/
public class CertificateSecurityState {

    /**
    * Protocol name (e.g. "TLS 1.2" or "QUIC").
    */
    private String protocol;

    /**
    * Key Exchange used by the connection, or the empty string if not applicable.
    */
    private String keyExchange;

    /**
    * (EC)DH group used by the connection, if applicable.
    */
    private String keyExchangeGroup;

    /**
    * Cipher name.
    */
    private String cipher;

    /**
    * TLS MAC. Note that AEAD ciphers do not have separate MACs.
    */
    private String mac;

    /**
    * Page certificate.
    */
    private java.util.List<String> certificate;

    /**
    * Certificate subject name.
    */
    private String subjectName;

    /**
    * Name of the issuing CA.
    */
    private String issuer;

    /**
    * Certificate valid from date.
    */
    private java.math.BigDecimal validFrom;

    /**
    * Certificate valid to (expiration) date
    */
    private java.math.BigDecimal validTo;

    /**
    * The highest priority network error code, if the certificate has an error.
    */
    private String certificateNetworkError;

    /**
    * True if the certificate uses a weak signature aglorithm.
    */
    private Boolean certificateHasWeakSignature;

    /**
    * True if the certificate has a SHA1 signature in the chain.
    */
    private Boolean certificateHasSha1Signature;

    /**
    * True if modern SSL
    */
    private Boolean modernSSL;

    /**
    * True if the connection is using an obsolete SSL protocol.
    */
    private Boolean obsoleteSslProtocol;

    /**
    * True if the connection is using an obsolete SSL key exchange.
    */
    private Boolean obsoleteSslKeyExchange;

    /**
    * True if the connection is using an obsolete SSL cipher.
    */
    private Boolean obsoleteSslCipher;

    /**
    * True if the connection is using an obsolete SSL signature.
    */
    private Boolean obsoleteSslSignature;

    public void setProtocol (String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setKeyExchange (String keyExchange) {
        this.keyExchange = keyExchange;
    }

    public String getKeyExchange() {
        return this.keyExchange;
    }

    public void setKeyExchangeGroup (String keyExchangeGroup) {
        this.keyExchangeGroup = keyExchangeGroup;
    }

    public String getKeyExchangeGroup() {
        return this.keyExchangeGroup;
    }

    public void setCipher (String cipher) {
        this.cipher = cipher;
    }

    public String getCipher() {
        return this.cipher;
    }

    public void setMac (String mac) {
        this.mac = mac;
    }

    public String getMac() {
        return this.mac;
    }

    public void setCertificate (java.util.List<String> certificate) {
        this.certificate = certificate;
    }

    public java.util.List<String> getCertificate() {
        return this.certificate;
    }

    public void setSubjectName (String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setIssuer (String issuer) {
        this.issuer = issuer;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public void setValidFrom (java.math.BigDecimal validFrom) {
        this.validFrom = validFrom;
    }

    public java.math.BigDecimal getValidFrom() {
        return this.validFrom;
    }

    public void setValidTo (java.math.BigDecimal validTo) {
        this.validTo = validTo;
    }

    public java.math.BigDecimal getValidTo() {
        return this.validTo;
    }

    public void setCertificateNetworkError (String certificateNetworkError) {
        this.certificateNetworkError = certificateNetworkError;
    }

    public String getCertificateNetworkError() {
        return this.certificateNetworkError;
    }

    public void setCertificateHasWeakSignature (Boolean certificateHasWeakSignature) {
        this.certificateHasWeakSignature = certificateHasWeakSignature;
    }

    public Boolean getCertificateHasWeakSignature() {
        return this.certificateHasWeakSignature;
    }

    public void setCertificateHasSha1Signature (Boolean certificateHasSha1Signature) {
        this.certificateHasSha1Signature = certificateHasSha1Signature;
    }

    public Boolean getCertificateHasSha1Signature() {
        return this.certificateHasSha1Signature;
    }

    public void setModernSSL (Boolean modernSSL) {
        this.modernSSL = modernSSL;
    }

    public Boolean getModernSSL() {
        return this.modernSSL;
    }

    public void setObsoleteSslProtocol (Boolean obsoleteSslProtocol) {
        this.obsoleteSslProtocol = obsoleteSslProtocol;
    }

    public Boolean getObsoleteSslProtocol() {
        return this.obsoleteSslProtocol;
    }

    public void setObsoleteSslKeyExchange (Boolean obsoleteSslKeyExchange) {
        this.obsoleteSslKeyExchange = obsoleteSslKeyExchange;
    }

    public Boolean getObsoleteSslKeyExchange() {
        return this.obsoleteSslKeyExchange;
    }

    public void setObsoleteSslCipher (Boolean obsoleteSslCipher) {
        this.obsoleteSslCipher = obsoleteSslCipher;
    }

    public Boolean getObsoleteSslCipher() {
        return this.obsoleteSslCipher;
    }

    public void setObsoleteSslSignature (Boolean obsoleteSslSignature) {
        this.obsoleteSslSignature = obsoleteSslSignature;
    }

    public Boolean getObsoleteSslSignature() {
        return this.obsoleteSslSignature;
    }

    public CertificateSecurityState(String protocol, String keyExchange, String keyExchangeGroup, String cipher, String mac, java.util.List<String> certificate, String subjectName, String issuer, java.math.BigDecimal validFrom, java.math.BigDecimal validTo, String certificateNetworkError, Boolean certificateHasWeakSignature, Boolean certificateHasSha1Signature, Boolean modernSSL, Boolean obsoleteSslProtocol, Boolean obsoleteSslKeyExchange, Boolean obsoleteSslCipher, Boolean obsoleteSslSignature) {
        this.protocol = protocol;
        this.keyExchange = keyExchange;
        this.keyExchangeGroup = keyExchangeGroup;
        this.cipher = cipher;
        this.mac = mac;
        this.certificate = certificate;
        this.subjectName = subjectName;
        this.issuer = issuer;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.certificateNetworkError = certificateNetworkError;
        this.certificateHasWeakSignature = certificateHasWeakSignature;
        this.certificateHasSha1Signature = certificateHasSha1Signature;
        this.modernSSL = modernSSL;
        this.obsoleteSslProtocol = obsoleteSslProtocol;
        this.obsoleteSslKeyExchange = obsoleteSslKeyExchange;
        this.obsoleteSslCipher = obsoleteSslCipher;
        this.obsoleteSslSignature = obsoleteSslSignature;
    }

    public CertificateSecurityState(String protocol, String keyExchange, String cipher, java.util.List<String> certificate, String subjectName, String issuer, java.math.BigDecimal validFrom, java.math.BigDecimal validTo, Boolean certificateHasWeakSignature, Boolean certificateHasSha1Signature, Boolean modernSSL, Boolean obsoleteSslProtocol, Boolean obsoleteSslKeyExchange, Boolean obsoleteSslCipher, Boolean obsoleteSslSignature) {
        this.protocol = protocol;
        this.keyExchange = keyExchange;
        this.keyExchangeGroup = null;
        this.cipher = cipher;
        this.mac = null;
        this.certificate = certificate;
        this.subjectName = subjectName;
        this.issuer = issuer;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.certificateNetworkError = null;
        this.certificateHasWeakSignature = certificateHasWeakSignature;
        this.certificateHasSha1Signature = certificateHasSha1Signature;
        this.modernSSL = modernSSL;
        this.obsoleteSslProtocol = obsoleteSslProtocol;
        this.obsoleteSslKeyExchange = obsoleteSslKeyExchange;
        this.obsoleteSslCipher = obsoleteSslCipher;
        this.obsoleteSslSignature = obsoleteSslSignature;
    }

    public CertificateSecurityState() {
    }

}