package jpuppeteer.cdp.client.entity.network;

/**
* HTTP response data.
*/
public class Response {

    /**
    * Response URL. This URL can be different from CachedResource.url in case of redirect.
    */
    private String url;

    /**
    * HTTP response status code.
    */
    private Integer status;

    /**
    * HTTP response status text.
    */
    private String statusText;

    /**
    * HTTP response headers.
    */
    private java.util.Map<String, Object> headers;

    /**
    * HTTP response headers text.
    */
    private String headersText;

    /**
    * Resource mimeType as determined by the browser.
    */
    private String mimeType;

    /**
    * Refined HTTP request headers that were actually transmitted over the network.
    */
    private java.util.Map<String, Object> requestHeaders;

    /**
    * HTTP request headers text.
    */
    private String requestHeadersText;

    /**
    * Specifies whether physical connection was actually reused for this request.
    */
    private Boolean connectionReused;

    /**
    * Physical connection id that was actually used for this request.
    */
    private java.math.BigDecimal connectionId;

    /**
    * Remote IP address.
    */
    private String remoteIPAddress;

    /**
    * Remote port.
    */
    private Integer remotePort;

    /**
    * Specifies that the request was served from the disk cache.
    */
    private Boolean fromDiskCache;

    /**
    * Specifies that the request was served from the ServiceWorker.
    */
    private Boolean fromServiceWorker;

    /**
    * Specifies that the request was served from the prefetch cache.
    */
    private Boolean fromPrefetchCache;

    /**
    * Total number of bytes received for this request so far.
    */
    private java.math.BigDecimal encodedDataLength;

    /**
    * Timing information for the given request.
    */
    private jpuppeteer.cdp.client.entity.network.ResourceTiming timing;

    /**
    * Response source of response from ServiceWorker.
    */
    private jpuppeteer.cdp.client.constant.network.ServiceWorkerResponseSource serviceWorkerResponseSource;

    /**
    * The time at which the returned response was generated.
    */
    private java.math.BigDecimal responseTime;

    /**
    * Cache Storage Cache Name.
    */
    private String cacheStorageCacheName;

    /**
    * Protocol used to fetch this request.
    */
    private String protocol;

    /**
    * Security state of the request resource.
    */
    private jpuppeteer.cdp.client.constant.security.SecurityState securityState;

    /**
    * Security details for the request.
    */
    private jpuppeteer.cdp.client.entity.network.SecurityDetails securityDetails;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatusText (String statusText) {
        this.statusText = statusText;
    }

    public String getStatusText() {
        return this.statusText;
    }

