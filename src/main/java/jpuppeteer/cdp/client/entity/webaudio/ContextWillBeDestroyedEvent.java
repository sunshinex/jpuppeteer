package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that an existing BaseAudioContext will be destroyed.
* experimental
*/
public class ContextWillBeDestroyedEvent {

    /**
    */
    private String contextId;

    public void setContextId (String contextId) {
        this.contextId = contextId;
    }

    public String getContextId() {
        return this.contextId;
    }

    public ContextWillBeDestroyedEvent(String contextId) {
        this.contextId = contextId;
    }

    public ContextWillBeDestroyedEvent() {
    }

}