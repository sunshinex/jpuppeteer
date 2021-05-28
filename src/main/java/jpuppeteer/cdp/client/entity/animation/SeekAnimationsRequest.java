package jpuppeteer.cdp.client.entity.animation;

/**
* experimental
*/
public class SeekAnimationsRequest {

    /**
    * List of animation ids to seek.
    */
    public final java.util.List<String> animations;

    /**
    * Set the current time of each animation.
    */
    public final java.math.BigDecimal currentTime;

    public SeekAnimationsRequest(java.util.List<String> animations, java.math.BigDecimal currentTime) {
        this.animations = animations;
        this.currentTime = currentTime;
    }

}