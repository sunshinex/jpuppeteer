package jpuppeteer.cdp.client.entity.animation;

/**
* Event for animation that has been started.
* experimental
*/
public class AnimationStartedEvent {

    /**
    * Animation that was started.
    */
    public final jpuppeteer.cdp.client.entity.animation.Animation animation;

    public AnimationStartedEvent(jpuppeteer.cdp.client.entity.animation.Animation animation) {
        this.animation = animation;
    }

}