package jpuppeteer.cdp.client.entity.animation;

/**
* Event for when an animation has been cancelled.
* experimental
*/
public class AnimationCanceledEvent {

    /**
    * Id of the animation that was cancelled.
    */
    private String id;

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public AnimationCanceledEvent(String id) {
        this.id = id;
    }

    public AnimationCanceledEvent() {
    }

}