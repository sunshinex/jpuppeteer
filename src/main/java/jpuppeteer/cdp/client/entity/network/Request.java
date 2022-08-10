package jpuppeteer.cdp.client.entity.network;

/**
* HTTP request data.
*/
public class Request {

    /**
    * Request URL (without fragment).
    */
    private String url;

    /**
    * Fragment of the requested URL starting with hash, if present.
    */
    private String urlFragment;

    /**
    * HTTP request method.
    */
    private String method;

    /**
    * HTTP request headers.
    */
    private java.util.Map<String, Object> headers;

    /**
    * HTTP POST request data.
    */
    private String postData;

    /**
    * True when the request has POST data. Note that postData might still be omitted when this flag is true when the data is too long.
    */
    private Boolean hasPostData;

    /**
    * Request body elements. This will be converted from base64 to binary
    */
    private java.util.List<jpuppeteer.cdp.client.entity.network.PostDataEntry> postDataEntries;

    /**
    * The mixed content type of the request.
    */
    private jpuppeteer.cdp.client.constant.security.MixedContentType mixedContentType;

    /**
    * Priority of the resource request at the time request is sent.
    */
    private jpuppeteer.cdp.client.constant.network.ResourcePriority initialPriority;

    /**
    * The referrer policy of the request, as defined in https://www.w3.org/TR/referrer-policy/
    */
    private jpuppeteer.cdp.client.constant.network.RequestReferrerPolicy referrerPolicy;

    /**
    * Whether is loaded via link preload.
    */
    private Boolean isLinkPreload;

    /**
    * Set for requests when the TrustToken API is used. Contains the parameters passed by the developer (e.g. via "fetch") as understood by the backend.
    */
    private jpuppeteer.cdp.client.entity.network.TrustTokenParams trustTokenParams;

    public void setUrl (String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrlFragment (String urlFragment) {
        this.urlFragment = urlFragment;
    }

    public String getUrlFragment() {
        return this.urlFragment;
    }

    public void setMethod (String method) {
        this.method = method;
    }

    public String getMethod() {
        return this.method;
    }

    public void setHeaders (java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

    public java.util.Map<String, Object> getHeaders() {
        return this.headers;
    }

    public void setPostData (String postData) {
        this.postData = postData;
    }

    public String getPostData() {
        return this.postData;
    }

    public void setHasPostData (Boolean hasPostData) {
        this.hasPostData = hasPostData;
    }

    public Boolean getHasPostData() {
        return this.hasPostData;
    }

    public void setPostDataEntries (java.util.List<jpuppeteer.cdp.client.entity.network.PostDataEntry> postDataEntries) {
        this.postDataEntries = postDataEntries;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.network.PostDataEntry> getPostDataEntries() {
        return this.postDataEntries;
    }

    public void setMixedContentType (jpuppeteer.cdp.client.constant.security.MixedContentType mixedContentType) {
        this.mixedContentType = mixedContentType;
    }

    public jpuppeteer.cdp.client.constant.security.MixedContentType getMixedContentType() {
        return this.mixedContentType;
    }

    public void setInitialPriority (jpuppeteer.cdp.client.constant.network.ResourcePriority initialPriority) {
        this.initialPriority = initialPriority;
    }

    public jpuppeteer.cdp.client.constant.network.ResourcePriority getInitialPriority() {
        return this.initialPriority;
    }

    public void setReferrerPolicy (jpuppeteer.cdp.client.constant.network.RequestReferrerPolicy referrerPolicy) {
        this.referrerPolicy = referrerPolicy;
    }

    public jpuppeteer.cdp.client.constant.network.RequestReferrerPolicy getReferrerPolicy() {
        return this.referrerPolicy;
    }

    public void setIsLinkPreload (Boolean isLinkPreload) {
        this.isLinkPreload = isLinkPreload;
    }

    public Boolean getIsLinkPreload() {
        return this.isLinkPreload;
    }

    public void setTrustTokenParams (jpuppeteer.cdp.client.entity.network.TrustTokenParams trustTokenParams) {
        this.trustTokenParams = trustTokenParams;
    }

    public jpuppeteer.cdp.client.entity.network.TrustTokenParams getTrustTokenParams() {
        return this.trustTokenParams;
    }

    public Request(String url, String urlFragment, String method, java.util.Map<String, Object> headers, String postData, Boolean hasPostData, java.util.List<jpuppeteer.cdp.client.entity.network.PostDataEntry> postDataEntries, jpuppeteer.cdp.client.constant.security.MixedContentType mixedContentType, jpuppeteer.cdp.client.constant.network.ResourcePriority initialPriority, jpuppeteer.cdp.client.constant.network.RequestReferrerPolicy referrerPolicy, Boolean isLinkPreload, jpuppeteer.cdp.client.entity.network.TrustTokenParams trustTokenParams) {
        this.url = url;
        this.urlFragment = urlFragment;
        this.method = method;
        this.headers = headers;
        this.postData = postData;
        this.hasPostData = hasPostData;
        this.postDataEntries = postDataEntries;
        this.mixedContentType = mixedContentType;
        this.initialPriority = initialPriority;
        this.referrerPolicy = referrerPolicy;
        this.isLinkPreload = isLinkPreload;
        this.trustTokenParams = trustTokenParams;
    }

    public Request(String url, String method, java.util.Map<String, Object> headers, jpuppeteer.cdp.client.constant.network.ResourcePriority initialPriority, jpuppeteer.cdp.client.constant.network.RequestReferrerPolicy referrerPolicy) {
        this.url = url;
        this.urlFragment = null;
        this.method = method;
        this.headers = headers;
        this.postData = null;
        this.hasPostData = null;
        this.postDataEntries = null;
        this.mixedContentType = null;
        this.initialPriority = initialPriority;
        this.referrerPolicy = referrerPolicy;
        this.isLinkPreload = null;
        this.trustTokenParams = null;
    }

    public Request() {
    }

}