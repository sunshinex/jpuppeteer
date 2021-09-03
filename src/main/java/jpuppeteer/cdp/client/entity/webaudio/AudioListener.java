package jpuppeteer.cdp.client.entity.webaudio;

/**
* Protocol object for AudioListener
* experimental
*/
public class AudioListener {

    /**
    */
    public final String listenerId;

    /**
    */
    public final String contextId;

    public AudioListener(String listenerId, String contextId) {
        this.listenerId = listenerId;
        this.contextId = contextId;
    }

}