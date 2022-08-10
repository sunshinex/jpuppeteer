package jpuppeteer.cdp.client.entity.cachestorage;

/**
* Data entry.
* experimental
*/
public class DataEntry {

    /**
    * Request URL.
    */
    private String requestURL;

    /**
    * Request method.
    */
    private String requestMethod;

    /**
    * Request headers
    */
    private java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> requestHeaders;

    /**
    * Number of seconds since epoch.
    */
    private java.math.BigDecimal responseTime;

    /**
    * HTTP response status code.
    */
    private Integer responseStatus;

    /**
    * HTTP response status text.
    */
    private String responseStatusText;

    /**
    * HTTP response type
    */
    private jpuppeteer.cdp.client.constant.cachestorage.CachedResponseType responseType;

    /**
    * Response headers
    */
    private java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> responseHeaders;

    public void setRequestURL (String requestURL) {
        this.requestURL = requestURL;
    }

    public String getRequestURL() {
        return this.requestURL;
    }

    public void setRequestMethod (String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public void setRequestHeaders (java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public void setResponseTime (java.math.BigDecimal responseTime) {
        this.responseTime = responseTime;
    }

    public java.math.BigDecimal getResponseTime() {
        return this.responseTime;
    }

    public void setResponseStatus (Integer responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Integer getResponseStatus() {
        return this.responseStatus;
    }

    public void setResponseStatusText (String responseStatusText) {
        this.responseStatusText = responseStatusText;
    }

    public String getResponseStatusText() {
        return this.responseStatusText;
    }

    public void setResponseType (jpuppeteer.cdp.client.constant.cachestorage.CachedResponseType responseType) {
        this.responseType = responseType;
    }

    public jpuppeteer.cdp.client.constant.cachestorage.CachedResponseType getResponseType() {
        return this.responseType;
    }

    public void setResponseHeaders (java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> getResponseHeaders() {
        return this.responseHeaders;
    }

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

    public DataEntry() {
    }

}