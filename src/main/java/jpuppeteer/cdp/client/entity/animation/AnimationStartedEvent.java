package jpuppeteer.cdp.client.entity.animation;

/**
* Event for animation that has been started.
* experimental
*/
public class AnimationStartedEvent {

    /**
    * Animation that was started.
    */
    public final Animation animation;

    public AnimationStartedEvent(Animation animation) {
        this.animation = animation;
    }

}