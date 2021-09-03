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
    public final jpuppeteer.cdp.client.constant.network.ResourceType type;

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
    public final jpuppeteer.cdp.client.constant.network.BlockedReason blockedReason;

    /**
    * The reason why loading was blocked by CORS, if any.
    */
    public final jpuppeteer.cdp.client.entity.network.CorsErrorStatus corsErrorStatus;

    public LoadingFailedEvent(String requestId, java.math.BigDecimal timestamp, jpuppeteer.cdp.client.constant.network.ResourceType type, String errorText, Boolean canceled, jpuppeteer.cdp.client.constant.network.BlockedReason blockedReason, jpuppeteer.cdp.client.entity.network.CorsErrorStatus corsErrorStatus) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.type = type;
        this.errorText = errorText;
        this.canceled = canceled;
        this.blockedReason = blockedReason;
        this.corsErrorStatus = corsErrorStatus;
    }

    public LoadingFailedEvent(String requestId, java.math.BigDecimal timestamp, jpuppeteer.cdp.client.constant.network.ResourceType type, String errorText) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.type = type;
        this.errorText = errorText;
        this.canceled = null;
        this.blockedReason = null;
        this.corsErrorStatus = null;
    }

}