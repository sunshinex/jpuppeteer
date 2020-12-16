package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that a new AudioParam has been created.
* experimental
*/
public class AudioParamCreatedEvent {

    /**
    */
    public final AudioParam param;

    public AudioParamCreatedEvent(AudioParam param) {
        this.param = param;
    }

}