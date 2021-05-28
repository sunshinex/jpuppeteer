package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that an AudioNode is connected to an AudioParam.
* experimental
*/
public class NodeParamConnectedEvent {

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

}