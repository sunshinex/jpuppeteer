package jpuppeteer.cdp.client.entity.network;

/**
* Security details about a request.
*/
public class SecurityDetails {

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
    * Certificate ID value.
    */
    private Integer certificateId;

    /**
    * Certificate subject name.
    */
    private String subjectName;

    /**
    * Subject Alternative Name (SAN) DNS names and IP addresses.
    */
    private java.util.List<String> sanList;

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
    * List of signed certificate timestamps (SCTs).
    */
    private java.util.List<jpuppeteer.cdp.client.entity.network.SignedCertificateTimestamp> signedCertificateTimestampList;

    /**
    * Whether the request complied with Certificate Transparency policy
    */
    private jpuppeteer.cdp.client.constant.network.CertificateTransparencyCompliance certificateTransparencyCompliance;

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

    public void setCertificateId (Integer certificateId) {
        this.certificateId = certificateId;
    }

    public Integer getCertificateId() {
        return this.certificateId;
    }

    public void setSubjectName (String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSanList (java.util.List<String> sanList) {
        this.sanList = sanList;
    }

    public java.util.List<String> getSanList() {
        return this.sanList;
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

    public void setSignedCertificateTimestampList (java.util.List<jpuppeteer.cdp.client.entity.network.SignedCertificateTimestamp> signedCertificateTimestampList) {
        this.signedCertificateTimestampList = signedCertificateTimestampList;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.network.SignedCertificateTimestamp> getSignedCertificateTimestampList() {
        return this.signedCertificateTimestampList;
    }

    public void setCertificateTransparencyCompliance (jpuppeteer.cdp.client.constant.network.CertificateTransparencyCompliance certificateTransparencyCompliance) {
        this.certificateTransparencyCompliance = certificateTransparencyCompliance;
    }

    public jpuppeteer.cdp.client.constant.network.CertificateTransparencyCompliance getCertificateTransparencyCompliance() {
        return this.certificateTransparencyCompliance;
    }

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

    public SecurityDetails() {
    }

}