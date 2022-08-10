package jpuppeteer.cdp.client.entity.webaudio;

/**
* Protocol object for AudioListener
* experimental
*/
public class AudioListener {

    /**
    */
    private String listenerId;

    /**
    */
    private String contextId;

    public void setListenerId (String listenerId) {
        this.listenerId = listenerId;
    }

    public String getListenerId() {
        return this.listenerId;
    }

    public void setContextId (String contextId) {
        this.contextId = contextId;
    }

    public String getContextId() {
        return this.contextId;
    }

    public AudioListener(String listenerId, String contextId) {
        this.listenerId = listenerId;
        this.contextId = contextId;
    }

    public AudioListener() {
    }

}