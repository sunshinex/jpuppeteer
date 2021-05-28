package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class SetPausedRequest {

    /**
    * Animations to set the pause state of.
    */
    public final java.util.List<String> animations;

    /**
    * Paused state to set to.
    */
    public final Boolean paused;

    public SetPausedRequest(java.util.List<String> animations, Boolean paused) {
        this.animations = animations;
        this.paused = paused;
    }

}