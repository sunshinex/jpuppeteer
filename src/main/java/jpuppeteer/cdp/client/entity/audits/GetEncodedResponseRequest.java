package jpuppeteer.cdp.client.entity.audits;

/**
* experimental
*/
public class GetEncodedResponseRequest {

    /**
    * Identifier of the network request to get content for.
    */
    private String requestId;

    /**
    * The encoding to use.
    */
    private jpuppeteer.cdp.client.constant.audits.GetEncodedResponseRequestEncoding encoding;

    /**
    * The quality of the encoding (0-1). (defaults to 1)
    */
    private java.math.BigDecimal quality;

    /**
    * Whether to only return the size information (defaults to false).
    */
    private Boolean sizeOnly;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setEncoding (jpuppeteer.cdp.client.constant.audits.GetEncodedResponseRequestEncoding encoding) {
        this.encoding = encoding;
    }

    public jpuppeteer.cdp.client.constant.audits.GetEncodedResponseRequestEncoding getEncoding() {
        return this.encoding;
    }

    public void setQuality (java.math.BigDecimal quality) {
        this.quality = quality;
    }

    public java.math.BigDecimal getQuality() {
        return this.quality;
    }

    public void setSizeOnly (Boolean sizeOnly) {
        this.sizeOnly = sizeOnly;
    }

    public Boolean getSizeOnly() {
        return this.sizeOnly;
    }

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

    public GetEncodedResponseRequest() {
    }

}