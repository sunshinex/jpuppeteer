package jpuppeteer.cdp.client.entity.heapprofiler;

/**
* If heap objects tracking has been started then backend regularly sends a current value for last seen object id and corresponding timestamp. If the were changes in the heap since last event then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
* experimental
*/
public class LastSeenObjectIdEvent {

    /**
    */
    public final Integer lastSeenObjectId;

    /**
    */
    public final java.math.BigDecimal timestamp;

    public LastSeenObjectIdEvent(Integer lastSeenObjectId, java.math.BigDecimal timestamp) {
        this.lastSeenObjectId = lastSeenObjectId;
        this.timestamp = timestamp;
    }

}