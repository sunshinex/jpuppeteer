package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that an existing AudioParam has been destroyed.
* experimental
*/
public class AudioParamWillBeDestroyedEvent {

    /**
    */
    private String contextId;

    /**
    */
    private String nodeId;

    /**
    */
    private String paramId;

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

    public void setParamId (String paramId) {
        this.paramId = paramId;
    }

    public String getParamId() {
        return this.paramId;
    }

    public AudioParamWillBeDestroyedEvent(String contextId, String nodeId, String paramId) {
        this.contextId = contextId;
        this.nodeId = nodeId;
        this.paramId = paramId;
    }

    public AudioParamWillBeDestroyedEvent() {
    }

}