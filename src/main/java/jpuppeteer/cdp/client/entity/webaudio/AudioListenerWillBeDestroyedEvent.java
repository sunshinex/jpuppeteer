package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that a new AudioListener has been created.
* experimental
*/
public class AudioListenerWillBeDestroyedEvent {

    /**
    */
    private String contextId;

    /**
    */
    private String listenerId;

    public void setContextId (String contextId) {
        this.contextId = contextId;
    }

    public String getContextId() {
        return this.contextId;
    }

    public void setListenerId (String listenerId) {
        this.listenerId = listenerId;
    }

    public String getListenerId() {
        return this.listenerId;
    }

    public AudioListenerWillBeDestroyedEvent(String contextId, String listenerId) {
        this.contextId = contextId;
        this.listenerId = listenerId;
    }

    public AudioListenerWillBeDestroyedEvent() {
    }

}