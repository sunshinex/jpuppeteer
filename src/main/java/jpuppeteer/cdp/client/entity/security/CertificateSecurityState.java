package jpuppeteer.cdp.client.entity.security;

/**
* Details about the security state of the page certificate.
*/
public class CertificateSecurityState {

    /**
    * Protocol name (e.g. "TLS 1.2" or "QUIC").
    */
    public final String protocol;

    /**
    * Key Exchange used by the connection, or the empty string if not applicable.
    */
    public final String keyExchange;

    /**
    * (EC)DH group used by the connection, if applicable.
    */
    public final String keyExchangeGroup;

    /**
    * Cipher name.
    */
    public final String cipher;

    /**
    * TLS MAC. Note that AEAD ciphers do not have separate MACs.
    */
    public final String mac;

    /**
    * Page certificate.
    */
    public final java.util.List<String> certificate;

    /**
    * Certificate subject name.
    */
    public final String subjectName;

    /**
    * Name of the issuing CA.
    */
    public final String issuer;

    /**
    * Certificate valid from date.
    */
    public final java.math.BigDecimal validFrom;

    /**
    * Certificate valid to (expiration) date
    */
    public final java.math.BigDecimal validTo;

    /**
    * The highest priority network error code, if the certificate has an error.
    */
    public final String certificateNetworkError;

    /**
    * True if the certificate uses a weak signature aglorithm.
    */
    public final Boolean certificateHasWeakSignature;

    /**
    * True if the certificate has a SHA1 signature in the chain.
    */
    public final Boolean certificateHasSha1Signature;

    /**
    * True if modern SSL
    */
    public final Boolean modernSSL;

    /**
    * True if the connection is using an obsolete SSL protocol.
    */
    public final Boolean obsoleteSslProtocol;

    /**
    * True if the connection is using an obsolete SSL key exchange.
    */
    public final Boolean obsoleteSslKeyExchange;

    /**
    * True if the connection is using an obsolete SSL cipher.
    */
    public final Boolean obsoleteSslCipher;

    /**
    * True if the connection is using an obsolete SSL signature.
    */
    public final Boolean obsoleteSslSignature;

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

}