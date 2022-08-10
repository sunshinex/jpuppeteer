package jpuppeteer.cdp.client.entity.dom;

/**
* Called when shadow root is pushed into the element.
*/
public class ShadowRootPushedEvent {

    /**
    * Host element id.
    */
    private Integer hostId;

    /**
    * Shadow root.
    */
    private jpuppeteer.cdp.client.entity.dom.Node root;

    public void setHostId (Integer hostId) {
        this.hostId = hostId;
    }

    public Integer getHostId() {
        return this.hostId;
    }

    public void setRoot (jpuppeteer.cdp.client.entity.dom.Node root) {
        this.root = root;
    }

    public jpuppeteer.cdp.client.entity.dom.Node getRoot() {
        return this.root;
    }

    public ShadowRootPushedEvent(Integer hostId, jpuppeteer.cdp.client.entity.dom.Node root) {
        this.hostId = hostId;
        this.root = root;
    }

    public ShadowRootPushedEvent() {
    }

}