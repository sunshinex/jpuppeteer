package jpuppeteer.cdp.client.entity.network;

/**
* Fired when HTTP request has failed to load.
*/
public class LoadingFailedEvent {

    /**
    * Request identifier.
    */
    private String requestId;

    /**
    * Timestamp.
    */
    private java.math.BigDecimal timestamp;

    /**
    * Resource type.
    */
    private jpuppeteer.cdp.client.constant.network.ResourceType type;

    /**
    * User friendly error message.
    */
    private String errorText;

    /**
    * True if loading was canceled.
    */
    private Boolean canceled;

    /**
    * The reason why loading was blocked, if any.
    */
    private jpuppeteer.cdp.client.constant.network.BlockedReason blockedReason;

    /**
    * The reason why loading was blocked by CORS, if any.
    */
    private jpuppeteer.cdp.client.entity.network.CorsErrorStatus corsErrorStatus;

    public void setRequestId (String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public void setType (jpuppeteer.cdp.client.constant.network.ResourceType type) {
        this.type = type;
    }

    public jpuppeteer.cdp.client.constant.network.ResourceType getType() {
        return this.type;
    }

    public void setErrorText (String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return this.errorText;
    }

    public void setCanceled (Boolean canceled) {
        this.canceled = canceled;
    }

    public Boolean getCanceled() {
        return this.canceled;
    }

    public void setBlockedReason (jpuppeteer.cdp.client.constant.network.BlockedReason blockedReason) {
        this.blockedReason = blockedReason;
    }

    public jpuppeteer.cdp.client.constant.network.BlockedReason getBlockedReason() {
        return this.blockedReason;
    }

    public void setCorsErrorStatus (jpuppeteer.cdp.client.entity.network.CorsErrorStatus corsErrorStatus) {
        this.corsErrorStatus = corsErrorStatus;
    }

    public jpuppeteer.cdp.client.entity.network.CorsErrorStatus getCorsErrorStatus() {
        return this.corsErrorStatus;
    }

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

    public LoadingFailedEvent() {
    }

}