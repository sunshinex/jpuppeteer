package jpuppeteer.cdp.client.entity.page;

/**
* Fired for top level page lifecycle events such as navigation, load, paint, etc.
*/
public class LifecycleEvent {

    /**
    * Id of the frame.
    */
    public final String frameId;

    /**
    * Loader identifier. Empty string if the request is fetched from worker.
    */
    public final String loaderId;

    /**
    */
    public final String name;

    /**
    */
    public final java.math.BigDecimal timestamp;

    public LifecycleEvent(String frameId, String loaderId, String name, java.math.BigDecimal timestamp) {
        this.frameId = frameId;
        this.loaderId = loaderId;
        this.name = name;
        this.timestamp = timestamp;
    }

}