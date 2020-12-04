package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that a new AudioListener has been created.
* experimental
*/
public class AudioListenerWillBeDestroyedEvent {

    /**
    */
    public final String contextId;

    /**
    */
    public final String listenerId;

    public AudioListenerWillBeDestroyedEvent(String contextId, String listenerId) {
        this.contextId = contextId;
        this.listenerId = listenerId;
    }

}