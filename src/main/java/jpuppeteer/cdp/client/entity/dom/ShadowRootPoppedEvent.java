package jpuppeteer.cdp.client.entity.dom;

/**
* Called when shadow root is popped from the element.
*/
public class ShadowRootPoppedEvent {

    /**
    * Host element id.
    */
    public final Integer hostId;

    /**
    * Shadow root id.
    */
    public final Integer rootId;

    public ShadowRootPoppedEvent(Integer hostId, Integer rootId) {
        this.hostId = hostId;
        this.rootId = rootId;
    }

}