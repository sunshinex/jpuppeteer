package jpuppeteer.cdp.client.entity.dom;

/**
* Called when shadow root is popped from the element.
*/
public class ShadowRootPoppedEvent {

    /**
    * Host element id.
    */
    private Integer hostId;

    /**
    * Shadow root id.
    */
    private Integer rootId;

    public void setHostId (Integer hostId) {
        this.hostId = hostId;
    }

    public Integer getHostId() {
        return this.hostId;
    }

    public void setRootId (Integer rootId) {
        this.rootId = rootId;
    }

    public Integer getRootId() {
        return this.rootId;
    }

    public ShadowRootPoppedEvent(Integer hostId, Integer rootId) {
        this.hostId = hostId;
        this.rootId = rootId;
    }

    public ShadowRootPoppedEvent() {
    }

}