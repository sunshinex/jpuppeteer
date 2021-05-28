package jpuppeteer.cdp.client.entity.network;

/**
* HTTP response data.
*/
public class Response {

    /**
    * Response URL. This URL can be different from CachedResource.url in case of redirect.
    */
    public final String url;

    /**
    * HTTP response status code.
    */
    public final Integer status;

    /**
    * HTTP response status text.
    */
    public final String statusText;

    /**
    * HTTP response headers.
    */
    public final java.util.Map<String, Object> headers;

    /**
    * HTTP response headers text.
    */
    public final String headersText;

    /**
    * Resource mimeType as determined by the browser.
    */
    public final String mimeType;

    /**
    * Refined HTTP request headers that were actually transmitted over the network.
    */
    public final java.util.Map<String, Object> requestHeaders;

    /**
    * HTTP request headers text.
    */
    public final String requestHeadersText;

    /**
    * Specifies whether physical connection was actually reused for this request.
    */
    public final Boolean connectionReused;

    /**
    * Physical connection id that was actually used for this request.
    */
    public final java.math.BigDecimal connectionId;

    /**
    * Remote IP address.
    */
    public final String remoteIPAddress;

    /**
    * Remote port.
    */
    public final Integer remotePort;

    /**
    * Specifies that the request was served from the disk cache.
    */
    public final Boolean fromDiskCache;

    /**
    * Specifies that the request was served from the ServiceWorker.
    */
    public final Boolean fromServiceWorker;

    /**
    * Specifies that the request was served from the prefetch cache.
    */
    public final Boolean fromPrefetchCache;

    /**
    * Total number of bytes received for this request so far.
    */
    public final java.math.BigDecimal encodedDataLength;

    /**
    * Timing information for the given request.
    */
    public final jpuppeteer.cdp.client.entity.network.ResourceTiming timing;

    /**
    * Response source of response from ServiceWorker.
    */
    public final jpuppeteer.cdp.client.constant.network.ServiceWorkerResponseSource serviceWorkerResponseSource;

    /**
    * The time at which the returned response was generated.
    */
    public final java.math.BigDecimal responseTime;

    /**
    * Cache Storage Cache Name.
    */
    public final String cacheStorageCacheName;

    /**
    * Protocol used to fetch this request.
    */
    public final String protocol;

    /**
    * Security state of the request resource.
    */
    public final jpuppeteer.cdp.client.constant.security.SecurityState securityState;

    /**
    * Security details for the request.
    */
    public final jpuppeteer.cdp.client.entity.network.SecurityDetails securityDetails;

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

}