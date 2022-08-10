package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that the construction of an AudioListener has finished.
* experimental
*/
public class AudioListenerCreatedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.webaudio.AudioListener listener;

    public void setListener (jpuppeteer.cdp.client.entity.webaudio.AudioListener listener) {
        this.listener = listener;
    }

    public jpuppeteer.cdp.client.entity.webaudio.AudioListener getListener() {
        return this.listener;
    }

    public AudioListenerCreatedEvent(jpuppeteer.cdp.client.entity.webaudio.AudioListener listener) {
        this.listener = listener;
    }

    public AudioListenerCreatedEvent() {
    }

}