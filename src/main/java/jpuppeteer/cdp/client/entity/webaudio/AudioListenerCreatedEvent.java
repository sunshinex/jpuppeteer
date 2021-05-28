package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that the construction of an AudioListener has finished.
* experimental
*/
public class AudioListenerCreatedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.webaudio.AudioListener listener;

    public AudioListenerCreatedEvent(jpuppeteer.cdp.client.entity.webaudio.AudioListener listener) {
        this.listener = listener;
    }

}