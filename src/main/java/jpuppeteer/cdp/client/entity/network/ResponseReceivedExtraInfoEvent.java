package jpuppeteer.cdp.client.entity.network;

/**
* Fired when additional information about a responseReceived event is available from the network stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for it, and responseReceivedExtraInfo may be fired before or after responseReceived.
*/
public class ResponseReceivedExtraInfoEvent {

    /**
    * Request identifier. Used to match this information to another responseReceived event.
    */
    public final String requestId;

    /**
    * A list of cookies which were not stored from the response along with the corresponding reasons for blocking. The cookies here may not be valid due to syntax errors, which are represented by the invalid cookie line string instead of a proper cookie.
    */
    public final java.util.List<BlockedSetCookieWithReason> blockedCookies;

    /**
    * Raw response headers as they were received over the wire.
    */
    public final java.util.Map<String, Object> headers;

    /**
    * Raw response header text as it was received over the wire. The raw text may not always be available, such as in the case of HTTP/2 or QUIC.
    */
    public final String headersText;

    public ResponseReceivedExtraInfoEvent(String requestId, java.util.List<BlockedSetCookieWithReason> blockedCookies, java.util.Map<String, Object> headers, String headersText) {
        this.requestId = requestId;
        this.blockedCookies = blockedCookies;
        this.headers = headers;
        this.headersText = headersText;
    }

    public ResponseReceivedExtraInfoEvent(String requestId, java.util.List<BlockedSetCookieWithReason> blockedCookies, java.util.Map<String, Object> headers) {
        this.requestId = requestId;
        this.blockedCookies = blockedCookies;
        this.headers = headers;
        this.headersText = null;
    }

}