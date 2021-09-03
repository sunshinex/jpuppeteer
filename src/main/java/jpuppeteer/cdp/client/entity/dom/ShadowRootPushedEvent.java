package jpuppeteer.cdp.client.entity.dom;

/**
* Called when shadow root is pushed into the element.
*/
public class ShadowRootPushedEvent {

    /**
    * Host element id.
    */
    public final Integer hostId;

    /**
    * Shadow root.
    */
    public final jpuppeteer.cdp.client.entity.dom.Node root;

    public ShadowRootPushedEvent(Integer hostId, jpuppeteer.cdp.client.entity.dom.Node root) {
        this.hostId = hostId;
        this.root = root;
    }

}