package jpuppeteer.cdp.client.entity.network;

/**
* Fired when additional information about a requestWillBeSent event is available from the network stack. Not every requestWillBeSent event will have an additional requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent or requestWillBeSentExtraInfo will be fired first for the same request.
*/
public class RequestWillBeSentExtraInfoEvent {

    /**
    * Request identifier. Used to match this information to an existing requestWillBeSent event.
    */
    public final String requestId;

    /**
    * A list of cookies which will not be sent with this request along with corresponding reasons for blocking.
    */
    public final java.util.List<BlockedCookieWithReason> blockedCookies;

    /**
    * Raw request headers as they will be sent over the wire.
    */
    public final java.util.Map<String, Object> headers;

    public RequestWillBeSentExtraInfoEvent(String requestId, java.util.List<BlockedCookieWithReason> blockedCookies, java.util.Map<String, Object> headers) {
        this.requestId = requestId;
        this.blockedCookies = blockedCookies;
        this.headers = headers;
    }

}