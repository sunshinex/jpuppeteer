package jpuppeteer.cdp.client.entity.cachestorage;

/**
* Data entry.
* experimental
*/
public class DataEntry {

    /**
    * Request URL.
    */
    public final String requestURL;

    /**
    * Request method.
    */
    public final String requestMethod;

    /**
    * Request headers
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> requestHeaders;

    /**
    * Number of seconds since epoch.
    */
    public final java.math.BigDecimal responseTime;

    /**
    * HTTP response status code.
    */
    public final Integer responseStatus;

    /**
    * HTTP response status text.
    */
    public final String responseStatusText;

    /**
    * HTTP response type
    */
    public final jpuppeteer.cdp.client.constant.cachestorage.CachedResponseType responseType;

    /**
    * Response headers
    */
    public final java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> responseHeaders;

    public DataEntry(String requestURL, String requestMethod, java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> requestHeaders, java.math.BigDecimal responseTime, Integer responseStatus, String responseStatusText, jpuppeteer.cdp.client.constant.cachestorage.CachedResponseType responseType, java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> responseHeaders) {
        this.requestURL = requestURL;
        this.requestMethod = requestMethod;
        this.requestHeaders = requestHeaders;
        this.responseTime = responseTime;
        this.responseStatus = responseStatus;
        this.responseStatusText = responseStatusText;
        this.responseType = responseType;
        this.responseHeaders = responseHeaders;
    }

}