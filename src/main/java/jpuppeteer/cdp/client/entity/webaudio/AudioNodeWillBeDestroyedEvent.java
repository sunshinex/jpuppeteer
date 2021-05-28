package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that an existing AudioNode has been destroyed.
* experimental
*/
public class AudioNodeWillBeDestroyedEvent {

    /**
    */
    public final String contextId;

    /**
    */
    public final String nodeId;

    public AudioNodeWillBeDestroyedEvent(String contextId, String nodeId) {
        this.contextId = contextId;
        this.nodeId = nodeId;
    }

}