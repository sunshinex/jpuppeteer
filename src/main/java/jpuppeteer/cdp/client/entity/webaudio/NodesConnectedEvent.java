package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that two AudioNodes are connected.
* experimental
*/
public class NodesConnectedEvent {

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

    /**
    */
    public final java.math.BigDecimal destinationInputIndex;

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

}