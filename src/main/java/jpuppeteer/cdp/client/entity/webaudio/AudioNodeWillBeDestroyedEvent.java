package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that an existing AudioNode has been destroyed.
* experimental
*/
public class AudioNodeWillBeDestroyedEvent {

    /**
    */
    private String contextId;

    /**
    */
    private String nodeId;

    public void setContextId (String contextId) {
        this.contextId = contextId;
    }

    public String getContextId() {
        return this.contextId;
    }

    public void setNodeId (String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public AudioNodeWillBeDestroyedEvent(String contextId, String nodeId) {
        this.contextId = contextId;
        this.nodeId = nodeId;
    }

    public AudioNodeWillBeDestroyedEvent() {
    }

}