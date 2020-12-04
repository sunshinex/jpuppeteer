package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that an existing AudioParam has been destroyed.
* experimental
*/
public class AudioParamWillBeDestroyedEvent {

    /**
    */
    public final String contextId;

    /**
    */
    public final String nodeId;

    /**
    */
    public final String paramId;

    public AudioParamWillBeDestroyedEvent(String contextId, String nodeId, String paramId) {
        this.contextId = contextId;
        this.nodeId = nodeId;
        this.paramId = paramId;
    }

}