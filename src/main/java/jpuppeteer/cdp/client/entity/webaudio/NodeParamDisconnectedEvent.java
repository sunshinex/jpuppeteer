package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that an AudioNode is disconnected to an AudioParam.
* experimental
*/
public class NodeParamDisconnectedEvent {

    /**
    */
    public final String contextId;

    /**
    */
    public final String sourceId;

    /**
    */
    public final String destinationId;

    /**
    */
    public final java.math.BigDecimal sourceOutputIndex;

    public NodeParamDisconnectedEvent(String contextId, String sourceId, String destinationId, java.math.BigDecimal sourceOutputIndex) {
        this.contextId = contextId;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.sourceOutputIndex = sourceOutputIndex;
    }

    public NodeParamDisconnectedEvent(String contextId, String sourceId, String destinationId) {
        this.contextId = contextId;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.sourceOutputIndex = null;
    }

}