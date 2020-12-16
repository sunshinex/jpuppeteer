package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that existing BaseAudioContext has changed some properties (id stays the same)..
* experimental
*/
public class ContextChangedEvent {

    /**
    */
    public final BaseAudioContext context;

    public ContextChangedEvent(BaseAudioContext context) {
        this.context = context;
    }

}