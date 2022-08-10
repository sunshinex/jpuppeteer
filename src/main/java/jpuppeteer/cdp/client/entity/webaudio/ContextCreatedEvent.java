package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that a new BaseAudioContext has been created.
* experimental
*/
public class ContextCreatedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext context;

    public void setContext (jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext context) {
        this.context = context;
    }

    public jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext getContext() {
        return this.context;
    }

    public ContextCreatedEvent(jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext context) {
        this.context = context;
    }

    public ContextCreatedEvent() {
    }

}