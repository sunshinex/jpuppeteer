package jpuppeteer.cdp.client.entity.network;

/**
* An object providing the result of a network resource load.
*/
public class LoadNetworkResourcePageResult {

    /**
    */
    public final Boolean success;

    /**
    * Optional values used for error reporting.
    */
    public final java.math.BigDecimal netError;

    /**
    */
    public final String netErrorName;

    /**
    */
    public final java.math.BigDecimal httpStatusCode;

    /**
    * If successful, one of the following two fields holds the result.
    */
    public final String stream;

    /**
    * Response headers.
    */
    public final java.util.Map<String, Object> headers;

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

}