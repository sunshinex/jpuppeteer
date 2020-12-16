package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that a new AudioNode has been created.
* experimental
*/
public class AudioNodeCreatedEvent {

    /**
    */
    public final AudioNode node;

    public AudioNodeCreatedEvent(AudioNode node) {
        this.node = node;
    }

}