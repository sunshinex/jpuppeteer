package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that two AudioNodes are connected.
* experimental
*/
public class NodesConnectedEvent {

    /**
    */
    private String contextId;

    /**
    */
    private String sourceId;

    /**
    */
    private String destinationId;

    /**
    */
    private java.math.BigDecimal sourceOutputIndex;

    /**
    */
    private java.math.BigDecimal destinationInputIndex;

    public void setContextId (String contextId) {
        this.contextId = contextId;
    }

    public String getContextId() {
        return this.contextId;
    }

    public void setSourceId (String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public void setDestinationId (String destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationId() {
        return this.destinationId;
    }

    public void setSourceOutputIndex (java.math.BigDecimal sourceOutputIndex) {
        this.sourceOutputIndex = sourceOutputIndex;
    }

    public java.math.BigDecimal getSourceOutputIndex() {
        return this.sourceOutputIndex;
    }

    public void setDestinationInputIndex (java.math.BigDecimal destinationInputIndex) {
        this.destinationInputIndex = destinationInputIndex;
    }

    public java.math.BigDecimal getDestinationInputIndex() {
        return this.destinationInputIndex;
    }

    public NodesConnectedEvent(String contextId, String sourceId, String destinationId, java.math.BigDecimal sourceOutputIndex, java.math.BigDecimal destinationInputIndex) {
        this.contextId = contextId;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.sourceOutputIndex = sourceOutputIndex;
        this.destinationInputIndex = destinationInputIndex;
    }

    public NodesConnectedEvent(String contextId, String sourceId, String destinationId) {
        this.contextId = contextId;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.sourceOutputIndex = null;
        this.destinationInputIndex = null;
    }

    public NodesConnectedEvent() {
    }

}