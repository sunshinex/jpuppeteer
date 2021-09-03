package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that a new BaseAudioContext has been created.
* experimental
*/
public class ContextCreatedEvent {

    /**
    */
    public final jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext context;

    public ContextCreatedEvent(jpuppeteer.cdp.client.entity.webaudio.BaseAudioContext context) {
        this.context = context;
    }

}