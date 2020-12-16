package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that the construction of an AudioListener has finished.
* experimental
*/
public class AudioListenerCreatedEvent {

    /**
    */
    public final AudioListener listener;

    public AudioListenerCreatedEvent(AudioListener listener) {
        this.listener = listener;
    }

}