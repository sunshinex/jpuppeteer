package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that an AudioNode is connected to an AudioParam.
* experimental
*/
public class NodeParamConnectedEvent {

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

    public NodeParamConnectedEvent(String contextId, String sourceId, String destinationId, java.math.BigDecimal sourceOutputIndex) {
        this.contextId = contextId;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.sourceOutputIndex = sourceOutputIndex;
    }

    public NodeParamConnectedEvent(String contextId, String sourceId, String destinationId) {
        this.contextId = contextId;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.sourceOutputIndex = null;
    }

    public NodeParamConnectedEvent() {
    }

}