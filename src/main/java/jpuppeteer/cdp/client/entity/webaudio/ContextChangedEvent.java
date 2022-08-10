package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
* experimental
*/
public class ContextChangedEvent {

    /**
    */
    private jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext context;

    public void setContext (jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext context) {
        this.context = context;
    }

    public jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext getContext() {
        return this.context;
    }

    public ContextChangedEvent(jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext context) {
        this.context = context;
    }

    public ContextChangedEvent() {
    }

}