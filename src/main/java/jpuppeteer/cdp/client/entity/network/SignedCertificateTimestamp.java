package jpuppeteer.cdp.client.entity.network;

/**
* Details of a signed certificate timestamp (SCT).
*/
public class SignedCertificateTimestamp {

    /**
    * Validation status.
    */
    private String status;

    /**
    * Origin.
    */
    private String origin;

    /**
    * Log name / description.
    */
    private String logDescription;

    /**
    * Log ID.
    */
    private String logId;

    /**
    * Issuance date.
    */
    private java.math.BigDecimal timestamp;

    /**
    * Hash algorithm.
    */
    private String hashAlgorithm;

    /**
    * Signature algorithm.
    */
    private String signatureAlgorithm;

    /**
    * Signature data.
    */
    private String signatureData;

    public void setStatus (String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setOrigin (String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setLogDescription (String logDescription) {
        this.logDescription = logDescription;
    }

    public String getLogDescription() {
        return this.logDescription;
    }

    public void setLogId (String logId) {
        this.logId = logId;
    }

    public String getLogId() {
        return this.logId;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setHashAlgorithm (String hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    public String getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public void setSignatureAlgorithm (String signatureAlgorithm) {
        this.signatureAlgorithm = signatureAlgorithm;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public void setSignatureData (String signatureData) {
        this.signatureData = signatureData;
    }

    public String getSignatureData() {
        return this.signatureData;
    }

    public SignedCertificateTimestamp(String status, String origin, String logDescription, String logId, java.math.BigDecimal timestamp, String hashAlgorithm, String signatureAlgorithm, String signatureData) {
        this.status = status;
        this.origin = origin;
        this.logDescription = logDescription;
        this.logId = logId;
        this.timestamp = timestamp;
        this.hashAlgorithm = hashAlgorithm;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signatureData = signatureData;
    }

    public SignedCertificateTimestamp() {
    }

}