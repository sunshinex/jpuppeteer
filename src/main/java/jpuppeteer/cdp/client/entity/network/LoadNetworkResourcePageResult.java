package jpuppeteer.cdp.client.entity.network;

/**
* An object providing the result of a network resource load.
*/
public class LoadNetworkResourcePageResult {

    /**
    */
    private Boolean success;

    /**
    * Optional values used for error reporting.
    */
    private java.math.BigDecimal netError;

    /**
    */
    private String netErrorName;

    /**
    */
    private java.math.BigDecimal httpStatusCode;

    /**
    * If successful, one of the following two fields holds the result.
    */
    private String stream;

    /**
    * Response headers.
    */
    private java.util.Map<String, Object> headers;

    public void setSuccess (Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setNetError (java.math.BigDecimal netError) {
        this.netError = netError;
    }

    public java.math.BigDecimal getNetError() {
        return this.netError;
    }

    public void setNetErrorName (String netErrorName) {
        this.netErrorName = netErrorName;
    }

    public String getNetErrorName() {
        return this.netErrorName;
    }

    public void setHttpStatusCode (java.math.BigDecimal httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public java.math.BigDecimal getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public void setStream (String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return this.stream;
    }

    public void setHeaders (java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

    public java.util.Map<String, Object> getHeaders() {
        return this.headers;
    }

    public LoadNetworkResourcePageResult(Boolean success, java.math.BigDecimal netError, String netErrorName, java.math.BigDecimal httpStatusCode, String stream, java.util.Map<String, Object> headers) {
        this.success = success;
        this.netError = netError;
        this.netErrorName = netErrorName;
        this.httpStatusCode = httpStatusCode;
        this.stream = stream;
        this.headers = headers;
    }

    public LoadNetworkResourcePageResult(Boolean success) {
        this.success = success;
        this.netError = null;
        this.netErrorName = null;
        this.httpStatusCode = null;
        this.stream = null;
        this.headers = null;
    }

    public LoadNetworkResourcePageResult() {
    }

}