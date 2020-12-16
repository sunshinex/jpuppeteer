package jpuppeteer.cdp.client.entity.network;

/**
* Details of a signed certificate timestamp (SCT).
*/
public class SignedCertificateTimestamp {

    /**
    * Validation status.
    */
    public final String status;

    /**
    * Origin.
    */
    public final String origin;

    /**
    * Log name / description.
    */
    public final String logDescription;

    /**
    * Log ID.
    */
    public final String logId;

    /**
    * Issuance date.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * Hash algorithm.
    */
    public final String hashAlgorithm;

    /**
    * Signature algorithm.
    */
    public final String signatureAlgorithm;

    /**
    * Signature data.
    */
    public final String signatureData;

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

}