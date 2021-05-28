package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
* experimental
*/
public class NodesDisconnectedEvent {

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

    public NodesDisconnectedEvent(String contextId, String sourceId, String destinationId, java.math.BigDecimal sourceOutputIndex, java.math.BigDecimal destinationInputIndex) {
        this.contextId = contextId;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.sourceOutputIndex = sourceOutputIndex;
        this.destinationInputIndex = destinationInputIndex;
    }

    public NodesDisconnectedEvent(String contextId, String sourceId, String destinationId) {
        this.contextId = contextId;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.sourceOutputIndex = null;
        this.destinationInputIndex = null;
    }

}