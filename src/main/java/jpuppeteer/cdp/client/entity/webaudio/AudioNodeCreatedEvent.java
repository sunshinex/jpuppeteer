package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that a new AudioNode has been created.
* experimental
*/
public class AudioNodeCreatedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.webaudio.AudioNode node;

    public void setNode (jpuppeteer.cdp.client.entity.webaudio.AudioNode node) {
        this.node = node;
    }

    public jpuppeteer.cdp.client.entity.webaudio.AudioNode getNode() {
        return this.node;
    }

    public AudioNodeCreatedEvent(jpuppeteer.cdp.client.entity.webaudio.AudioNode node) {
        this.node = node;
    }

    public AudioNodeCreatedEvent() {
    }

}