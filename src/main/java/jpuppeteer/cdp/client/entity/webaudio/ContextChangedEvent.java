package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
* experimental
*/
public class ContextChangedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext context;

    public ContextChangedEvent(jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext context) {
        this.context = context;
    }

}