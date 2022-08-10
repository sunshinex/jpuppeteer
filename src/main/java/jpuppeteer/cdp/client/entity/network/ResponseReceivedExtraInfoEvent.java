package jpuppeteer.cdp.client.entity.network;

/**
* Fired when additional information about a responseReceived event is available from the network stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for it, and responseReceivedExtraInfo may be fired before or after responseReceived.
*/
public class ResponseReceivedExtraInfoEvent {

    /**
    * Request identifier. Used to match this information to another responseReceived event.
    */
    private String requestId;

    /**
    * A list of cookies which were not stored from the response along with the corresponding reasons for blocking. The cookies here may not be valid due to syntax errors, which are represented by the invalid cookie line string instead of a proper cookie.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.network.BlockedSetCookieWithReason> blockedCookies;

    /**
    * Raw response headers as they were received over the wire.
    */
    private java.util.Map<String, Object> headers;

    /**
    * The IP address space of the resource. The address space can only be determined once the transport established the connection, so we can't send it in `requestWillBeSentExtraInfo`.
    */
    private jpuppeteer.cdp.client.constant.network.IPAddressSpace resourceIPAddressSpace;

    /**
    * Raw response header text as it was received over the wire. The raw text may not always be available, such as in the case of HTTP/2 or QUIC.
    */
    private String headersText;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setBlockedCookies (java.util.List<jpuppeteer.cdp.client.entity.network.BlockedSetCookieWithReason> blockedCookies) {
        this.blockedCookies = blockedCookies;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.network.BlockedSetCookieWithReason> getBlockedCookies() {
        return this.blockedCookies;
    }

    public void setHeaders (java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

    public java.util.Map<String, Object> getHeaders() {
        return this.headers;
    }

    public void setResourceIPAddressSpace (jpuppeteer.cdp.client.constant.network.IPAddressSpace resourceIPAddressSpace) {
        this.resourceIPAddressSpace = resourceIPAddressSpace;
    }

    public jpuppeteer.cdp.client.constant.network.IPAddressSpace getResourceIPAddressSpace() {
        return this.resourceIPAddressSpace;
    }

    public void setHeadersText (String headersText) {
        this.headersText = headersText;
    }

    public String getHeadersText() {
        return this.headersText;
    }

    public ResponseReceivedExtraInfoEvent(String requestId, java.util.List<jpuppeteer.cdp.client.entity.network.BlockedSetCookieWithReason> blockedCookies, java.util.Map<String, Object> headers, jpuppeteer.cdp.client.constant.network.IPAddressSpace resourceIPAddressSpace, String headersText) {
        this.requestId = requestId;
        this.blockedCookies = blockedCookies;
        this.headers = headers;
        this.resourceIPAddressSpace = resourceIPAddressSpace;
        this.headersText = headersText;
    }

    public ResponseReceivedExtraInfoEvent(String requestId, java.util.List<jpuppeteer.cdp.client.entity.network.BlockedSetCookieWithReason> blockedCookies, java.util.Map<String, Object> headers, jpuppeteer.cdp.client.constant.network.IPAddressSpace resourceIPAddressSpace) {
        this.requestId = requestId;
        this.blockedCookies = blockedCookies;
        this.headers = headers;
        this.resourceIPAddressSpace = resourceIPAddressSpace;
        this.headersText = null;
    }

    public ResponseReceivedExtraInfoEvent() {
    }

}