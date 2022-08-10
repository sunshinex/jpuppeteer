package jpuppeteer.cdp.client.entity.animation;

/**
* Event for each animation that has been created.
* experimental
*/
public class AnimationCreatedEvent {

    /**
    * Id of the animation that was created.
    */
    private String id;

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public AnimationCreatedEvent(String id) {
        this.id = id;
    }

    public AnimationCreatedEvent() {
    }

}