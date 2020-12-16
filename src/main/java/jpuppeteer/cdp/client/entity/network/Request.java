package jpuppeteer.cdp.client.entity.network;

/**
* HTTP request data.
*/
public class Request {

    /**
    * Request URL (without fragment).
    */
    public final String url;

    /**
    * Fragment of the requested URL starting with hash, if present.
    */
    public final String urlFragment;

    /**
    * HTTP request method.
    */
    public final String method;

    /**
    * HTTP request headers.
    */
    public final java.util.Map<String, Object> headers;

    /**
    * HTTP POST request data.
    */
    public final String postData;

    /**
    * True when the request has POST data. Note that postData might still be omitted when this flag is true when the data is too long.
    */
    public final Boolean hasPostData;

    /**
    * The mixed content type of the request.
    */
    public final jpuppeteer.cdp.client.constant.security.MixedContentType mixedContentType;

    /**
    * Priority of the resource request at the time request is sent.
    */
    public final jpuppeteer.cdp.client.constant.network.ResourcePriority initialPriority;

    /**
    * The referrer policy of the request, as defined in https://www.w3.org/TR/referrer-policy/
    */
    public final jpuppeteer.cdp.client.constant.network.RequestReferrerPolicy referrerPolicy;

    /**
    * Whether is loaded via link preload.
    */
    public final Boolean isLinkPreload;

    public Request(String url, String urlFragment, String method, java.util.Map<String, Object> headers, String postData, Boolean hasPostData, jpuppeteer.cdp.client.constant.security.MixedContentType mixedContentType, jpuppeteer.cdp.client.constant.network.ResourcePriority initialPriority, jpuppeteer.cdp.client.constant.network.RequestReferrerPolicy referrerPolicy, Boolean isLinkPreload) {
        this.url = url;
        this.urlFragment = urlFragment;
        this.method = method;
        this.headers = headers;
        this.postData = postData;
        this.hasPostData = hasPostData;
        this.mixedContentType = mixedContentType;
        this.initialPriority = initialPriority;
        this.referrerPolicy = referrerPolicy;
        this.isLinkPreload = isLinkPreload;
    }

    public Request(String url, String method, java.util.Map<String, Object> headers, jpuppeteer.cdp.client.constant.network.ResourcePriority initialPriority, jpuppeteer.cdp.client.constant.network.RequestReferrerPolicy referrerPolicy) {
        this.url = url;
        this.urlFragment = null;
        this.method = method;
        this.headers = headers;
        this.postData = null;
        this.hasPostData = null;
        this.mixedContentType = null;
        this.initialPriority = initialPriority;
        this.referrerPolicy = referrerPolicy;
        this.isLinkPreload = null;
    }

}