package jpuppeteer.cdp.client.entity.page;

/**
* Fired for top level page lifecycle events such as navigation, load, paint, etc.
*/
public class LifecycleEvent {

    /**
    * Id of the frame.
    */
    private String frameId;

    /**
    * Loader identifier. Empty string if the request is fetched from worker.
    */
    private String loaderId;

    /**
    */
    private String name;

    /**
    */
    private java.math.BigDecimal timestamp;

    public void setFrameId (String frameId) {
        this.frameId = frameId;
    }

    public String getFrameId() {
        return this.frameId;
    }

    public void setLoaderId (String loaderId) {
        this.loaderId = loaderId;
    }

    public String getLoaderId() {
        return this.loaderId;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTimestamp (java.math.BigDecimal timestamp) {
        this.timestamp = timestamp;
    }

    public java.math.BigDecimal getTimestamp() {
        return this.timestamp;
    }

    public LifecycleEvent(String frameId, String loaderId, String name, java.math.BigDecimal timestamp) {
        this.frameId = frameId;
        this.loaderId = loaderId;
        this.name = name;
        this.timestamp = timestamp;
    }

    public LifecycleEvent() {
    }

}