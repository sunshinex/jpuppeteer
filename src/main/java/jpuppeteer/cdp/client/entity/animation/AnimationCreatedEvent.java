package jpuppeteer.cdp.client.entity.animation;

/**
* Event for each animation that has been created.
* experimental
*/
public class AnimationCreatedEvent {

    /**
    * Id of the animation that was created.
    */
    public final String id;

    public AnimationCreatedEvent(String id) {
        this.id = id;
    }

}