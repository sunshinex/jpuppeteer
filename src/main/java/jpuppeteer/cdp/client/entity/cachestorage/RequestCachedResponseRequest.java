package jpuppeteer.cdp.client.entity.cachestorage;

/**
* experimental
*/
public class RequestCachedResponseRequest {

    /**
    * Id of cache that contains the entry.
    */
    private String cacheId;

    /**
    * URL spec of the request.
    */
    private String requestURL;

    /**
    * headers of the request.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> requestHeaders;

    public void setCacheId (String cacheId) {
        this.cacheId = cacheId;
    }

    public String getCacheId() {
        return this.cacheId;
    }

    public void setRequestURL (String requestURL) {
        this.requestURL = requestURL;
    }

    public String getRequestURL() {
        return this.requestURL;
    }

    public void setRequestHeaders (java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public RequestCachedResponseRequest(String cacheId, String requestURL, java.util.List<jpuppeteer.cdp.client.entity.cachestorage.Header> requestHeaders) {
        this.cacheId = cacheId;
        this.requestURL = requestURL;
        this.requestHeaders = requestHeaders;
    }

    public RequestCachedResponseRequest() {
    }

}