    public void setHeaders (java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

    public java.util.Map<String, Object> getHeaders() {
        return this.headers;
    }

    public void setHeadersText (String headersText) {
        this.headersText = headersText;
    }

    public String getHeadersText() {
        return this.headersText;
    }

    public void setMimeType (String mimeType) {
        this.mimeType = mimeType;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setRequestHeaders (java.util.Map<String, Object> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public java.util.Map<String, Object> getRequestHeaders() {
        return this.requestHeaders;
    }

    public void setRequestHeadersText (String requestHeadersText) {
        this.requestHeadersText = requestHeadersText;
    }

    public String getRequestHeadersText() {
        return this.requestHeadersText;
    }

    public void setConnectionReused (Boolean connectionReused) {
        this.connectionReused = connectionReused;
    }

    public Boolean getConnectionReused() {
        return this.connectionReused;
    }

    public void setConnectionId (java.math.BigDecimal connectionId) {
        this.connectionId = connectionId;
    }

    public java.math.BigDecimal getConnectionId() {
        return this.connectionId;
    }

    public void setRemoteIPAddress (String remoteIPAddress) {
        this.remoteIPAddress = remoteIPAddress;
    }

    public String getRemoteIPAddress() {
        return this.remoteIPAddress;
    }

    public void setRemotePort (Integer remotePort) {
        this.remotePort = remotePort;
    }

    public Integer getRemotePort() {
        return this.remotePort;
    }

    public void setFromDiskCache (Boolean fromDiskCache) {
        this.fromDiskCache = fromDiskCache;
    }

    public Boolean getFromDiskCache() {
        return this.fromDiskCache;
    }

    public void setFromServiceWorker (Boolean fromServiceWorker) {
        this.fromServiceWorker = fromServiceWorker;
    }

    public Boolean getFromServiceWorker() {
        return this.fromServiceWorker;
    }

    public void setFromPrefetchCache (Boolean fromPrefetchCache) {
        this.fromPrefetchCache = fromPrefetchCache;
    }

    public Boolean getFromPrefetchCache() {
        return this.fromPrefetchCache;
    }

    public void setEncodedDataLength (java.math.BigDecimal encodedDataLength) {
        this.encodedDataLength = encodedDataLength;
    }

    public java.math.BigDecimal getEncodedDataLength() {
        return this.encodedDataLength;
    }

    public void setTiming (jpuppeteer.cdp.client.entity.network.ResourceTiming timing) {
        this.timing = timing;
    }

    public jpuppeteer.cdp.client.entity.network.ResourceTiming getTiming() {
        return this.timing;
    }

    public void setServiceWorkerResponseSource (jpuppeteer.cdp.client.constant.network.ServiceWorkerResponseSource serviceWorkerResponseSource) {
        this.serviceWorkerResponseSource = serviceWorkerResponseSource;
    }

    public jpuppeteer.cdp.client.constant.network.ServiceWorkerResponseSource getServiceWorkerResponseSource() {
        return this.serviceWorkerResponseSource;
    }

    public void setResponseTime (java.math.BigDecimal responseTime) {
        this.responseTime = responseTime;
    }

    public java.math.BigDecimal getResponseTime() {
        return this.responseTime;
    }

    public void setCacheStorageCacheName (String cacheStorageCacheName) {
        this.cacheStorageCacheName = cacheStorageCacheName;
    }

    public String getCacheStorageCacheName() {
        return this.cacheStorageCacheName;
    }

    public void setProtocol (String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setSecurityState (jpuppeteer.cdp.client.constant.security.SecurityState securityState) {
        this.securityState = securityState;
    }

    public jpuppeteer.cdp.client.constant.security.SecurityState getSecurityState() {
        return this.securityState;
    }

    public void setSecurityDetails (jpuppeteer.cdp.client.entity.network.SecurityDetails securityDetails) {
        this.securityDetails = securityDetails;
    }

    public jpuppeteer.cdp.client.entity.network.SecurityDetails getSecurityDetails() {
        return this.securityDetails;
    }

    public Response(String url, Integer status, String statusText, java.util.Map<String, Object> headers, String headersText, String mimeType, java.util.Map<String, Object> requestHeaders, String requestHeadersText, Boolean connectionReused, java.math.BigDecimal connectionId, String remoteIPAddress, Integer remotePort, Boolean fromDiskCache, Boolean fromServiceWorker, Boolean fromPrefetchCache, java.math.BigDecimal encodedDataLength, jpuppeteer.cdp.client.entity.network.ResourceTiming timing, jpuppeteer.cdp.client.constant.network.ServiceWorkerResponseSource serviceWorkerResponseSource, java.math.BigDecimal responseTime, String cacheStorageCacheName, String protocol, jpuppeteer.cdp.client.constant.security.SecurityState securityState, jpuppeteer.cdp.client.entity.network.SecurityDetails securityDetails) {
        this.url = url;
        this.status = status;
        this.statusText = statusText;
        this.headers = headers;
        this.headersText = headersText;
        this.mimeType = mimeType;
        this.requestHeaders = requestHeaders;
        this.requestHeadersText = requestHeadersText;
        this.connectionReused = connectionReused;
        this.connectionId = connectionId;
        this.remoteIPAddress = remoteIPAddress;
        this.remotePort = remotePort;
        this.fromDiskCache = fromDiskCache;
        this.fromServiceWorker = fromServiceWorker;
        this.fromPrefetchCache = fromPrefetchCache;
        this.encodedDataLength = encodedDataLength;
        this.timing = timing;
        this.serviceWorkerResponseSource = serviceWorkerResponseSource;
        this.responseTime = responseTime;
        this.cacheStorageCacheName = cacheStorageCacheName;
        this.protocol = protocol;
        this.securityState = securityState;
        this.securityDetails = securityDetails;
    }

    public Response(String url, Integer status, String statusText, java.util.Map<String, Object> headers, String mimeType, Boolean connectionReused, java.math.BigDecimal connectionId, java.math.BigDecimal encodedDataLength, jpuppeteer.cdp.client.constant.security.SecurityState securityState) {
        this.url = url;
        this.status = status;
        this.statusText = statusText;
        this.headers = headers;
        this.headersText = null;
        this.mimeType = mimeType;
        this.requestHeaders = null;
        this.requestHeadersText = null;
        this.connectionReused = connectionReused;
        this.connectionId = connectionId;
        this.remoteIPAddress = null;
        this.remotePort = null;
        this.fromDiskCache = null;
        this.fromServiceWorker = null;
        this.fromPrefetchCache = null;
        this.encodedDataLength = encodedDataLength;
        this.timing = null;
        this.serviceWorkerResponseSource = null;
        this.responseTime = null;
        this.cacheStorageCacheName = null;
        this.protocol = null;
        this.securityState = securityState;
        this.securityDetails = null;
    }

    public Response() {
    }

}