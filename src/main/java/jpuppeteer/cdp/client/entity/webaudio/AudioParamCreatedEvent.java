package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that a new AudioParam has been created.
* experimental
*/
public class AudioParamCreatedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.webaudio.AudioParam param;

    public void setParam (jpuppeteer.cdp.client.entity.webaudio.AudioParam param) {
        this.param = param;
    }

    public jpuppeteer.cdp.client.entity.webaudio.AudioParam getParam() {
        return this.param;
    }

    public AudioParamCreatedEvent(jpuppeteer.cdp.client.entity.webaudio.AudioParam param) {
        this.param = param;
    }

    public AudioParamCreatedEvent() {
    }

}