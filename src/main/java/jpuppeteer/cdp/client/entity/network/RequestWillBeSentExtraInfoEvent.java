package jpuppeteer.cdp.client.entity.network;

/**
* Fired when additional information about a requestWillBeSent event is available from the network stack. Not every requestWillBeSent event will have an additional requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent or requestWillBeSentExtraInfo will be fired first for the same request.
*/
public class RequestWillBeSentExtraInfoEvent {

    /**
    * Request identifier. Used to match this information to an existing requestWillBeSent event.
    */
    private String requestId;

    /**
    * A list of cookies potentially associated to the requested URL. This includes both cookies sent with the request and the ones not sent; the latter are distinguished by having blockedReason field set.
    */
    private java.util.List<jpuppeteer.cdp.client.entity.network.BlockedCookieWithReason> associatedCookies;

    /**
    * Raw request headers as they will be sent over the wire.
    */
    private java.util.Map<String, Object> headers;

    /**
    * The client security state set for the request.
    */
    private jpuppeteer.cdp.client.entity.network.ClientSecurityState clientSecurityState;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setAssociatedCookies (java.util.List<jpuppeteer.cdp.client.entity.network.BlockedCookieWithReason> associatedCookies) {
        this.associatedCookies = associatedCookies;
    }

    public java.util.List<jpuppeteer.cdp.client.entity.network.BlockedCookieWithReason> getAssociatedCookies() {
        return this.associatedCookies;
    }

    public void setHeaders (java.util.Map<String, Object> headers) {
        this.headers = headers;
    }

    public java.util.Map<String, Object> getHeaders() {
        return this.headers;
    }

    public void setClientSecurityState (jpuppeteer.cdp.client.entity.network.ClientSecurityState clientSecurityState) {
        this.clientSecurityState = clientSecurityState;
    }

    public jpuppeteer.cdp.client.entity.network.ClientSecurityState getClientSecurityState() {
        return this.clientSecurityState;
    }

    public RequestWillBeSentExtraInfoEvent(String requestId, java.util.List<jpuppeteer.cdp.client.entity.network.BlockedCookieWithReason> associatedCookies, java.util.Map<String, Object> headers, jpuppeteer.cdp.client.entity.network.ClientSecurityState clientSecurityState) {
        this.requestId = requestId;
        this.associatedCookies = associatedCookies;
        this.headers = headers;
        this.clientSecurityState = clientSecurityState;
    }

    public RequestWillBeSentExtraInfoEvent(String requestId, java.util.List<jpuppeteer.cdp.client.entity.network.BlockedCookieWithReason> associatedCookies, java.util.Map<String, Object> headers) {
        this.requestId = requestId;
        this.associatedCookies = associatedCookies;
        this.headers = headers;
        this.clientSecurityState = null;
    }

    public RequestWillBeSentExtraInfoEvent() {
    }

}