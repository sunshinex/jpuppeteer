package jpuppeteer.cdp.client.entity.animation;

/**
* Event for when an animation has been cancelled.
* experimental
*/
public class AnimationCanceledEvent {

    /**
    * Id of the animation that was cancelled.
    */
    public final String id;

    public AnimationCanceledEvent(String id) {
        this.id = id;
    }

}