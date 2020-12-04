package jpuppeteer.cdp.client.entity.network;

/**
* Fired when HTTP request has failed to load.
*/
public class LoadingFailedEvent {

    /**
    * Request identifier.
    */
    public final String requestId;

    /**
    * Timestamp.
    */
    public final java.math.BigDecimal timestamp;

    /**
    * Resource type.
    */
    public final String type;

    /**
    * User friendly error message.
    */
    public final String errorText;

    /**
    * True if loading was canceled.
    */
    public final Boolean canceled;

    /**
    * The reason why loading was blocked, if any.
    */
    public final String blockedReason;

    public LoadingFailedEvent(String requestId, java.math.BigDecimal timestamp, String type, String errorText, Boolean canceled, String blockedReason) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.type = type;
        this.errorText = errorText;
        this.canceled = canceled;
        this.blockedReason = blockedReason;
    }

    public LoadingFailedEvent(String requestId, java.math.BigDecimal timestamp, String type, String errorText) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.type = type;
        this.errorText = errorText;
        this.canceled = null;
        this.blockedReason = null;
    }

}