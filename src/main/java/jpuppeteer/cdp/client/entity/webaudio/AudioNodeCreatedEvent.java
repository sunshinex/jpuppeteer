package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that a new AudioNode has been created.
* experimental
*/
public class AudioNodeCreatedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.webaudio.AudioNode node;

    public AudioNodeCreatedEvent(jpuppeteer.cdp.client.entity.webaudio.AudioNode node) {
        this.node = node;
    }

}