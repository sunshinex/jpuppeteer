package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class GetEncodedResponseRequest {

    /**
    * Identifier of the network request to get content for.
    */
    public final String requestId;

    /**
    * The encoding to use.
    */
    public final jpuppeteer.cdp.client.constant.audits.GetEncodedResponseRequestEncoding encoding;

    /**
    * The quality of the encoding (0-1). (defaults to 1)
    */
    public final java.math.BigDecimal quality;

    /**
    * Whether to only return the size information (defaults to false).
    */
    public final Boolean sizeOnly;

    public GetEncodedResponseRequest(String requestId, jpuppeteer.cdp.client.constant.audits.GetEncodedResponseRequestEncoding encoding, java.math.BigDecimal quality, Boolean sizeOnly) {
        this.requestId = requestId;
        this.encoding = encoding;
        this.quality = quality;
        this.sizeOnly = sizeOnly;
    }

    public GetEncodedResponseRequest(String requestId, jpuppeteer.cdp.client.constant.audits.GetEncodedResponseRequestEncoding encoding) {
        this.requestId = requestId;
        this.encoding = encoding;
        this.quality = null;
        this.sizeOnly = null;
    }

}