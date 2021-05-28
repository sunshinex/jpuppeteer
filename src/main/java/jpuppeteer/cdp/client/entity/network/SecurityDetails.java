package jpuppeteer.cdp.client.entity.network;

/**
* Security details about a request.
*/
public class SecurityDetails {

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
    * Certificate ID value.
    */
    public final Integer certificateId;

    /**
    * Certificate subject name.
    */
    public final String subjectName;

    /**
    * Subject Alternative Name (SAN) DNS names and IP addresses.
    */
    public final java.util.List<String> sanList;

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
    * List of signed certificate timestamps (SCTs).
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.network.SignedCertificateTimestamp> signedCertificateTimestampList;

    /**
    * Whether the request complied with Certificate Transparency policy
    */
    public final jpuppeteer.cdp.client.constant.network.CertificateTransparencyCompliance certificateTransparencyCompliance;

    public SecurityDetails(String protocol, String keyExchange, String keyExchangeGroup, String cipher, String mac, Integer certificateId, String subjectName, java.util.List<String> sanList, String issuer, java.math.BigDecimal validFrom, java.math.BigDecimal validTo, java.util.List<jpuppeteer.cdp.client.entity.network.SignedCertificateTimestamp> signedCertificateTimestampList, jpuppeteer.cdp.client.constant.network.CertificateTransparencyCompliance certificateTransparencyCompliance) {
        this.protocol = protocol;
        this.keyExchange = keyExchange;
        this.keyExchangeGroup = keyExchangeGroup;
        this.cipher = cipher;
        this.mac = mac;
        this.certificateId = certificateId;
        this.subjectName = subjectName;
        this.sanList = sanList;
        this.issuer = issuer;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.signedCertificateTimestampList = signedCertificateTimestampList;
        this.certificateTransparencyCompliance = certificateTransparencyCompliance;
    }

    public SecurityDetails(String protocol, String keyExchange, String cipher, Integer certificateId, String subjectName, java.util.List<String> sanList, String issuer, java.math.BigDecimal validFrom, java.math.BigDecimal validTo, java.util.List<jpuppeteer.cdp.client.entity.network.SignedCertificateTimestamp> signedCertificateTimestampList, jpuppeteer.cdp.client.constant.network.CertificateTransparencyCompliance certificateTransparencyCompliance) {
        this.protocol = protocol;
        this.keyExchange = keyExchange;
        this.keyExchangeGroup = null;
        this.cipher = cipher;
        this.mac = null;
        this.certificateId = certificateId;
        this.subjectName = subjectName;
        this.sanList = sanList;
        this.issuer = issuer;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.signedCertificateTimestampList = signedCertificateTimestampList;
        this.certificateTransparencyCompliance = certificateTransparencyCompliance;
    }

}