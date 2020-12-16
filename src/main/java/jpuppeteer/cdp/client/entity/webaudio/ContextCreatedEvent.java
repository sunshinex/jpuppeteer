package jpuppeteer.cdp.client.entity.webaudio;

/**
* Notifies that a new BaseAudioContext has been created.
* experimental
*/
public class ContextCreatedEvent {

    /**
    */
    public final BaseAudioContext context;

    public ContextCreatedEvent(BaseAudioContext context) {
        this.context = context;
    }

}