package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that an existing BaseAudioContext will be destroyed.
* experimental
*/
public class ContextWillBeDestroyedEvent {

    /**
    */
    public final String contextId;

    public ContextWillBeDestroyedEvent(String contextId) {
        this.contextId = contextId;
    }

}