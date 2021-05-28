package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that a new AudioParam has been created.
* experimental
*/
public class AudioParamCreatedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.webaudio.AudioParam param;

    public AudioParamCreatedEvent(jpuppeteer.cdp.client.entity.webaudio.AudioParam param) {
        this.param = param;
    }

}