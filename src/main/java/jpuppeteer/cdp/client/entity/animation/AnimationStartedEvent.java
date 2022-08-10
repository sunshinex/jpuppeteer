package jpuppeteer.cdp.client.entity.animation;

/**
* Event for animation that has been started.
* experimental
*/
public class AnimationStartedEvent {

    /**
    * Animation that was started.
    */
    private jpuppeteer.cdp.client.entity.animation.Animation animation;

    public void setAnimation (jpuppeteer.cdp.client.entity.animation.Animation animation) {
        this.animation = animation;
    }

    public jpuppeteer.cdp.client.entity.animation.Animation getAnimation() {
        return this.animation;
    }

    public AnimationStartedEvent(jpuppeteer.cdp.client.entity.animation.Animation animation) {
        this.animation = animation;
    }

    public AnimationStartedEvent() {
    }

}